package de.pvhil.statsdiscord;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class main extends JavaPlugin implements EventListener {
    public static String urlf;
    public static String name;
    public static String pw;
    public static Connection conn;
    public static JDA jda;
    public static InetAddress IP;

    @Override
    public void onEnable() {
        loadConfig();
        String token = getConfig().getString("BOTTOKEN");
        if (token.equalsIgnoreCase("token")){
            System.out.println("!!![DiscordStats] Please enter a Discord bot ID in the config!!");
            return;
        }

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            Order order = mapper.readValue(new File("plugins\\Stats\\config.yml"), Order.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(urlf, name, pw);
            System.out.println("DiscordStats successfully connected to Stats Plugin ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Discord Stats could not connect to Stats. Maybe Stats isnt also working?");
        }

        try {
            jda = JDABuilder.createDefault(token)
                    .addEventListeners(new DiscordMessage())
                    .build();
        } catch (LoginException e) {
            System.out.println("Discord Stats is not working because the BOT TOKEN is invalid!!!");
        }
        main.jda.getPresence().setActivity(Activity.watching("your stats | .mcstats"));
        try {
            IP = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


        // Plugin startup logic

    }
    public void loadConfig(){
        this.saveDefaultConfig();
        saveConfig();
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public void onEvent(@NotNull GenericEvent event) {

    }
}
