package ftse1801.demo.spring.modal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ftse1801.demo.spring.di.IUserDao;
import ftse1801.demo.spring.modal.bean.DatabaseUntil;
import ftse1801.demo.spring.modal.bean.User;

public class UserDao implements IUserDao {
	static Connection conn;
	User user;
	public static final int RECORD_IN_PAGE = 2; 
	
	@Override
	public ArrayList<User> showAllUser() {
		ArrayList<User> list = new ArrayList<>();
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM nguoi_dung";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getString("nguoi_dung.id"));
				user.setName(resultSet.getString("nguoi_dung.userName"));
				user.setPass(resultSet.getString("nguoi_dung.passWord"));
				user.setAge(resultSet.getString("nguoi_dung.age"));
				user.setAdd(resultSet.getString("nguoi_dung.address"));
				list.add(user);
			}
			
		} catch (Exception e) {
		}finally {
			try {
				statement.close();
			} catch (Exception e2) {
			}
		}
		DatabaseUntil.closeConnection(conn);
		return list;
	}
	
	@Override
	public boolean addUser(String id, String name, String pass, String age, String add,String img) {
		boolean kiemTra =false;
		conn = DatabaseUntil.getConnect();
		String sql = "INSERT INTO nguoi_dung VALUES(?,?,?,?,?)";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, name);
			statement.setString(3, pass);
			statement.setString(4, age);
			statement.setString(5, add);
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (Exception e) {
		}finally {
			try {
				statement.close();
			} catch (Exception e2) {
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}
	
	@Override
	public boolean updateUser(String name, String pass, String age, String add, String id, String img) {
		boolean kiemTra = false;
		conn = DatabaseUntil.getConnect();
		String sql = "UPDATE nguoi_dung SET userName = ?, passWord = ?, age = ?, address = ?  WHERE id = ?";
		PreparedStatement statement =null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, pass);
			statement.setString(3, age);
			statement.setString(4, add);
			statement.setString(5, id);
			if(statement.executeUpdate()>0) {
				kiemTra =true;
			}
		}  catch (Exception e) {
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}
	
	@Override
	public boolean delUser(String id) {
		boolean kiemTra = false;
		conn = DatabaseUntil.getConnect();
		String sql = "DELETE FROM nguoi_dung WHERE id = ?";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			if (statement.executeUpdate()>0) {
				kiemTra = true;
			}
		} catch (Exception e) {
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
		
	}
	
//	@Override
//	public ArrayList<User> searchUser(String key) {
//		ArrayList<User> list = new ArrayList<>();
//		PreparedStatement statement = null;
//		conn = DatabaseUntil.getConnect();
//		String sql = "SELECT * FROM nguoi_dung WHERE userName LIKE ?";
//		try {
//			statement = conn.prepareStatement(sql);
//			statement.setString(1, "%"+key+"%");
//			ResultSet resultSet = statement.executeQuery();
//			while (resultSet.next()) {
//				User = new User();
//				User.setId(resultSet.getString("nguoi_dung.id"));
//				User.setName(resultSet.getString("nguoi_dung.userName"));
//				User.setPass(resultSet.getString("nguoi_dung.passWord"));
//				User.setAge(resultSet.getString("nguoi_dung.age"));
//				User.setAdd(resultSet.getString("nguoi_dung.address"));
//				list.add(User);
//			}
//			
//		} catch (Exception e) {
//		}finally {
//			try {
//				statement.close();
//			} catch (Exception e2) {
//			}
//		}
//		DatabaseUntil.closeConnection(conn);
//		return list;
//		
//		
//	}
	
	@Override
	public ArrayList<User> showAllUserInPage(int start, int recordPage) {
		ArrayList<User> list = new ArrayList<>();
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM nguoi_dung LIMIT ?,?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, start);
			statement.setInt(2, recordPage);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getString("nguoi_dung.id"));
				user.setName(resultSet.getString("nguoi_dung.userName"));
				user.setPass(resultSet.getString("nguoi_dung.passWord"));
				user.setAge(resultSet.getString("nguoi_dung.age"));
				user.setAdd(resultSet.getString("nguoi_dung.address"));
				list.add(user);
			}
			
		} catch (Exception e) {
		}finally {
			try {
				statement.close();
			} catch (Exception e2) {
			}
		}
		DatabaseUntil.closeConnection(conn);
		return list;
	}
	
//	@Override
//	public int Count() {
//		int total = 0;
//		conn = DatabaseUntil.getConnect();
//		PreparedStatement statement =null;
//		String sql = "SELECT COUNT(*) FROM nguoi_dung";
//		try {
//			statement = conn.prepareStatement(sql);
//			ResultSet resultSet = statement.executeQuery();
//			while (resultSet.next()) {
//				total = resultSet.getInt("COUNT(*)");
//			}
//		} catch (Exception e) {
//		}finally {
//			if (statement != null) {
//				try {
//					statement.close();
//				} catch (SQLException e) {
//				}
//			}
//		}
//		DatabaseUntil.closeConnection(conn);
//		return  total;
//	}

	@Override
	public User getUser(String id) {
		User user = null;
		conn= DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		String sql = "SELECT * FROM nguoi_dung WHERE id=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				user = new User();
				user.setName(resultSet.getString("userName"));
				user.setPass(resultSet.getString("passWord"));
				user.setAge(resultSet.getString("age"));
				user.setAdd(resultSet.getString("address"));
				user.setId(resultSet.getString("id"));
			}
		} catch (Exception e) {
		}finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
			}
		}
		DatabaseUntil.closeConnection(conn);
		return user;
	}
}
