package org.example.controller;
import org.example.dao.JobDAO;
import org.example.dto.jobDto;
import org.example.models.job;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.URI;
import java.util.ArrayList;

@Path("/jobs")
public class JobController {

    JobDAO dao = new JobDAO();
    @Context UriInfo uriInfo;
    @Context HttpHeaders headers;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllJobs(
            @HeaderParam("Authorization") String authorizationHeader,
            @CookieParam("JSESSIONID") Cookie sessionId) {
        try {
            GenericEntity<ArrayList<job>> jobs = new GenericEntity<ArrayList<job>>(dao.selectAlljobs()) {};
            if(headers.getAcceptableMediaTypes().contains(MediaType.valueOf(MediaType.APPLICATION_XML))) {
                return Response
                        .ok(jobs)
                        .type(MediaType.APPLICATION_XML)
                        .build();
            }
            return Response
                    .ok(jobs, MediaType.APPLICATION_JSON)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred while fetching the jobs.")
                    .build();
        }
    }

    @GET
    @Path("{jobId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getJob(
            @HeaderParam("Authorization") String authorizationHeader,
            @CookieParam("JSESSIONID") Cookie sessionId,
            @PathParam("jobId") int jobId) {
        try {
            job job = dao.selectJob(jobId);
            if (job == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Job not found.")
                        .build();
            }
            jobDto jto = new jobDto();
            jto.setJobId(jto.getJobId());
            jto.setTitle(jto.getTitle());
            jto.setMinSalary(jto.getMinSalary());

            addLinks(jto);
            return Response.ok(jto).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred while fetching the job.")
                    .build();
        }
    }

    private void addLinks(jobDto jto) {
        URI selfUri = uriInfo.getAbsolutePath();
        URI empsUri = uriInfo.getAbsolutePathBuilder()
                .path(JobController.class)
                .build();

        jto.addLink(selfUri.toString(), "self");
        jto.addLink(empsUri.toString(), "employees");
    }

    @DELETE
    @Path("{jobId}")
    public Response deleteJob(
            @CookieParam("JSESSIONID") Cookie sessionId,
            @PathParam("jobId") int jobId) {
        try {
            dao.deletejob(jobId);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred while deleting the job.")
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertJob(job tJob) {
        try {
            dao.insertJob(tJob);
            URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(tJob.getJobId())).build();
            return Response.created(uri).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred while inserting the job.")
                    .build();
        }
    }

    @PUT
    @Path("{jobId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateJob(@PathParam("jobId") int jobId, job tJob) {
        try {
            tJob.setJobId(jobId);
            dao.updateJob(tJob);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred while updating the job.")
                    .build();
        }
    }
}