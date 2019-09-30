package model;

import java.util.ArrayList;

public class Member {

  private String name;
  private int pNumber;
  private int idNumber;
  private int boatID;
  private ArrayList<Boat> boats;

  public Member(String n, int pN, int id) {
    name = n;
    pNumber = pN;
    idNumber = id;
    boatID = 0;
    boats = new ArrayList<>();
  }

  public Member() {

    boats = new ArrayList<Boat>();
  }

  public void setName(String n) {
    name = n;
  }

  public int getId() {
    return idNumber;
  }

  public void setIdNumber(int n) {
    idNumber = n;
  }

  public String getName() {
    return name;
  }

  public void setPNumber(int number) {
    pNumber = number;
  }

  public int getpNumber() {
    return pNumber;
  }

  public void addBoat(Boat.BoatType type, double length) {
    boatID++;
    boats.add(new Boat(type, length, boatID));
  }

  public void removeBoat(int boatId) {
    boats.remove(getBoat(boatId));
  }

  public int getNumberOfBoats() {
    return boats.size();
  }

  public Boat getBoat(int id) {
    for (Boat b : boats) {
      if (id == b.getId()) {
        return b;
      }
    }
    throw new IllegalArgumentException();
  }

  public Iterable<Boat> getBoats() {
    return boats;
  }
}
