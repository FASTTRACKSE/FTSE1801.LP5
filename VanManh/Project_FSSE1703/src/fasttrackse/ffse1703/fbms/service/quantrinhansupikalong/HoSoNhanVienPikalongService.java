package fasttrackse.ffse1703.fbms.service.quantrinhansupikalong;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;



public interface HoSoNhanVienPikalongService {
	public List<HoSoNhanVienPikalong> listNhanVien();
	public List<HoSoNhanVienPikalong> listNhanVienPagination(int start, int end);
	public void delete(String maNv);
	public void insert(HoSoNhanVienPikalong hoSoNhanVien);

	public String getId();
	public HoSoNhanVienPikalong getHoSoNhanVienById (String maNv);

	public HoSoNhanVienPikalong getEdit(String maNv);
	public void update(HoSoNhanVienPikalong hoSoNhanVienPikalong);
	public Long countAll();
	public boolean checkExistMaNv(String maNv);
	public boolean checkIsActive(String maNv);
	
	// xem nhân viên theo phòng ban
	
	public List<HoSoNhanVienPikalong> listNhanVienByPhongBan(String phongBan);

}
