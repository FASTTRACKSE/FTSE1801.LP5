package model.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginBean {
	private String userName;
	private String passWord;
	private String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String checkSession() {
		if (userName!=null) {
			return "success";
		}else {
			return "failure";
		}
	}
	
	public String checkLogin() {
		String checking = "";
		if (userName.equals("vanmanh") && passWord.equals("123")) {
			checking = "index";
		}else {
			userName = null;
			passWord = null;
			checking = "login";
		}
		return checking;
	}
	
}
