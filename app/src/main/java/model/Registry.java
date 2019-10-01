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

  public void deleteMember(Member m) {
    members.remove(m);
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
