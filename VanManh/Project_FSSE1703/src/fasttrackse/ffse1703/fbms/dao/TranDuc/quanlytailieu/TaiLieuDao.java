package fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.DanhMuc;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TaiLieu;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

public interface TaiLieuDao {
	public List<TaiLieu> listAllDel0();

	public List<TaiLieu> listAllDel1();

	public void addTL(TaiLieu tl);

	public void updateTL(TaiLieu tl);

	public void deleteTL(Integer idTL);

	public TaiLieu getTLbyID(Integer maTL);

	public List<TaiLieu> listAllDel0(int start, int limit);

	public List<TaiLieu> listAllDel1(int start, int limit);

	public List<DanhMuc> listDanhMuc();

	List<PhongBan> listPhongBan();

	List<TaiLieu> listbyPhongBan(int start, int limit, String maPB);

}
