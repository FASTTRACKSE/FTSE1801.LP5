package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.HoSoNhanVienTeam1;

public interface HoSoNhanVienTeam1Dao {
	public List<HoSoNhanVienTeam1> findAll(String phongBan);
	public List<HoSoNhanVienTeam1> getAll();
	public HoSoNhanVienTeam1 getById(int maNhanVien);

}
