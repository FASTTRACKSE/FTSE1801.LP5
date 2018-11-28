package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.HoSoNhanVienTeam1;

public interface HoSoNhanVienTeam1Service {
	public List<HoSoNhanVienTeam1> findAll(String phongBan);
	public List<HoSoNhanVienTeam1> getAll();
	public HoSoNhanVienTeam1 getById(int maNhanVien);
}
