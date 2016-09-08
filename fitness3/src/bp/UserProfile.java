package bp;

public class UserProfile extends Workout {

	protected String mUserName;
	private String mUserGender;
	private double mUserWeight;
	private int mUserAge;
	private double mUserHeight;


	

	/**
	 * @return the userAge
	 */
	public int getUserAge() {
		return this.mUserAge;
	}
	/**
	 * @param pUserAge the userAge to set
	 */
	public void setUserAge(int pUserAge) {
		this.mUserAge = pUserAge;
	}
	/**
	 * @return the userHeight
	 */
	public double getUserHeight() {
		return this.mUserHeight;
	}
	/**
	 * @param pUserHeight the userHeight to set
	 */
	public void setUserHeight(int pUserHeight) {
		this.mUserHeight = pUserHeight;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return this.mUserName;
	}
	/**
	 * @param pUserName the userName to set
	 */
	public void setUserName(String pUserName) {
		this.mUserName = pUserName;
	}
	/**
	 * @return the userWeight
	 */
	public double getUserWeight() {
		return this.mUserWeight;
	}
	/**
	 * @param pUserWeight the userWeight to set
	 */
	public void setUserWeight(int pUserWeight) {
		this.mUserWeight = pUserWeight;
	}


	/**
	 * @return the userGender
	 */
	public String getUserGender() {
		return mUserGender;
	}
	/**
	 * @param pUserGender the userGender to set
	 */
	public void setUserGender(String pUserGender) {
		mUserGender = pUserGender;
	}

	

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(int pWordoutID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}
