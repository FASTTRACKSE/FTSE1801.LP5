package myJSF;

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
	@ManagedProperty(value = "#{sinhVienDAO}")
	private SinhVienDAO sinhVienDao;
	private String maSv;
	private String name;
	private int age;
	private int p = 1;
	private int totalPage = 1;
	private int totalRows;
	private int range = 3;
	private int last;
	private int limit = 5;
	private int start = 1;
	private int end = 1;
	private int next;
	private int prev;

	private String img;
	private Part file;
	private String fileName;
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

			String folder1 = dirPath + "/" + maSv;
			if (!dir.exists()) {
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
			Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
		}

		return "index";
	}
	// private LazyDataModel<SinhVien> listSinhVien;

	// public void init() {
	// listSinhVien = new SinhVienDataModel(sinhVienDao);
	// }

	// public LazyDataModel<SinhVien> getListSinhVien() {
	// return listSinhVien;
	// }

	public SinhVien() {
	}

	public SinhVien(SinhVienDAO sinhVienDao, String maSv, String name, int age, int p, int totalPage, int totalRows,
			int range, int last, int limit, int start, int end, int next, int prev, String img, Part file,
			String fileName, long fileSize) {
		super();
		this.sinhVienDao = sinhVienDao;
		this.maSv = maSv;
		this.name = name;
		this.age = age;
		this.p = p;
		this.totalPage = totalPage;
		this.totalRows = totalRows;
		this.range = range;
		this.last = last;
		this.limit = limit;
		this.start = start;
		this.end = end;
		this.next = next;
		this.prev = prev;
		this.img = img;
		this.file = file;
		this.fileName = fileName;
		this.fileSize = fileSize;
	}

	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public SinhVienDAO getSinhVienDao() {
		return sinhVienDao;
	}

	public void setSinhVienDao(SinhVienDAO sinhVienDao) {
		this.sinhVienDao = sinhVienDao;
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

	public int getNext() {
		p = p + 1;
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getPrev() {
		p = p - 1;
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	// public LazyDataModel<SinhVien> getListSinhVien() {
	// return listSinhVien;
	// }
	//
	// public void setListSinhVien(LazyDataModel<SinhVien> listSinhVien) {
	// this.listSinhVien = listSinhVien;
	// }

	public void getAll(String maSv, String name, int age) {
		this.maSv = maSv;
		this.name = name;
		this.age = age;
	}

	public ArrayList<SinhVien> getAllSinhVien() {
		return sinhVienDao.getAllSinhVien();
	}

	public String getSinhVienByMaSv() {
		this.maSv = sinhVienDao.getSinhVienByMaSv(maSv).getMaSv();
		this.name = sinhVienDao.getSinhVienByMaSv(maSv).getName();
		this.age = sinhVienDao.getSinhVienByMaSv(maSv).getAge();

		return "xinchao";
	}

	public void resetValue() {
		this.maSv = "";
		this.name = "";
		this.age = 0;
	}

	public String addSinhVien() {
		if (sinhVienDao.addSinhVien(maSv, name, age, img)) {
			return "index";
		} else {
			return "view";
		}

	}

	public boolean updateSinhVien() {
		return sinhVienDao.updateSinhVienByMaSV(name, age, maSv);
	}

	public boolean deleteSinhVien(String maSv) {
		this.maSv = maSv;
		return sinhVienDao.deleteSinhVienByMaSV(maSv);
	}

	@PostConstruct
	public void init() {
		link();
		paging();
	}

	public ArrayList<SinhVien> getAll() {
		ArrayList<SinhVien> list = new ArrayList<>();
		list = sinhVienDao.getAllSinhVien1((p - 1) * limit, limit);
		return list;
	}

	public void paging() {
		totalRows = sinhVienDao.getAllSinhVien().size();
		totalPage = totalRows / limit + (totalRows % limit == 0 ? 0 : 1);
		// if (totalPage < 0) {
		// totalPage = 1;
		// }
		if (totalPage < range) {
			start = 1;
			end = totalPage;
			next = p + 1;
		} else {
			start = p - range / 2 + 1;
			end = p + range / 2 + 1;
			next = p + 1;
			prev = p - 1;
		}
		if (start < 1) {
			start = 1;
			end = range;
		} else if (end > totalPage) {
			end = totalPage;
			start = totalPage - range + 1;
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
}
