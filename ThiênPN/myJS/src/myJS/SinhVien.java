package myJS;

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

import userDao.SinhVienDAO;

/**
 * ngọc thiên 1801014
 * 
 * @author TGDD
 *
 */
@ManagedBean
@RequestScoped

public class SinhVien {
	private String maSinhVien;
	private String tensinhVien;
	private String password;
	private String tuoi;
	private String img;
	@ManagedProperty(value = "#{diem}")
	private Diem diem;
	private int pages = 1;
	private int totalpages = 1;
	private int totalrows;
	private int range = 3;
	private int last;
	private int limit = 3;
	private int starf = 1;
	private int end = 1;
	private Part File;
    private String FileName;
    private long FileSize;
	
	public SinhVien(String maSinhVien, String tensinhVien, String password, String tuoi, String img, Diem diem,
			int pages, int totalpages, int totalrows, int range, int last, int limit, int starf, int end, Part file,
			String fileName, long fileSize, SinhVienDAO sinhvienDao) {
		super();
		this.maSinhVien = maSinhVien;
		this.tensinhVien = tensinhVien;
		this.password = password;
		this.tuoi = tuoi;
		this.img = img;
		this.diem = diem;
		this.pages = pages;
		this.totalpages = totalpages;
		this.totalrows = totalrows;
		this.range = range;
		this.last = last;
		this.limit = limit;
		this.starf = starf;
		this.end = end;
		File = file;
		FileName = fileName;
		FileSize = fileSize;
		this.sinhvienDao = sinhvienDao;
	}

	public SinhVien() {
	}

	@ManagedProperty(value = "#{sinhvienDao}")
	private SinhVienDAO sinhvienDao;

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTensinhVien() {
		return tensinhVien;
	}

	public void setTensinhVien(String tensinhVien) {
		this.tensinhVien = tensinhVien;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTuoi() {
		return tuoi;
	}

	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}
	

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Diem getDiem() {
		return diem;
	}

	public void setDiem(Diem diem) {
		this.diem = diem;
	}

	public SinhVienDAO getSinhvienDao() {
		return sinhvienDao;
	}

	public void setSinhvienDao(SinhVienDAO sinhvienDao) {
		this.sinhvienDao = sinhvienDao;
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
		last =totalrows / limit + (totalrows%limit==0?0:1);
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
		return File;
	}
	public void setFile(Part file) {
		File = file;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public long getFileSize() {
		return FileSize;
	}
	public void setFileSize(long fileSize) {
		FileSize = fileSize;
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
		// ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		// list = sinhvienDao.getAllSinhVien(totalpages, limit);

		return sinhvienDao.getAllSinhVien((pages - 1) * limit, limit);
	}

	public boolean deleteSv(String maSinhVien) {
		return sinhvienDao.deleteSV(maSinhVien);
	}

	public void getSinhVienById(String maSinhVien, String tenSinhVien, String password, String tuoi,String img, Diem diem) {
		this.maSinhVien = maSinhVien;
		this.tensinhVien = tenSinhVien;
		this.password = password;
		this.tuoi = tuoi;
		this.img = img;
		this.diem = diem;
	}

	public boolean upDate() {
		return sinhvienDao.updateSV(this.maSinhVien, this.tensinhVien, this.password)
				&& sinhvienDao.UpdateDiemSV(this.maSinhVien, this.diem);
	}

	public String Insert() {
		if (sinhvienDao.addSinhVien(this.maSinhVien, this.tensinhVien, this.password, this.tuoi,this.img)
				&& sinhvienDao.addDiemSV(this.maSinhVien, this.diem)) {
			return "index";
		}else {
			return "view";
		}
	}
    
	
	public void resetValue() {
		this.maSinhVien = "";
		this.tensinhVien = "";
		this.password = "";
		this.tuoi = "";

	}

	public void paging() {
		totalrows = sinhvienDao.AllSinhVien().size();
		totalpages = totalrows / limit + (totalrows%limit==0?0:1);
		if (totalpages < 0) {
			totalpages = 1;
		}
		if (totalpages < range) {
			starf = 1;
			end = totalpages;
		} else {
			starf = pages - 1;
			end = pages + 1;
		}
		if (starf < 1) {
			starf = 1;
			end = range;
		} else if (end > totalpages) {
			end = totalpages;
			starf = totalpages - 2;
		}
	}
	 public void uploadFile() {
	    	try {
	    		FileName = File.getSubmittedFileName();
	    		img = FileName;
	    		FileSize = File.getSize();
	    		 String dirPath= FacesContext.getCurrentInstance().getExternalContext().getRealPath("/upload");
	    		 System.out.println(dirPath);
	    		 String foder = dirPath+"/"+maSinhVien;
	    		java.io.File dir = new java.io.File(dirPath);
	    		if(!dir.exists()) {
	    			dir.mkdirs();
	    			java.io.File dirImg = new java.io.File(foder);
	    			if (dirImg.mkdirs()) {
	    				 File.write(dirImg + "/"+ FileName);
					}
	    		}else {
	    			java.io.File dirImg = new java.io.File(foder);
	    			if (dirImg.mkdirs()) {
	    				 File.write(dirImg + "/"+ FileName);
					}
	    		}
	    		 
	    	}catch (Exception e) {
	    		Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, e);
			}
	    }
	
}
