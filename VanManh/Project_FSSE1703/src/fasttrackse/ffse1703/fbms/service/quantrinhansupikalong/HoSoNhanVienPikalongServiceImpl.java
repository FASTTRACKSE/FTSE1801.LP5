package fasttrackse.ffse1703.fbms.service.quantrinhansupikalong;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong.HoSoNhanVienPikalongDao;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;

@Service
public class HoSoNhanVienPikalongServiceImpl implements HoSoNhanVienPikalongService {
	@Autowired
	private HoSoNhanVienPikalongDao hoSoNhanVienPikalongDao;

	public void setHoSoNhanVienPikalongDao(HoSoNhanVienPikalongDao hoSoNhanVienPikalongDao) {
		this.hoSoNhanVienPikalongDao = hoSoNhanVienPikalongDao;
	}

	@Override
	@Transactional
	public List<HoSoNhanVienPikalong> listNhanVien() {

		return hoSoNhanVienPikalongDao.listNhanVien();
	}

	@Override
	@Transactional
	public List<HoSoNhanVienPikalong> listNhanVienPagination(int start, int end) {
		// TODO Auto-generated method stub
		return hoSoNhanVienPikalongDao.listNhanVienPagination(start, end);
	}

	@Override
	@Transactional
	public void delete(String maNv) {
		hoSoNhanVienPikalongDao.delete(maNv);
	}

	@Override
	@Transactional
	public void insert(HoSoNhanVienPikalong hoSoNhanVien) {
		hoSoNhanVienPikalongDao.insert(hoSoNhanVien);

	}

	@Override
	@Transactional
	public String getId() {
		return this.hoSoNhanVienPikalongDao.getAutoId();
	}

	@Override
	@Transactional
	public HoSoNhanVienPikalong getHoSoNhanVienById(String maNv) {
		return this.hoSoNhanVienPikalongDao.getHoSoNhanVienById(maNv);
	}

	@Override
	@Transactional
	public HoSoNhanVienPikalong getEdit(String maNv) {

		return hoSoNhanVienPikalongDao.getEdit(maNv);
	}

	@Override
	@Transactional
	public void update(HoSoNhanVienPikalong hoSoNhanVienPikalong) {
		hoSoNhanVienPikalongDao.update(hoSoNhanVienPikalong);

	}

	@Override
	@Transactional
	public Long countAll() {
		// TODO Auto-generated method stub
		return hoSoNhanVienPikalongDao.countAll();
	}

	@Override
	@Transactional
	public boolean checkExistMaNv(String maNv) {
		return hoSoNhanVienPikalongDao.checkExistMaNv(maNv);
	}

	@Override
	@Transactional
	public boolean checkIsActive(String maNv) {

		return hoSoNhanVienPikalongDao.checkIsActive(maNv);
	}

	@Override
	@Transactional
	public List<HoSoNhanVienPikalong> listNhanVienByPhongBan(String phongBan) {
		return hoSoNhanVienPikalongDao.listNhanVienByPhongBan(phongBan);
	}

}
