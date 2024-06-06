package org.example.dao;
import org.example.models.*;

import java.sql.*;
import java.util.ArrayList;

public class JobDAO {

    private static final String URL = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\javaCourse\\HrApiDay7\\HrApiDay7\\src\\main\\java\\org\\example\\hr.db";
    private static final String SELECT_ALL_jobs = "select * from jobs";
    private static final String SELECT_ONE_job = "select * from jobs where job_id = ?";
    private static final String Insert_job = "insert into jobs values (?, ?, ?, ?)";
    private static final String UPDATE_job = "update jobs set job_title = ?, min_salary = ?, max_salary = ? where job_id = ?";
    private static final String DELETE_job = "delete from departments where department_id = ?";

    public void insertJob(job job) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(Insert_job);
        st.setInt(1, job.getJobId());
        st.setString(2, job.getTitle());
        st.setDouble(3, job.getMinSalary());
        st.setDouble(4, job.getMaxSal());
        st.executeUpdate();
    }

    public void updateJob(job job) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_job);
        st.setString(1, job.getTitle());
        st.setDouble(2, job.getMinSalary());
        st.setDouble(3, job.getMaxSal());
        st.setInt(4, job.getJobId());
        st.executeUpdate();
    }

    public void deletejob(int jobId) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_job);
        st.setInt(1, jobId);
        st.executeUpdate();
    }

    public job selectJob(int jobId) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_job);
        st.setInt(1, jobId);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return new job(rs);
        } else {
            return null;
        }
    }

    public ArrayList<job> selectAlljobs() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ALL_jobs);
        ResultSet rs = st.executeQuery();
        ArrayList<job> jobs = new ArrayList<>();
        while (rs.next()) {
            jobs.add(new job(rs));
        }

        return jobs;
    }

}
