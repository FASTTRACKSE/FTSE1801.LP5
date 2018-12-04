package demo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import demo.bean.Student;
import demo.bean.StudentMapper;

public class JDBCStudentDao implements IStudentDao{
	private JdbcTemplate jdbcTemplate;   
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	} 
	@Override
	public ArrayList<Student> getStudent() {
		String sql = "SELECT  * FROM sinhvien";
		return (ArrayList<Student>) jdbcTemplate.query(sql, new StudentMapper());
	}

	@Override
	public boolean addStudent(Student student) {
		String sql = "INSERT INTO `sinhvien`(id,`name`, `old`, `adress`, `numberPhone`, img) VALUES (?,?,?,?,?,?)";
	 jdbcTemplate.update(sql, student.getId(), student.getName(), student.getOld(), student.getAdress(), student.getNumberPhone(), student.getImg());
	return false;
	}

	@Override
	public boolean editStudent(String name, String old, String adress, String numberPhone, int id) {
		String sql = "UPDATE sinhvien SET name=?, old=?, adress=?, numberPhone=? WHERE id=?";
		jdbcTemplate.update(sql, new StudentMapper(), name, old, adress, numberPhone, id);
		return false;
	}

	@Override
	public boolean deletelStudent(int id) {
		String sql = "DELETE FROM sinhvien WHERE id=?";
		jdbcTemplate.update(sql, new StudentMapper(), id);
		return false;
	}

	@Override
	public Student getAllByStudent(int id) {
		String sql = "SELECT  * FROM sinhvien WHERE id=?";
		return (Student) jdbcTemplate.query(sql, new StudentMapper(), id);
		
	}

	@Override
	public ArrayList<Student> getAllStudent(int pageid, int total) {
		String sql = "SELECT * FROM sinhvien LIMIT ?,?";
		return (ArrayList<Student>) jdbcTemplate.query(sql, new StudentMapper(), pageid, total);
	}

	@Override
	public int getCount(int soDong) {
		 String sql= " SELECT COUNT(*) FROM sinhvien";
	 jdbcTemplate.query(sql, new StudentMapper(), soDong); ;
	return soDong;
	}

	@Override
	public boolean isValidUser(String username, String password) throws SQLException {
		return false;
	}
	@Override
	public ArrayList<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}
