package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import myJSF.Student;

@ManagedBean(name="st")
public class StudentDao {
	
	private static final int RECORD_IN_PAGE = 0;
	private Connection conn;
	private PreparedStatement statement =null;
	private ResultSet result;
	
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
				student.setImg(result.getString("img"));
				listSv.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
	
		return listSv;
		}
	
	public boolean addStudent(String id, String name, String old, String adress, String numberPhone,String img) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "INSERT INTO `sinhvien` VALUES (?,?,?,?,?,?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, name);
			statement.setString(3, old);
			statement.setString(4, adress);
			statement.setString(5, numberPhone);
			statement.setString(6, img);
			if (statement.executeUpdate() > 0) {
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabasaUltil.closeConnection(conn);
		return statusExecute;

	}
	public boolean editStudent(String name, String old, String adress, String numberPhone,String img, String id) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		String sql = "UPDATE sinhvien SET name=?, old=?, adress=?, numberPhone=?, img=?  WHERE id=?";
		try {
			statement = conn.prepareStatement(sql);

			statement.setString(1, name);
			statement.setString(2, old);
			statement.setString(3, adress);
			statement.setString(4, numberPhone);
			statement.setString(5, img);
			statement.setString(6, id);
			
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
	
	public boolean deletelStudent(String id) {
		boolean statusExecute = false;
		conn = DatabasaUltil.getConnect();
		
		String sql = "DELETE FROM sinhvien WHERE id=?";

		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, id);

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
	
	public Student getAllByStudent(String id) {
		
		String sql = "SELECT  * FROM sinhvien WHERE id=?";
		conn = DatabasaUltil.getConnect();
		 Student student = null;
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
				student.setImg(result.getString("img"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabasaUltil.closeConnection(conn);
		}
		return student;
	}

	
	public ArrayList<Student> getAllStudent(int page, int soDong){
		 String sql = "SELECT * FROM sinhvien LIMIT ?,?";
		 conn = DatabasaUltil.getConnect();
		 ArrayList<Student> listSv= new  ArrayList<Student>();
		 try {
			 statement = conn.prepareStatement(sql);
			 statement.setInt(1, page);
			 statement.setInt(2, soDong);
			 result = statement.executeQuery();
			Student student;
			while (result.next()) {
				student = new Student();
				student.setId(result.getString("id"));
				student.setName(result.getString("name"));
				student.setOld(result.getString("old"));
				student.setAdress(result.getString("adress"));
				student.setNumberPhone(result.getString("numberPhone"));
				student.setImg(result.getString("img"));
				listSv.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabasaUltil.closeConnection(conn);
		}
		return listSv;
		 
	 }
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
	 public ArrayList<Student> SearchStudent(String key) {
		 conn = DatabasaUltil.getConnect();
	        ArrayList<Student> listSv = new ArrayList();
	        String sql = "SELECT * FROM sinhvien WHERE name LIKE ?";
	        try {
	        	 statement = conn.prepareStatement(sql);
	        	 statement.setString(1, "%"+key+"%");
				 result = statement.executeQuery();
				 Student student;
	            while (result.next()) {
	            	student = new Student();
					student.setId(result.getString("id"));
					student.setName(result.getString("name"));
					student.setOld(result.getString("old"));
					student.setAdress(result.getString("adress"));
					student.setNumberPhone(result.getString("numberPhone"));
					student.setImg(result.getString("img"));
					listSv.add(student);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return listSv;
	    }
	 
	 public List<Student> getStudentInPage(int curentPage){
		 int startRecord=(++curentPage - 1)* RECORD_IN_PAGE;
		 String sql = "SELECT * FROM sinhvien LIMIT ?,?";
		return null;
		 
	 }

}
