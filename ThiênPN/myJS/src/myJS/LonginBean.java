package myJS;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="loginBean",eager = true)
@RequestScoped
public class LonginBean {
	private String username;
	private String password;

	public LonginBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public LonginBean() {

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
    public String Check() {
    
    		if(username.equals("luanngao123")&&password.equals("12345")) {
        		return "index";
        	}else {
    			return "login";
    		}
    	
    }
}
