import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JDBC {


    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://den1.mysql2.gear.host:3306/adventlog";

    static final String USER = "adventlog";
    static final String PASS = "Pe180g_lc5-3";

    public static void addLog(String log, String table) {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (Exception e){
            e.printStackTrace();
        }

        try (
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement())

        {

           String sql = "CREATE TABLE IF NOT EXISTS " +table +
                    " (log VARCHAR(255));";

            stmt.execute(sql);

            sql = "INSERT INTO " +table +
                    " VALUES ('" + log + "')";
            stmt.executeUpdate(sql);


        } catch (
                Exception ex)

        {
            ex.printStackTrace();
            System.out.println(ex);
        }

    }

    public static List<String> getAllOpenedDay() {
        List<String> days = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            Class.forName(JDBC_DRIVER);

            String sql = "select day from already_opened;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String getName = rs.getString("day");
                days.add(getName);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return days;
    }

    public static String getDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Instant now = Instant.now();
        ZoneId zoneId = ZoneId.of( "Europe/Budapest" );
        ZonedDateTime zdt = ZonedDateTime.ofInstant( now , zoneId );
        String formattedDate = zdt.format(formatter);
        return formattedDate;
    }
}
