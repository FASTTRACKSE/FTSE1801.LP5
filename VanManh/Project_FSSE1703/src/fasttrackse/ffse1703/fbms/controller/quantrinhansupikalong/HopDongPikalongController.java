package fasttrackse.ffse1703.fbms.controller.quantrinhansupikalong;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HopDongPikalong;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HoSoNhanVienPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HopDongPikalongSevice;

@Controller
@RequestMapping("/QuanTriNhanSu/quanlihopdong/")
public class HopDongPikalongController {
	@Autowired
	private HoSoNhanVienPikalongService hoSoNhanVienPikalongService;

	@Autowired
	private HopDongPikalongSevice hopDongPikalongService;

	@RequestMapping("/")
	public String listHopDong(Model model) {
		List<HopDongPikalong> listHopDong = hopDongPikalongService.listHopDong();
		System.out.println(listHopDong);
		model.addAttribute("listHopDong", listHopDong);
		
		return "QuanTriNhanSuPikalong/ThongTinHopDong/ListHopDong";
	}

	@RequestMapping(value = "viewOneHopDong/view/{maHopDong}", method = RequestMethod.GET)
	public String viewThongTinHopDong(@PathVariable("maHopDong") int maHopDong, Model model) {
		HoSoNhanVienPikalong hsnv = this.hoSoNhanVienPikalongService
				.getEdit(hopDongPikalongService.getMaHopDong(maHopDong).getHoSoNhanVienPikalong().getMaNv());
		model.addAttribute("hsnv", hsnv);
		HopDongPikalong hdById = this.hopDongPikalongService.getHopDongById(maHopDong);
		model.addAttribute("hopDong", hdById);
		
		return "QuanTriNhanSuPikalong/ThongTinHopDong/view/ViewThongTinHopDong";
	}

	@RequestMapping(value = "formaddhd/{maNv}" + "", method = RequestMethod.GET)
	public String addFormHd(@PathVariable String maNv, Model model) {
		String lastMaHd = this.hopDongPikalongService.getLastMaHd();
		System.out.println(lastMaHd);
		model.addAttribute("hsnv", hoSoNhanVienPikalongService.getEdit(maNv));
		model.addAttribute("hopDongPikalong", new HopDongPikalong());
		model.addAttribute("lastMaHd", lastMaHd);
		
		return "QuanTriNhanSuPikalong/ThongTinHopDong/FormAddHd";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String addSaveHd(@ModelAttribute("hopDongPikalong") @Valid HopDongPikalong hd, BindingResult result,
			Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			model.addAttribute("hsnv", hoSoNhanVienPikalongService.getEdit(hd.getHoSoNhanVienPikalong().getMaNv()));
			return "QuanTriNhanSuPikalong/ThongTinHopDong/FormAddHd";
		}
		String maNv = hd.getHoSoNhanVienPikalong().getMaNv();
		HoSoNhanVienPikalong hsnv = this.hoSoNhanVienPikalongService.getEdit(maNv);

		hd.setMaHopDong(Integer.valueOf(this.hopDongPikalongService.getAutoId()));
		this.hopDongPikalongService.insert(hd);
		model.addAttribute("hoSoNhanVien", hsnv);
		
		return "redirect:/QuanTriNhanSu/quanlihopdong/viewOneHopDong/" + maNv;
	}

	@RequestMapping(value = "viewOneHopDong/formedithd/{maHopDong}", method = RequestMethod.GET)
	public String editFormHd(@PathVariable int maHopDong, Model model) {
		String lastMaHd = this.hopDongPikalongService.getLastMaHd();
		model.addAttribute("hsnv", hoSoNhanVienPikalongService
				.getEdit(hopDongPikalongService.getMaHopDong(maHopDong).getHoSoNhanVienPikalong().getMaNv()));
		model.addAttribute("hopDongPikalong", hopDongPikalongService.getMaHopDong(maHopDong));
		model.addAttribute("lastMaHd", lastMaHd);

		return "QuanTriNhanSuPikalong/ThongTinHopDong/FormEditHd";
	}

	@RequestMapping(value = "edithd", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("hopDongPikalong") @Valid HopDongPikalong hd, BindingResult result,
			Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			model.addAttribute("hsnv", hoSoNhanVienPikalongService.getEdit(hd.getHoSoNhanVienPikalong().getMaNv()));
			return "QuanTriNhanSuPikalong/ThongTinHopDong/FormEditHd";
		}
		String maNv = hd.getHoSoNhanVienPikalong().getMaNv();
		HoSoNhanVienPikalong hsnv = this.hoSoNhanVienPikalongService.getEdit(maNv);
		this.hopDongPikalongService.update(hd);
		model.addAttribute("hoSoNhanVien", hsnv);
		
		return "redirect:/QuanTriNhanSu/quanlihopdong/viewOneHopDong/" + maNv;
	}

	@RequestMapping("viewOneHopDong/{maNv}")
	public String viewOneHopDong(@PathVariable String maNv, Model model) {
		boolean isActive = hoSoNhanVienPikalongService.checkIsActive(maNv);
		if (isActive == true) {
			List<HopDongPikalong> hdong = this.hopDongPikalongService.viewOne(maNv);
			model.addAttribute("lastTrangThai", this.hopDongPikalongService.getLastTrangThaiHd(maNv));
			model.addAttribute("listHopDong", hdong);
			model.addAttribute("maNv", maNv);
			return "QuanTriNhanSuPikalong/ThongTinHopDong/HopDong";
		} else {
			return "QuanTriHeThong/error-404";
		}
	}

}
