package myJSF;

import java.sql.SQLException;
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

import model.SinhVienDao;

@ManagedBean
@RequestScoped
public class SinhVien {
	@ManagedProperty(value = "#{sinhVienDao}")
	private SinhVienDao sinhvienDao;
	private String id;
	private String ten;
	private String tuoi;
	private String diachi;
	private String lop;
	private String img;
	private int pages = 1;
	private int totalpages = 1;
	private int totalrows;
	private int range = 3;
	private int last;
	private int limit = 3;
	private int starf = 1;
	private int end = 1;
	private Part file;
	private String fileName;
	private long fileSize;

	public SinhVien() {

	}

	public SinhVien(String id, String ten, String tuoi, String diachi, String lop, String img) {
		super();
		this.id = id;
		this.ten = ten;
		this.tuoi = tuoi;
		this.diachi = diachi;
		this.lop = lop;
		this.img = img;
	}

	public SinhVienDao getSinhvienDao() {
		return sinhvienDao;
	}

	public void setSinhvienDao(SinhVienDao sinhvienDao) {
		this.sinhvienDao = sinhvienDao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getTuoi() {
		return tuoi;
	}

	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
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
		last = totalrows / limit + (totalrows % limit == 0 ? 0 : 1);
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

	public int getStarf() {
		return starf;
	}

	public void setStarf(int starf) {
		this.starf = starf;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

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

	public void SV() {

		Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap();
		String param = parameterMap.get("pages");

		if (param != null) {
			this.pages = Integer.parseInt(param.toString());
		}

	}

	@PostConstruct
	public void init() {
		SV();
		paging();
	}

	public ArrayList<SinhVien> getAllSV() {

		return sinhvienDao.getAllSinhVien1((pages - 1) * limit, limit);
	}

	public String getAllSvById() {
		this.id = sinhvienDao.getAllSvById(id).getId();
		this.ten = sinhvienDao.getAllSvById(id).getTen();
		this.tuoi = sinhvienDao.getAllSvById(id).getTuoi();
		this.diachi = sinhvienDao.getAllSvById(id).getDiachi();
		this.lop = sinhvienDao.getAllSvById(id).getLop();

		return "xinchao";
	}

	public void getResetSv() {
		this.ten = "";
		this.tuoi = "";
		this.diachi = "";
		this.lop = "";
		this.img = "";
	}

	public void getUpdateByID(String id, String ten, String tuoi, String diachi, String lop, String img) {
		this.id = id;
		this.ten = ten;
		this.tuoi = tuoi;
		this.diachi = diachi;
		this.lop = lop;
		this.img = img;

	}

	// public boolean addSV() {
	// SinhVien sv = new SinhVien(id, ten, tuoi, diachi, lop, img);
	// return sinhvienDao.addSinhVien(sv);
	// }

	public boolean updateSV() {
		SinhVien sv = new SinhVien(id, ten, tuoi, diachi, lop, img);
		return new SinhVienDao().UpdateSinhVien(sv, id);
	}

	public boolean deleteSV(String id) throws SQLException {
		return new SinhVienDao().DeleteSinhVien(id);
	}

	public String Insert() {
		if (sinhvienDao.addSinhVien(this.ten, this.tuoi, this.diachi, this.lop, this.img)) {
			return "index";
		} else {
			return "view";
		}
	}

	public void upload() {
		try {
			id = ""+(sinhvienDao.getId()+1);
			fileName = file.getSubmittedFileName();
			img = fileName;
			fileSize = file.getSize();
			String dirPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/upload");
			System.out.println(dirPath);
			String foder = dirPath + "/" + id;
			java.io.File dir = new java.io.File(dirPath);
			if (!dir.exists()) {
				dir.mkdirs();
				java.io.File dirImg = new java.io.File(foder);
				if (dirImg.mkdirs()) {
					file.write(dirImg + "/" + fileName);
				}
			} else {
				java.io.File dirImg = new java.io.File(foder);
				if (dirImg.mkdirs()) {
					file.write(dirImg + "/" + fileName);
				}
			}

		} catch (Exception e) {
			Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public void paging() {
		totalrows = sinhvienDao.getAllSinhVien().size();
		totalpages = totalrows / limit + (totalrows % limit == 0 ? 0 : 1);
		if (totalpages < 0) {
			totalpages = 1;
		}
		if (totalpages < range) {
			starf = 1;
			end = totalpages;
		} else {
			starf = pages - range / 2 + 1;
			end = pages + range / 2 + 1;
		}
		if (starf < 1) {
			starf = 1;
			end = range;
		} else if (end > totalpages) {
			end = totalpages;
			starf = totalpages - range + 1;
		}
	}
}
