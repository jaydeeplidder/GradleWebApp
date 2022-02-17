package in.sts.webappgradle.model;

import java.math.BigDecimal;

public class SignUp {



	private String username;
	private String password;
	private String email;
	private BigDecimal phoneno;
	private String location;
	private BigDecimal pincode;



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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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




}
