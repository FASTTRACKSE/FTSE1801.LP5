package myJSF;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.PrimeFaces;



import javax.faces.bean.ManagedBean;

@ManagedBean
public class UserLogin {
	  private String message ="Enter username and password.";
	    private String username;
	    private String password;
	    public String login(){
	    	if("admin".equalsIgnoreCase(username) && "123".equalsIgnoreCase(password)) {
	    		message ="Successfully logged-in.";
	    		return "index";
	    	} else {
	    		message ="Bạn nhập sai tài khoản hoặc mật khẩu";
	    		return "login";
	    	}
	    }
	    public String getMessage() {
		return message;
	    }
	    public void setMessage(String
	     message) {
		this.message = message;
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
}
