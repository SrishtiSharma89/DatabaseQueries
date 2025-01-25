// DELETE Operation
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteEmployeeData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedata";
        String user = "root";
        String password = "srishti@1234@";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Connected to the database!");

            System.out.println("Enter employee ID to delete:");
            System.out.print("Employee ID: ");
            int deleteId = scanner.nextInt();

            String deleteQuery = "DELETE FROM employees WHERE employee_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
                pstmt.setInt(1, deleteId);
                int rowsDeleted = pstmt.executeUpdate();
                System.out.println(rowsDeleted + " row(s) deleted.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
