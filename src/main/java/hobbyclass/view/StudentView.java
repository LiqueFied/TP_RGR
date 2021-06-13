package hobbyclass.view;

import hobbyclass.model.Student;
import hobbyclass.service.StudentService;
import org.hibernate.service.spi.ServiceException;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentView {

    private StudentService studentService = new StudentService();
    private Scanner firstScan = new Scanner(System.in);
    private Scanner secondScan = new Scanner(System.in);

    private static void actions() {
        System.out.println("\nChoose student action:\n"
                + "1-Insert new row.\n"
                + "2-Show all row.\n"
                + "3-Delete row.\n"
                + "4-Update row.\n"
                + "5-Search by id.\n"
                + "\t0-Exit.");
    }

    public void runStudentView() throws SQLException {
        actions();
        Scanner mainScan = new Scanner(System.in);
        try {
            int numOfPoint = mainScan.nextInt();
            while (numOfPoint != 0) {
                switch (numOfPoint) {
                    case 1:
                        addStudent();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 2:
                        printAllStudents();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 3:
                        deleteStudent();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 4:
                        updateStudent();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 5:
                        getByIdStudent();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 0:
                        numOfPoint = 0;
                        break;
                    default:
                        System.out.println("There is no such command.");
                        actions();
                        numOfPoint = mainScan.nextInt();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addStudent() throws SQLException {
        try {
            Student student = new Student();

            System.out.println("Enter student name: ");
            String studentName = firstScan.nextLine();
            student.setName(studentName);

            System.out.println("Enter dateOfBirth:");
            String studentDateOfBirth = secondScan.nextLine();
            student.setDateOfBirth(studentDateOfBirth);

            System.out.println("Enter phone number:");
            String studentPhoneNumber = firstScan.nextLine();
            student.setPhoneNumber(studentPhoneNumber);

            System.out.println("Enter email:");
            String studentEmail = secondScan.nextLine();
            student.setEmail(studentEmail);

            studentService.saveStudent(student);
            System.out.println("Student has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void updateStudent() throws SQLException {
        try {
            System.out.println("Enter id in order to find element :");
            Long id = Long.parseLong(secondScan.next());

            Student newStudent = studentService.getStudentById(id);

            System.out.println("Enter student name: ");
            String studentName = firstScan.nextLine();
            newStudent.setName(studentName);

            System.out.println("Enter dateOfBirth:");
            String studentDateOfBirth = secondScan.nextLine();
            newStudent.setDateOfBirth(studentDateOfBirth);

            System.out.println("Enter phone number:");
            String studentPhoneNumber = firstScan.nextLine();
            newStudent.setPhoneNumber(studentPhoneNumber);

            System.out.println("Enter email:");
            String studentEmail = secondScan.nextLine();
            newStudent.setEmail(studentEmail);

            studentService.updateStudent(newStudent);
            System.out.println("Student with id " + id + " has been updated successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deleteStudent() throws SQLException {
        System.out.println("Enter id in order to delete row:");
        Long id = Long.parseLong(secondScan.next());
        try {
            studentService.deleteStudent(id);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Student with id " + id + " has been deleted successfully");
    }

    public void printAllStudents() throws SQLException {
        List<Student> students = studentService.printAllStudents();
        System.out.println("List of all students:");
        students.forEach(student1 -> System.out.println(student1.toString()));
    }

    public void getByIdStudent() throws SQLException {
        System.out.println("Enter id in order to get student:");
        Long id = Long.parseLong(firstScan.next());
        try {
            if (studentService.getStudentById(id) != null) {
                System.out.println(studentService.getStudentById(id).toString());
            } else {
                System.out.println("This id is doesn't exist.");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number.");
            getByIdStudent();
        }
    }
}
