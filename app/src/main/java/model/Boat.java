package model;



/**Boat class creating the objects of Boats
 * @author johan
 *
 */

public class Boat {

	private BoatType type;
	private double length;

	public enum BoatType {
		SAILBOAT, MOTORSAILER, KAYAK, CANOE, OTHER
	}
	
	
	
	/**Constructors classes
	 * @param type - Type of boat
	 * @param l - Length of boat
	 */
	public Boat (BoatType type, double l) {
		setType(type);
		setLength(l);
	}
	
public Boat () {
		
	}

	/**Set the type of boat
	 * @param t - type
	 */
	public void setType(BoatType t) {
			type = t;

	}
	/**Get the boat type
	 * @return
	 */
	public BoatType getType() {
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
