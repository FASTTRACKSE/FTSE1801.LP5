package fasttrackse.ffse1703.fbms.service.qlvn2;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlvn2.DonXinPhepEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.LyDoEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.SoNgayNghiEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.TrangThaiEntity;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

public interface DonXinPhepService {
	public List<DonXinPhepEntity> danhsachnhap003();

	public List<DonXinPhepEntity> danhsachchoduyet003();

	public List<DonXinPhepEntity> danhsachdaduyet003();

	public List<DonXinPhepEntity> danhsachbituchoi003();

	public List<SoNgayNghiEntity> ngaynghiphep();
	
	
	public List<TrangThaiEntity> thongketrangthai();
	
	public void create(DonXinPhepEntity DonXinPhepEntity);

	public void createcho(DonXinPhepEntity DonXinPhepEntity);

	public void createduyet(DonXinPhepEntity DonXinPhepEntity);

	public void createtuchoi(DonXinPhepEntity DonXinPhepEntity);

	public List<LyDoEntity> danhSachLyDo();

	public List<TrangThaiEntity> danhSachTrangThai();

	public List<HoSoNhanVien> danhSachHoSo();
	  
	
	public  List<PhongBan> danhSachPhong();
	
	public List<DonXinPhepEntity> listbyPhongBan(String maPB);
	public List<DonXinPhepEntity> listbyPhongBan1(String maPB);



	public DonXinPhepEntity findById(int id);

	public void delete(int id);

	public void update(DonXinPhepEntity DonXinPhepEntity);
	
	public List<DonXinPhepEntity>  findAllForPaging1(int startPosition,int maxResult);
	public List<DonXinPhepEntity>  findAllForPaging2(int startPosition,int maxResult);
	public List<DonXinPhepEntity>  findAllForPaging3(int startPosition,int maxResult);
	public List<DonXinPhepEntity>  findAllForPaging4(int startPosition,int maxResult);
	public List<SoNgayNghiEntity>  findAllForPagingngaynghi(int startPosition,int maxResult);
	public List<TrangThaiEntity>  findAllForPagingTT(int startPosition,int maxResult);

}