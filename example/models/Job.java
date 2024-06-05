package org.example.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Job {


    private int job_id;
    private String job_title;
    private double min_salary;
    private double max_salary;

    public Job(int job_id, String job_title, double min_salary, double max_salary) throws SQLException {
        this.job_id = job_id;
        this.job_title = job_title;
        this.min_salary = min_salary;
        this.max_salary = max_salary;
    }

    public Job(ResultSet rs) throws SQLException {
        this.job_id = rs.getInt("job_id");
        this.job_title = rs.getString("job_title");
        this.min_salary = rs.getDouble("min_salary");
        this.max_salary = rs.getDouble("max_salary");
    }

    // Getters
    public int getJob_id() {
        return job_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public double getMin_salary() {
        return min_salary;
    }

    public double getMax_salary() {
        return max_salary;
    }

    // Setters
    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public void setMin_salary(double min_salary) {
        this.min_salary = min_salary;
    }

    public void setMax_salary(double max_salary) {
        this.max_salary = max_salary;
    }


}