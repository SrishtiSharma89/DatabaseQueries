public class SelectFromEmployee {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/employeedata"; // Replace 'localhost' with your server address
        String username = "root"; // Replace with your MySQL username
        String password = "PASSWORD"; // Replace with your MySQL password

        // JDBC connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            String query = "SELECT * FROM employees";
            ResultSet resultSet = statement.executeQuery(query);

            // Process the results
            System.out.println("ID | Name    | Age  | Salary");
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double salary = resultSet.getDouble("salary");
                System.out.printf("%d | %s | %d | %.2f%n", id, name, age, salary);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
