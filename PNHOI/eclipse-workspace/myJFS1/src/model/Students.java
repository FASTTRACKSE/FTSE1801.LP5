package model;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
@ManagedBean(name="students")
@RequestScoped
public class Students {
	private String id;
	private String name;
	private String age;
	private String address;
	@ManagedProperty(value="#{studentsDAO}")
	private StudentsDAO studentsDAO;
	
	public StudentsDAO getStudentsDAO() {
		return studentsDAO;
	}
	public void setStudentsDAO(StudentsDAO studentsDAO) {
		this.studentsDAO = studentsDAO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Students() {
		
	}
	
	public Students(String id, String name, String age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public ArrayList<Students> getAll(){
		return studentsDAO.getAllSinhVien();
	}
	
	public boolean deleteSV(String id){
		return studentsDAO.deleteSinhVien(id);
	}
	
	 public void resetValue(){
	        this.id = "";
	        this.name = "";
	        this.age = "";
	        this.address = "";
	    }
	
	public boolean addSV(){
		Students students = new Students(id, name, age, address);
		return studentsDAO.addNewSinhVien(students);
	}
	
	public void getAllByIDShow(String id, String name, String age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
	
	public boolean updateSV(){
		Students students = new Students(id, name, age, address);
		return studentsDAO.updateSinhVien(students);
	}
	
	public Students getById() {
        return studentsDAO.getSinhVien(id);
    }
}
