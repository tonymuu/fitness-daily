/**This class is responsible for storing multiple sports
 * exercise that a user might enjoy doing. It is responsible for
 * type of sports, duration of exercise, average heart rate, and 
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

/**This class is responsible for storing multiple sports
 * exercise that a user might enjoy doing. It is responsible for
 * type of sports, duration of exercise, average heart rate, and 
 * notes user would like to add. In addition to that, user may also 
 * save or load information of an earlier day.
 * @author Administrator
 *
 */
public class Sports extends ExerciseDay {
	/**
	 * type of sports been played by the user.
	 */
	private String mSportsPlayed;
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
	 * list of sports that will hold the sports objects.
	 * 
	 */
	private List<Sports> mSports = new ArrayList<>();
	
	/**
	 * new user profile.
	 */
	private ExerciseDay newUser;

	/**this method will return the sports played by user.
	 * @return the sportsPlayed by user.
	 */
	public final String getSportsPlayed() {
		return this.mSportsPlayed;
	}
	/**this method will set what sports did the user play.
	 * @param pSportsPlayed the sportsPlayed to set
	 */
	public final void setSportsPlayed(final String pSportsPlayed) {
		this.mSportsPlayed = pSportsPlayed;
	}

	/**this method will return the time etnered by user.
	 * @return the time entered.
	 */
	public final double getTime() {
		return mTime;
	}
	/**this method is responsible for setting the time user entered for sports.
	 * @param pTime the time to set by user.
	 */
	public final void setTime(final double pTime) {
		mTime = pTime;
	}
	/**thsi list object is responsible for holding the sports objects.
	 * @return the sports
	 */
	public final List<Sports> getSports() {
		return mSports;
	}
	/**this method will set the sports objects into the sports list.
	 * 
	 * @param pSports the sports to set in the list.
	 */
	public final void setSports(final List<Sports> pSports) {
		mSports = pSports;
	}
	/**this method will return the heart rate to the caller.
	 * @return the heartRate of user.
	 */
	public final int getHeartRate() {
		return mHeartRate;
	}
	/**this method will set the heart rate of the sports object.
	 * @param pHeartRate the heartRate to set
	 */
	public final void setHeartRate(final int pHeartRate) {
		mHeartRate = pHeartRate;
	}
	/**this method will return the string notes to the caller.
	 * @return the notes taht will be passed on.
	 */
	public final String getNotes() {
		return mNotes;
	}
	/**this method will set the notes got from user entered in the textfield.
	 * @param pNotes the notes to set passed in.
	 */
	public final void setNotes(final String pNotes) {
		mNotes = pNotes;
	}
	/**this method will get the new user profile and link it.
	 * @return the newUser
	 */
	public final UserProfile getNewUser() {
		return newUser;
		
	}
	/**this method will set the new user logged in to known account.
	 * @param pNewUser the newUser to set to log in.
	 */
	public final void setNewUser(final ExerciseDay pNewUser) {
		newUser = pNewUser;
		
		mUserName = newUser.getUserName();
		mDate = new Date();
		mRHR = newUser.getRHR();
	}
	/**this method returns the date of using playing sports.
	 * @return the date using playing sports.
	 */
	public Date getDate() {
		return mDate;
	}
	/**this method sets the date of exercise.
	 * @param pDate the date to set
	 */
	public final void setDate(final Date pDate) {
		mDate = pDate;
	}
	/**
	 * this method adds the sports being played by user.
	 * @param pSports passed in to be added.
	 */
	public final void addSportsPlayed(final Sports pSports) {
		mSports.add(pSports);
	}
	
	@Override
	public final void save() {

		Database myDB = new Database();
		List<Parameter> params = new ArrayList<>();
		
		params.add(new Parameter<String>(mUserName));
		params.add(new Parameter<Date>(mDate)); 
		
		params.add(new Parameter<String>(mSportsPlayed));
		params.add(new Parameter<Double>(mTime));
		params.add(new Parameter<Integer>(mHeartRate));
		params.add(new Parameter<String>(mNotes));
		
		myDB.executeSql("usp_SaveSportWorkout", params);
		
		
		
		
		
	}
	@Override
	public final void load(final String pUserName, final Date pDate) {
		
		Database myDb = new Database();
		List<Parameter> params = new ArrayList<>();

		params.add(new Parameter<Date>(pDate));
		params.add(new Parameter<String>(pUserName));


		ResultSet workouts = myDb.getResultSet("usp_GetSportWorkouts",
						params);

				
		try {
				
				while (workouts.next()) {
					Sports workout = new Sports();
					workout.setUserName(mUserName);
					workout.setDate(mDate);
					workout.setRHR(workouts.getInt("AverageHeartRate"));
					workout.setTime(workouts.getDouble("Minutes"));
					workout.setNotes(workouts.getString("Notes"));
					workout.setSportsPlayed(workouts.getString("ExerciseName"));
					
					addSportsPlayed(workout);
				}


		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}


}

