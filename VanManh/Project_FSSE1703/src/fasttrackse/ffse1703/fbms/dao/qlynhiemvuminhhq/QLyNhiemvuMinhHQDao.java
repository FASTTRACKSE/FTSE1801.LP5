package fasttrackse.ffse1703.fbms.dao.qlynhiemvuminhhq;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.*;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;




 public interface QLyNhiemvuMinhHQDao {
 	public List<CongViecMinhHQ> findAll(String search);

 	public void addNew(CongViecMinhHQ cv);

 	public void update(CongViecMinhHQ cv);

 	public void delete(CongViecMinhHQ cv);

 	public CongViecMinhHQ findByID(int ID);
	
 	public List<CongViecMinhHQ> findAllForPaging(int iDisplayStart, int iDisplayLength, String search);
 	
 	public List<TrangThaiMinhHQ> trangThai();
 	
 	public List<LoaiCongViecMinhHQ> loaiCongViec();
 	
 	public List<DuAnMinhHQ> duAn();
 	
 	public List<HoSoNhanVien> nhanVien();
 	
 	public List<CongViecMinhHQ> searchAll(String search);
	
 }
