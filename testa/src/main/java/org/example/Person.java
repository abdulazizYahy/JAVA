package org.example;


public abstract class Person extends PersonRecord{
    String name;
    int age;
    String address;

    public Person(String name, int age, String address) {
        this.name = name;
        setAge(age);
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 150){
            this.age = age;
        }else {
            throw new IllegalArgumentException("The age must be between 0 - 150.");
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Address: " + address;
    }

    @Override
    public String getDetails() {
        return toString();
    }

    public abstract boolean compareById(int id);
}