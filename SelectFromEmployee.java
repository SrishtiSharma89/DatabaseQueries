public class SelectFromEmployee {
    public static void main(String[] args) {
       
        String url = "jdbc:mysql://localhost:3306/employeedata"; 
        String username = "root"; 
        String password = "PASSWORD";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM employees";
            ResultSet resultSet = statement.executeQuery(query);

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
