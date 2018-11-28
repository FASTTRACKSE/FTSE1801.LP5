package userDao;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UserDao {
   public String  getUsername(int id) {
	  String name=null;
	  if(id==1) {
		name= "luân";  
	  }else {
		name="luân chó đẻ";
	}
	  return name;
	   
   }
}
