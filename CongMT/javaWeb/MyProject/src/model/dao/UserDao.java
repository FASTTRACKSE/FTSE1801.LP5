package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import common.database.DatabaseUltil;
import common.database.DatabaseUltil.IPrePareStatement;
import model.entity.User;

public class UserDao {
	private IPareStatement iPareStatement = new IPareStatement() {
		public void setParamaterQuery(Map<?, ?> mapParam, PreparedStatement statement) throws SQLException{
			statement.setString(1, (String) mapParam.get("user"));
			statement.setString(2, (String) mapParam.get("pass"));
		}
	};
	private PareEntity<User> pareEntity = new PareEntity<User>(){
		public User pra(ResultSet result) throws SQLException{
		return new User(result.getString("userName"), result.getString("passWord"), result.getString("fullName"), result.getString("old"));	
		}
	};
	 public User getUser(String userName, String passWord) {
	String sql = "select * from user where userName= ? and passWord=?";
	Map<String, String> mapParam = new HashMap<String, String>();
	mapParam.put("user", userName);
	mapParam.put("pass", passWord);
	List<User> listUser= DatabaseUltil.executeSelect(sql, mapParam, iPareStatement, pareEntity);
	return listUser.size()== 0 ? null : listUser.get(0);
		
	 }
}
