package model.entity;

public class User {
	private String uesrname;
	private String password;
	private String fullname;
	private String old;

	public User() {
	}

	public User(String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}

	public String getUesrname() {
		return uesrname;
	}

	public void setUesrname(String uesrname) {
		this.uesrname = uesrname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getOld() {
		return old;
	}

	public void setOld(String old) {
		this.old = old;
	}

}
