package fasttrackse.ffse1703.fbms.controller.quantrinhansupikalong;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HopDongPikalong;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HopDongPikalongSevice;

@Controller
@RequestMapping("/quantrinhansu/hopdongphongban/")
public class HopDongPhongBanPikalongController {
	@Autowired
	private HopDongPikalongSevice hopDongPikalongSevice;
	@RequestMapping("{phongBan}")
	public String listHopDongPhongBan(@PathVariable String phongBan, Model model) {
		List<HopDongPikalong> hopDongNhanVienByPhongBan = hopDongPikalongSevice.listHopDongByPhongBan(phongBan);
		model.addAttribute("listHopDongPhongBan", hopDongNhanVienByPhongBan);
		model.addAttribute("size", hopDongNhanVienByPhongBan.size());
		return "QuanTriNhanSuPikalong/ThongTinHopDong/ListHopDongPhongBan";
	}
}
