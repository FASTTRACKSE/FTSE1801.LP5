package model;

public class User {
  private String user;
  private String password;
  public User() {
	  
  }
public User(String user, String password) {
	super();
	this.user = user;
	this.password = password;
}
  public String toString() {
	  return user+"/"+ password;
  }
}
