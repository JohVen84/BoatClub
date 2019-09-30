package model;

import com.thoughtworks.xstream.XStream;
import model.Boat.BoatType;

import java.io.IOException;
import java.util.ArrayList;

public class Registry {

  private ArrayList<Member> members;
  private FileHandler file;
  private int memberID;
  private XStream xstream;
  private int size = 0;

  public Registry() {
    members = new ArrayList<>();
    file = new FileHandler();
    memberID = 1;
    xstream = new XStream();
  }

  public int getSize() {
    return members.size();
  }

  public void addMember(String name, int pnumber) {
    members.add(new Member(name, pnumber, memberID));
    ++memberID;
  }

  public void deleteMember(int id) {
    members.remove(getMember(id));
  }

  public void updateMember(int id, String name, int number) {
    getMember(id).setName(name);
    getMember(id).setPNumber(number);
  }

  public void addBoat(int id, BoatType t, double l) {
    getMember(id).addBoat(t, l);
  }

  public void updateBoat(int id, int boatId, BoatType type, double length) {
    getMember(id).getBoat(boatId).setType(type);
    getMember(id).getBoat(boatId).setLength(length);
  }

  public void deleteBoat(int id, int boatId) {
    getMember(id).removeBoat(boatId);
  }

  public Iterable<Member> getList() {
    return members;
  }

  public Member getMember(int id) {
    for (Member m : members) {
      if (m.getId() == id) {
        return m;
      }
    }
    throw new IllegalArgumentException();
  }

  public void loadRegistry() {
    String savedFile = file.loadFile();
    members = (ArrayList<Member>) xstream.fromXML(savedFile);
  }

  public void saveRegistry() throws IOException {
    String xml;
    xml = xstream.toXML(members);
    file.saveFile(xml);
  }
}
