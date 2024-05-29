package HomeWork;
public class Main {

        public static void main(String[] args) {
            Student student1 = new Student("John Doe", 1001);
            Student student2 = new Student("Jane Smith", 1002);
            Student student3 = new Student("Bob Johnson", 1003);

            StudentManager studentManager = new StudentManager();
            studentManager.addStudent(student1);
            studentManager.addStudent(student2);
            studentManager.addStudent(student3);


              Student retrievedStudent = studentManager.getStudentById(1002);
              System.out.println("Retrieved student: " + retrievedStudent.getName() + " (ID: " + retrievedStudent.getId() + ")");


            System.out.println("\nAll students:");


            for (Student student : studentManager.getAllStudents()) {
                System.out.println(student.getName() + " (ID: " + student.getId() + ")");
            }


            boolean removed = studentManager.removeStudentById(1003);
            if (removed) {
                System.out.println("\nStudents after removal:");
                for (Student student : studentManager.getAllStudents()) {
                    System.out.println(student.getName() + " (ID: " + student.getId() + ")");
                }
            } else {
                System.out.println("\nStudent with ID 1003 not found.");
            }
        }
    }


