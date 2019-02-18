package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlyduan.VendorDao;
import fasttrackse.ftse1801.fbms.entity.quanlyduan.Vendor;
@Service 
public class VendorServiceImpl implements VendorService{
@Autowired
private VendorDao vendorDao;

	public VendorDao getVendorDao() {
	return vendorDao;
}

public void setVendorDao(VendorDao vendorDao) {
	this.vendorDao = vendorDao;
}

	@Override
	public List<Vendor> findAll() {
		return vendorDao.findAll();
	}

	@Override
	public Vendor findById(String idVendor) {
		return vendorDao.findById(idVendor);
	}

	@Override
	public void addNew(Vendor vendor) {
		vendorDao.addNew(vendor);		
	}

	@Override
	public void update(Vendor vendor) {
		vendorDao.update(vendor);		
	}

	@Override
	public void delete(Vendor vendor) {
		vendorDao.delete(vendor);		
	}

	@Override
	public int checkMaVendor(String idVendor) {
		return vendorDao.checkMaVendor(idVendor);
	}

	@Override
	public int checkTenVendor(String nameVendor) {
		return vendorDao.checkTenVendor(nameVendor);
	}

	@Override
	public List<Vendor> listVendor(int start, int maxRows) {
		return vendorDao.listVendor(start, maxRows);
	}

	@Override
	public int countVendor() {
		return vendorDao.countVendor();
	}

}
