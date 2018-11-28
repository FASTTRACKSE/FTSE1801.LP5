package myJSF;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import model.QLSinhVienDAO;

//import model.SinhVienDataModel;

@ManagedBean
@RequestScoped
@SessionScoped
public class SinhVien {
	private String MASV;
	private String NAME;
	private String PASS;
	private int AGE;
	private int p = 1;
	private int totalPage = 1;
	private int totalRows;
	private int range = 3;
	private int last;
	private int limit = 5;
	private int start = 1;
	private int end = 1;
	private Part file;
	private String image;

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	private String fileName;
	private long fileSize;

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

	@ManagedProperty(value = "#{sinhVienDAO}")
	private QLSinhVienDAO sinhVienDAO;

	/* private LazyDataModel<SinhVien> listSinhVien; */

	// public void init() {
	// listSinhVien = new SinhVienDataModel(sinhVienDAO);
	// }
	//
	// public LazyDataModel<SinhVien> getListSinhVien() {
	// return listSinhVien;
	// }

	public int getP() {
		return p;
	}

	public SinhVien() {
	}

	public SinhVien(String mASV, String nAME, String pASS, int aGE, int p, int totalPage, int totalRows, int range,
			int last, int limit, int start, int end, Part file, String image, String fileName, long fileSize,
			QLSinhVienDAO sinhVienDAO) {
		MASV = mASV;
		NAME = nAME;
		PASS = pASS;
		AGE = aGE;
		this.p = p;
		this.totalPage = totalPage;
		this.totalRows = totalRows;
		this.range = range;
		this.last = last;
		this.limit = limit;
		this.start = start;
		this.end = end;
		this.file = file;
		this.image = image;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.sinhVienDAO = sinhVienDAO;
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
		last = totalRows / limit + (totalRows % limit == 0 ? 0 : 1);
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

	// public LazyDataModel<SinhVien> getListSinhVien() {
	// return listSinhVien;
	// }

	// public void setListSinhVien(LazyDataModel<SinhVien> listSinhVien) {
	// this.listSinhVien = listSinhVien;
	// }

	public String getMASV() {
		return MASV;
	}

	public void setMASV(String mASV) {
		MASV = mASV;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getPASS() {
		return PASS;
	}

	public void setPASS(String pASS) {
		PASS = pASS;
	}

	public int getAGE() {
		return AGE;
	}

	public void setAGE(int aGE) {
		AGE = aGE;
	}

	public QLSinhVienDAO getSinhVienDAO() {
		return sinhVienDAO;
	}

	public void setSinhVienDAO(QLSinhVienDAO sinhVienDAO) {
		this.sinhVienDAO = sinhVienDAO;
	}

	public String displayName() {
		this.MASV = sinhVienDAO.displaySV(NAME).getMASV();
		this.NAME = sinhVienDAO.displaySV(NAME).getNAME();
		this.AGE = sinhVienDAO.displaySV(NAME).getAGE();
		return "welcome";
	}

	public ArrayList<SinhVien> getdisplaySV() {
		return sinhVienDAO.displayAllSinhVien();
	}

	public String add() {
		if (upload()) {
			if (sinhVienDAO.addSinhVien(image, MASV, NAME, AGE)) {
				return "index";
			} else {
				return "error";
			}
		} else {
			return "error";
		}
	}

	public boolean update() {
		return sinhVienDAO.updateSinhVienByMaSV(NAME, AGE, MASV);
	}

	public void getallSVByID(String MASV, String NAME, int AGE) {
		this.MASV = MASV;
		this.NAME = NAME;
		this.AGE = AGE;
	}

	public boolean delete(String MASV) {
		this.MASV = MASV;
		return sinhVienDAO.deleteSinhVienByMaSV(MASV);
	}

	public String login() {
		boolean loggedIn = sinhVienDAO.login(NAME, PASS);

		if (loggedIn) {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.setAttribute("username", NAME);
			return "index";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return "login";
		}
	}

	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		return "login";
	}

	@PostConstruct
	public void init() {
		link();
		paging();
	}

	public ArrayList<SinhVien> getAll() {
		ArrayList<SinhVien> list = new ArrayList<>();
		list = sinhVienDAO.displayAllSinhVien((p - 1) * limit, limit);
		return list;
	}

	public void paging() {
		totalRows = sinhVienDAO.displayAllSinhVien().size();
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

	public boolean upload() {
		boolean check = false;
		try {
			// get fullpath of opload folder in web root
			String dirPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/upload/");
			File dir = new File(dirPath);
			System.out.println(dirPath);
			String folder1 = dirPath + "" + MASV;
			if (image.matches("\\w*\\.jpg")) {
				if (!dir.exists()) {
					dir.mkdir();
					File folder = new File(folder1);
					if (folder.mkdirs()) {
						// get name of selected file
						image = file.getSubmittedFileName();
						// get file's size
						fileSize = file.getSize();
						// write file to upload folder
						file.write(folder1 + "/" + image);
						check = true;
					}
				} else {
					File folder = new File(folder1);
					if (folder.mkdirs()) {
						image = file.getSubmittedFileName();
						// get file's size
						fileSize = file.getSize();
						// write file to upload folder
						file.write(folder1 + "/" + image);
						check = true;
					}
				}
			}

		} catch (IOException ex) {
			Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
		}

		return check;
	}
}
