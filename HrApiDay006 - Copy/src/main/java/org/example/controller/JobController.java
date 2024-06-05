package org.example.controller;

import org.example.dao.JobDAO;
import org.example.dao.JobFilterDto;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.*;
import org.example.models.Job;

import java.util.ArrayList;

@Path("/jobs")
public class JobController {

    JobDAO dao = new JobDAO();

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public ArrayList<Job> getAllJobs(@BeanParam JobFilterDto filterDto ) {
        try {
            return dao.selectAll(filterDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("{JobId}")
    public Job getDepartment(@PathParam("JobId") int JobId) {

        try {
            return dao.selectJob(JobId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @DELETE
    @Path("{jobId}")
    public void deleteJob(@PathParam("jobId") int jobId) {
        try {
            dao.deleteJob(jobId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @POST

    public void insertJob(Job job) {
        try {
            dao.insertJob(job);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("{jobId}")

    public void updateJob(@PathParam("jobId") int jobId, Job job) {
        try {
            job.setJob_id(jobId);
            dao.updateJob(job);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
}


