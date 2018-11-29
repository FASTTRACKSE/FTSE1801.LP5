package model.dao;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UserDao {
	public String getUsername(int id) {
		String name = null;
		if(id==1) {
			name = "HKH";
		} else {
			name = "thằng ml";
		}
		return name;
	}
}
