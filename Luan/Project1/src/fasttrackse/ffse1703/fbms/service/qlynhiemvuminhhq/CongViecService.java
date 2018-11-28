package fasttrackse.ffse1703.fbms.service.qlynhiemvuminhhq;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.DuAnMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.LoaiCongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.TrangThaiMinhHQ;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;




 public interface CongViecService {
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
 	
 	public String toJson(List<CongViecMinhHQ> list);
 	
 }
