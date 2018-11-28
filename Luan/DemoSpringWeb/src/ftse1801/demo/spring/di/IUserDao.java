package ftse1801.demo.spring.di;

import java.util.List;

import ftse1801.demo.spring.modal.bean.User;

public interface IUserDao {
	public List<User> showAllUser();
	public List<User> showAllUserInPage(int start, int recordPage);
	public boolean addUser(String id, String name, String pass, String age, String add, String img);
	public boolean updateUser(String name, String pass, String age, String add, String id, String img);
	public boolean delUser(String id);
	public User getUser(String id);
}
