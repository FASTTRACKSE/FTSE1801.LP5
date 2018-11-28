package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import org.springframework.validation.BindingResult;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ThongTinBangCapTT;

public interface ThongTinBangCapServiceTT {
	public void addThongTinBangCap(ThongTinBangCapTT ttbc);
	public void updateThongTinBangCap(ThongTinBangCapTT ttbc);
	public void deleteThongTinBangCap(ThongTinBangCapTT ttbc);
	public List<String> getDeleteList(List<ThongTinBangCapTT> listThongTinBangcap);
	public List<String> getErrorList(BindingResult bindingResult) ;
	public List<ThongTinBangCapTT> listBangCap();
	public ThongTinBangCapTT findByBangCap(int id);
	public HoSoNhanVienTT getHoSoNhanVienById(int maNhanVien);
	public List<ThongTinBangCapTT> viewOne(int maNhanVien);
}
