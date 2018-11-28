package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Vendor;

public interface VendorService {
	public List<Vendor> findAll();
	public Vendor findById(String id);
	public void addNew(Vendor vendor);
	public void update(Vendor vendor);
	public void delete(Vendor vendor);
	public int checkVendor(String nameVendor);
	public List<Vendor> listVendor(int start, int maxRows);
	public int countVendor();
}