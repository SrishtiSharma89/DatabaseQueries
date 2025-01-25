// INSERT Operation
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertEmployeeData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedata";
        String user = "root";
        String password = "PASSWORD";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Connected to the database!");

            System.out.println("Enter employee details to insert:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();

            String insertQuery = "INSERT INTO employees (name, age, salary) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.setDouble(3, salary);
                int rowsInserted = pstmt.executeUpdate();
                System.out.println(rowsInserted + " row(s) inserted.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
