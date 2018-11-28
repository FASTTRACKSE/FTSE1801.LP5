package fasttrackse.ffse1703.fbms.controller.quantrinhansupikalong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.service.mvpquanliduan.NhiemVuService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HoSoNhanVienPikalongService;

@Controller
@RequestMapping(value = "/QuanTriNhanSuPikalong/KinhNghiemDuAn")
public class KinhNghiemDuAnPikalongController {
	@Autowired
	private NhiemVuService nhiemVuService;

	@Autowired
	private HoSoNhanVienPikalongService hoSoNhanVienPikalongService;

	@RequestMapping("/viewOneKinhNghiemDuAn/{maNV}")
	public String viewOneKinhNghiemDuAn(@PathVariable String maNV, Model model) {
		boolean isActive = hoSoNhanVienPikalongService.checkIsActive(maNV);
		if (isActive == true) {
			model.addAttribute("hosonhanvien", this.hoSoNhanVienPikalongService.getEdit(maNV));
			model.addAttribute("viewOne", this.nhiemVuService.getByMaNhanVien(maNV));
			model.addAttribute("maNv", maNV);
			return "QuanTriNhanSuPikalong/KinhNghiemDuAn/viewOneKinhNghiemDuAn";
		} else {
			return "QuanTriHeThong/error-404";
		}
	}
}
