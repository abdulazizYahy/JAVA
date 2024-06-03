package day04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dep {
    public static void main(String[] args) {
          try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\dev\\Downloads\\hr.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM jobs");

            System.out.println("Connected to the SQLite database successfully.");
            System.out.println("Jobs table:");
            while (rs.next()) {
                int id = rs.getInt("job_id");
                String title = rs.getString("job_title");
                double maxsalary = rs.getDouble("max_salary");
                double minsalary = rs.getDouble("min_salary");

                System.out.printf("%d: %s - Min Salary: %.2f, Max Salary: %.2f%n", id, title, minsalary, maxsalary);
            }

            rs.close();
            stmt.close();
            conn.close();
          } catch (SQLException e) {
            System.out.println("Failed to connect to the SQLite database.");
            System.out.println(e.getMessage());
          }
    }
}



