package connection_test;
import java.sql.*;
public class BasicConnection {
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/mybase?serverTimezone=America/Bogota";
        String username = "project2687365";
        String password = "project2687365";
        String sql = null;
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            sql = "SELECT * FROM mybase.users_tbl";
            conn = DriverManager.getConnection(url,username, password);
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                System.out.print(rs.getString("user_firstname"));
                System.out.print(" | ");
                System.out.print(rs.getString("user_lastname"));
                System.out.print(" | ");
                System.out.print(rs.getString("user_email"));
                System.out.print(" | ");
                System.out.print(rs.getString("user_password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stm.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }// end try-catch
    } // main
}
