// UPDATE Operation
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateEmployeeData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedata";
        String user = "root";
        String password = "srishti@1234@";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Connected to the database!");

            System.out.println("Enter employee details to update:");
            System.out.print("Employee ID to update: ");
            int updateId = scanner.nextInt();
            System.out.print("New Salary: ");
            double newSalary = scanner.nextDouble();

            String updateQuery = "UPDATE employees SET salary = ? WHERE employee_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
                pstmt.setDouble(1, newSalary);
                pstmt.setInt(2, updateId);
                int rowsUpdated = pstmt.executeUpdate();
                System.out.println(rowsUpdated + " row(s) updated.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
