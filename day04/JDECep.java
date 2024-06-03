package day04;
import java.sql.*;
import java.util.Scanner;
public class JDECep {




    public static class JDBCDep {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            //Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\dev\\Desktop\\Sdaia_git_repo\\javaP1\\src\\main\\java\\day4\\hr.db");
            String quary = "INSERT into jobs values (?,?,?,?)";
            try ( Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\dev\\Desktop\\Sdaia_git_repo\\javaP1\\src\\main\\java\\day4\\hr.db")){
                PreparedStatement st = conn.prepareStatement(quary);


                System.out.println("Connected to the SQLite database successfully.");
                System.out.println("Enter job id:");
                int jobId = sc.nextInt();
                st.setInt(1,jobId);
                System.out.println("Enter job title:");
                sc.nextLine();

                String jobTitle = sc.nextLine();

                st.setString(2,jobTitle);
                System.out.println("Enter job max_salary:");
                double maxS = sc.nextDouble();
                st.setDouble(3,maxS);
                System.out.println("Enter job min_salary:");
                double minS = sc.nextDouble();
                st.setDouble(4,minS);

                int rows = st.executeUpdate();

                System.out.println(rows + " Inserted");

                st.close();


            } catch (SQLException e) {
                System.out.println("Failed to connect to the SQLite database.");
                System.out.println(e.getMessage());
            }
        }
    }
}
