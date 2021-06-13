package hobbyclass.view;

import hobbyclass.model.Hobby;
import hobbyclass.service.HobbyService;
import org.hibernate.service.spi.ServiceException;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HobbyView {

    private HobbyService hobbyService = new HobbyService();
    private Scanner firstScan = new Scanner(System.in);
    private Scanner secondScan = new Scanner(System.in);

    private static void actions() {
        System.out.println("\nChoose hobby action:\n"
                + "1-Insert new row.\n"
                + "2-Show all row.\n"
                + "3-Delete row.\n"
                + "4-Update row.\n"
                + "5-Search by id.\n"
                + "6-Search by name.\n"
                + "\t0-Exit.");
    }

    public void runHobbyView() throws SQLException {
        actions();
        Scanner mainScan = new Scanner(System.in);
        try {
            int numOfPoint = mainScan.nextInt();
            while (numOfPoint != 0) {
                switch (numOfPoint) {
                    case 1:
                        addHobby();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 2:
                        printAllHobbys();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 3:
                        deleteHobby();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 4:
                        updateHobby();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 5:
                        getByIdHobby();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 6:
                        getHobbyByName();

                        actions();
                        numOfPoint = mainScan.nextInt();
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

    public void addHobby() throws SQLException {
        try {
            Hobby hobby = new Hobby();

            System.out.println("Enter hobby name:");
            String hobbyName = firstScan.nextLine();
            hobby.setName(hobbyName);

            System.out.println("Enter teacher:");
            String hobbyTeacher = firstScan.nextLine();
            hobby.setTeacher(hobbyTeacher);

            System.out.println("Enter creation date:");
            String hobbyCreationDate = firstScan.nextLine();
            hobby.setCreationDate(hobbyCreationDate);

            System.out.println("Enter category:");
            String hobbyCategory = firstScan.nextLine();
            hobby.setCategory(hobbyCategory);

            System.out.println("Enter price:");
            String hobbyPrice = firstScan.nextLine();
            hobby.setPrice(hobbyPrice);

            hobbyService.saveHobby(hobby);
            System.out.println("Hobby has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void updateHobby() throws SQLException {
        try {
            System.out.println("Enter id in order to find element:");
            Long id = Long.parseLong(secondScan.next());

            Hobby newHobby = hobbyService.getHobbyById(id);

            System.out.println("Enter hobby name: ");
            String hobbyName = firstScan.nextLine();
            newHobby.setName(hobbyName);

            System.out.println("Enter teacher:");
            String hobbyTeacher = firstScan.nextLine();
            newHobby.setTeacher(hobbyTeacher);

            System.out.println("Enter creation date:");
            String hobbyCreationDate = firstScan.nextLine();
            newHobby.setCreationDate(hobbyCreationDate);

            System.out.println("Enter category:");
            String hobbyCategory = firstScan.nextLine();
            newHobby.setCategory(hobbyCategory);

            System.out.println("Enter price:");
            String hobbyPrice = firstScan.nextLine();
            newHobby.setPrice(hobbyPrice);


            hobbyService.updateHobby(newHobby);
            System.out.println("Hobby with id " + id + " has been updated successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deleteHobby() throws SQLException {
        System.out.println("Enter id in order to delete row:");
        Long id = Long.parseLong(secondScan.next());
        try {
            hobbyService.deleteHobby(id);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Hobby with id " + id + " has been deleted successfully");
    }

    public void printAllHobbys() throws SQLException {
        List<Hobby> hobbies = hobbyService.printAllHobbys();
        System.out.println("List of all hobbys:");
        hobbies.forEach(hobby1 -> System.out.println(hobby1.toString()));
    }

    public void getByIdHobby() throws SQLException {
        System.out.println("Enter id in order to get hobby:");
        Long id = Long.parseLong(firstScan.next());
        try {
            if (hobbyService.getHobbyById(id) != null) {
                System.out.println(hobbyService.getHobbyById(id).toString());
            } else {
                System.out.println("This id is doesn't exist.");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number.");
            getByIdHobby();
        }
    }

    public void getHobbyByName() throws SQLException {
        System.out.println("Enter name in order to get hobby:");
        String name = secondScan.next();
        try {
            if (hobbyService.getHobbyByName(name) != null) {
                System.out.println(hobbyService.getHobbyByName(name).toString());
            } else {
                System.out.println("This name is doesn't exist.");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number.");
            getHobbyByName();
        }
    }
}
