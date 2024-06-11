package org.example;


public class Students extends Person implements ComparableById {
    int studentID;
    String course;

    public Students(String name, int age, String address, int studentID, String course) {
        super(name, age, address);
        setStudentID(studentID);
        this.course = course;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getCourse() {
        return course;
    }

    public void setStudentID(int studentID) {
        if (studentID > 0){
            this.studentID = studentID;
        } else {
            throw new IllegalArgumentException("Student ID must be bigger than 0 and a positive number.");
        }
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student Name: " + getName() + ", Age: " + getAge() + ", Address: " + getAddress() +
                ", Student ID: " + studentID + ", Course: " + course;
    }

    @Override
    public String getDetails() {
        return toString();
    }

    @Override
    public boolean compareById(int id) {
        return studentID == id;
    }

    @Override
    public boolean ComparableByld(int id) {
        return false;
    }
}