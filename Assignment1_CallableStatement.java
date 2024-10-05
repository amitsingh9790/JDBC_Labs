import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Assignment1_CallableStatement {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. Load or Register the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (
                //2. Establishes the Connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InstructorDB", "root", "student");

                //3. Create Callable Statement to call the stored procedure
                CallableStatement cs = con.prepareCall("{call getInstructorFeedback(?)}");
        ) {
            // Pass the instructorId as a parameter
            cs.setInt(1, 101);

            //4. Execute the query
            ResultSet rs = cs.executeQuery();

            //Displaying the result set
            while (rs.next()) {
                int id = rs.getInt("instructor_id");
                String name = rs.getString("name");
                String feedback = rs.getString("feedback");

                System.out.println("Instructor ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Feedback: " + feedback);
                System.out.println("=========================================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
