package in.sts.webappgradle.model;

import java.math.BigDecimal;

public class Users {


	private int userid;
	private String firstname;
	private String lastname;
	private int age;
	private String email;
	private String password;
	private BigDecimal phoneno;
	private String location;
	private BigDecimal pincode;



	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return firstname;
	}
	public void setUsername(String username) {
		this.firstname = username;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public BigDecimal getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(BigDecimal phoneno) {
		this.phoneno = phoneno;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "signup [pincode=" + pincode + "]";
	}
	public BigDecimal getPincode() {
		return pincode;
	}
	public void setPincode(BigDecimal pincode) {
		this.pincode = pincode;
	}
	
	
	public Users() {
		super();
	}
	public Users(int userid, String firstname, String lastname, int age,  String email,String password,
			BigDecimal phoneno, String location, BigDecimal pincode) {
		
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
		this.password = password;
		this.phoneno = phoneno;
		this.location = location;
		this.pincode = pincode;
	}




}
