package modal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import modal.bean.DatabaseUntil;
import modal.bean.UserBean;

@ManagedBean
public class UserDao {
	static Connection conn;
	UserBean userBean;
	public static final int RECORD_IN_PAGE = 2; 
	
	public ArrayList<UserBean> showAllUser() {
		ArrayList<UserBean> list = new ArrayList<>();
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM nguoi_dung";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				userBean = new UserBean();
				userBean.setId(resultSet.getString("nguoi_dung.id"));
				userBean.setName(resultSet.getString("nguoi_dung.userName"));
				userBean.setPass(resultSet.getString("nguoi_dung.passWord"));
				userBean.setAge(resultSet.getString("nguoi_dung.age"));
				userBean.setAdd(resultSet.getString("nguoi_dung.address"));
				list.add(userBean);
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
	public boolean addUser(String id, String img, String name, String pass, String age, String add) {
		boolean kiemTra =false;
		conn = DatabaseUntil.getConnect();
		String sql = "INSERT INTO nguoi_dung VALUES(?,?,?,?,?,?)";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, img);
			statement.setString(3, name);
			statement.setString(4, pass);
			statement.setString(5, age);
			statement.setString(6, add);
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
	
	public boolean updateUser(String id, String name, String pass, String age, String add) {
		boolean kiemTra = false;
		conn = DatabaseUntil.getConnect();
		String sql = "UPDATE nguoi_dung SET userName = ?, passWord = ?, age = ?, address = ?  WHERE id = ?";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, pass);
			statement.setString(3, age);
			statement.setString(4, add);
			statement.setString(5, id);
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
	
	public ArrayList<UserBean> searchUser(String key) {
		ArrayList<UserBean> list = new ArrayList<>();
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM nguoi_dung WHERE userName LIKE ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, "%"+key+"%");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				userBean = new UserBean();
				userBean.setId(resultSet.getString("nguoi_dung.id"));
				userBean.setName(resultSet.getString("nguoi_dung.userName"));
				userBean.setPass(resultSet.getString("nguoi_dung.passWord"));
				userBean.setAge(resultSet.getString("nguoi_dung.age"));
				userBean.setAdd(resultSet.getString("nguoi_dung.address"));
				list.add(userBean);
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
	
	public ArrayList<UserBean> showAllUserInPage(int start, int recordPage) {
		ArrayList<UserBean> list = new ArrayList<>();
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM nguoi_dung LIMIT ?,?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, start);
			statement.setInt(2, recordPage);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				userBean = new UserBean();
				userBean.setId(resultSet.getString("nguoi_dung.id"));
				userBean.setImage(resultSet.getString("nguoi_dung.image"));
				userBean.setName(resultSet.getString("nguoi_dung.userName"));
				userBean.setPass(resultSet.getString("nguoi_dung.passWord"));
				userBean.setAge(resultSet.getString("nguoi_dung.age"));
				userBean.setAdd(resultSet.getString("nguoi_dung.address"));
				list.add(userBean);
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
	
	public int Count() {
		int total = 0;
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement =null;
		String sql = "SELECT COUNT(*) FROM nguoi_dung";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				total = resultSet.getInt("COUNT(*)");
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
		return  total;
	}

	public boolean getUser(String userName, String pass) {
		boolean kiemtra = false;
		conn= DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		String sql = "SELECT userName, passWord FROM nguoi_dung WHERE userName =? and passWord =?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, pass);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				kiemtra = true;
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
		return kiemtra;
	}
}
