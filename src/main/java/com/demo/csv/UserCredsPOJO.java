package com.demo.csv;

public class UserCredsPOJO {
 String username,password;
 
public UserCredsPOJO(){
	
}

public UserCredsPOJO(String username, String password) {
	super();
	this.username = username;
	this.password = password;
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

@Override
public String toString() {
	return "UserCreds [username=" + username + ", password=" + password + "]";
}
 
 
}
