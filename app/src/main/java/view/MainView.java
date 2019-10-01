package view;

import model.Boat;
import model.Member;
import model.Registry;

import java.io.IOException;
import java.util.Scanner;

public class MainView {

  private Registry registry;
  private Scanner scan;
  private String strInput = "";
  private int intInput = 0;
  private double doubleInput = 0.0;

  public MainView(Registry r) {
    registry = r;
    scan = new Scanner(System.in);
  }

  public void displayMainMenu() throws IOException {
    System.out.println("Main Menu");
    System.out.println("################");
    System.out.println("1 View members");
    System.out.println("2 Add a member");
    System.out.println("3 Manage a member");
    System.out.println("4 Search a member");
    System.out.println("5 Save");
    System.out.println("6 Quit");
    System.out.println("################");
    System.out.print("Input(1-6): ");

    intInput = getIntInput();

    switch (intInput) {
      case (1):
        displayMemberViewMenu();
        break;
      case (2):
        addMember();
        displayMainMenu();
        break;
      case (3):
        displayMemberManageMenu(selectMember());
        break;
      case (4):
        searchMember();
        displayMainMenu();
        break;
      case (5):
        saveFile();
        displayMainMenu();
        break;
      case (6):
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

  private void displayMemberManageMenu(Member m) throws IOException {
    System.out.println("################");
    System.out.println("1 Update member");
    System.out.println("2 Remove member");
    System.out.println("3 Add a boat");
    System.out.println("4 Update a boat");
    System.out.println("5 Remove a boat");
    System.out.println("6 Return to main menu");
    System.out.println("################");
    System.out.print("Input: ");

    intInput = getIntInput();

    switch (intInput) {
      case (1):
        updateMember(m);
        displayMemberManageMenu(m);
        break;
      case (2):
        removeMember(m);
        displayMainMenu();
        break;
      case (3):
        addBoat(m);
        displayMemberManageMenu(m);
      case (4):
        updateBoat(m);
        displayMemberManageMenu(m);
        break;
      case (5):
        removeBoat(m);
        displayMemberManageMenu(m);
        break;
      case (6):
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

  private Member selectMember() {
    System.out.print("Enter member ID: ");
    intInput = getIntInput();
    return registry.getMember(intInput);
  }

  private Boat selectBoat(Member m) {
    System.out.print("Enter boat ID: ");
    intInput = getIntInput();
    return m.getBoat(intInput);
  }

  private void updateMember(Member m) {
    System.out.print("New name: ");
    strInput = getStrInput();
    System.out.print("New Personal Number: ");
    intInput = getIntInput();
    m.setName(strInput);
    m.setPNumber(intInput);
    System.out.println("Member updated!");
  }

  private void removeMember(Member m) {
    registry.deleteMember(m);
    System.out.println("Member removed!");
  }

  private void addBoat(Member m) {
    DisplayBoatTypes();
    System.out.print("Type(Enter a number 1-5): ");
    intInput = getIntInput();
    System.out.print("Length: ");
    doubleInput = getDoubleInput();
    try {
      m.addBoat(getBoatType(intInput), doubleInput);
    } catch (Exception e) {
      System.out.println("Wrong Input, try again");
    }
    System.out.println("Boat added");
  }

  private void updateBoat(Member m) {
    Boat.BoatType type;
    Boat b = selectBoat(m);
    DisplayBoatTypes();
    System.out.print("Type(Enter a number 1-5): ");
    intInput = getIntInput();
    type = getBoatType(intInput);
    System.out.print("New length: ");
    doubleInput = getDoubleInput();
    try {
      b.setLength(doubleInput);
      b.setType(type);
    } catch (Exception e) {
      System.out.println("Wrong Input, try again");
    }
    System.out.println("Boat updated");
  }

  private void removeBoat(Member m) {
    m.removeBoat(selectBoat(m));
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
    System.out.println("File Saved!");
  }

  private void displayMember(Member m) {
    System.out.println("Name: " + m.getName());
    System.out.println("ID Number: " + m.getId());
    System.out.println("Person number:" + m.getpNumber());
    System.out.println("Number of boats: " + m.getNumberOfBoats());
  }

  private void displayBoats(model.Member m) {
    if (m.getNumberOfBoats() > 0) {
      System.out.println("List of boats: ");
      for (model.Boat b : m.getBoats()) {
        System.out.println("ID:" + b.getId());
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
    for (Boat.BoatType type : Boat.BoatType.values()) {
      System.out.print(i++ + ". " + type + ", ");
    }
    System.out.println();
  }

  private Boat.BoatType getBoatType(int index) {
    return Boat.BoatType.values()[index - 1];
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