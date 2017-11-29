import java.sql.*;

public class JDBC {

    public static void main(String[] args) {
        addLog("booooyaaaa");
    }

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/adventlog";

    static final String USER = "postgres";
    static final String PASS = "test1234";

    public static void addLog(String log) {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (Exception e){
            e.printStackTrace();
        }

        try (
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement())

        {

            String sql = "CREATE TABLE IF NOT EXISTS adventlog.log" +
                    " (log VARCHAR(255));";

            stmt.execute(sql);

            sql = "INSERT INTO adventlog.log" +
                    " VALUES ('" + log + "')";
            stmt.executeUpdate(sql);


        } catch (
                Exception ex)

        {
            ex.printStackTrace();
            System.out.println(ex);
        }

    }
}
