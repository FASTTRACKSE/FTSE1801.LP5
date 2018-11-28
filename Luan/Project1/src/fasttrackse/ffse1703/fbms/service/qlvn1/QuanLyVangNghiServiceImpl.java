package fasttrackse.ffse1703.fbms.service.qlvn1;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.qlvn1.QuanLyVangNghiDao;
import fasttrackse.ffse1703.fbms.entity.qlvn1.DonNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn1.LyDo;
import fasttrackse.ffse1703.fbms.entity.qlvn1.TinhTrangNghi;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;

@Service
public class QuanLyVangNghiServiceImpl implements QuanLyVangNghiService {
	@Autowired
	private QuanLyVangNghiDao qlvnDao;

	public void setQuanLyVangNghiDao(QuanLyVangNghiDao personDAO) {
		this.qlvnDao = personDAO;
	}

	@Transactional
	@Override
	public void addDon(DonNghi dn) {
		this.qlvnDao.addDon(dn);

	}

	@Transactional
	@Override
	public List<DonNghi> listDonNghiNhap(int id_nv) {

		return this.qlvnDao.listDonNghiNhap(id_nv);
	}

	@Transactional
	@Override
	public UserAccount getThongTinUser(String username) {
		return this.qlvnDao.getThongTinUser(username);
	}

	@Transactional
	@Override
	public TinhTrangNghi getTinhTrang(int id_nv) {
		return this.qlvnDao.getTinhTrang(id_nv);
	}

	@Transactional
	@Override
	public List<LyDo> listLyDo() {
		return this.qlvnDao.listLyDo();
	}

	@Transactional
	@Override
	public void insertUpdateTinhTrang(int id_nv, TinhTrangNghi tt) {
		this.qlvnDao.insertTinhTrang(id_nv, tt);
	}



	@Transactional
	@Override
	public List<DonNghi> listDonNghiChoDuyet(int id_nv) {
		return this.qlvnDao.listDonNghiChoDuyet(id_nv);
	}

	@Transactional
	@Override
	public DonNghi getDonNghiNv(int id_don) {
		return this.qlvnDao.getDonNghiNv(id_don);
	}

	@Transactional
	@Override
	public void updateDon(DonNghi dn) {
		this.qlvnDao.updateDon(dn);
		
	}

	@Transactional
	@Override
	public List<DonNghi> listDonNghiPheDuyet1(String tenPhongBan) {
		return this.qlvnDao.listDonNghiPheDuyet1(tenPhongBan);
	}

	@Transactional
	@Override
	public void updateTinhTrang(TinhTrangNghi tt) {
		this.qlvnDao.updateTinhTrang(tt);
	}
	@Transactional
	@Override
	public void deleteDon(int id_don) {
		this.qlvnDao.deleteDon(id_don);
	}
	@Transactional
	@Override
	public List<DonNghi> listDonNghiPheDuyet2() {
		return this.qlvnDao.listDonNghiPheDuyet2();
	}
	@Transactional
	@Override
	public List<DonNghi> listDonNghiTuChoi(int id_nv,int start,int end) {
		return this.qlvnDao.listDonNghiBiTuChoi(id_nv, start, end);
	}
	@Transactional
	@Override
	public List<DonNghi> listDanhSachPheDuyet(int id_nv,int start,int end) {
		return this.qlvnDao.listDanhSachPheDuyet(id_nv, start, end);
	}

	@Transactional
	@Override
	public Long countListDaDuyet(int id_nv) {
		return this.qlvnDao.countListDaDuyet(id_nv);
	}
	@Transactional
	@Override
	public Long countListTuChoi(int id_nv) {
		return this.qlvnDao.countListTuChoi(id_nv);
	}

	@Override
	public List<DonNghi> listdanhsachpheduyetcty() {
		return this.qlvnDao.listdanhsachpheduyetcty();
	}

	

	
}
