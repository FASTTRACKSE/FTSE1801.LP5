package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlyduan.VaiTroThanhVienDao;
import fasttrackse.ftse1801.fbms.entity.quanlyduan.VaiTroThanhVien;

@Service
@Transactional
public class VaiTroThanhVienServiceImpl implements VaiTroThanhVienService {

	@Autowired
	private VaiTroThanhVienDao vaiTroThanhVienDao;

	@Override
	public List<VaiTroThanhVien> findAll() {
		return vaiTroThanhVienDao.findAll();
	}

	@Override
	public VaiTroThanhVien findById(String maVaiTro) {
		return vaiTroThanhVienDao.findById(maVaiTro);
	}

	@Override
	@Transactional
	public void add(VaiTroThanhVien vaiTroThanhVien) {
		vaiTroThanhVienDao.add(vaiTroThanhVien);
	}

	@Override
	@Transactional
	public void update(VaiTroThanhVien vaiTroThanhVien) {
		vaiTroThanhVienDao.update(vaiTroThanhVien);
	}

	@Override
	@Transactional
	public void delete(VaiTroThanhVien vaiTroThanhVien) {
		vaiTroThanhVienDao.delete(vaiTroThanhVien);
	}

	@Override
	public int checkTenVaiTro(String tenVaiTro) {
		return vaiTroThanhVienDao.checkTenVaiTro(tenVaiTro);
	}

	@Override
	public List<VaiTroThanhVien> listVaiTro(int start, int maxRows) {
		return vaiTroThanhVienDao.listVaiTro(start, maxRows);
	}

	@Override
	public int countVaiTro() {
		return vaiTroThanhVienDao.countVaiTro();
	}

}
