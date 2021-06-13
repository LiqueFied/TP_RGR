package hobbyclass.view;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {

    private HobbyView hobbyView;
    private StudentView studentView;
    private TeacherView teacherView;
    private HobbyclassView hobbyclassView;

    private static MainView mainView;

    private MainView() {
        hobbyView = new HobbyView();
        studentView = new StudentView();
        teacherView = new TeacherView();
        hobbyclassView = new HobbyclassView();
    }

    public static MainView getInstance() {
        if (mainView == null) {
            mainView = new MainView();
        }
        return mainView;
    }

    private static void actions() {
        System.out.println("\nChoose action:\n"
                + "1-Hobbys.\n"
                + "2-Students.\n"
                + "3-Teachers.\n"
                + "4-Hobbyclasses.\n"
                + "\t0-Exit.");
    }

    public void runMainView() throws SQLException {
        actions();
        Scanner mainScan = new Scanner(System.in);

        try {
            int numOfPoint = mainScan.nextInt();
            while (numOfPoint != 0) {
                switch (numOfPoint) {
                    case 1:
                        runHobby();
                        break;
                    case 2:
                        runStudent();
                        break;
                    case 3:
                        runTeacher();
                        break;
                    case 4:
                        runHobbyclass();
                        break;
                    case 0:
                        numOfPoint = 0;
                        break;
                    default:
                        System.out.println("There is no such command.");
                        System.out.println("Choose action:");
                        numOfPoint = mainScan.nextInt();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        mainScan.close();
    }

    public void runHobby() throws SQLException {
        hobbyView.runHobbyView();
    }

    public void runStudent() throws SQLException {
        studentView.runStudentView();
    }

    public void runTeacher() throws SQLException {
        teacherView.runTeacherView();
    }

    public void runHobbyclass() throws SQLException {
        hobbyclassView.runHobbyclassView();
    }
}
