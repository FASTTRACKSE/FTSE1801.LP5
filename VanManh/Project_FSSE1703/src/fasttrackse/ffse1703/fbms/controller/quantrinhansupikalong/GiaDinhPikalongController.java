package fasttrackse.ffse1703.fbms.controller.quantrinhansupikalong;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.GiaDinhPikalong;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.GiaDinhPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HoSoNhanVienPikalongService;

@Controller
@RequestMapping(value = "/QuanTriNhanSuPikalong/QuanLiGiaDinh")
public class GiaDinhPikalongController {
	@Autowired
	private GiaDinhPikalongService giaDinhPikalongService;

	@Autowired
	private HoSoNhanVienPikalongService hoSoNhanVienPikalongService;

	public void setGiaDinhPikalongService(GiaDinhPikalongService giaDinhPikalongService) {
		this.giaDinhPikalongService = giaDinhPikalongService;
	}

	@RequestMapping("/saveOneGiaDinh")
	public String saveOneGiaDinh(@ModelAttribute("command") @Valid GiaDinhPikalong p, BindingResult result,
			Model model) {
		// System.out.println("ma nv " + p.getMaNV());
		if (result.hasErrors()) {
			return "QuanTriNhanSuPikalong/QuanLiGiaDinh/formAddGiaDinhPikalong";
		}
		// check trùng quan hệ
		int checkQuanHe = giaDinhPikalongService.checkQuanHe(p.getQuanHe(), p.getMaNV());
		System.out.println("ggsggggg" + checkQuanHe);
		System.out.println("ggsggggg" + p.getQuanHe());
		if (checkQuanHe >= 1) {
			model.addAttribute("messageQuanHe", "<script>alert('Nhân Viên Đã Có " + p.getQuanHe() + "');</script>");
			return "QuanTriNhanSuPikalong/QuanLiGiaDinh/formAddGiaDinhPikalong";
		}
		giaDinhPikalongService.addGiaDinhPikalong(p);
		return "redirect:/QuanTriNhanSuPikalong/QuanLiGiaDinh/viewOneGiaDinh/" + p.getMaNV();
	}

	@RequestMapping("/editOneGiaDinh")
	public String updateOneGiaDinh(@ModelAttribute("command") @Valid GiaDinhPikalong p, BindingResult result) {
		// System.out.println("ma nv " + p.getMaNV());
		if (result.hasErrors()) {
			return "QuanTriNhanSuPikalong/QuanLiGiaDinh/formUpdateGiaDinhPikalong";
		}
		giaDinhPikalongService.updateGiaDinhPikalong(p);
		return "redirect:/QuanTriNhanSuPikalong/QuanLiGiaDinh/viewOneGiaDinh/" + p.getMaNV();
	}

	@RequestMapping("/remove/{id}")
	public String removeOneGiaDinh(@PathVariable int id, GiaDinhPikalong p) {
		p = giaDinhPikalongService.getGiaDinhPikalongById(id);
		giaDinhPikalongService.removeGiaDinhPikalong(id);
		return "redirect:/QuanTriNhanSuPikalong/QuanLiGiaDinh/viewOneGiaDinh/" + p.getMaNV();
	}

	@RequestMapping("/viewOneGiaDinh/{maNV}")
	public String viewOneGiaDinh(@PathVariable String maNV, Model model) {
		boolean isActive = hoSoNhanVienPikalongService.checkIsActive(maNV);
		if (isActive == true) {
			model.addAttribute("hosonhanvien", this.hoSoNhanVienPikalongService.getEdit(maNV));
			model.addAttribute("viewOne", this.giaDinhPikalongService.viewOne(maNV));
			model.addAttribute("maNv", maNV);
			return "QuanTriNhanSuPikalong/QuanLiGiaDinh/viewOneGiaDinhPikalong";
		} else {
			return "QuanTriHeThong/error-404";
		}
		
	}

	@RequestMapping(value = "/add/{maNV}", method = RequestMethod.GET)
	public String showFormAdd(Model model, HttpSession session, @PathVariable String maNV) {

		GiaDinhPikalong hsnv = new GiaDinhPikalong();
		hsnv.setMaNV(maNV);
		model.addAttribute("command", hsnv);
		session.setAttribute("maNv", maNV);
		// model.addAttribute("maNv", maNV);
		return "QuanTriNhanSuPikalong/QuanLiGiaDinh/formAddGiaDinhPikalong";
	}

	@RequestMapping("/edit/{maNV}")
	public String showFormUpdate(@PathVariable("maNV") int id, Model model, GiaDinhPikalong p)
			throws IllegalStateException, IOException {
		p = giaDinhPikalongService.getGiaDinhPikalongById(id);
		model.addAttribute("command", p);
		model.addAttribute("maNv", p.getMaNV());
		return "QuanTriNhanSuPikalong/QuanLiGiaDinh/formUpdateGiaDinhPikalong";
	}

}
