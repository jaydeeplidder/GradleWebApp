package in.sts.webappgradle.model;

public class Login {
	private Booking booking;
	private int userid;
	private String username;
	private String email;


	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return email;
	}
	public void setPassword(String password) {
		this.email = password;
	}



	public Login() {
		super();
	}
	public Login(int userid, String username, String password) {

		this.userid = userid;
		this.username = username;
		this.email = password;
	}


}
