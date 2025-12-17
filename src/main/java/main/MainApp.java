package main;

import java.util.Scanner;

import dao.CourseDAO;
import dao.EnrollmentDAO;
import dao.StudentDAO;
import entity.Course;
import entity.Student;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

        while (true) {
            System.out.println("\n===== LEARNING MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student to Course");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter student name: ");
                    sc.nextLine();
                    String sname = sc.nextLine();

                    System.out.print("Enter student email: ");
                    String email = sc.nextLine();

                    Student student = new Student(sname, email);
                    studentDAO.saveStudent(student);

                    System.out.println("Student added successfully");
                    break;

                case 2:
                    System.out.print("Enter course name: ");
                    sc.nextLine();
                    String cname = sc.nextLine();

                    System.out.print("Enter duration (days): ");
                    int duration = sc.nextInt();

                    Course course = new Course(cname, duration);
                    courseDAO.saveCourse(course);

                    System.out.println("Course added successfully");
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int sid = sc.nextInt();

                    System.out.print("Enter course ID: ");
                    int cid = sc.nextInt();

                    enrollmentDAO.enrollStudent(sid, cid);

                    System.out.println("Enrollment successful");
                    break;

                case 4:
                    System.out.println("Thank you for using LMS");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
            
        }
    }
}
