package model;

import java.util.ArrayList;


/**
 * Class with objects of member
 *
 */

public class Member {
	// name, person number and member number

	private String name;
	private int pNumber;
	private int idNumber;
	private ArrayList<Boat> boats;




	/**
	 * Constructors
	 * @param n - name
	 * @param pN - Person Number
	 */
	public Member (String n, int pN, int id) {
		name = n;
		pNumber = pN;
		idNumber = id;
		boats = new ArrayList<>();
	}

	public Member () {

		boats = new ArrayList<Boat>();
	}

	/**
	 * Set the members name
	 * @param n - name
	 */
	public void setName(String n) {
		name = n;
	}
	/**
	 * Get members id
	 * @return int
	 */
	public int getId() {
		return idNumber;
	}

	/**
	 * Set the members Idnumber
	 * @param n - name
	 */
	public void setIdNumber(int n) {
	idNumber = n;
	}
	/**
	 * Get members name
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set Person Number
	 * @param number
	 */
	public void setPNumber(int number) {
		pNumber = number;
	}

	/**
	 * Get Person Number of Member
	 * @return
	 */
	public int getpNumber() {
		return pNumber;
	}

		/**
	 * Adds a boat to the member
	 * @param type, length
	 */
	public void addBoat(Boat.BoatType type, double length) {
		boats.add(new Boat(type,length));
	}

	/**
	 * Returns a  Boat at the index
	 * @param index
	 * @return
	 */
	public Boat getBoat(int index){
		return boats.get(index);
	}

	/** Removes a boat from the member
	 * @param index
	 */
	public void removeBoat(int index) {
		boats.remove(boats.get(index));
	}

	/**Get the total amount of boats a member owns
	 * @return
	 */
	public int getNumberOfBoats () {
		return boats.size();
	}

	/**Returns the list of boats
	 * @return
	 */
	public Iterable<Boat> getBoats() {
		return boats;
	}


}
