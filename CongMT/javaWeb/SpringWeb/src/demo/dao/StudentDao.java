package demo.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import demo.bean.Student;
import demo.databasa.DatabasaUltil;



public  class StudentDao implements IStudentDao {
	
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet result;
	
	@Override
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
				student.setId(result.getInt("id"));
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
	@Override
	public boolean addStudent(Student student) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "INSERT INTO `sinhvien`(id,`name`, `old`, `adress`, `numberPhone`, img) VALUES (?,?,?,?,?,?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, student.getId());
			statement.setString(2, student.getName());
			statement.setString(3, student.getOld());
			statement.setString(4, student.getAdress());
			statement.setString(5, student.getNumberPhone());
			statement.setString(6, student.getImg());
			
			int count = statement.executeUpdate();
			
			if (count > 0) {
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;

	}
	@Override	
	public boolean editStudent(Student student) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "UPDATE sinhvien SET name=?, old=?, adress=?, numberPhone=? WHERE id=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, student.getName());
			statement.setString(2, student.getOld());
			statement.setString(3, student.getAdress());
			statement.setString(4, student.getNumberPhone());
			statement.setInt(5, student.getId());
			int count = statement.executeUpdate();
			if (count > 0) {
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DatabasaUltil.closeConnection(conn);
		}
		return statusExecute;
	}
	@Override
	public boolean deletelStudent(int id) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		
		String sql = "DELETE FROM sinhvien WHERE id=?";

		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			int count = statement.executeUpdate();
			if (count > 0) {
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DatabasaUltil.closeConnection(conn);
		}
		return statusExecute;
	}
	@Override
	public Student getAllByStudent(int id) {
		
		String sql = "SELECT  * FROM sinhvien WHERE id=?";
		conn = DatabasaUltil.getConnect();
		 Student student = null;
		try {
			 statement = conn.prepareStatement(sql);
			 statement.setInt(1, id);
			 result = statement.executeQuery();
			while (result.next()) {
				student = new Student();
				student.setId(result.getInt("id"));
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
	@Override
	public ArrayList<Student> getAllStudent(int pageid,int total){
		 String sql = "SELECT * FROM sinhvien LIMIT ?,?";
		 conn = DatabasaUltil.getConnect();
		 ArrayList<Student> listSv= new  ArrayList<Student>();
		 try {
			 statement = conn.prepareStatement(sql);
			 statement.setInt(1, pageid);
			 statement.setInt(2, total);
			 result = statement.executeQuery();
			while (result.next()) {
				Student student = new Student();
				student.setId(result.getInt("id"));
				student.setName(result.getString("name"));
				student.setOld(result.getString("old"));
				student.setAdress(result.getString("adress"));
				student.setNumberPhone(result.getString("numberPhone"));
				listSv.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabasaUltil.closeConnection(conn);
		}
		return listSv;
		 
	 }
	@Override
	 public int getCount(int soDong) {
		 String sql= " SELECT COUNT(*) FROM sinhvien";
		 conn = DatabasaUltil.getConnect();
		 int count =0;
		 try {
			 statement = conn.prepareStatement(sql);
			 result = statement.executeQuery();
			while (result.next()) {
			count = result.getInt("COUNT(*)");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabasaUltil.closeConnection(conn);
		}
		 if(count%soDong == 0) {
			 return count/soDong;
		}else {
			return count/soDong+1;
		}
	 }
	 @Override
	     public boolean isValidUser(String username, String password) throws SQLException{
		 	boolean statusExecute = false;
	         String sql = "Select count(1) from user where username = ? and password = ?";
	         conn = DatabasaUltil.getConnect();
	         statement = conn.prepareStatement(sql);
	         statement.setString(1, username);
	         statement.setString(2, password);
	         result = statement.executeQuery();
	         int count = statement.executeUpdate();
				if (count > 0) {
					statusExecute = true;
				}
				return statusExecute;
	         
	        }
	@Override
	public ArrayList<Student> getAllStudent() {
		return null;
	}

}
