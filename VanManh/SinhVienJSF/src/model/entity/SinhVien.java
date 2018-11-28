package model.entity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import model.dao.SinhVienDAO;

@ManagedBean
@RequestScoped
public class SinhVien {
	private String name;
	private String age;
	private int maSV;
	@ManagedProperty(value = "#{monHoc}")
	private MonHoc monHoc;
	@ManagedProperty(value="#{sinhVienDAO}")
	private SinhVienDAO sinhVienDAO;
	private int p =1;
	private int totalPage = 1;
	private int totalRows;
	private int range=3;
	private int last;
	private int limit = 2;
	private int start = 1;
	private int end = 1;
	private String img;
	private Part file;
	private long fileSize;

	/**
	 * Creates a new instance of Upload_File
	 */
	
	public Part getFile() {
		return file;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public boolean upload() {
		boolean checkUpload = false;		
		try {
			this.maSV=sinhVienDAO.getMaSV();
			// get fullpath of opload folder in web root
			String dirPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/upload");
			String folder1 = dirPath+"/"+maSV;
			File folder = new File(dirPath);
			img = file.getSubmittedFileName();
			if (img.matches("[A-Za-z0-9]*\\.jpg")) {
				if (!folder.exists()) {
					folder.mkdirs();
					File folderSV= new File(folder1);
					if (folderSV.mkdirs()) {
						// get file's size
						fileSize = file.getSize();
						// write file to upload folder
						file.write(folder1+"/"+img);
						checkUpload=true;
					}
				}else {
					File folderSV= new File(folder1);
					if (folderSV.mkdirs()) {						
						// get file's size
						fileSize = file.getSize();
						// write file to upload folder
						file.write(folder1+"/"+img);
						checkUpload=true;
					}
				}
			}
			
			
		} catch (IOException ex) {
			Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
		}
			return checkUpload;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
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

	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public SinhVienDAO getSinhVienDAO() {
		return sinhVienDAO;
	}

	public void setSinhVienDAO(SinhVienDAO sinhVienDAO) {
		this.sinhVienDAO = sinhVienDAO;
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

	public String addSV() {
		if (upload()) {
			if (sinhVienDAO.addSV(this.name,this.age,this.img)) {
				return "index";
			}else {
				return "Error";
			}
		}else {	  
			return "Error";
		}
	}

	public String addMonHoc() {
		if (sinhVienDAO.addDiem(this.maSV, this.monHoc)) {
			return "index?faces-redirect=true";
		}else {
			return "Error";
		}
	}
	
	public String updateSV() {
		if (sinhVienDAO.upDateSV(maSV, name, age)) {
			return "index";
		}else {
			return "Error";
		}
	}
	
	public String updateDiem() {
		if (sinhVienDAO.upDateDiem(maSV, monHoc)) {
			return "index";
		}else {
			return "Error";
		}
	}
	
	public void getSV(int maSV, String name, String age, MonHoc monHoc) {
		this.maSV=maSV;
		this.name=name;
		this.age=age;
		this.monHoc = monHoc;
	}
	
	public String deleteSV(int maSV) {
		if (sinhVienDAO.kiemTraDelete(maSV)) {
			if (sinhVienDAO.deleteDiem(maSV)&&sinhVienDAO.deleteSV(maSV)) {
				return "index";
			}else {
				return "Error";
			}
		}else {
			if (sinhVienDAO.deleteSV(maSV)) {
				return "index";
			}else {
				return "Error";
			}
		}
		
	}
	
	@PostConstruct
	public void init() {
		link();
		paging();
	}

	public ArrayList<SinhVien> getAll() {
		ArrayList<SinhVien> list = new ArrayList<>();
		list = sinhVienDAO.getSinhVienRecord((p-1)*limit, limit);
		return list;
	}

	public void paging() {
		totalRows = sinhVienDAO.showAllSinhVien().size();
		totalPage = totalRows / limit + (totalRows%limit==0?0:1);
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
			this.p=Integer.parseInt(param.toString());
		}
	}
}

