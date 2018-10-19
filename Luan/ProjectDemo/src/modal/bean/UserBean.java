package modal.bean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import modal.dao.UserDao;

@ManagedBean
@RequestScoped
public class UserBean {
	private String id;
	private String name;
	private String pass;
	private String age;
	private String add;
	private String search;
	@ManagedProperty(value = "#{userDao}")
	private UserDao userDao;

	private int p = 1;
	private int totalPage = 1;
	private int totalRows;
	private int range = 3;
	private int last;
	private int limit = 1;
	private int start = 1;
	private int end = 1;

	private Part uploadFile;
	private String image;
	private long fileSize;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public Part getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(Part uploadFile) {
		this.uploadFile = uploadFile;
	}

	public void uploadFile() {
		try {
			String dirPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/upload");
			File file = new File(dirPath);
			String folder = dirPath + "/" + id;

			if (!file.exists()) {
				file.mkdirs();
				File file1 = new File(folder);
				if (file1.mkdirs()) {
					image = uploadFile.getSubmittedFileName();
					fileSize = uploadFile.getSize();
					uploadFile.write(folder + "/" + image);
				}
			} else {
				File file1 = new File(folder);
				if (file1.mkdirs()) {
					image = uploadFile.getSubmittedFileName();
					fileSize = uploadFile.getSize();
					uploadFile.write(folder + "/" + image);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getLast() {
		last = totalPage;
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

	public ArrayList<UserBean> getShowAll() {
		return userDao.showAllUser();
	}

	public String addUser() {
		if (userDao.addUser(id, image, name, pass, age, add)) {
			return "index";
		}else {
			return "addUser";
		}
		

	}

	public boolean updateUser() {
		return userDao.updateUser(id, name, pass, age, add);
	}

	public void giveUser(String id, String name, String pass, String age, String add) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.age = age;
		this.add = add;
	}

	public boolean delUser(String id) {
		return userDao.delUser(id);
	}

	public ArrayList<UserBean> getSearchUser() {
		return userDao.searchUser(search);
	}

	@PostConstruct
	public void init() {
		link();
		paging();
	}

	public ArrayList<UserBean> getAll() {
		ArrayList<UserBean> list = new ArrayList<>();
		list = userDao.showAllUserInPage((p - 1) * limit, limit);
		return list;
	}

	public void paging() {
		totalRows = userDao.showAllUser().size();

		totalPage = totalRows / limit + (totalRows % limit == 0 ? 0 : 1);
		if (totalPage < 0) {
			totalPage = 1;
		}
		if (totalPage < range) {
			start = 1;
			end = totalPage;
		} else {
			start = p - 1;
			end = p + 1;
		}
		if (start < 1) {
			start = 1;
			end = range;
		} else if (end > totalPage) {
			end = totalPage;
			start = totalPage - 2;
		}
	}

	public void link() {
		Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap();
		String param = parameterMap.get("p");

		if (param != null) {
			this.p = Integer.parseInt(param.toString());
		}
	}
	
	public String checkLogin() {
		
		if (userDao.getUser(name, pass)) {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("name", name);;
			return "index";
		}else {
			return "login";
		}
	}
	
	public String loguot() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		return "login";
	}
}
