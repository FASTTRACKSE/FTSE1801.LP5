package fasttrackse.ffse1703.fbms.service.quantridanhgia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.quantridanhgia.QuanTriDanhGiaDAO;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

@Service
public class QuanTriDanhGiaServiceImpl implements QuanTriDanhGiaService {

	@Autowired
	private QuanTriDanhGiaDAO dao;

	public void setDao(QuanTriDanhGiaDAO dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public List<HoSoNhanVien> getListNhanVienPhongBan(PhongBan phongBan) {
		// TODO Auto-generated method stub
		return dao.getListNhanVienPhongBan(phongBan);
	}

	@Transactional
	@Override
	public DanhGiaBanThan getDanhGiaBanThan(KyDanhGia kyDanhGia, HoSoNhanVien nhanVien) {
		// TODO Auto-generated method stub
		return dao.getDanhGiaBanThan(kyDanhGia, nhanVien);
	}

	@Transactional
	@Override
	public void addDanhGiaBanthan(DanhGiaBanThan danhGiaBanThan) {
		// TODO Auto-generated method stub
		dao.addDanhGiaBanthan(danhGiaBanThan);
	}

	@Transactional
	@Override
	public void updateDanhGiaBanThan(DanhGiaBanThan danhGiaBanThan) {
		// TODO Auto-generated method stub
		dao.updateDanhGiaBanThan(danhGiaBanThan);
	}

	@Transactional
	@Override
	public void addDanhGianNhanVien(DanhGiaNhanVien danhGiaNhanVien) {
		// TODO Auto-generated method stub
		dao.addDanhGianNhanVien(danhGiaNhanVien);
	}

	@Transactional
	@Override
	public List<DanhGiaNhanVien> getDanhGiaNhanVien(KyDanhGia kyDanhGia, HoSoNhanVien nhanVien) {
		// TODO Auto-generated method stub
		return dao.getDanhGiaNhanVien(kyDanhGia, nhanVien);
	}

	@Transactional
	@Override
	public void updateDanhGiaNhanVien(DanhGiaNhanVien danhGiaNhanVien) {
		// TODO Auto-generated method stub
		dao.updateDanhGiaNhanVien(danhGiaNhanVien);
	}

	@Transactional
	@Override
	public void deleteDanhGiaNhanVien(DanhGiaNhanVien danhGiaNhanVien) {
		// TODO Auto-generated method stub
		dao.deleteDanhGiaNhanVien(danhGiaNhanVien);
	}

	@Transactional
	@Override
	public TruongPhongDanhGia getTruongPhongDanhGia(KyDanhGia kyDanhGia, HoSoNhanVien nhanVien) {
		// TODO Auto-generated method stub
		return dao.getTruongPhongDanhGia(kyDanhGia, nhanVien);
	}

	@Transactional
	@Override
	public int getListKyDanhGia() {
		// TODO Auto-generated method stub
		return dao.getListKyDanhGia();
	}

	@Transactional
	@Override
	public List<KyDanhGia> getListKyDanhGia(int start, int maxItems) {
		// TODO Auto-generated method stub
		return dao.getListKyDanhGia(start, maxItems);
	}

	@Transactional
	@Override
	public KyDanhGia getKyDanhGia(String id) {
		// TODO Auto-generated method stub
		return dao.getKyDanhGia(id);
	}

	@Transactional
	@Override
	public void addKyDanhGia(KyDanhGia kyDanhGia) {
		// TODO Auto-generated method stub
		dao.addKyDanhGia(kyDanhGia);
	}

	@Transactional
	@Override
	public void updateKyDanhGia(KyDanhGia kyDanhGia) {
		// TODO Auto-generated method stub
		dao.updateKyDanhGia(kyDanhGia);
	}

	@Transactional
	@Override
	public void deleteKyDanhGia(KyDanhGia kyDanhGia) {
		// TODO Auto-generated method stub
		dao.deleteKyDanhGia(kyDanhGia);
	}

	@Transactional
	@Override
	public List<DanhGiaBanThan> getListDanhGiaBanThanToanCongTy(int start, int maxItems, KyDanhGia kyDanhGia) {
		// TODO Auto-generated method stub
		return dao.getListDanhGiaBanThanToanCongTy(start, maxItems, kyDanhGia);
	}

	@Transactional
	@Override
	public int getListTruongPhongDanhGia(KyDanhGia kyDanhGia, PhongBan phongBan) {
		// TODO Auto-generated method stub
		return dao.getListTruongPhongDanhGia(kyDanhGia, phongBan);
	}

	@Transactional
	@Override
	public TruongPhongDanhGia getTruongPhongDanhGia(int id) {
		// TODO Auto-generated method stub
		return dao.getTruongPhongDanhGia(id);
	}

	@Transactional
	@Override
	public void addDanhGiaNhanVien(TruongPhongDanhGia truongPhongDanhGia) {
		// TODO Auto-generated method stub
		dao.addDanhGiaNhanVien(truongPhongDanhGia);
	}

	@Transactional
	@Override
	public void updateDanhGiaNhanVien(TruongPhongDanhGia truongPhongDanhGia) {
		// TODO Auto-generated method stub
		dao.updateDanhGiaNhanVien(truongPhongDanhGia);
	}

	@Transactional
	@Override
	public void deleteDanhGiaNhanVien(TruongPhongDanhGia truongPhongDanhGia) {
		// TODO Auto-generated method stub
		dao.deleteDanhGiaNhanVien(truongPhongDanhGia);
	}

	@Transactional
	@Override
	public int getListDanhGiaBanThanPhongBan(KyDanhGia kyDanhGia, PhongBan phongBan) {
		// TODO Auto-generated method stub
		return dao.getListDanhGiaBanThanPhongBan(kyDanhGia, phongBan);
	}

	@Transactional
	@Override
	public List<HoSoNhanVien> getNhanVienLimit(int nhanVien, PhongBan phongBan) {
		// TODO Auto-generated method stub
		return dao.getNhanVienLimit(nhanVien, phongBan);
	}

	@Transactional
	@Override
	public DanhGiaNhanVien getDanhGiaNhanVien(int id) {
		// TODO Auto-generated method stub
		return dao.getDanhGiaNhanVien(id);
	}

	@Transactional
	@Override
	public List<DanhGiaNhanVien> getNhanVienDanhGia(KyDanhGia kyDanhGia, HoSoNhanVien nhanVien) {
		// TODO Auto-generated method stub
		return dao.getNhanVienDanhGia(kyDanhGia, nhanVien);
	}

	@Transactional
	@Override
	public List<PhongBan> getListPhongBan() {
		// TODO Auto-generated method stub
		return dao.getListPhongBan();
	}

	@Transactional
	@Override
	public int checkKyDanhGia(KyDanhGia kyDanhGia) {
		// TODO Auto-generated method stub
		return dao.checkKyDanhGia(kyDanhGia);
	}

	@Transactional
	@Override
	public int checkActiveKyDanhGia() {
		// TODO Auto-generated method stub
		return dao.checkActiveKyDanhGia();
	}

	@Transactional
	@Override
	public KyDanhGia getKyDanhGiaActive() {
		// TODO Auto-generated method stub
		return dao.getKyDanhGiaActive();
	}

	@Transactional
	@Override
	public int getListDanhGiaBanThanToanCongTy(KyDanhGia kyDanhGia) {
		// TODO Auto-generated method stub
		return dao.getListDanhGiaBanThanToanCongTy(kyDanhGia);
	}

	@Transactional
	@Override
	public void createPhanCongDanhGia(List<DanhGiaNhanVien> danhGiaNhanVien) {
		// TODO Auto-generated method stub
		dao.createPhanCongDanhGia(danhGiaNhanVien);
	}

	@Transactional
	@Override
	public int checkPhanCongDanhGiaExist(KyDanhGia kyDanhGia, PhongBan phongBan) {
		// TODO Auto-generated method stub
		return dao.checkPhanCongDanhGiaExist(kyDanhGia, phongBan);
	}

	@Transactional
	@Override
	public PhongBan getPhongBanBy(String phongban) {
		// TODO Auto-generated method stub
		return dao.getPhongBanBy(phongban);
	}

	@Transactional
	@Override
	public List<TruongPhongDanhGia> getListTruongPhongDanhGia(int start, int maxItems, KyDanhGia kyDanhGia,
			PhongBan phongBan) {
		// TODO Auto-generated method stub
		return dao.getListTruongPhongDanhGia(start, maxItems, kyDanhGia, phongBan);
	}

	@Transactional
	@Override
	public List<DanhGiaBanThan> getListDanhGiaBanThanPhongBan(int start, int maxItems, KyDanhGia kyDanhGia,
			PhongBan phongBan) {
		// TODO Auto-generated method stub
		return dao.getListDanhGiaBanThanPhongBan(start, maxItems, kyDanhGia, phongBan);
	}

	@Transactional
	@Override
	public DanhGiaBanThan getDanhGiaBanThan(int id) {
		// TODO Auto-generated method stub
		return dao.getDanhGiaBanThan(id);
	}

	@Transactional
	@Override
	public void createTruongPhongDanhGia(List<TruongPhongDanhGia> truongPhongDanhGia) {
		// TODO Auto-generated method stub
		dao.createTruongPhongDanhGia(truongPhongDanhGia);
	}

}
