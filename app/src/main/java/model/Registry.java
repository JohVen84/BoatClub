package model;

import com.thoughtworks.xstream.XStream;
import model.Boat.BoatType;

import java.io.IOException;
import java.util.ArrayList;



/**
 * Class to handle the memberregistry
 *
 */



public class Registry {



	private ArrayList<Member> members;
	private FileHandler file;
	private int memberID;
	private XStream xstream;
	private int size = 0;



		/**
		 * Constructor
		 */
		public Registry() {
			members = new ArrayList<>();
			file = new FileHandler();
			memberID = 1;
			xstream = new XStream();
		}

		public int getSize() {
		    return members.size();
        }

		/**
		 * Adds a member to the register
		 * @param name
		 * @param pnumber - Person Number
		 */
		public void addMember(String name, int pnumber) {
			members.add(new Member(name, pnumber, memberID));
			++memberID;
		}

		/**
		 * Deletes a member based on the id
		 * @param id
		 */
		public void deleteMember(int id) {

			members.remove(getMember(id));
		}

		/**
		 * Updates a current member
		 * @param id
		 * @param name
		 * @param number
		 */
		public void updateMember(int id, String name, int number) {
			getMember(id).setName(name);
			getMember(id).setPNumber(number);

		}

		/**
		 * Adds a boat to a member
		 * @param id
		 * @param t - type
		 * @param l - length
		 */
		public void addBoat(int id, BoatType t, double l) {
			getMember(id).addBoat(t,l);
		}

		/**
		 * Updated a current Boat
		 * @param id
		 * @param boatIndex
		 * @param type
		 * @param length
		 */
		public void updateBoat(int id, int boatIndex, BoatType type, double length) {
			getMember(id).getBoat(boatIndex).setType(type);
			getMember(id).getBoat(boatIndex).setLength(length);
		}

		/**
		 * Deletes a boat
		 * @param id
		 * @param index
		 */
		public void deleteBoat(int id, int index) {
			getMember(id).removeBoat(index);

		}

		/**
		 * Get a list of the members
		 * @return
		 */
		public Iterable<Member>  getList() {
			return members;
		}

		/**
		 * Returns a specific member
		 * @param id
		 * @return
		 */
		public Member getMember(int id) {
			for(Member m : members) {
				if(m.getId() == id) {
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
