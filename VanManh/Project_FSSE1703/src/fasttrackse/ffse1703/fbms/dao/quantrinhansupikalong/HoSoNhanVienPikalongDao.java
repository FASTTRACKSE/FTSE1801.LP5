package fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;

public interface HoSoNhanVienPikalongDao {
	public List<HoSoNhanVienPikalong> listNhanVien();
	public List<HoSoNhanVienPikalong> listNhanVienPagination(int start, int end);
	public void delete(String maNv);
	public void insert(HoSoNhanVienPikalong hoSoNhanVien);
	public String getAutoId();
	public HoSoNhanVienPikalong getHoSoNhanVienById(String maNv);
	public HoSoNhanVienPikalong getEdit(String maNv);
	public void update(HoSoNhanVienPikalong hoSoNhanVienPikalong);
	public Long countAll(); 
	public boolean checkExistMaNv(String maNv);
	public boolean checkIsActive(String maNv);
	
	// xem theo phòng ban
	
	public List<HoSoNhanVienPikalong> listNhanVienByPhongBan (String phongBan);
}
