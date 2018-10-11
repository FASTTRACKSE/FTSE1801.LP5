package model;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "students")
@RequestScoped
public class Students {
	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getTotalpages() {
		return totalpages;
	}

	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}

	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getLast() {
		  last = totalrows / limit+(totalrows%limit==0?0:1);
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	private int p =1;
	private int totalpages = 1;
	private int totalrows;
	private int range = 3;
	private int last;
	private int limit = 2;
	private int start = 1;
	private int end = 1;
	private String id;
	private String name;
	private String age;
	private String address;
	private String user;
	private String password;
	@ManagedProperty(value = "#{studentsDAO}")
	private StudentsDAO studentsDAO;

	public StudentsDAO getStudentsDAO() {
		return studentsDAO;
	}

	public void setStudentsDAO(StudentsDAO studentsDAO) {
		this.studentsDAO = studentsDAO;
	}
	
	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public ArrayList<Students> getAll() {
		return studentsDAO.getAllSinhVien();
	}

	public boolean deleteSV(String id) {
		return studentsDAO.deleteSinhVien(id);
	}

	public void resetValue() {
		this.id = "";
		this.name = "";
		this.age = "";
		this.address = "";
	}

	public boolean addSV() {
		Students students = new Students(id, name, age, address);
		return studentsDAO.addNewSinhVien(students);
	}

	public void getAllByIDShow(String id, String name, String age, String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public boolean updateSV() {
		Students students = new Students(id, name, age, address);
		return studentsDAO.updateSinhVien(students);
	}

	public Students getById() {
		return studentsDAO.getSinhVien(id);
	}
	
	public void link(){
		Map<String,String> parameterMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String param = parameterMap.get("p");
		if (param != null) {
		   this.p = Integer.parseInt(param.toString());
		}
		 }
	
	@PostConstruct
	public void init() {
		link();
		paging();
	}

	public ArrayList<Students> getAllSinhVien() {
		ArrayList<Students> list = new ArrayList<>();
		list = studentsDAO.getAll((p - 1) * limit, limit);

		return list;

	}

	public void paging() {
		totalrows = studentsDAO.getAllSinhVien().size();
		totalpages = totalrows / limit+(totalrows%limit==0?0:1);
		if (totalpages < 0)
			totalpages = 1;
		if (totalpages < range) {
			start = 1;
			end = totalpages;
		} else {
			start = p - 1;
			end = p + 1;
			if (start < 1) {
				start = 1;
				end = range;
			} else if (end > totalpages) {
				end = totalpages;
				start = totalpages - 2;
			}
		}
	}
	
	public String login() {
		if(user.equals("Hoi") && password.equals("123")) {
			return "Students";
		}else {
			return "error";
		}
	}
}
