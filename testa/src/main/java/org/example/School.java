package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.io.BufferedReader;
import java.io.FileReader;


public class School {
    private ArrayList<Students> students;

    public ArrayList<Students> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Students> students) {
        this.students = students;
    }

    public School(ArrayList<Students> students) {
        this.students = students;
    }

    public void addStudents(Students student) {
        students.add(student);
    }

    public void removeStudentById(int studentId) {
        Students studentToRemove = null;
        for (Students student : students) {
            if (student.getStudentID() == studentId) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student with ID " + studentId + " removed successfully.");
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void sortStudentsByName() {
        Collections.sort(students, Comparator.comparing(Students::getName));
    }

    public Students findStudentById(int studentId) {
        int left = 0;
        int right = students.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Students currentStudent = students.get(mid);

            if (currentStudent.getStudentID() == studentId) {
                return currentStudent;
            } else if (currentStudent.getStudentID() < studentId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void writeStudentsToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Students student : students) {
                writer.println(student.toString());
            }
            System.out.println("Student details written to " + fileName + " successfully.");
        } catch (IOException e) {
            System.err.println("Error writing student details to file: " + e.getMessage());
        }
    }

    public void readStudentsFromFile(String fileName) {
        students.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) { // Assuming the line contains all necessary details
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String address = parts[2];
                    int studentId = Integer.parseInt(parts[3]);
                    String course = parts[4];
                    students.add(new Students(name, age, address, studentId, course));
                } else {
                    System.err.println("Invalid data format in line: " + line);
                }
            }
            System.out.println("Student details read from " + fileName + " successfully.");
        } catch (IOException e) {
            System.err.println("Error reading student details from file: " + e.getMessage());
        }
    }
}