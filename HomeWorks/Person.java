package HomeWorks;

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

    public static void main(String[] args) {
        Person p1 = new Person("Mohammed", 25, "123 Main St");
        Person p2 = new Person("Abdulrhman", 30, "456 Elm St");

        System.out.println("Details of Person 1:");
        System.out.println("Name: " + p1.getName());
        System.out.println("Age: " + p1.getAge());
        System.out.println("Address: " + p1.getAddress());

        System.out.println("\nDetails of Person 2:");
        System.out.println("Name: " + p2.getName());
        System.out.println("Age: " + p2.getAge());
        System.out.println("Address: " + p2.getAddress());
    }
}