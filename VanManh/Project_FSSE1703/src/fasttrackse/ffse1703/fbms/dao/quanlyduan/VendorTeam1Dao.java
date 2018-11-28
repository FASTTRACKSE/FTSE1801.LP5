package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.VendorTeam1;

public interface VendorTeam1Dao {

	public List<VendorTeam1> getAll();

	public void delete(String maVendor);

	public void addNew(VendorTeam1 vd);

	public VendorTeam1 getById(String maVendor);

	public void update(VendorTeam1 vd);

	public void setIsDelete(String maVendor);
	
	public int getName(String tenVendor);
	
	public int getMa(String maVendor);
	
	public List<VendorTeam1> findAllForPaging(int startPosition,int maxResult);
}
