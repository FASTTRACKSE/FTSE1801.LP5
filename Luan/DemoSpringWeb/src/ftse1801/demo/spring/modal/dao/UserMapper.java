package ftse1801.demo.spring.modal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ftse1801.demo.spring.modal.bean.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet resultSet, int row) throws SQLException {
		User user = new User();
		user.setId(resultSet.getString("id"));
		user.setName(resultSet.getString("userName"));
		user.setPass(resultSet.getString("passWord"));
		user.setAge(resultSet.getString("age"));
		user.setAdd(resultSet.getString("address"));
		user.setImg(resultSet.getString("image"));
		return user;
	}

}
