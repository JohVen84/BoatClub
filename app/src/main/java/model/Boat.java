package model;

public class Boat {

  private BoatType type;
  private int id;
  private double length;

  public enum BoatType {
    SAILBOAT,
    MOTORSAILER,
    KAYAK,
    CANOE,
    OTHER
  }

  public Boat(BoatType t, double l, int boatID) {
    id = boatID;
    type = t;
    setLength(l);
  }

  public Boat() {}

  public int getId() {
    return id;
  }

  public void setType(BoatType t) {
    this.type = t;
  }

  public BoatType getType() {
    return type;
  }

  public void setLength(double l) {
    if (l > 0) {
      this.length = l;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public double getLength() {
    return length;
  }
}
