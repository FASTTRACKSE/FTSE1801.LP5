package model;

import javax.faces.bean.ManagedBean;
@ManagedBean
public class UserDao {
	public String getUsername(int id) {
		String name = null;
		if(id==1) {
			name = "๖²⁴ʱC҉H҉ịC҉H҉﹏❣";
		}else {
			name = "๖²⁴ʱЖŐạČ﹏❣‏";
		}
		return name;
	}
}
