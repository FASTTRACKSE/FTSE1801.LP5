package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.mvpquanliduan.VendorDAO;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Vendor;
@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorDAO vendorDAO;
	
	public void setVendorDAO(VendorDAO vendorDAO) {
		this.vendorDAO = vendorDAO;
	}

	@Override
	@Transactional
	public List<Vendor> findAll() {
		
		return vendorDAO.findAll();
	}

	@Override
	@Transactional
	public Vendor findById(String id) {
		return vendorDAO.findById(id);
	}

	@Override
	@Transactional
	public void addNew(Vendor vendor) {
	vendorDAO.addNew(vendor);
		
	}

	@Override
	@Transactional
	public void update(Vendor vendor) {
		vendorDAO.update(vendor);
		
	}

	@Override
	@Transactional
	public void delete(Vendor vendor) {
		vendorDAO.delete(vendor);
		
	}

	@Override
	@Transactional
	public int checkVendor(String nameVendor) {
		return vendorDAO.checkVendor(nameVendor);
	}

	@Override
	@Transactional
	public List<Vendor> listVendor(int start, int maxRows) {
		
		return vendorDAO.listVendor(start, maxRows);
	}

	@Override
	@Transactional
	public int countVendor() {
		
		return vendorDAO.countVendor();
	}

}