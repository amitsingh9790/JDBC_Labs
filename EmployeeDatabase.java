import java.sql.*;

public class EmployeeDatabase {
    public static void main(String[] args) throws SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        try{
            //1. Load or Register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2. Establish Connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB","root","student");
            System.out.println("Connection: " + con);

            //3. Create statement
            ps = con.prepareStatement(
                    "create table Employee(eid int primary key auto_increment not null,name varchar(20) not null,address varchar(20) not null,salary int not null);"
            );
            System.out.println("table creation done successfully");

            //4. Execute the query
            int count = ps.executeUpdate();
            ps = con.prepareStatement("INSERT INTO employee(name,address,salary) VALUES(?,?,?)");

            ps.setString(1,"priya");
            ps.setString(2,"kolkata");
            ps.setInt(3,30000);
            ps.executeUpdate();

            ps = con.prepareStatement("INSERT INTO employee(name,address,salary) VALUE(?,?,?)");
            ps.setString(1,"riya");
            ps.setString(2,"bangalore");
            ps.setInt(3,56000);
            ps.executeUpdate();

            // Execute a SELECT query to retrieve data
            ps = con.prepareStatement("Select * from employee");
            ResultSet rs = ps.executeQuery();

            // Showing the data from result set
            while(rs.next()){
                int id = rs.getInt("eid");
                System.out.println("Id: "+id);
                String name = rs.getString("name");
                System.out.println("Name: "+name);
                String address = rs.getString("address");
                System.out.println("Address: "+address);
                String Salary = rs.getString("salary");
                System.out.println("Salary: "+Salary);
                System.out.println("=========================================");
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
          assert ps != null;
          con.close();
          ps.close();
        }
    }
}
