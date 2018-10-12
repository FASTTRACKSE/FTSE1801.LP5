package model;

import javax.faces.bean.ManagedBean;
@ManagedBean(name="dao")

public class UserDao {
	
	
	public String getUserName(int id) {
		String name = null;
		if(id==1) {
			name="Hoi";
		}else {
			name="HoiCa";
		}
		return name;
	}
}
