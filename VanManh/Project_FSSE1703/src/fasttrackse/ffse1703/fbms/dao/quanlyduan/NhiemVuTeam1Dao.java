package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.NhiemVuTeam1;

public interface NhiemVuTeam1Dao {
	public void save(NhiemVuTeam1 nhiemVu);

	public void update(NhiemVuTeam1 nhiemVu, NhiemVuTeam1 oldNhiemVu);

	public List<NhiemVuTeam1> getAll(String maDuAn);

	public List<NhiemVuTeam1> getById(String maDuAn, int maNhanVien);

	public NhiemVuTeam1 getDetailNhiemVu(String maDuAn, int maNhanVien, String maVaiTro);

	public void delete(NhiemVuTeam1 nhiemvu);
}
