package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import model.dao.DatabasaUltil;
import myJSF.Student;
@ManagedBean
public class UserDao {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet result;
	public Student getAllByStudent(String id) {
		
		String sql = "SELECT  * FROM sinhvien WHERE id=?";
		conn = DatabasaUltil.getConnect();
		 Student student = new Student();
		try {
			 statement = conn.prepareStatement(sql);
			 statement.setString(1, id);
			 result = statement.executeQuery();
			while (result.next()) {
				student = new Student();
				student.setId(result.getString("id"));
				student.setName(result.getString("name"));
				student.setOld(result.getString("old"));
				student.setAdress(result.getString("adress"));
				student.setNumberPhone(result.getString("numberPhone"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabasaUltil.closeConnection(conn);
		}
		return student;
	}
	public ArrayList<Student> getStudent() {
		String sql = "SELECT  * FROM sinhvien";
		conn = DatabasaUltil.getConnect();
		ArrayList<Student> listSv = new ArrayList<Student>();
		try {
			 statement = conn.prepareStatement(sql);
			 result = statement.executeQuery();
			 Student student;
			while (result.next()) {
				student = new Student();
				student.setId(result.getString("id"));
				student.setName(result.getString("name"));
				student.setOld(result.getString("old"));
				student.setAdress(result.getString("adress"));
				student.setNumberPhone(result.getString("numberPhone"));
				listSv.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
	
		return listSv;
		}
}
