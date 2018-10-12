package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import common.database.DatabaseUtil;

import model.entity.User;

//public class UserDao {
//	private IPrePareStatement iPareStatement = new IPrePareStatement() {
//		
//		public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException {
//			statement.setString(1, (String) mapParam.get("user"));
//			statement.setString(2, (String) mapParam.get("pass"));
//			
//		}
//	};
//	private IPareEntity<User> iPareEntity = new IPareEntity<User>() {
//		public User par(ResultSet result) throws SQLException{
//			return new User(result.getString("username"), result.getString("password"), result.getString("fullname"), result.getString("old"));
//		}
//	};
//
//	public User getUser(String userName, String passWord) {
//		String sql = "select * from user where username = ? and password = ?";
//		Map<String, String> mapParam = new HashMap<String, String>();
//		mapParam.put("user", userName);
//		mapParam.put("pass", passWord);
//		List<User> listUser = DatabaseUtil.executeSelect(sql, mapParam, iPareStatement, iPareEntity);
//		return listUser.size() == 0 ? null : listUser.get(0);
		
//	}
//}
