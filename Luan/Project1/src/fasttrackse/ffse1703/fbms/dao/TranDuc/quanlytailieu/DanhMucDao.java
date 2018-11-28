package fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.DanhMuc;

public interface DanhMucDao {
	public List<DanhMuc> listAllDanhMuc();

	public void addDM(DanhMuc dm);

	public void updateDM(DanhMuc dm);

	public void deleteDM(String id);

	public DanhMuc getDMbyID(String id);
	
	public List<DanhMuc> listAllDanhMuc(int start, int limit,String sql);

	public String getRecordTotal();
	
}
