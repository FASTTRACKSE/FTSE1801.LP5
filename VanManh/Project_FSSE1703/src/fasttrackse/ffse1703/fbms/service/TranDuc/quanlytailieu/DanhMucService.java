package fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.DanhMuc;

public interface DanhMucService {
	public List<DanhMuc> listAllDanhMuc();

	public void addDM(DanhMuc dm);

	public void updateDM(DanhMuc dm);

	public void deleteDM(String maDM);

	public DanhMuc getDMbyID(String maDM);

	public List<DanhMuc> listAllDanhMuc(int start, int limit,String sql);

	public String getRecordTotal();
}
