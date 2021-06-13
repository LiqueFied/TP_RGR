package hobbyclass.view;

import hobbyclass.model.Teacher;
import hobbyclass.service.TeacherService;
import org.hibernate.service.spi.ServiceException;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TeacherView {

    private TeacherService teacherService = new TeacherService();
    private Scanner firstScan = new Scanner(System.in);
    private Scanner secondScan = new Scanner(System.in);

    private static void actions() {
        System.out.println("\nChoose teacher action:\n"
                + "1-Insert new row.\n"
                + "2-Show all row.\n"
                + "3-Delete row.\n"
                + "4-Update row.\n"
                + "5-Search by id.\n"
                + "\t0-Exit.");
    }

    public void runTeacherView() throws SQLException {
        actions();
        Scanner mainScan = new Scanner(System.in);
        try {
            int numOfPoint = mainScan.nextInt();
            while (numOfPoint != 0) {
                switch (numOfPoint) {
                    case 1:
                        addTeacher();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 2:
                        printAllTeachers();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 3:
                        deleteTeacher();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 4:
                        updateTeacher();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 5:
                        getByIdTeacher();

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

    public void addTeacher() throws SQLException {
        try {
            Teacher teacher = new Teacher();

            System.out.println("Enter teacher name: ");
            String studentName = firstScan.nextLine();
            teacher.setName(studentName);

            System.out.println("Enter phonenumber:");
            String teacherPhonenumber = secondScan.nextLine();
            teacher.setPhoneNumber(teacherPhonenumber);

            teacherService.saveTeacher(teacher);
            System.out.println("Teacher has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void updateTeacher() throws SQLException {
        try {
            System.out.println("Enter id in order to find element :");
            Long id = Long.parseLong(secondScan.next());

            Teacher newTeacher = teacherService.getTeacherById(id);

            System.out.println("Enter teacher name: ");
            String studentName = firstScan.nextLine();
            newTeacher.setName(studentName);

            System.out.println("Enter phonenumber:");
            String teacherPhonenumber = secondScan.nextLine();
            newTeacher.setPhoneNumber(teacherPhonenumber);

            teacherService.updateTeacher(newTeacher);
            System.out.println("Teacher has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deleteTeacher() throws SQLException {
        System.out.println("Enter id in order to delete row:");
        Long id = Long.parseLong(secondScan.next());
        try {
            teacherService.deleteTeacher(id);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Teacher with id " + id + " has been deleted successfully");
    }

    public void printAllTeachers() throws SQLException {
        List<Teacher> teachers = teacherService.printAllTeachers();
        System.out.println("List of all teachers:");
        teachers.forEach(teacher1 -> System.out.println(teacher1.toString()));
    }

    public void getByIdTeacher() throws SQLException {
        System.out.println("Enter id in order to get teacher:");
        Long id = Long.parseLong(firstScan.next());
        try {
            if (teacherService.getTeacherById(id) != null) {
                System.out.println(teacherService.getTeacherById(id).toString());
            } else {
                System.out.println("This id is doesn't exist.");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number.");
            getByIdTeacher();
        }
    }
}
