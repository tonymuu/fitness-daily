/**This class is responsible for storing multiple aerobic
 * exercise that a user might enjoy doing. It is responsible for
 * type of aerobic exercises, duration of exercise, average heart rate, 
 * distance of a specific exercise, and 
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

/**This class is responsible for storing multiple aerobic
 * exercise that a user might enjoy doing. It is responsible for
 * type of aerobic exercises, duration of exercise, average heart rate, 
 * distance of a specific exercise, and 
 * notes user would like to add. In addition to that, user may also 
 * save or load information of an earlier day.
 * @author Administrator
 *
 */
public class Aerobic extends ExerciseDay {
	/**
	 * user's name.
	 */
	private String mUserName;
	/**
	 * exercise name user chooses to do.
	 */
	private String mExercise;


	/**
	 * distance user did aerobic through.
	 */
	private double mDistance;
	
	/**
	 * duration of this workout.
	 */
		private double mTime;
		/**
		 * average heart rate during the workout.
		 */
		private int mHeartRate;
		/**
		 * user taken notes.
		 */
		private String mNotes;
		/**
		 * date of the workout.
		 */
		private Date mDate;
	
		/**
		 * a new user profile.
		 */
	private ExerciseDay mNewUser;
	/**
	 * a list that will contain all the aerobic sports.
	 */
	
	private List<Aerobic> mSports = new ArrayList<>();
	

	
	/**get the new user profile from GUI.
	 * @return the newUser the info from new user.
	 */
	public final ExerciseDay getNewUser() {
		return mNewUser;
	}

	/**set the user information to the presentation layer.
	 * @param pNewUser the user data from db.
	 *            the newUser to set
	 */
	public final void setNewUser(final ExerciseDay pNewUser) {
		mNewUser = pNewUser;

	}

	/**this method will get the user name of this aerobic sports.
	 * @return the userName of the specific aerobic.
	 */
	public final String getUserName() {
		return mUserName;
	}

	/**set the user name according to input.
	 * @param pUserName the userName to set by input.
	 */
	public final void setUserName(final String pUserName) {
		mUserName = pUserName;
	}

	/**this method will return the date of the object aerobic.
	 * @return the date in this aerobic object.
	 */
	public Date getDate() {
		return mDate;
	}

	/**this method will set the date from passed in date.
	 * @param pDate the date to set from passed in date.
	 */
	public final void setDate(final Date pDate) {
		mDate = pDate;
	}

	/**this method will return the exercise that's been called.
	 * @return the exercise being returnd.
	 */
	public final String getExercise() {
		return mExercise;
	}

	/**this method will set the exercise accroding to the params..
	 * @param pExercise the exercise to set by choice.
	 */
	public final void setExercise(final String pExercise) {
		mExercise = pExercise;
	}

	/**this method will return the time user did aerobic..
	 * @return the time used by user.
	 */
	public final double getTime() {
		return mTime;
	}

	/**this method will set the time used by user..
	 * @param pTime the time to set used by user.
	 */
	public final void setTime(final double pTime) {
		mTime = pTime;
	}

	/**this method will return the heart rate of this aerobic.
	 * @return the heartRate of this exercise.
	 */
	public final int getHeartRate() {
		return mHeartRate;
	}

	/**set the heart rate of this aerobic exercise.
	 * @param pHeartRate the heartRate to set in this aerobic exercise.
	 */
	public final void setHeartRate(final int pHeartRate) {
		mHeartRate = pHeartRate;
	}

	/**return the notes taken down by user.
	 * @return the notes taken by user.
	 */
	public final String getNotes() {
		return mNotes;
	}

	/**set the notes passed by user written.
	 * @param pNotes the notes to set by user.
	 */
	public final void setNotes(final String pNotes) {
		mNotes = pNotes;
	}

	/**get the distance of how many miles user did aerobic.
	 * @return the distance user did aerobic..
	 */
	public final double getDistance() {
		return mDistance;
	}

	/**set the distance of how many miles user did aerobics.
	 * @param pDistance the distance to set by user.
	 */
	public final void setDistance(final double pDistance) {
		mDistance = pDistance;
	}
	/**thsi list object is responsible for holding the sports objects.
	 * @return the sports
	 */
	public final List<Aerobic> getSports() {
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
		params.add(new Parameter<Double>(mDistance));
		
		myDB.executeSql("usp_SaveAerobicWorkout", params);
	}

	@Override
	public final void load(final String pUserName, final Date pDate) {
		Database myDb = new Database();
		List<Parameter> params = new ArrayList<>();

		params.add(new Parameter<Date>(pDate));
		params.add(new Parameter<String>(pUserName));


		ResultSet workouts = myDb.getResultSet("usp_GetAerobicWorkouts",
						params);

				
		try {
				mSports.clear();
				while (workouts.next()) {
					Aerobic workout = new Aerobic();
					workout.setUserName(mUserName);
					workout.setDate(mDate);
					workout.setTime(workouts.getDouble("Minutes"));
					workout.setRHR(workouts.getInt("AverageHeartRate"));
					workout.setDistance(workouts.getDouble("Distance"));
					workout.setNotes(workouts.getString("Notes"));
					workout.setExercise(workouts.getString("ExerciseName"));
					
					addSportsPlayed(workout);
				}


		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
	
	/**
	 * this method will add the aerobic exercise that is done.
	 * @param pWorkout aerobic exercise being done.
	 */
	public final void addSportsPlayed(final Aerobic pWorkout) {
		mSports.add(pWorkout);
	}
	@Override
	public void load(final int pWordoutID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}
