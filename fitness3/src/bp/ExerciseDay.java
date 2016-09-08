/**
 * This class is responsible for the
 * user information such as Resting 
 * heart rate, name, date, intake calories
 * and such. it also has funcionalities of 
 * saving and loading exercise days information
 * 
 */
package bp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.Database;
import db.Parameter;



/**
 *  * This class is responsible for the
 * user information such as Resting 
 * heart rate, name, date, intake calories
 * and such. it also has funcionalities of 
 * saving and loading exercise days information.
 * It's the class that generalize user's 
 * info.
 * @author user
 *
 */
/**
 * @author Administrator
 *
 */
public class ExerciseDay extends UserProfile {
	/**
	 * calories intake for only today
	 * entered by user.
	 */
	private double mCalories;
	/**
	 * User's working out date. Can be generated or 
	 * entered by user.
	 */
	private Date mDate;
	/**
	 * Notes entered by user. It's optional 
	 * when saviing in data base.
	 */
	private String mNotes;
	/**
	 * user's resting heart rate.
	 * Entered by user.
	 */
	protected int mRHR;
	
	/**
	 * this list of Aerobic objects contains data
	 * loaded from db.
	 */
	private List<Aerobic> aerobicWorkouts = new ArrayList<>();
	/**
	 *this list of Sports objects contains data
	 * loaded from db.
	 */
	private List<Sports> sportsWorkouts = new ArrayList<>();
	/**
	 *this list of Weight objects contains data
	 * loaded from db.
	 */
	private List<Weight>weightWorkouts = new ArrayList<>();
	/**
	 * this method returns the list that contains 
	 * aerobic workouts.
	 * @return the list contains aerobic workouts.
	 */
	public final List<Aerobic> getAerobicWorkouts() {
		return aerobicWorkouts;
	}
	/**
	 * this method sets the list that contains 
	 * aerobic workouts from the data by db.

	 * @param pAerobicWorkouts the list that will
	 * come in as a parameter of aerobicworkouts list.
	 */
	public final void setAerobicWorkouts(final List<Aerobic> pAerobicWorkouts) {
		aerobicWorkouts = pAerobicWorkouts;
	}
	/**
	 * this method returns the Aerobic object.
	 * @param indexOfWorkout index of which workout is called
	 * in the list
	 * @return returns the index of aerobic object.
	 */
	public final Aerobic getAerobicWorkout(final int indexOfWorkout) {
		return aerobicWorkouts.get(indexOfWorkout);
	}
	/**
	 * this method add aerobic workout objects in the list.
	 * @param pAerobicWorkout that is passed in the list.
	 */
	public final void addAerobicWorkouts(final Aerobic pAerobicWorkout) {
		aerobicWorkouts.add(pAerobicWorkout);
	}
	/**
	 * this method removes the indicated objects in the aerobic 
	 * workout list.
	 * @param indexOfWorkout index of workout to be removed.
	 */
	public final void removeAerobicWOrkout(final int indexOfWorkout) {
		aerobicWorkouts.remove(indexOfWorkout);
	}
	/**
	 * this method returns a list of sports type.
	 * @return a list of sports type.
	 */
	public final List<Sports> getSportsWorkouts() {
		return sportsWorkouts;
	}
	/**.
	 * this class sets up the list of sports type
	 * @param pSportsWorkouts sport object to be passed in the list.
	 */
	public final void setSportsWorkouts(final List<Sports> pSportsWorkouts) {
		sportsWorkouts = pSportsWorkouts;
	}
	/**
	 * this method returns the Sports object.
	 * @param indexOfWorkout index of which workout is called
	 * in the list
	 * @return returns the index of sport object.
	 */
	public final Sports getSportsWorkout(final int indexOfWorkout) {
		return sportsWorkouts.get(indexOfWorkout);
	}
	/**
	 * this method add sports workout objects in the list.
	 * @param pSportsWorkout that is passed in the list.
	 */
	public final void addSportsWorkouts(final Sports pSportsWorkout) {
		sportsWorkouts.add(pSportsWorkout);
	}
	/**
	 * this method removes the indicated objects in the sports 
	 * workout list.
	 * @param indexOfWorkout index of workout to be removed.
	 */
	public final void removeSportsWOrkout(final int indexOfWorkout) {
		sportsWorkouts.remove(indexOfWorkout);
	}
	/**
	 * this method returns a list of weight type.
	 * @return a list of weight type.
	 */
	public final List<Weight> getWeightWorkouts() {
		return weightWorkouts;
	}
	/**.
	 * this class sets up the list of weight type
	 * @param pWeightWorkouts weight object to be passed in the list.
	 */
	public final void setWeightWorkouts(final List<Weight> pWeightWorkouts) {
		weightWorkouts = pWeightWorkouts;
	}
	/**this method returns the notes
	 * written by users.
	 * @return the notes
	 */
	public String getNotes() {
		return mNotes;
	}
	/**this method pass in the notes 
	 * written by users.
	 * @param pNotes the notes to set
	 */
	public void setNotes(final String pNotes) {
		mNotes = pNotes;
	}
	/**
	 * this method returns the indicated index of 
	 * weight workout object.
	 * @param indexOfWorkout specific index to be returned.
	 * @return the indicated weight object.
	 */
	public final Weight getweightWorkout(final int indexOfWorkout) {
		return weightWorkouts.get(indexOfWorkout);
	}
	/**
	 * this method adds the weight object passed in to the weight
	 * list.
	 * @param pweightWorkout weight object to be added in the list.
	 */
	public final void addweightWorkouts(final Weight pweightWorkout) {
		weightWorkouts.add(pweightWorkout);
	}
	/**
	 * this method removes the indicated workout.
	 * @param indexOfWorkout workout to be removed.
	 */
	public final void removeweightWOrkout(final int indexOfWorkout) {
		weightWorkouts.remove(indexOfWorkout);
	}
	/**
	 * this method sets the intake calories.
	 * @param pCalories in take calories.
	 */
	public final void setCalories(final double pCalories) {
		mCalories = pCalories;
	}
	/**this method returns the intake calories
	 * entered by user.
	 * @return the calories entered by user.
	 */
	public final double getCalories() {
		return this.mCalories;
	}
	/**this method sets the calories
	 * entered by user.
	 * @param pCalories the calories to set
	 * from db.
	 */
	public final void setCalories(final int pCalories) {
		this.mCalories = pCalories;
	}

	/**this method gets the resting heart rate from the object.
	 * @return the rHR the resting heart rate.
	 */
	public final int getRHR() {
		return mRHR;
	}
	/**this method sets the resting heart rate to the value passed in.
	 * @param pRHR the rHR to set 
	 */
	public final void setRHR(final int pRHR) {
		mRHR = pRHR;
	}

	/**this method returns the duration of the workout.
	 * @return the time the duration of this workout.
	 */
	public Date getDate() {
		return this.mDate;
	}
	/**this method sets the duration of the workout by
	 * passing in a value from db.
	 * @param pString is the time to set
	 */
	public void setDate(final Date pString) {
		this.mDate = pString;
	}

	@Override
	public void save() {
		Database myDB = new Database();
		List<Parameter> params = new ArrayList<>();
		
		params.add(new Parameter<Date>(mDate));
		params.add(new Parameter<String>(mUserName));
		params.add(new Parameter<Double>(mCalories));
		params.add(new Parameter<Integer>(mRHR));
		params.add(new Parameter<String>(mNotes));
		
		myDB.executeSql("usp_SaveExerciseDay", params);
	}
	@Override
	public void load(final String pUserName, final Date pDate) {
		System.out.println(pUserName + pDate);
		
		Database myDB = new Database();
		List<Parameter> params = new ArrayList<>();

		params.add(new Parameter<Date>(pDate));
		params.add(new Parameter<String>(pUserName));
		ResultSet exerciseDays = 
				myDB.getResultSet("usp_GetExerciseDay", params);
		try {
			while (exerciseDays.next()) {
			
				mDate = pDate;
				
				mUserName = pUserName;
				
				mCalories = exerciseDays.getInt("CalorieIntake");
				
				
				mRHR = exerciseDays.getInt("RestingHeartRate");
				
				mNotes = exerciseDays.getString("Notes");
     
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * this method cleans up all the variables in the object.
	 * 
	 */
	public final void clear() {
		mUserName = "";
		mDate = null;
		mCalories = 0;
		mRHR = 0;
		mNotes = "";
	}
}
