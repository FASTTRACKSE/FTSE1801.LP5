package myJSF;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UserBean {
	private String username;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String sayhelloUser() {
		return "welcome";
	}
}
