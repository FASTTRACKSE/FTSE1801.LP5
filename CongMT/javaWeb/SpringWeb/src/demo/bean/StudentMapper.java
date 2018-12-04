package demo.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet arg0, int arg1) throws SQLException {
		Student student= new Student();
		student.setId(arg0.getInt("id"));
		student.setName(arg0.getString("name"));
		student.setOld(arg0.getString("old"));
		student.setAdress(arg0.getString("adress"));
		student.setNumberPhone(arg0.getString("phoneNumber"));
		student.setImg(arg0.getString("img"));
		return student;
	}

}
