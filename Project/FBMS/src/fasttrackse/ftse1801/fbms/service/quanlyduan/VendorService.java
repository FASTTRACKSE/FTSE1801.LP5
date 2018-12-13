package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Vendor;

public interface VendorService {
	public List<Vendor> findAll();
	public Vendor findById(String idVendor);
	public void addNew(Vendor vendor);
	public void update(Vendor vendor);
	public void delete(Vendor vendor);
	public int checkMaVendor(String idVendor);
	public int checkTenVendor(String nameVendor);
	public List<Vendor> listVendor(int start, int maxRows);
	public int countVendor();
}
