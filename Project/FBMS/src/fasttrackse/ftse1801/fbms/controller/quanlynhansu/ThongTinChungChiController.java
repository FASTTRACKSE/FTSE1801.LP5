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

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.ThongTinChungChi;
import fasttrackse.ftse1801.fbms.service.quanlynhansu.HoSoNhanSuService;
import fasttrackse.ftse1801.fbms.service.quanlynhansu.ThongTinChungChiService;

@Controller
@RequestMapping("QuanLyNhanSu/thongTinChungChi")
public class ThongTinChungChiController {
	@Autowired
	private ThongTinChungChiService thongTinChungChiService;
	
	@Autowired
	private HoSoNhanSuService hoSoNhanSuService;
	
	
	@RequestMapping(value="/")
	public String viewList(Model model) {
		List<ThongTinChungChi> list = thongTinChungChiService.getAll();
		model.addAttribute("list", list);
		return "QuanLyNhanSu/thongTinChungChi/list";
	}
	@RequestMapping(value = "/viewOne/{id}", method = RequestMethod.GET)
	public String viewOne(@PathVariable("id") int id, Model model) {
		model.addAttribute("chungChi", thongTinChungChiService.getById(id));
		model.addAttribute("nhanVien", hoSoNhanSuService.getById(id));
		return "QuanLyNhanSu/thongTinChungChi/viewOne";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("chungChi", new ThongTinChungChi());
		return "QuanLyNhanSu/thongTinChungChi/add_form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("chungChi") ThongTinChungChi chungChi,
			final RedirectAttributes redirectAttributes) {
		try {
			thongTinChungChiService.addNew(chungChi);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyNhanSu/thongTinChungChi/";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") int id, Model model) {
		model.addAttribute("chungChi", thongTinChungChiService.getById(id));
		return "QuanLyNhanSu/thongTinChungChi/edit_form";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("chungChi") ThongTinChungChi chungChi,
			final RedirectAttributes redirectAttributes) {
		try {
			thongTinChungChiService.update(chungChi);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyNhanSu/thongTinChungChi/";
	}
}

