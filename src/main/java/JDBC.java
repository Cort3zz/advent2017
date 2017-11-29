import java.sql.*;

public class JDBC {



    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "postgres://wcydfihkdzncoo:3143fc315b0462594a5ed74f7d2fc682258ab247a77f86de8d287fec6dc97423@ec2-184-72-255-211.compute-1.amazonaws.com:5432/drhp6e2pfd5ng";

    static final String USER = "wcydfihkdzncoo";
    static final String PASS = "3143fc315b0462594a5ed74f7d2fc682258ab247a77f86de8d287fec6dc97423";

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
