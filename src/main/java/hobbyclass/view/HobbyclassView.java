package hobbyclass.view;

import hobbyclass.model.Hobby;
import hobbyclass.model.Hobbyclass;
import hobbyclass.model.Teacher;
import hobbyclass.model.Student;
import hobbyclass.service.HobbyService;
import hobbyclass.service.HobbyclassService;
import hobbyclass.service.TeacherService;
import hobbyclass.service.StudentService;
import org.hibernate.service.spi.ServiceException;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HobbyclassView {

    private HobbyclassService hobbyclassService = new HobbyclassService();
    private HobbyService hobbyService = new HobbyService();
    private StudentService studentService = new StudentService();
    private TeacherService teacherService = new TeacherService();

    private Scanner firstScan = new Scanner(System.in);
    private Scanner secondScan = new Scanner(System.in);

    private static void actions() {
        System.out.println("\nChoose hobbyclass action:\n"
                + "1-Insert new row.\n"
                + "2-Show all row.\n"
                + "3-Delete row.\n"
                + "4-Update row.\n"
                + "5-Search by id.\n"
                + "\t0-Exit.");
    }

    public void runHobbyclassView() throws SQLException {
        actions();
        Scanner mainScan = new Scanner(System.in);
        try {
            int numOfPoint = mainScan.nextInt();
            while (numOfPoint != 0) {
                switch (numOfPoint) {
                    case 1:
                        addHobbyclass();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 2:
                        printAllHobbyclasses();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 3:
                        deleteHobbyclass();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 4:
                        updateHobbyclass();

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

    public void addHobbyclass() throws SQLException {
        try {
            Hobbyclass hobbyclass = new Hobbyclass();

            System.out.println("Enter hobbyclass name: ");
            String hobbyclassName = firstScan.nextLine();
            hobbyclass.setName(hobbyclassName);

            System.out.println("Enter formationDate:");
            String hobbyclassFormationDate = firstScan.nextLine();
            hobbyclass.setFormationDate(hobbyclassFormationDate);

            System.out.println("Enter return date:");
            String hobbyclassGraduationDate = firstScan.nextLine();
            hobbyclass.setGraduationDate(hobbyclassGraduationDate);

            System.out.println("Enter amountStudents:");
            String hobbyclassAmountStudents = firstScan.nextLine();
            hobbyclass.setAmountStudents(hobbyclassAmountStudents);

            Hobby testHobby = hobbyService.getHobbyById(1L);
            if (testHobby != null) {
                System.out.println("Enter hobby_id:");
                String hobbyclassHobbyId = secondScan.nextLine();
                Hobby hobby = hobbyService.getHobbyById((long) Integer.parseInt(hobbyclassHobbyId));
                hobbyclass.setHobby(hobby);
            } else hobbyclass.setHobby(null);

            Student testStudent = studentService.getStudentById(1L);
            if (testStudent != null) {
                System.out.println("Enter student_id:");
                String hobbyclassStudentId = secondScan.nextLine();
                Student student = studentService.getStudentById((long) Integer.parseInt(hobbyclassStudentId));
                hobbyclass.setStudent(student);
            } else hobbyclass.setStudent(null);

            Teacher testTeacher = teacherService.getTeacherById(1L);
            if (testTeacher != null) {
                System.out.println("Enter teacher_id:");
                String hobbyclassTeacherId = secondScan.nextLine();
                Teacher teacher = teacherService.getTeacherById((long) Integer.parseInt(hobbyclassTeacherId));
                hobbyclass.setTeacher(teacher);
            } else hobbyclass.setTeacher(null);

            hobbyclassService.saveHobbyclass(hobbyclass);
            System.out.println("Hobbyclass has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void updateHobbyclass() throws SQLException {
        try {
            System.out.println("Enter id in order to find element :");
            Long id = Long.parseLong(secondScan.next());

            Hobbyclass newHobbyclass = hobbyclassService.getHobbyclassById(id);

            System.out.println("Enter hobbyclass name: ");
            String hobbyclassName = firstScan.nextLine();
            newHobbyclass.setName(hobbyclassName);

            System.out.println("Enter formationDate:");
            String hobbyclassFormationDate = firstScan.nextLine();
            newHobbyclass.setFormationDate(hobbyclassFormationDate);

            System.out.println("Enter graduationDate:");
            String hobbyclassGraduationDate = firstScan.nextLine();
            newHobbyclass.setGraduationDate(hobbyclassGraduationDate);

            System.out.println("Enter amountStudents:");
            String hobbyclassAmountStudents = firstScan.nextLine();
            newHobbyclass.setAmountStudents(hobbyclassAmountStudents);

            Hobby testHobby = hobbyService.getHobbyById(1L);
            if (testHobby != null) {
                System.out.println("Enter hobby_id:");
                String hobbyclassHobbyId = secondScan.nextLine();
                Hobby hobby = hobbyService.getHobbyById((long) Integer.parseInt(hobbyclassHobbyId));
                newHobbyclass.setHobby(hobby);
            } else newHobbyclass.setHobby(null);

            Student testStudent = studentService.getStudentById(1L);
            if (testStudent != null) {
                System.out.println("Enter student_id:");
                String hobbyclassStudentId = secondScan.nextLine();
                Student student = studentService.getStudentById((long) Integer.parseInt(hobbyclassStudentId));
                newHobbyclass.setStudent(student);
            } else newHobbyclass.setStudent(null);

            Teacher testTeacher = teacherService.getTeacherById(1L);
            if (testTeacher != null) {
                System.out.println("Enter teacher_id:");
                String hobbyclassTeacherId = secondScan.nextLine();
                Teacher teacher = teacherService.getTeacherById((long) Integer.parseInt(hobbyclassTeacherId));
                newHobbyclass.setTeacher(teacher);
            } else newHobbyclass.setTeacher(null);

            hobbyclassService.updateHobbyclass(newHobbyclass);
            System.out.println("Hobbyclass has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deleteHobbyclass() throws SQLException {
        System.out.println("Enter id in order to delete row:");
        Long id = Long.parseLong(secondScan.next());
        try {
            hobbyclassService.deleteHobbyclass(id);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Hobbyclass with id " + id + " has been deleted successfully");
    }

    public void printAllHobbyclasses() throws SQLException {
        List<Hobbyclass> hobbyclasses = hobbyclassService.printAllHobbyclasses();
        System.out.println("List of all hobbyclasses:");
        hobbyclasses.forEach(teacher1 -> System.out.println(teacher1.toString()));
    }

    public void getByIdTeacher() throws SQLException {
        System.out.println("Enter id in order to get hobbyclass:");
        Long id = Long.parseLong(firstScan.next());
        try {
            if (hobbyclassService.getHobbyclassById(id) != null) {
                System.out.println(hobbyclassService.getHobbyclassById(id).toString());
            } else {
                System.out.println("This id is doesn't exist.");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number.");
            getByIdTeacher();
        }
    }
}
