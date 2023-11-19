import dao.StudentDAO;
import entity.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student name:");
        String name = scanner.nextLine();

        System.out.println("Enter student age:");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.println("Enter student grade:");
        String grade = scanner.nextLine();

        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setGrade(grade);

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudent(student);
    }
}