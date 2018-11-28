package ftse1801.demo.spring.modal.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import ftse1801.demo.spring.di.IUserDao;
import ftse1801.demo.spring.modal.bean.User;

public class UserDaoJDBC implements IUserDao{
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public ArrayList<User> showAllUser() {
		String sql ="SELECT * FROM nguoi_dung";
		return (ArrayList<User>) template.query(sql, new UserMapper());
	}

	@Override
	public ArrayList<User> showAllUserInPage(int start, int recordPage) {
		String sql = "SELECT * FROM nguoi_dung LIMIT ?,?";
		return (ArrayList<User>) template.query(sql, new UserMapper(), start, recordPage);
	}

	@Override
	public boolean addUser(String id, String name, String pass, String age, String add,String img) {
		boolean kiemTra =false;
		String sql = "INSERT INTO nguoi_dung VALUES(?,?,?,?,?,?)";
		int count = template.update(sql, id,name,pass,age,add,img);
		if (count>0) {
			kiemTra = true;
		}
		return kiemTra;
	}

	@Override
	public boolean updateUser(String name, String pass, String age, String add, String id, String img) {
		String sql = "UPDATE nguoi_dung SET userName = ?, passWord = ?, age = ?, address = ?  WHERE id = ?";
		boolean kiemTra = false;
		int count = template.update(sql, name, pass, age, add, id, img);
		if (count>0) {
			kiemTra = true;
		}
		return kiemTra;
	}

	@Override
	public boolean delUser(String id) {
		String sql = "DELETE FROM nguoi_dung WHERE id = ?";
		boolean kiemTra = false;
		int count = template.update(sql, id);
		if (count>0) {
			kiemTra = true;
		}
		return kiemTra;
	}

	@Override
	public User getUser(String id) {
		String sql = "SELECT * FROM nguoi_dung WHERE id=?";
		return (User) template.queryForObject(sql, new UserMapper(), id);
	}

}
