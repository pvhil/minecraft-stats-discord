package de.pvhil.statsdiscord;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.concurrent.CompletionException;

public class DiscordMessage extends ListenerAdapter implements EventListener {
    public static String name;
    public static MessageReceivedEvent pubEvent;
    public void onMessageReceived(MessageReceivedEvent event) {
        pubEvent = event;
        if (event.getAuthor().isBot()) {
            return;
        }
        java.lang.String[] args = event.getMessage().getContentRaw().split("\\s+");

        if(args[0].equalsIgnoreCase(".mcstats")){
            if(args.length<2){
                EmbedBuilder server = new EmbedBuilder();
                server.setTitle("Stats for the Server");
                server.addField("Online Players: ", String.valueOf(Bukkit.getOnlinePlayers().size()), true);
                server.addField("IP: ", String.valueOf(main.IP), false);
                server.setFooter("Use .mcstats name for player stats");
                server.setColor(0x8B4513);
                event.getChannel().sendMessage(server.build()).queue();


                return;
            }
            name = args[1];
            try {
                uuid.main(null);
            }catch (CompletionException e){
                event.getChannel().sendMessage("User not existing in Minecraft!").queue();
            }
            sqlread.sqlact();
            Player player = Bukkit.getPlayerExact(name);

            EmbedBuilder stats = new EmbedBuilder();
            stats.setTitle("Stats for player "+args[1]);
                    stats.addField("PvP-Kills:", sqlread.kills,true)
                    .addField("Deaths: ", String.valueOf(sqlread.deaths),true)
                    .addField("Damage taken ", String.valueOf(sqlread.damage),true)
                    .addField("Arrows shot: ", sqlread.arrows,true)
                    .addField("Beds joined: ", sqlread.beds,true)
                    .addField("Items crafted:  ", String.valueOf(sqlread.crafted),true)
                    .addField("Items picked up:  ", String.valueOf(sqlread.picked),true)
                    .addField("Items dropped:  ", String.valueOf(sqlread.dropped),true)
                    .addField("Tools broken: ", String.valueOf(sqlread.brokentools),true)
                    .addField("Commands executed: ", sqlread.commands,true)
                    .addField("XP gained: ", sqlread.xp,true)
                    .addField("Messages: ", sqlread.chat,true)
                    .addField("Join amount:", sqlread.join,true)
                    .addField("Food consumed:  ", String.valueOf(sqlread.food),true)
                    .addField("Kick amount: ", sqlread.kicked,true)
                    .addField("Eggs thrown: ", sqlread.eggs, true)
                    .addField("Empty buckets: ", sqlread.bucketemp,true)
                    .addField("Fish caught: ", String.valueOf(sqlread.fish),true)
                    .addField("Blocks breaked: ", String.valueOf(sqlread.breaked),true)
                    .addField("Blocks placed: ", String.valueOf(sqlread.placed),true)
                            .addField("Playtime ", sqlread.playtime/60 +" Minutes",true)
                    .setFooter("On server: "+ main.IP)
                    .setThumbnail("https://crafatar.com/avatars/"+uuid.uuid+"?overlay");
                    if(player == null) {
                    stats.setAuthor("is offline",null,"https://raw.githubusercontent.com/pvhil/DiscordWhitelister/master/src/main/resources/red.png");
                    }else{
                        stats.setAuthor("is online",null,"https://raw.githubusercontent.com/pvhil/DiscordWhitelister/master/src/main/resources/green.png");
                    }
                    stats.setColor(0x8B4513);
            event.getChannel().sendMessage(stats.build()).queue();


        }

    }




}
