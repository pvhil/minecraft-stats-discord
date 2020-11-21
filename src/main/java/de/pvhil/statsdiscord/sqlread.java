package de.pvhil.statsdiscord;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlread {
    public static String arrows= "0";
    public static String beds= "0";
    public static String bucketemp= "0";
    public static String commands= "0";
    public static String eggs= "0";
    public static String kills= "0";
    public static String join= "0";
    public static String chat= "0";
    public static String xp= "0";
    public static String kicked= "0";
    public static int breaked= 0;
    public static int placed= 0;
    public static int deaths= 0;
    public static int damage= 0;
    public static int brokentools= 0;
    public static int fish= 0;
    public static int food=0;
    public static int crafted=0;
    public static int picked=0;
    public static int dropped=0;
    public static int playtime=0;

    public static void sqlact()

    {

        try {
            Statement stmt = main.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM stats5.stats_block_break WHERE player LIKE 0x" + uuid.uuid);
            while (rs.next()) {
                breaked = breaked + rs.getInt(6);

            } ResultSet rs1 = stmt.executeQuery("SELECT * FROM stats5.stats_arrows_shot WHERE player LIKE 0x" + uuid.uuid);
            if (rs1.next()) {
                arrows = rs1.getString(3);


            }ResultSet rs2 = stmt.executeQuery("SELECT * FROM stats5.stats_beds_entered WHERE player LIKE 0x" + uuid.uuid);
            if (rs2.next()) {
                beds = rs2.getString(3);


            }
            ResultSet rs3 = stmt.executeQuery("SELECT * FROM stats5.stats_buckets_emptied WHERE player LIKE 0x" + uuid.uuid);
            if (rs3.next()) {
                bucketemp = rs3.getString(3);


            }
            ResultSet rs4 = stmt.executeQuery("SELECT * FROM stats5.stats_commands_performed WHERE player LIKE 0x" + uuid.uuid);
            if (rs4.next()) {
                commands = rs4.getString(3);


            }ResultSet rs5 = stmt.executeQuery("SELECT * FROM stats5.stats_eggs_thrown WHERE player LIKE 0x" + uuid.uuid);
            if (rs5.next()) {
                eggs = rs5.getString(3);


            }ResultSet rs6 = stmt.executeQuery("SELECT * FROM stats5.stats_pvp_kills WHERE player LIKE 0x" + uuid.uuid);
            if (rs6.next()) {
                kills = rs6.getString(3);


            }ResultSet rs7 = stmt.executeQuery("SELECT * FROM stats5.stats_times_joined WHERE player LIKE 0x" + uuid.uuid);
            if (rs7.next()) {
                join = rs7.getString(3);


            }ResultSet rs8 = stmt.executeQuery("SELECT * FROM stats5.stats_times_kicked WHERE player LIKE 0x" + uuid.uuid);
            if (rs8.next()) {
                 kicked = rs8.getString(3);


            }ResultSet rs10 = stmt.executeQuery("SELECT * FROM stats5.stats_words_said WHERE player LIKE 0x" + uuid.uuid);
            if (rs10.next()) {
                chat = rs10.getString(3);


            }ResultSet rs11 = stmt.executeQuery("SELECT * FROM stats5.stats_xp_gained WHERE player LIKE 0x" + uuid.uuid);
            if (rs11.next()) {
                xp = rs11.getString(3);


            }ResultSet rs12 = stmt.executeQuery("SELECT * FROM stats5.stats_block_place WHERE player LIKE 0x" + uuid.uuid);
            while (rs12.next()) {
                placed = placed + rs12.getInt(5);


            }ResultSet rs13 = stmt.executeQuery("SELECT * FROM stats5.stats_death WHERE player LIKE 0x" + uuid.uuid);
            while (rs13.next()) {
                deaths = deaths + rs13.getInt(4);

            }ResultSet rs14 = stmt.executeQuery("SELECT * FROM stats5.stats_damage_taken WHERE player LIKE 0x" + uuid.uuid);
            while (rs14.next()) {
                damage = damage + rs14.getInt(3);

            }ResultSet rs15 = stmt.executeQuery("SELECT * FROM stats5.stats_tools_broken WHERE player LIKE 0x" + uuid.uuid);
            while (rs15.next()) {
                brokentools = brokentools + rs15.getInt(4);

            }ResultSet rs16 = stmt.executeQuery("SELECT * FROM stats5.stats_fish_caught WHERE player LIKE 0x" + uuid.uuid);
            while (rs16.next()) {
                fish = fish + rs16.getInt(4);

            }ResultSet rs17 = stmt.executeQuery("SELECT * FROM stats5.stats_food_consumed WHERE player LIKE 0x" + uuid.uuid);
            while (rs17.next()) {
                food = food + rs17.getInt(4);

            }ResultSet rs18 = stmt.executeQuery("SELECT * FROM stats5.stats_items_crafted WHERE player LIKE 0x" + uuid.uuid);
            while (rs18.next()) {
                crafted = crafted + rs18.getInt(4);

            }ResultSet rs19 = stmt.executeQuery("SELECT * FROM stats5.stats_items_dropped WHERE player LIKE 0x" + uuid.uuid);
            while (rs19.next()) {
                dropped = dropped + rs19.getInt(4);

            }ResultSet rs20 = stmt.executeQuery("SELECT * FROM stats5.stats_items_picked_up WHERE player LIKE 0x" + uuid.uuid);
            while (rs20.next()) {
                picked = picked + rs20.getInt(4);

            }ResultSet rs21 = stmt.executeQuery("SELECT * FROM stats5.stats_playtime WHERE player LIKE 0x" + uuid.uuid);
            if (rs21.next()) {
                playtime = rs21.getInt(3);
            }


            stmt.close();
            rs.close();
            rs1.close();
            rs2.close();
            rs3.close();
            rs4.close();
            rs5.close();
            rs6.close();
            rs7.close();
            rs8.close();
            rs10.close();
            rs11.close();
            rs12.close();
            rs13.close();
            rs14.close();
            rs15.close();
            rs16.close();
            rs17.close();
            rs18.close();
            rs19.close();
            rs20.close();
            rs21.close();


        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
            DiscordMessage.pubEvent.getChannel().sendMessage("User never played on the Server!").queue();
        }

    }
}
