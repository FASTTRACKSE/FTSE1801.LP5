package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.VaiTroThanhVienTeam1;


public interface VaiTroTeam1Dao {
	public List<VaiTroThanhVienTeam1> getAll();

	public void delete(String maVaiTro);

	public void addNew(VaiTroThanhVienTeam1 vt);

	public VaiTroThanhVienTeam1 getById(String maVaiTro);

	public void update(VaiTroThanhVienTeam1 vt);

	public void setIsDelete(String maVaiTro);
	
	public int getMa(String maVaiTro);
	
	public List<VaiTroThanhVienTeam1> findAllForPaging(int startPosition,int maxResult);


}
