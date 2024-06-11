
import org.example.Person;
import org.example.School;
import org.example.Students;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class TestClass {
    private Person p1;
    private Students s1;
    private static School school;
    private static Students student1;
    private static Students student2;
    private static Students student3;


    @BeforeEach
    public void init(){
        student1 = new Students("Abdulaziz", 23, "Riyadh", 12345, "Computer Science");
        student2 = new Students("Ahmed", 21, "Albaha", 12346, "Mathematics");
        student3 = new Students("Omar", 24, "Jeddah", 12347, "Physics");

        ArrayList<Students> studentsList = new ArrayList<>();
        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);

        school = new School(studentsList);
        System.out.println("stsrt before each");
    }


    @Test
    public void testPerson() {
        p1 = new Person("Abdulaziz", 23, "Riyadh") {
            @Override
            public boolean compareById(int id) {
                return false;
            }
        };








        String actual = "Name: " + p1.getName() + ", Age: " + p1.getAge() + ", Address: " + p1.getAddress();
        String expected = "Name: Abdulaziz, Age: 23, Address: Riyadh";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testStudents(){
        s1 = new Students("Ali", 18, "Tabuk", 123, "JAVA");

        String actual = "Student Name: " + s1.getName() + ", Age: " + s1.getAge() + ", Address: " + s1.getAddress() +
                ", Student ID: " + s1.getStudentID() + ", Course: " + s1.getCourse();
    }

    @Test
    public void testAddStudents() {
        Students newStudent = new Students("Laila", 21, "Mecca", 12348, "Chemistry");
        school.addStudents(newStudent);

        Assertions.assertEquals(4, school.getStudents().size());
        Assertions.assertEquals(newStudent, school.getStudents().get(3));
    }

    @Test
    public void testRemoveStudentById() {
        school.removeStudentById(12345);
        Assertions.assertEquals(2, school.getStudents().size());
        Assertions.assertNull(school.findStudentById(12345));
    }

    @Test
    public void testSortStudentsByName() {
        school.sortStudentsByName();

        Assertions.assertEquals("Abdulaziz", school.getStudents().get(0).getName());
        Assertions.assertEquals("Ahmed", school.getStudents().get(1).getName());
        Assertions.assertEquals("Omar", school.getStudents().get(2).getName());
    }

    @Test
    public void testFindStudentById() {
        Students foundStudent = school.findStudentById(12345);
        Assertions.assertNotNull(foundStudent);
        Assertions.assertEquals(student1, foundStudent);

        Students notFoundStudent = school.findStudentById(99999);
        Assertions.assertNull(notFoundStudent);
    }

    @Test
    public void testWriteAndReadStudentsToFile() {
        String fileName = "students.txt";

        // Write students to file
        school.writeStudentsToFile(fileName);

        // Clear current students and read back from file
        school.readStudentsFromFile(fileName);

        Assertions.assertEquals(3, school.getStudents().size());
        Assertions.assertEquals(student1.getName(), school.getStudents().get(0).getName());
        Assertions.assertEquals(student2.getName(), school.getStudents().get(1).getName());
        Assertions.assertEquals(student3.getName(), school.getStudents().get(2).getName());
    }

}