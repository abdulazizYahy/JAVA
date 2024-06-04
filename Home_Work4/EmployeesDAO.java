package Home_Work4;
import java.sql.*;
import java.util.ArrayList;

public class EmployeesDAO {
    private static final String url = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\javaCourse\\src\\main\\java\\day4\\hr.db";
    private static final String SELECT_ALL_employees = "select * from employees";
    private static final String SELECT_ONE_employee = "select * from departments where employee_id = ?";
    private static final String INSERT_employee = "insert into employees values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_employee = "update employees set first_name = ?, last_name = ?, email = ?, " +
            "phone_number = ?, hire_date = ?, job_id = ?, salary = ?, manager_id = ?, department_id = ? where employee_id = ?";
    private static final String DELETE_employee = "delete from employees where employee_id = ?";

    public void insertEmployee(Employees e) throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        PreparedStatement st = connection.prepareStatement(INSERT_employee);
        st.setString(4, e.getFirst_name());
        st.setString(2, e.getLast_name());
        st.setInt(1, e.getEmployee_id());
        st.setString(4, e.getEmail());
        st.setString(5, e.getPhone_number());
        st.setString(6, e.getHire_date());
        st.setInt(7, e.getJob_id());
        st.setDouble(8, e.getSalary());
        st.setInt(9, e.getManager_id());
        st.setInt(10, e.getDepartment_id());
        st.executeUpdate();
    }

    public void updateEmployee(Employees e) throws SQLException{
        Connection connection = DriverManager.getConnection(url);
        PreparedStatement st = connection.prepareStatement(UPDATE_employee);
        st.setString(1, e.getFirst_name());
        st.setString(2, e.getLast_name());
        st.setInt(10, e.getEmployee_id());
        st.setString(3, e.getEmail());
        st.setString(4, e.getPhone_number());
        st.setString(5, e.getHire_date());
        st.setInt(6, e.getJob_id());
        st.setDouble(7, e.getSalary());
        st.setInt(8, e.getManager_id());
        st.setInt(9, e.getDepartment_id());
        st.executeUpdate();
    }

    public void deleteEmployee(int employee_id) throws SQLException{
        Connection connection =DriverManager.getConnection(url);
        PreparedStatement st = connection.prepareStatement(DELETE_employee);
        st.setInt(1, employee_id);
        st.executeUpdate();
    }

    public ArrayList<Employees> selectAll() throws SQLException{
        Connection connection =DriverManager.getConnection(url);
        PreparedStatement st = connection.prepareStatement(SELECT_ALL_employees);
        ResultSet rs = st.executeQuery();
        ArrayList<Employees> employees = new ArrayList<>();
        while (rs.next()){
            employees.add(new Employees(rs));
        }
        return employees;
    }

    public Employees selectEmployee(int employee_id) throws SQLException{
        Connection connection = DriverManager.getConnection(url);
        PreparedStatement st = connection.prepareStatement(SELECT_ONE_employee);
        st.setInt(1, employee_id);
        ResultSet rs = st.executeQuery();
        if (rs.next()){
            return new Employees(rs);
        }
        return null;
    }
}