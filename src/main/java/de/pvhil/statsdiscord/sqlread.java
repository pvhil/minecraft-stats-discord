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

    public static void sqlact()

    {

        try {
            Statement stmt = main.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM stats5.stats_block_break WHERE player LIKE 0x" + uuid.uuid);
            if (rs.next()) {
                System.out.println(rs.getString(4));

            } ResultSet rs1 = stmt.executeQuery("SELECT * FROM stats5.stats_arrows_shot WHERE player LIKE 0x" + uuid.uuid);
            if (rs1.next()) {
                System.out.println(rs1.getString(3));
                arrows = rs1.getString(3);


            }ResultSet rs2 = stmt.executeQuery("SELECT * FROM stats5.stats_beds_entered WHERE player LIKE 0x" + uuid.uuid);
            if (rs2.next()) {
                System.out.println(rs2.getString(3));
                beds = rs2.getString(3);


            }
            ResultSet rs3 = stmt.executeQuery("SELECT * FROM stats5.stats_buckets_emptied WHERE player LIKE 0x" + uuid.uuid);
            if (rs3.next()) {
                System.out.println(rs3.getString(3));
                bucketemp = rs3.getString(3);


            }
            ResultSet rs4 = stmt.executeQuery("SELECT * FROM stats5.stats_commands_performed WHERE player LIKE 0x" + uuid.uuid);
            if (rs4.next()) {
                System.out.println(rs4.getString(3));
                commands = rs4.getString(3);


            }ResultSet rs5 = stmt.executeQuery("SELECT * FROM stats5.stats_eggs_thrown WHERE player LIKE 0x" + uuid.uuid);
            if (rs5.next()) {
                System.out.println(rs5.getString(3));
                eggs = rs5.getString(3);


            }ResultSet rs6 = stmt.executeQuery("SELECT * FROM stats5.stats_pvp_kills WHERE player LIKE 0x" + uuid.uuid);
            if (rs6.next()) {
                System.out.println(rs6.getString(3));
                kills = rs6.getString(3);


            }ResultSet rs7 = stmt.executeQuery("SELECT * FROM stats5.stats_times_joined WHERE player LIKE 0x" + uuid.uuid);
            if (rs7.next()) {
                System.out.println(rs7.getString(3));
                join = rs7.getString(3);


            }ResultSet rs8 = stmt.executeQuery("SELECT * FROM stats5.stats_times_kicked WHERE player LIKE 0x" + uuid.uuid);
            if (rs8.next()) {
                System.out.println(rs8.getString(3));
                 kicked = rs8.getString(3);


            }ResultSet rs9 = stmt.executeQuery("SELECT * FROM stats5.stats_arrows_shot WHERE player LIKE 0x" + uuid.uuid);
            if (rs9.next()) {
                System.out.println(rs9.getString(3));



            }ResultSet rs10 = stmt.executeQuery("SELECT * FROM stats5.stats_words_said WHERE player LIKE 0x" + uuid.uuid);
            if (rs10.next()) {
                System.out.println(rs10.getString(3));
                chat = rs10.getString(3);


            }ResultSet rs11 = stmt.executeQuery("SELECT * FROM stats5.stats_xp_gained WHERE player LIKE 0x" + uuid.uuid);
            if (rs11.next()) {
                System.out.println(rs11.getString(3));
                xp = rs11.getString(3);


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
            rs9.close();
            rs10.close();
            rs11.close();


        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
            DiscordMessage.pubEvent.getChannel().sendMessage("User never played on the Server!").queue();
        }

    }
}
