package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.KhachHangTeam1;

public interface KhachHangTeam1Dao {
	public List<KhachHangTeam1> getAll();

	public KhachHangTeam1 findById(String maKH);

	public void delete(KhachHangTeam1 khachhang);

	public void update(KhachHangTeam1 khachhang);

	public void create(KhachHangTeam1 khachhang);

	public List<KhachHangTeam1> findAllForPaging(int startPosition, int maxResult);

}
