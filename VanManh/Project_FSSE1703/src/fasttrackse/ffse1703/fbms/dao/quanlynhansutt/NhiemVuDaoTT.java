package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.NhiemVuTT;

public interface NhiemVuDaoTT {
	public void add(NhiemVuTT nhiemVu);

	public NhiemVuTT getByID(int id);

	public List<NhiemVuTT> getByDuAn(String idProjects);

	public void update(NhiemVuTT nhiemVu);

	public void delete(int id);
	
	public List<NhiemVuTT> getByMaNhanVien(int maNhanVien);
}
