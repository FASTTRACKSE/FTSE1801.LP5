package fasttrackse.ftse1801.fbms.service.quantridanhgia;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ftse1801.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ftse1801.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ftse1801.fbms.entity.quantridanhgia.TruongPhongDanhGia;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;

public interface QuanTriDanhGiaService {
	public List<HoSoNhanSu> getListNhanVienPhongBan(PhongBan phongBan);
	public List<HoSoNhanSu> getNhanVienLimit(int nhanVien, PhongBan phongBan);
	public KyDanhGia getKyDanhGiaActive();
	
	//=====Role NhanVien standard START=====
	public DanhGiaBanThan getDanhGiaBanThan(KyDanhGia kyDanhGia, HoSoNhanSu nhanVien);
	public void addDanhGiaBanthan(DanhGiaBanThan danhGiaBanThan);
	public void updateDanhGiaBanThan(DanhGiaBanThan danhGiaBanThan);
	public void addDanhGianNhanVien(DanhGiaNhanVien danhGiaNhanVien);
	
	public List<DanhGiaNhanVien> getDanhGiaNhanVien(KyDanhGia kyDanhGia, HoSoNhanSu nhanVien);
	public DanhGiaNhanVien getDanhGiaNhanVien(int id);
	public void updateDanhGiaNhanVien(DanhGiaNhanVien danhGiaNhanVien);
	public void deleteDanhGiaNhanVien(DanhGiaNhanVien danhGiaNhanVien);
	
	public List<DanhGiaNhanVien> getNhanVienDanhGia(KyDanhGia kyDanhGia, HoSoNhanSu nhanVien);
	
	public TruongPhongDanhGia getTruongPhongDanhGia(KyDanhGia kyDanhGia, HoSoNhanSu nhanVien);
	//=====Role NhanVien standard END=====
	
	//=====Role PhongNhanSu START=====
	public int getListKyDanhGia();
	public List<KyDanhGia> getListKyDanhGia(int start, int maxItems);
	public List<PhongBan> getListPhongBan();
	public int checkKyDanhGia(KyDanhGia kyDanhGia);
	public int checkActiveKyDanhGia();
	public KyDanhGia getKyDanhGia(String id);
	public void addKyDanhGia(KyDanhGia kyDanhGia);
	public void updateKyDanhGia(KyDanhGia kyDanhGia);
	public void deleteKyDanhGia(KyDanhGia kyDanhGia);
	
	public void createPhanCongDanhGia(List<DanhGiaNhanVien> danhGiaNhanVien);
	public int checkPhanCongDanhGiaExist(KyDanhGia kyDanhGia,PhongBan phongBan);
	public PhongBan getPhongBanBy(String phongban);
	
	public int getListDanhGiaBanThanToanCongTy(KyDanhGia kyDanhGia);
	public List<DanhGiaBanThan> getListDanhGiaBanThanToanCongTy(int start, int maxItems, KyDanhGia kyDanhGia);
	//=====Role PhongNhanSu END=====
	
	//=====Role TruongPhong START=====
	public int getListTruongPhongDanhGia(KyDanhGia kyDanhGia, PhongBan phongBan);
	public List<TruongPhongDanhGia> getListTruongPhongDanhGia(int start, int maxItems, KyDanhGia kyDanhGia, PhongBan phongBan);
	public void createTruongPhongDanhGia(List<TruongPhongDanhGia> truongPhongDanhGia);
	
	public TruongPhongDanhGia getTruongPhongDanhGia(int id);
	public void addDanhGiaNhanVien(TruongPhongDanhGia truongPhongDanhGia);
	public void updateDanhGiaNhanVien(TruongPhongDanhGia truongPhongDanhGia);
	public void deleteDanhGiaNhanVien(TruongPhongDanhGia truongPhongDanhGia);
	
	public int getListDanhGiaBanThanPhongBan(KyDanhGia kyDanhGia, PhongBan phongBan);
	public List<DanhGiaBanThan> getListDanhGiaBanThanPhongBan(int start, int maxItems, KyDanhGia kyDanhGia, PhongBan phongBan);
	public DanhGiaBanThan getDanhGiaBanThan(int id);
	//=====Role TruongPhong END=====
}
