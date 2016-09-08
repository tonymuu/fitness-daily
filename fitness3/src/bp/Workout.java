/**
 * This is an abstract class that is responsible
 * for a few functional methods for its subclasses
 * to have. It mostly deal with database stuff.
 */
package bp;

import java.util.Date;

/** This is an abstract class that is responsible
 * for a few functional methods for its subclasses
 * to have. It mostly deal with database stuff.
 * @author Administrator
 *
 */
public abstract class Workout {

	/**
	 * Save the object/data into database.
	 */
	public abstract void save();
	/**
	 * load the object from database by wordoutID.
	 * @param pWordoutID somekind of password.
	 */
	public abstract void load(int pWordoutID);
	/**
	 * delete item object from db.
	 */
	public abstract void delete();
	/**
	 * load objects from db by name and data.
	 * @param pUserName name user entered.
	 * @param pDate date of retrieving data.
	 */
	public void load(String pUserName, Date pDate) {
		
		
	}
}
