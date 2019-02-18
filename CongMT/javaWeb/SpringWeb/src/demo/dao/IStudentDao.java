package demo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import demo.bean.Student;

public interface IStudentDao {
	
	public ArrayList<Student> getStudent() ;
	public boolean addStudent(Student student) ;
	public boolean editStudent(Student student);	
	public boolean deletelStudent(int id) ;
	public Student getAllByStudent(int id) ;
	public ArrayList<Student> getAllStudent(int pageid, int total);
	 public int getCount(int soDong) ;
	  public boolean isValidUser(String username, String password) throws SQLException;
	ArrayList<Student> getAllStudent();
}
