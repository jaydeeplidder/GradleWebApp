package in.sts.webappgradle.model;

public class Booking {

	private int userid;
	private String username;
	private String date;
	private String location;
	private String hotel;
	private int stay;
	private int guest;

	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public int getStay() {
		return stay;
	}
	public void setStay(int stay) {
		this.stay = stay;
	}
	public int getGuest() {
		return guest;
	}
	public void setGuest(int guest) {
		this.guest = guest;
	}




	public Booking() {
		super();
	}
	public Booking(int userid,String username, String date, String location, String hotel, int stay, int guest) {

		this.userid = userid;
		this.username = username;
		this.date = date;
		this.location = location;
		this.hotel = hotel;
		this.stay = stay;
		this.guest = guest;
	}
	@Override
	public String toString() {
		return "booking [username=" + username + ", date=" + date + ", location=" + location + ", hotel=" + hotel
				+ ", stay=" + stay + ", guest=" + guest + "]";
	}


}
