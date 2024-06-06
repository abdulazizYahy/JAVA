package org.example.dao;

public interface JobFilterDto {
    void setJobId(int jobId);

    void setMaxSalary(double maxSalary);

    void setMinSalary(double minSalary);
    void setJob_title(String jobTitle);

}
