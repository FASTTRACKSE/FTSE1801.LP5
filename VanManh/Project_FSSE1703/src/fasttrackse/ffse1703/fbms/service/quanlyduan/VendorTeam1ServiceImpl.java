package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlyduan.VendorTeam1Dao;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.VendorTeam1;
@Service
public class VendorTeam1ServiceImpl implements VendorTeam1Service{
	@Autowired
	private VendorTeam1Dao vendorDao;

	@Override
	@Transactional
	public List<VendorTeam1> getAll() {
		 return this.vendorDao.getAll();
	}

	@Override
	@Transactional
	public void addNew(VendorTeam1 vd) {
		this.vendorDao.addNew(vd);
	}

	@Override
	@Transactional
	public void update(VendorTeam1 vd) {
		this.vendorDao.update(vd);
	}

	@Override
	@Transactional
	public void delete(String maVendor) {
		this.vendorDao.delete(maVendor);
	}

	@Override
	@Transactional
	public VendorTeam1 getById(String maVendor) {
		return this.vendorDao.getById(maVendor);
	}

	@Override
	@Transactional
	public void setIsDelete(String maVendor) {
		this.vendorDao.setIsDelete(maVendor);
		
	}

	@Override
	@Transactional
	public int getName(String tenVendor) {
		return this.vendorDao.getName(tenVendor);
	}

	@Override
	@Transactional
	public int getMa(String maVendor) {
		return this.vendorDao.getMa(maVendor);
	}

	@Override
	@Transactional
	public List<VendorTeam1> findAllForPaging(int startPosition, int maxResult) {
		return this.vendorDao.findAllForPaging(startPosition, maxResult);
	}

}
