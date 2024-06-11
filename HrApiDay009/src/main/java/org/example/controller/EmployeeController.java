package org.example.controller;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.example.models.Employee;

import java.util.ArrayList;

@Path("/employees")
public class EmployeeController {

    @GET
    public ArrayList<Employee> getAllEmployees(@PathParam("deptId") Integer deptId) {
        System.out.println(deptId);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        employees.add(new Employee());
        employees.add(new Employee());
        employees.add(new Employee());
        return employees;
    }

    @POST
    public void insertEmployee(@PathParam("deptId") Integer deptId, Employee emp) {

        System.out.println(deptId);
        System.out.println(emp);
    }

}
