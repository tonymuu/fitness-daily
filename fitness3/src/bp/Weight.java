/**This class is responsible for storing multiple weight training
 * exercise that a user might enjoy doing. It is responsible for
 * type of weight exercises, repititions and weight of exercise, 
 * average heart rate,  and 
 * notes user would like to add. In addition to that, user may also 
 * save or load information of an earlier day.
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

/**This class is responsible for storing multiple weight training
 * exercise that a user might enjoy doing. It is responsible for
 * type of weight exercises, repititions and weight of exercise, 
 * average heart rate,  and 
 * notes user would like to add. In addition to that, user may also 
 * save or load information of an earlier day.
 * @author Administrator
 *
 */
public class Weight extends Workout {

	/**
	 * weight of the wegiht training set in pounds..
	 */
	private double mWeight;
	/**
	 * reps of a weight set. 
	 */
	private int mReps;
	/**
	 * time spent in this workout.
	 */
	private double mTime;
	/**
	 * user's name.
	 */
	private String mUserName;
	/**
	 * exercise date.
	 */
	private Date mDate;
	/**
	 * what kind of weight training.
	 */
	private String mExercise;
	/**
	 * average heart rate during exercise.
	 */
	private int mHeartRate;
	/**
	 * the notes user may like to take.
	 */
	private String mNotes;

	/**
	 * a new user profile used to store user info.
	 */
	private ExerciseDay mNewUser;
	
	/**
	 * a list of weight object used to store weights.
	 */
	private List<Weight> mSports = new ArrayList<>();

	/**this method will return the repitions of a weight set.
	 * @return the reps user did.
	 */
	public final int getReps() {
		return mReps;
	}

	/**set the reps in a set that user did.
	 * @param pReps user set in a set.
	 *            the reps to set
	 */
	public final void setReps(final int pReps) {
		mReps = pReps;
	}

	/**time user spent in exercise weight.
	 * @return the time user spent
	 */
	public final double getTime() {
		return mTime;
	}

	/**set the time user spend in an specific exercise weight.
	 * @param pTime the time to set in an exercise. 
	 */
	public final void setTime(final double pTime) {
		mTime = pTime;
	}

	/**how much weight a user can lift.
	 * @return the weight user lifts.
	 */
	public final double getWeight() {
		return mWeight;
	}

	/**sets the weight user lifted.
	 * @param pWeight user lifted.
	 *            the weight to set
	 */
	public final void setWeight(final double pWeight) {
		mWeight = pWeight;
	}

	/**returns the user name as a string.
	 * @return the userName as a string.
	 */
	public final String getUserName() {
		return mUserName;
	}

	/**sets the user name entered by user.
	 * @param pUserName a string.
	 *            the userName to set
	 */
	public final void setUserName(final String pUserName) {
		mUserName = pUserName;
	}

	/**returns the date of the exercise.
	 * @return the date
	 */
	public Date getDate() {
		return mDate;
	}

	/**sets the date of the exercise user engaged in.
	 * @param pDate
	 *            the date to set
	 */
	public final void setDate(final Date pDate) {
		mDate = pDate;
	}

	/**the exercise user engaged in .
	 * @return the exercise weight user lifted.
	 */
	public final String getExercise() {
		return mExercise;
	}

	/**the exercise user wants to set in data base.
	 * @param pExercise
	 *            the exercise to set
	 */
	public final void setExercise(final String pExercise) {
		mExercise = pExercise;
	}

	/**user's heart rate during weight lifting.
	 * @return the heartRate during weight.
	 */
	public final int getHeartRate() {
		return mHeartRate;
	}

	/**sets the user's heart rate to this object/db.
	 * @param pHeartRate
	 *            the heartRate to set
	 */
	public final void setHeartRate(final int pHeartRate) {
		mHeartRate = pHeartRate;
	}

	/**gets the notes taken by user.
	 * @return the notes taken by user.
	 */
	public final String getNotes() {
		return mNotes;
	}

	/**sets the notes taken by user in object or db.
	 * @param pNotes
	 *            the notes to set
	 */
	public final void setNotes(final String pNotes) {
		mNotes = pNotes;
	}

	/**new user profile created.
	 * @return the newUser profile.
	 */
	public final ExerciseDay getNewUser() {
		return mNewUser;
	}

	/**set the existign user profile to new.
	 * @param pNewUser
	 *            the newUser to set
	 */
	public final void setNewUser(final ExerciseDay pNewUser) {
		mNewUser = pNewUser;
	}
	/**thsi list object is responsible for holding the sports objects.
	 * @return the sports
	 */
	public final List<Weight> getSports() {
		return mSports;
	}

	@Override
	public final void save() {
		Database myDB = new Database();
		List<Parameter> params = new ArrayList();
		
		params.add(new Parameter<String>(mUserName));
		params.add(new Parameter<Date>(mDate));
		params.add(new Parameter<String>(mExercise));
		params.add(new Parameter<Double>(mTime));
		params.add(new Parameter<Integer>(mHeartRate));
		params.add(new Parameter<String>(mNotes));
		params.add(new Parameter<Integer>(mReps));
		params.add(new Parameter<Double>(mWeight));
		
		myDB.executeSql("usp_SaveWeightSetWorkout", params);

	}

	@Override
	public final void load(final String pUserName, final Date pDate) {
		Database myDb = new Database();
		List<Parameter> params = new ArrayList<>();

		params.add(new Parameter<Date>(pDate));
		params.add(new Parameter<String>(pUserName));


		ResultSet workouts = myDb.getResultSet("usp_GetWeightSetWorkouts",
						params);

				
		try {
				mSports.clear();
				while (workouts.next()) {
					Weight workout = new Weight();
					workout.setUserName(mUserName);
					workout.setDate(mDate);
					workout.setReps(workouts.getInt("Reps"));
					workout.setHeartRate(workouts.getInt("AverageHeartRate"));
					workout.setExercise(workouts.getString("ExerciseName"));
					workout.setNotes(workouts.getString("Notes"));
					workout.setWeight(workouts.getDouble("Weight"));
					workout.setTime(workouts.getDouble("Minutes"));
			
					
					addSportsPlayed(workout);
				}


		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
	
	/**
	 * add the weight workout exercise.
	 * @param pSports weight exercise.
	 */
	public final void addSportsPlayed(final Weight pSports) {
		mSports.add(pSports);
	}

	@Override
	public final void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(final int pWordoutID) {
		// TODO Auto-generated method stub
		
	}

}
