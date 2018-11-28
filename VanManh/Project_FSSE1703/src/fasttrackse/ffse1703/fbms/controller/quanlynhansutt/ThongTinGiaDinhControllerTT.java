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

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ThongTinGiaDinhTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.ThongTinGiaDinhServiceTT;

@Controller
@RequestMapping("/quanlynhansutt/gia_dinh/")
public class ThongTinGiaDinhControllerTT {

	@Autowired
	private ThongTinGiaDinhServiceTT thongTinGiaDinhServiceTT;

	public void setThongTinGiaDinhServiceTT(ThongTinGiaDinhServiceTT thongTinGiaDinhServiceTT) {
		this.thongTinGiaDinhServiceTT = thongTinGiaDinhServiceTT;
	}

	// Add family information to an employee
	@RequestMapping(value = "/add_giadinh/{maNhanVien}", method = RequestMethod.GET)
	public String showFormAdd(Model model, final RedirectAttributes redirectAttributes, @PathVariable int maNhanVien) {
		model.addAttribute("hosonv", thongTinGiaDinhServiceTT.getHoSoNhanVienById(maNhanVien));
		ThongTinGiaDinhTT ttgd = new ThongTinGiaDinhTT();
		model.addAttribute("hsgd", ttgd);
		return "QuanLyNhanSuTT/ThongTinGiaDinh/add_form";
	}

	// Fix Family Information for Employees
	@RequestMapping("/edit_giadinh/{maNhanVien}")
	public String showFormUpdate(@PathVariable("maNhanVien") int maNhanVien, Model model)
			throws IllegalStateException, IOException {
		model.addAttribute("hsgd", thongTinGiaDinhServiceTT.getGiaDinhById(maNhanVien));
		return "QuanLyNhanSuTT/ThongTinGiaDinh/edit_form";
	}

	// delete an employee's contract
	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
		ThongTinGiaDinhTT ttgd = thongTinGiaDinhServiceTT.getGiaDinhById(id);
		ttgd.setIsdelete(0);
		thongTinGiaDinhServiceTT.updateGiaDinh(ttgd);
		return "redirect:/quanlynhansutt/ho_so/";
	}

	// Show an employee's family information
	@RequestMapping("/viewOneGiaDinh/{maNhanVien}")
	public String viewOneGiaDinh(@PathVariable int maNhanVien, Model model) {
		model.addAttribute("viewOne", this.thongTinGiaDinhServiceTT.viewOne(maNhanVien));
		model.addAttribute("maNhanVien", maNhanVien);
		return "QuanLyNhanSuTT/ThongTinGiaDinh/viewOneGiaDinh";
	}

	// Processing additional information, correcting a degree for an employee
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveHopDong(@ModelAttribute("hsgd") @Valid ThongTinGiaDinhTT gd, BindingResult result, Model model) {
		if (gd.getId() == 0) {
			// new person, add it
			if (result.hasErrors()) {
				return "QuanLyNhanSuTT/ThongTinGiaDinh/add_form";

			}
			// check trùng quan hệ
			int checkQuanHe = thongTinGiaDinhServiceTT.checkQuanHe(gd.getQuanHe(),
					gd.getHoSoNhanVienTT().getMaNhanVien());
			if (checkQuanHe >= 1) {
				model.addAttribute("messageQuanHe",
						"<script>alert('Nhân Viên Đã Có " + gd.getQuanHe() + "');</script>");
				return "QuanLyNhanSuTT/ThongTinGiaDinh/add_form";
			}
			gd.setIsdelete(1); 
			thongTinGiaDinhServiceTT.addGiaDinh(gd);
		} else {
			// existing person, call update
			if (result.hasErrors()) {
				return "QuanLyNhanSuTT/ThongTinGiaDinh/edit_form";
			}
			gd.setIsdelete(1); 
			thongTinGiaDinhServiceTT.updateGiaDinh(gd);
		}
		return "redirect:/quanlynhansutt/ho_so/";
	}

}
