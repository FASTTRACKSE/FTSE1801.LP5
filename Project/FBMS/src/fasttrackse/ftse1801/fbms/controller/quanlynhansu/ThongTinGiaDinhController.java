package fasttrackse.ftse1801.fbms.controller.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.ThongTinGiaDinh;
import fasttrackse.ftse1801.fbms.service.quanlynhansu.ThongTinGiaDinhService;

@Controller
@RequestMapping("QuanLyNhanSu/thongTinGiaDinh")
public class ThongTinGiaDinhController {
	@Autowired
	private ThongTinGiaDinhService thongTinGiaDinhService;
	
	@RequestMapping(value="/")
	public String viewList(Model model) {
		List<ThongTinGiaDinh> list = thongTinGiaDinhService.getAll();
		model.addAttribute("list", list);
		return "QuanLyNhanSu/thongTinGiaDinh/list";
	}
	@RequestMapping(value = "/viewOne/{id}", method = RequestMethod.GET)
	public String viewOne(@PathVariable int id, Model model) {
		model.addAttribute("giaDinh", thongTinGiaDinhService.getById(id));
		return "QuanLyNhanSu/thongTinGiaDinh/viewOne";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("giaDinh", new ThongTinGiaDinh());
		return "QuanLyNhanSu/thongTinGiaDinh/add_form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("giaDinh") ThongTinGiaDinh giaDinh,
			final RedirectAttributes redirectAttributes) {
		try {
			thongTinGiaDinhService.addNew(giaDinh);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyNhanSu/thongTinGiaDinh/";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") int id, Model model) {
		model.addAttribute("giaDinh", thongTinGiaDinhService.getById(id));
		return "QuanLyNhanSu/thongTinGiaDinh/edit_form";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("chungChi") ThongTinGiaDinh giaDinh,
			final RedirectAttributes redirectAttributes) {
		try {
			thongTinGiaDinhService.update(giaDinh);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyNhanSu/thongTinGiaDinh/";
	}

}
