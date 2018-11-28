package model.Dao;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UserDao {
	public String getName(int id) {
		String name = null;
		if (id==1) {
			name= "Manh";
		}else {
			name= "Van Manh";
		}
		
		return name;
	}
}
