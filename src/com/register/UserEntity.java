package com.register;

public class UserEntity {
	private String username;
	private String passcodeString;
	private int authority;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasscodeString() {
		return passcodeString;
	}
	public void setPasscodeString(String passcodeString) {
		this.passcodeString = passcodeString;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
}
