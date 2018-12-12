package fasttrackse.ftse1801.fbms.dao.quantritailieu;

import java.util.List;

import fasttrackse.ftse1801.fbms.entity.quantritailieu.DanhMucTaiLieu;
import fasttrackse.ftse1801.fbms.entity.quantritailieu.TaiLieu;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;

public interface TaiLieuDao {
	public List<TaiLieu> getAllTaiLieuDel0();

	public List<TaiLieu> getAllTaiLieuDel1();

	public void insertTaiLieu(TaiLieu tl);

	public void updateTaiLieu(TaiLieu tl);

	public void deleteTaiLieu(int maTL);

	public TaiLieu getTaiLieuByMa(int maTL);

	public List<TaiLieu> getAllTaiLieuDel0(int page, int record);

	public List<TaiLieu> getAllTaiLieuDel1(int page, int record);

	public List<DanhMucTaiLieu> listDanhMuc();

	public List<PhongBan> listPhongBan();
}
