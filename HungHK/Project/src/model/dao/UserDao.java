package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.database.DatabaseUltil;
import common.database.DatabaseUltil.IPareEntity;
import common.database.DatabaseUltil.IPrePareStatement;
import model.entity.User;

/**
 * @author PC
 *
 */
public class UserDao {
	private IPrePareStatement iPrePareStatement = new IPrePareStatement() {
		public void setParameterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException {
			statement.setString(1, (String) mapParam.get("user"));
			statement.setString(2, (String) mapParam.get("pass"));
		}
	};

	private IPareEntity<User> iPareEntity = new IPareEntity<User>() {
		public User pare(ResultSet result) throws SQLException {
			return new User(result.getString("username"), result.getString("password"), result.getString("fullname"),
					result.getString("old"));
		}
	};

	public User getUser(String username, String password) {

		User user = null;
		if ("nhat".equals(username) && "123".equals(password)) {
			user = new User();
			user.setUesrname("nhat");
			user.setPassword("123");
			user.setOld("25");
		}

		String sql = "select * from user where username =? and password =?";
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("user", username);
		mapParam.put("pass", password);
		List<User> listUser = DatabaseUltil.executeSelect(sql, mapParam, iPrePareStatement, iPareEntity);
		return listUser.size() == 0 ? null : listUser.get(0);
		// return user;
	}

}
