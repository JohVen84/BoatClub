package view;

import model.Boat.BoatType;
import model.Registry;

import java.io.IOException;
import java.util.Scanner;

public class Console {

    private Registry registry;
    private Scanner scan;
    private String strInput = "";
    private int intInput = 0;
    private int intInput2 = 0;
    private BoatType type;
    private double doubleInput = 0.0;


    public Console(Registry r) {
        registry = r;
        scan = new Scanner(System.in);
    }

    public void displayMainMenu() throws IOException {
        System.out.println("Main Menu");
        System.out.println("################");
        System.out.println("1 View Members");
        System.out.println("2 Manage Members");
        System.out.println("3 Quit and Save");
        System.out.println("################");
        System.out.print("Input: ");

        intInput = getIntInput();

        switch (intInput) {
            case (1):
                displayMemberViewMenu();
                break;
            case (2):
                displayMemberManageMenu();
                break;
            case (3):
                saveFile();
                System.exit(0);
            default:
                System.out.println("Invalid Input");
                break;
        }
    }

    private void displayMemberViewMenu() throws IOException {
        System.out.println("1 View a comapct List");
        System.out.println("2 View a verbose List");
        System.out.println("3. Return to main menu");
        System.out.print("Input:");

        intInput = getIntInput();

        switch (intInput) {
            case (1):
                displayCompactList();
                displayMemberViewMenu();
                break;
            case (2):
                displayVerboseList();
                displayMemberViewMenu();
                break;
            case (3):
                displayMainMenu();
                break;
            default:
                System.out.println("Invalid Input");
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

        intInput = getIntInput();

        switch (intInput) {
            case (1):
                addMember();
                displayMemberManageMenu();
                break;
            case (2):
                updateMember();
                displayMemberManageMenu();
                break;
            case (3):
                removeMember();
                displayMemberManageMenu();
            case (4):
                addBoat();
                displayMemberManageMenu();
                break;
            case (5):
                updateBoat();
                displayMemberManageMenu();
                break;
            case (6):
                removeBoat();
                displayMemberManageMenu();
                break;
            case (7):
                searchMember();
                displayMemberManageMenu();
                break;
            case (8):
                displayMainMenu();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }

  private void displayCompactList() {
        if (registry.getSize() > 0) {
          for (model.Member m : registry.getList()) {
            displayMember(m);
            System.out.println("-------------------------------------");
          }
        } else {
          System.out.println("Register is empty");
        }
    }

  private void displayVerboseList() {
        System.out.println("-------------------------------------");
        if (registry.getSize() > 0) {
          for (model.Member m : registry.getList()) {
            displayMember(m);
            displayBoats(m);
            System.out.println("-------------------------------------");
          }
        } else {
          System.out.println("Register is empty");
        }
   }
    private void addMember() {
        System.out.print("Name: ");
        strInput = getStrInput();

        System.out.print("PersonNumber(yymmdd): ");
        intInput = getIntInput();
        registry.addMember(strInput, intInput);
        System.out.println("Member: " + strInput + " succesfully added!");
    }

    private void updateMember() {
        System.out.print("Member ID: ");
        intInput = getIntInput();
        System.out.print("New name: ");
        strInput = getStrInput();
        System.out.print("New Personal Number: ");
        intInput2 = getIntInput();
        registry.updateMember(intInput, strInput, intInput2);
        System.out.println("Member updated!");
    }

    private void removeMember() {
        System.out.print("Member ID: ");
        intInput = getIntInput();
        registry.deleteMember(intInput);
        System.out.println("Member removed!");
    }

    private void addBoat() {
        System.out.print("Member ID: ");
        intInput = getIntInput();
        DisplayBoatTypes();
        System.out.print("Type(Enter a number 1-5): ");
        intInput2 = getIntInput();
        type  = getBoatType(intInput2);
        System.out.println(type.toString());
        System.out.print("Length: ");
        doubleInput = getDoubleInput();
        try {
            registry.addBoat(intInput, type, doubleInput);
        } catch (Exception e) {
            System.out.println("Wrong Input, try again");
        }
        System.out.println("Boat added");
    }

    private void updateBoat() {
        System.out.print("Member ID: ");
        intInput = getIntInput();
        DisplayBoatTypes();
        System.out.print("Type(Enter a number 1-5): ");
        intInput2 = getIntInput();
        type = getBoatType(intInput2);
        System.out.print("Select boat(id): ");
        intInput2 = getIntInput();
        System.out.print("New length: ");
        doubleInput = getDoubleInput();
        try {
            registry.updateBoat(intInput, intInput2, type, doubleInput);
        } catch (Exception e) {
            System.out.println("Wrong Input, try again");
        }
        System.out.println("Boat updated");
    }

    private void removeBoat() {
        System.out.print("Member ID: ");
        intInput = getIntInput();
        System.out.print("Select boat(id):  ");
        intInput2 = getIntInput();
        registry.deleteBoat(intInput, intInput2);
        System.out.println("Boat removed");
    }

    private void searchMember() {
        System.out.print("Member ID: ");
        intInput = getIntInput();
        displayMember(registry.getMember(intInput));
        displayBoats(registry.getMember(intInput));
    }

    private void saveFile() throws IOException {
        registry.saveRegistry();
        System.out.println("Welcome back!");
        scan.close();
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

    private void DisplayBoatTypes() {
        int i = 1;
        for(BoatType type: BoatType.values()) {
            System.out.print(i++ + ". " + type + ", ");
        }
        System.out.println();
    }

    private BoatType getBoatType(int index) {
        return BoatType.values()[index - 1];
    }

    private String getStrInput() {
        return scan.next() + scan.nextLine();
    }

    private int getIntInput() {
        return scan.nextInt();
    }
    private double getDoubleInput() {
        return scan.nextDouble();
    }

}