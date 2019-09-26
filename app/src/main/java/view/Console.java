package view;

import model.Registry;

import java.io.IOException;
import java.util.Scanner;

public class Console {

    private Registry registry;
    private Scanner scan = new Scanner(System.in);
    private String input = "";
    private String name;
    private int pNumber = 0;
    private int id = 0;
    private double length = 0;
    private String type = "";
    private int boatId = 0;

    public Console(Registry r) {
        registry = r;
    }

    public void displayMainMenu() throws IOException {
        System.out.println("Main Menu");
        System.out.println("################");
        System.out.println("1 View Members");
        System.out.println("2 Manage Members");
        System.out.println("3 Quit and Save");
        System.out.println("################");
        System.out.print("Input: ");

        input = scan.next();

        switch (input) {
            case ("1"):
                displayMemberViewMenu();
                break;
            case ("2"):
                displayMemberManageMenu();
                break;
            case ("3"):
                saveFile();
                System.exit(0);
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    private void displayMemberViewMenu() throws IOException {
        System.out.println("1 View comapct List");
        System.out.println("2 View verbose List");
        System.out.println("3. Return to main menu");
        System.out.print("Input:");

        input = scan.next();

        switch (input) {
            case ("1"):
                displayCompactList();
                displayMemberViewMenu();
                break;
            case ("2"):
                displayVerboseList();
                displayMemberViewMenu();
                break;
            case ("3"):
                displayMainMenu();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    private void displayMemberManageMenu() throws IOException {
        System.out.println("################");
        System.out.println("1 Add a member");
        System.out.println("2 Update a member");
        System.out.println("3 Remove a member");
        System.out.println("4 Add a boat");
        System.out.println("5 Update a boat");
        System.out.println("6 Remove a boat");
        System.out.println("7 Search a member");
        System.out.println("8 Return to main menu");
        System.out.println("################");
        System.out.print("Input: ");

        input = scan.next();

        switch (input) {
            case ("1"):
                addMember();
                displayMemberManageMenu();
                break;
            case ("2"):
                updateMember();
                displayMemberManageMenu();
                break;
            case ("3"):
                removeMember();
                displayMemberManageMenu();
            case ("4"):
                addBoat();
                displayMemberManageMenu();
                break;
            case ("5"):
                updateBoat();
                displayMemberManageMenu();
                break;
            case ("6"):
                removeBoat();
                displayMemberManageMenu();
                break;
            case ("7"):
                searchMember();
                displayMemberManageMenu();
                break;
            case ("8"):
                displayMainMenu();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    private void displayCompactList() {
        for (model.Member m : registry.getList()) {
            displayMember(m);
            System.out.println("-------------------------------------");
        }
    }

    private void displayVerboseList() {
        for (model.Member m : registry.getList()) {
            displayMember(m);
            displayBoats(m);
            System.out.println("-------------------------------------");
            }
    }

    private void addMember() {
        System.out.print("Name: ");
        name = scan.next() + scan.nextLine();

        System.out.print("PersonNumber(yymmdd): ");
        pNumber = scan.nextInt();
        registry.addMember(name, pNumber);
    }

    private void updateMember() {
        System.out.print("Member ID: ");
        id = scan.nextInt();
        System.out.print("New name: ");
        name = scan.next() + scan.nextLine();
        System.out.print("New Personal ID");
        pNumber = scan.nextInt();
        registry.updateMember(id, name, pNumber);
    }

    private void removeMember() {
        System.out.print("Member ID: ");
        id = scan.nextInt();
        registry.deleteMember(id);
    }

    private void addBoat() {
        System.out.print("Member ID: ");
        id = scan.nextInt();
        System.out.print("Type: ");
        type = scan.next();
        System.out.print("Length: ");
        length = scan.nextDouble();
        try {
            registry.addBoat(id, type, length);
        } catch (Exception e) {
            System.out.println("Wrong input, try again");
        }
    }

    private void updateBoat() {
        System.out.print("Member ID: ");
        id = scan.nextInt();
        System.out.print("Select boat(id): ");
        boatId = scan.nextInt();
        System.out.print("New type: ");
        type = scan.next();
        System.out.print("New length: ");
        length = scan.nextDouble();
        try {
            registry.updateBoat(id, boatId, type, length);
        } catch (Exception e) {
            System.out.println("Wrong input, try again");
        }
    }

    private void removeBoat() {
        System.out.print("Member ID: ");
        id = scan.nextInt();
        System.out.print("Select boat(id):  ");
        boatId = scan.nextInt();
        registry.deleteBoat(id, boatId);
    }

    private void searchMember() {
        System.out.print("Member ID: ");
        id = scan.nextInt();
        displayMember(registry.getMember(id));
        displayBoats(registry.getMember(id));
    }

    private void saveFile() throws IOException {
        registry.saveRegistry();
        System.out.println("Welcome back!");
    }

    private void displayMember(model.Member m) {
        System.out.println("Name: " + m.getName());
        System.out.println("ID Number: " + m.getId());
        System.out.println("Person number:" + m.getpNumber());
        System.out.println("Number of boats: " + m.getNumberOfBoats());
    }


    private void displayBoats(model.Member m) {
        if (m.getNumberOfBoats() > 0) {
            System.out.println("List of boats: ");
            for (model.Boat b : m.getBoats()) {
                System.out.println("Type: " + b.getType());
                System.out.println("Length: " + b.getLength());
                System.out.println("##################");
            }
        } else {
            System.out.println("The member does not own any boats");
          }
    }

}