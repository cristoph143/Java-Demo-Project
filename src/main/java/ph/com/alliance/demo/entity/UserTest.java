package ph.com.alliance.demo.entity;

public class UserTest {
	private int userID;
	private String username;
	private String password;
	
	public UserTest()
	{
	}
	
	public UserTest(final int userID, final String username, final String password)
	{
		this.userID = userID;
		this.username = username;
		this.password = password;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
