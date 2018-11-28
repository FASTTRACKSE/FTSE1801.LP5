package fasttrackse.ffse1703.fbms.controller.quanlynhansutt;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ThongTinBangCapTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.ThongTinBangCapServiceTT;

@Controller
@RequestMapping("/quanlynhansutt/bang_cap/")
public class ThongTinBangCapControllerTT {
	@Autowired
	private ThongTinBangCapServiceTT thongTinBangCapServiceTT;

	public void setThongTinBangCapServiceTT(ThongTinBangCapServiceTT thongTinBangCapServiceTT) {
		this.thongTinBangCapServiceTT = thongTinBangCapServiceTT;
	}

	// Show all qualifications
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewBangCap(Model model) {
		model.addAttribute("listBangCap", thongTinBangCapServiceTT.listBangCap());
		return "QuanLyNhanSuTT/QuanLyBangCapTT/viewBangCap";
	}

	// Add a degree to an employee
	@RequestMapping(value = "/add_bangcap/{maNhanVien}", method = RequestMethod.GET)
	public String showFormAdd(Model model, final RedirectAttributes redirectAttributes, @PathVariable int maNhanVien) {
		model.addAttribute("hosonv", thongTinBangCapServiceTT.getHoSoNhanVienById(maNhanVien));
		ThongTinBangCapTT hsnv = new ThongTinBangCapTT();
		model.addAttribute("ttbc", hsnv);
		return "QuanLyNhanSuTT/QuanLyBangCapTT/add_form";
	}

	// Edit a degree for an employee
	@RequestMapping("/edit_bangcap/{maNhanVien}")
	public String showFormUpdate(@PathVariable("maNhanVien") int maNhanVien, Model model)
			throws IllegalStateException, IOException {
		model.addAttribute("ttbc", thongTinBangCapServiceTT.findByBangCap(maNhanVien));
		return "QuanLyNhanSuTT/QuanLyBangCapTT/edit_form";
	}

	// delete qualification for an employee
	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
		ThongTinBangCapTT ttbc = thongTinBangCapServiceTT.findByBangCap(id);
		ttbc.setIsdelete(0);
		thongTinBangCapServiceTT.updateThongTinBangCap(ttbc);
		return "redirect:/quanlynhansutt/bang_cap/";
	}

	// Processing additional information, correcting a degree for an employee
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveHopDong(@ModelAttribute("ttbc") @Valid ThongTinBangCapTT ttbc, BindingResult result) {
		if (ttbc.getId() == 0) {
			// new person, add it
			if (result.hasErrors()) {
				return "QuanLyNhanSuTT/QuanLyBangCapTT/add_form";

			}
			ttbc.setIsdelete(1);
			thongTinBangCapServiceTT.addThongTinBangCap(ttbc);
		} else {
			// existing person, call update
			if (result.hasErrors()) {
				return "QuanLyNhanSuTT/QuanLyBangCapTT/edit_form";
			}
			ttbc.setIsdelete(1);
			thongTinBangCapServiceTT.updateThongTinBangCap(ttbc);
		}
		return "redirect:/quanlynhansutt/ho_so/";
	}

	// viewOneBangCap Staff
	@RequestMapping("/viewOneBangCap/{maNhanVien}")
	public String viewOneHopDong(@PathVariable int maNhanVien, Model model) {
		model.addAttribute("viewOne", this.thongTinBangCapServiceTT.viewOne(maNhanVien));
		model.addAttribute("maNhanVien", maNhanVien);
		return "QuanLyNhanSuTT/QuanLyBangCapTT/viewOneBangCap";
	}
}
