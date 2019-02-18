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

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HopDong;
import fasttrackse.ftse1801.fbms.service.quanlynhansu.HopDongService;

@Controller
@RequestMapping("QuanLyNhanSu/hopDong")
public class HopDongController {
	@Autowired
	private HopDongService hopDongService;
	
	@RequestMapping(value="/")
	public String viewHoSoNhanVien(Model model) {
		List<HopDong> list = hopDongService.getAll();
		model.addAttribute("list", list);
		return "QuanLyNhanSu/hopDong/list";
	}
	
	@RequestMapping(value = "/viewOne/{maHopDong}", method = RequestMethod.GET)
	public String viewOne(@PathVariable("maHopDong") int maHopDong, Model model) {
		model.addAttribute("hopDong", hopDongService.getById(maHopDong));
		return "QuanLyNhanSu/hopDong/viewOne";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("hopDong", new HopDong());
		return "QuanLyNhanSu/hopDong/add_form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("hopDong") HopDong hopDong,
			final RedirectAttributes redirectAttributes) {
		try {
			hopDongService.addNew(hopDong);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyNhanSu/hopDong/";
	}
	
	@RequestMapping(value = "/edit/{maHopDong}", method = RequestMethod.GET)
	public String editForm(@PathVariable("maHopDong") int maHopDong, Model model) {
		model.addAttribute("hopDong", hopDongService.getById(maHopDong));
		return "QuanLyNhanSu/hopDong/edit_form";
	}

	@RequestMapping(value = "/edit/{maHopDong}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("maHopDong") HopDong hopDong,
			final RedirectAttributes redirectAttributes) {
		try {
			hopDongService.update(hopDong);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyNhanSu/hopDong/";
	}
	
	@RequestMapping(value = "/delete/{maHopDong}", method = RequestMethod.GET)
	public String delete(@PathVariable("maHopDong") int maHopDong, final RedirectAttributes redirectAttributes) {
		try {
			HopDong hopDong = hopDongService.getById(maHopDong);
			hopDong.setIsdelete(1);
			hopDongService.update(hopDong);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại");
		}
		return "redirect:/QuanLyNhanSu/hopDong/";
	}
}
