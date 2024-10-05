import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Lab_Assignment2 {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            //1. Load or Register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2. Establish Connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "student");
            System.out.println("Connection: " + con);

            //3. Prepare Statement
            ps = con.prepareStatement("Select * from student",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            //4. Execute a SELECT query to retrieve data
            ResultSet rs = ps.executeQuery();
            rs.afterLast();
            // Showing the data from result set
            while (rs.previous()) {
                int id = rs.getInt("id");
                System.out.println("Id: " + id);
                String name = rs.getString("name");
                System.out.println("Name: " + name);
                String address = rs.getString("address");
                System.out.println("Address: " + address);
                System.out.println("=========================================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert ps != null;
            con.close();
            ps.close();
        }
    }
}

