package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "userLogin", eager = true)
@RequestScoped
public class Login {
	private String message;
	private String username;
	private String password;

	public String login() {
		if ("a".equalsIgnoreCase(username) && "a".equalsIgnoreCase(password)) {
			return "index";
		} else {
			message = "Đăng nhập không chính xác, vui lòng nhập lại.";
			return "login";
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
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