package model;



/**Boat class creating the objects of Boats
 * @author johan
 *
 */

public class Boat {

	private String type;
	private double length;
	
	
	
	
	/**Constructors classes
	 * @param type - Type of boat
	 * @param l - Length of boat
	 */
	public Boat (String type, double l) {
		setType(type);
		setLength(l);
	}
	
public Boat () {
		
	}

	/**Set the type of boat
	 * @param t - type
	 */
	public void setType(String t) {
		t = t.toUpperCase();
		if(t.equals("SAILBOAT") || t.equals("MOTORSAILER")
				|| t.equals("KAYAK/CANOE") || t.equals("OTHER")) {
			type = t;
			}
		else {
			throw new IllegalArgumentException();
		}
	}
	/**Get the boat type
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**Set the length of boat
	 * @param l - length
	 */
	public void setLength(double l) {
		if(l > 0) {
			length = l;
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	/**Get the length of boat
	 * @return
	 */
	public double getLength() {
		return length;
	}
	
	

	
}
