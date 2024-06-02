package HomeWorks;

public class Students extends Person implements ComparableById  {
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
        }else{
            throw new IllegalArgumentException("Student ID must be bigger than 0 and positive number.");
        }
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student Name: " + name + ", Age: " + age + ", Address: " + address +
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

    public static void main(String[] args) {
        // Test Students class
        Students s1 = new Students("Ziyad", 23, "689 Oak St", 101, "Computer information System");
        Students s2 = new Students("Abdulaziz", 22, "986 Pine St", 102, "IT");

        System.out.println("Details of Student 1:");
        System.out.println(s1);

        System.out.println("\nDetails of Student 2:");
        System.out.println(s2);

        System.out.println("\nIs student s1 matching ID 101? " + s1.compareById(101));
        System.out.println("Is student s2 matching ID 102? " + s2.compareById(3));
    }


    @Override
    public boolean comparableById(int id) {
        return false;
    }
}
