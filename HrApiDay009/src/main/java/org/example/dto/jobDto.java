package org.example.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//@XmlRootElement
public class jobDto {

    private int jobId;
    private String title;
    private double minSalary, maxSal;

    private ArrayList<LinkDto> links = new ArrayList<>();
    public jobDto() {
    }

    public jobDto(int jobId, String title, double minSalary, double maxSalary) {
        this.jobId = jobId;
        this.title = title;
        this.minSalary = minSalary;
        this.maxSal = maxSalary;
    }

    public jobDto(ResultSet rs) throws SQLException {
        jobId = rs.getInt("job_id");
        title = rs.getString("job_title");
        minSalary = rs.getDouble("min_salary");
        maxSal = rs.getDouble("max_salary");
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public double getMaxSalary() {return maxSal;}

    public void setMinsalary(double min_salary) {
        this.minSalary = min_salary;
    }

    public void setMaxsalary(double max_salary) {
        this.maxSal = max_salary;
    }





    public ArrayList<LinkDto> getLinks() {
        return links;
    }

    public void addLink(String url, String rel) {
        LinkDto link = new LinkDto();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }

    @Override
    public String toString() {
        return "job{" +
                "jobId=" + jobId +
                ", title='" + title + '\'' +
                ", minSalary=" + minSalary +
                ", maxSal=" + maxSal +
                '}';
    }
}