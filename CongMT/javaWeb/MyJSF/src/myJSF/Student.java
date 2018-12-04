package myJSF;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.LazyDataModel;

import model.dao.StudentDao;

@RequestScoped
@ManagedBean
public class Student {
	private String id;
	private String name;
	private String old;
	private String adress;
	private String numberPhone;
	private LazyDataModel<Student> listStudent;
	
	@ManagedProperty(value="#{studentDao}")
	private StudentDao studentDao;	
	@PostConstruct
	public void init() {
		listStudent = new StudentDataModel(studentDao);
	}
	public Student() {
		super();
	}
	

	public Student(String id, String name, String old, String adress, String numberPhone) {
		super();
		this.id = id;
		this.name = name;
		this.old = old;
		this.adress = adress;
		this.numberPhone = numberPhone;
	}


	public Student(String id, String name, String old, String adress, String numberPhone, StudentDao studentDao) {
		super();
		this.id = id;
		this.name = name;
		this.old = old;
		this.adress = adress;
		this.numberPhone = numberPhone;
		this.studentDao = studentDao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public String getAllByStudent() {
		this.id= studentDao.getAllByStudent(id).getId();
		this.name=studentDao.getAllByStudent(id).getName();
		this.old= studentDao.getAllByStudent(id).getOld();
		this.adress= studentDao.getAllByStudent(id).getAdress();
		this.numberPhone=studentDao.getAllByStudent(id).getNumberPhone();
		return "Search";
		
	}
	//Search database by name
    public ArrayList<Student> getAllByNameStudent() {
		return new StudentDao().SearchStudent(name);
    }
	public void getSvById(String id, String name, String old, String adress, String numberPhone) {
		this.id= id;
		this.name=name;
		this.old= old;
		this.adress= adress;
		this.numberPhone=numberPhone;
	
		
	}
	public ArrayList<Student> getAllStudent(){
		return studentDao.getStudent();
	}
	 //Insert database
    public boolean addStudent() throws SQLException {
        Student b = new Student( id, name, old, adress,numberPhone);
        return new StudentDao().addStudent(b);
    }
    //Update database by id
    public boolean updateStudent() throws SQLException {
    	Student student = new Student(id,name, old, adress,numberPhone);
        return new StudentDao().editStudent(student, id);
    }
    //Delet database by id
    public boolean deleteStudent(String id) throws SQLException {
        return new StudentDao().deletelStudent(id);
    }
	
	
	
}
