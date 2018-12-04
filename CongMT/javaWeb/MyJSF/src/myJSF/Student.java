package myJSF;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import org.primefaces.model.LazyDataModel;

import model.dao.StudentDao;

@RequestScoped
@ManagedBean
public class Student {
	private String id;
	private String img;
	private String name;
	private String old;
	private String adress;
	private String numberPhone;
	private Part file;
    private String fileName;
    private long fileSize;
//	private LazyDataModel<Student> listStudent;
	
	@ManagedProperty(value="#{st}")
	private StudentDao studentDao;	
//	@PostConstruct
//	public void init() {
//		listStudent = new StudentDataModel(studentDao);
//	}
	public Student() {
		super();
	}
	

	public Student(String id, String name, String old, String adress, String numberPhone, String img) {
		super();
		this.id = id;
		this.name = name;
		this.old = old;
		this.adress = adress;
		this.numberPhone = numberPhone;
		this.img = img;
	}


	public Student(String id, String name, String old, String adress, String numberPhone,String img, StudentDao studentDao) {
		super();
		this.id = id;
		this.name = name;
		this.old = old;
		this.adress = adress;
		this.numberPhone = numberPhone;
		this.img = img;
		this.studentDao = studentDao;
	}

	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	/**
     * Creates a new instance of Upload_File
     */
  
 
    public Part getFile() {
        return file;
    }
 
    public void setFile(Part file) {
        this.file = file;
    }
 
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public long getFileSize() {
        return fileSize;
    }
 
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
     
    public String upload() {
		try {
			String dirPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/upload");
			File dir = new File(dirPath);

			String folder1 = dirPath + "/" + id;
			if (dir.exists()) {
				dir.mkdirs();
				File folder = new File(folder1);
				if (folder.mkdirs()) {
					// get name of selected file
					img = file.getSubmittedFileName();
					System.out.println(img);
					// get file's size
					fileSize = file.getSize();
					// get fullpath of opload folder in web root
					// write file to upload folder
					file.write(folder1 + "/" + img);
				}
			} else {
				File folder = new File(folder1);
				if (folder.mkdirs()) {
					// get name of selected file
					img = file.getSubmittedFileName();
					System.out.println(img);
					// get file's size
					fileSize = file.getSize();
					// get fullpath of opload folder in web root
					// write file to upload folder
					file.write(folder1 + "/" + img);
				}
			}

		} catch (IOException ex) {
			Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
		}

		return "index";
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
	public void getSvById(String id, String name, String old, String adress, String numberPhone,String img) {
		this.id= id;
		this.name=name;
		this.old= old;
		this.adress= adress;
		this.numberPhone=numberPhone;
		this.img=img;
		
	}
	public ArrayList<Student> getAllStudent(){
		return studentDao.getStudent();
	}
	 //Insert database
    public String addStudent(){
    	
    	if(studentDao.addStudent(id, name, old, adress, numberPhone, img)){
    		
    		return "index";
    	}else {
    		return "view";
    	}
        
        
    }
    //Update database by id
    public String updateStudent() {
    	if(studentDao.editStudent(name, old, adress, numberPhone, img, id)) {
    		return "index";
    	}else {
    		return "view";
    	}
	
    }
    //Delet database by id
    public boolean deleteStudent(String id) throws SQLException {
        return new StudentDao().deletelStudent(id);
    }
	
	
	
}
