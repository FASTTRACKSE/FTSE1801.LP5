package fasttrackse.ftse1801.fbms.controller.quantritailieu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftse1801.fbms.entity.quantritailieu.TrangThaiTaiLieu;
import fasttrackse.ftse1801.fbms.service.quantritailieu.TrangThaiService;

@Controller
@RequestMapping(value="QuanTriTaiLieu/trang_thai")
public class TrangThaiTLieuController {
	@Autowired
private TrangThaiService trangThaiService;
	@RequestMapping(value="/")
	public ModelAndView getListTrangThaiDel0(Model model) {
		List<TrangThaiTaiLieu> listTT = trangThaiService.getAllTrangThaiDel0();
		return new ModelAndView("QuanTriTaiLieu/trangthai/list","listTT",listTT);
	}
	@RequestMapping(value="/addTT")
	public ModelAndView addTT(Model model) {
		return new ModelAndView("QuanTriTaiLieu/trangthai/add_tt","trangThai",new TrangThaiTaiLieu());
	}
	@RequestMapping(value="/addTT",method=RequestMethod.POST)
	public ModelAndView doAddTT(@ModelAttribute("trangThai") TrangThaiTaiLieu trangThai, final RedirectAttributes redirectAttributes) {
		try {
			trangThaiService.insertTrangThai(trangThai);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return new ModelAndView("redirect:/QuanTriTaiLieu/trang_thai/");
	}
	@RequestMapping(value="/editTT/{maTrangThai}")
	public ModelAndView editTT(@PathVariable String maTrangThai) {
		return new ModelAndView("QuanTriTaiLieu/trangthai/edit_tt","trangThai",trangThaiService.getTrangThaibyMa(maTrangThai));
	}
	@RequestMapping(value="/editTT",method=RequestMethod.POST)
	public ModelAndView doEditTT(@ModelAttribute("trangThai") TrangThaiTaiLieu trangThai,final RedirectAttributes redirectAttributes) {
		try {
			trangThaiService.updateTrangThai(trangThai);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm đổi thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return new ModelAndView("redirect:/QuanTriTaiLieu/trang_thai/");
	}
	@RequestMapping(value="/deleteTT/{maTrangThai}",method= RequestMethod.GET)
	public ModelAndView deleteTT(@PathVariable String maTrangThai,final RedirectAttributes redirectAttributes) {
		try {
			if(maTrangThai.equalsIgnoreCase("Draft")) {
				redirectAttributes.addFlashAttribute("messageError", "Trạng thái cơ bản không thể xóa");
				return new ModelAndView("redirect:/QuanTriTaiLieu/trang_thai/");
			}else if (maTrangThai.equalsIgnoreCase("Approved")) {
				redirectAttributes.addFlashAttribute("messageError", "Trạng thái cơ bản không thể xóa");
				return new ModelAndView("redirect:/QuanTriTaiLieu/trang_thai/");
			}else if (maTrangThai.equalsIgnoreCase("Wait")) {
				redirectAttributes.addFlashAttribute("messageError", "Trạng thái cơ bản không thể xóa");
				return new ModelAndView("redirect:/QuanTriTaiLieu/trang_thai/");
			}else {
				trangThaiService.deleteTrangThai(maTrangThai);
				return new ModelAndView("redirect:/QuanTriTaiLieu/trang_thai/");
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return new ModelAndView("redirect:/QuanTriTaiLieu/trang_thai/");
	}
}
