package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlyduan.VaiTroTeam1Dao;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.VaiTroThanhVienTeam1;
@Service
public class VaiTroTeam1ServiceImpl implements VaiTroTeam1Service{

	@Autowired
	private VaiTroTeam1Dao vaiTroDao;

	@Override
	@Transactional
	public List<VaiTroThanhVienTeam1> getAll() {
		return this.vaiTroDao.getAll();
	}

	@Override
	@Transactional
	public void delete(String maVaiTro) {
		this.vaiTroDao.delete(maVaiTro);
		
	}

	@Override
	@Transactional
	public void addNew(VaiTroThanhVienTeam1 vt) {
		this.vaiTroDao.addNew(vt);
		
	}

	@Override
	@Transactional
	public VaiTroThanhVienTeam1 getById(String maVaiTro) {
		return this.vaiTroDao.getById(maVaiTro);
	}

	@Override
	@Transactional
	public void update(VaiTroThanhVienTeam1 vt) {
		this.vaiTroDao.update(vt);
	}

	@Override
	@Transactional
	public void setIsDelete(String maVaiTro) {
		this.vaiTroDao.setIsDelete(maVaiTro);
		
	}

	@Override
	@Transactional
	public int getMa(String maVendor) {
		return this.vaiTroDao.getMa(maVendor);
		
	}

	@Override
	@Transactional
	public List<VaiTroThanhVienTeam1> findAllForPaging(int startPosition, int maxResult) {
		return this.vaiTroDao.findAllForPaging(startPosition, maxResult);
	}
	

}
