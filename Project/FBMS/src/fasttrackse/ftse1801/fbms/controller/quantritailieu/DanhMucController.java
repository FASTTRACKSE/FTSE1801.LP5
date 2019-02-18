package fasttrackse.ftse1801.fbms.controller.quantritailieu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftse1801.fbms.entity.quantritailieu.DanhMucTaiLieu;
import fasttrackse.ftse1801.fbms.service.quantritailieu.DanhMucService;

@Controller
@RequestMapping(value = "QuanTriTaiLieu/danh_muc")
public class DanhMucController {
	@Autowired
	private DanhMucService danhMucService;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getListDanhMuc(Model model) {
		int record = 1;
		int pages = danhMucService.getAllDanhMuc().size()/record;
		int end = 3;
		int start = 1;
		if (pages < 3) {
			start = 1;
			end = pages;
		}
		model.addAttribute("pages", pages);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("page", 1);
		List<DanhMucTaiLieu> list = danhMucService.getAllDanhMuc(0, record);
		return new ModelAndView("QuanTriTaiLieu/danhmuc/list", "listDM", list);
	}
	@RequestMapping(value="/{page}",method=RequestMethod.GET)
	public ModelAndView getListDanhMuc1(@PathVariable int page, Model model) {
		int record = 1;
		int pages = danhMucService.getAllDanhMuc().size()/record + (danhMucService.getAllDanhMuc().size() % record == 0 ? 0 : 1);
		int end = 3;
		int start = 1;
		if (page <= 0) {
			page = 1;
		} else if (page > pages) {
			page = 1;
		} else if (page == pages) {
			start = pages - 2;
			end = pages;
		} else if (page == 1) {
			start = 1;
			end = 3;
		} else {
			start = page - 1;
			end = page + 1;
		}
		if (pages < 3) {
			start = 1;
			end = pages;
		}
		model.addAttribute("pages", pages);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("page", page);
		List<DanhMucTaiLieu> list = danhMucService.getAllDanhMuc((page-1)*record, record);
		return new ModelAndView("QuanTriTaiLieu/danhmuc/list", "listDM", list);
	}

	@RequestMapping(value = "/add")
	public ModelAndView addDanhmuc(Model model) {
		return new ModelAndView("QuanTriTaiLieu/danhmuc/addDM", "danhMuc", new DanhMucTaiLieu());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView doAddDanhMuc(@ModelAttribute("danhMuc") DanhMucTaiLieu dm,
			final RedirectAttributes redirectAttributes) {
		try {
			danhMucService.insertDanhMuc(dm);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return new ModelAndView("redirect:/QuanTriTaiLieu/danh_muc/");
	}

	@RequestMapping(value = "/edit/{maDanhMuc}")
	public ModelAndView editFormDM(@PathVariable String maDanhMuc) {
		return new ModelAndView("QuanTriTaiLieu/danhmuc/editDM", "danhMuc", danhMucService.getDanhMucByMa(maDanhMuc));
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView doEdit(@ModelAttribute("danhMuc") DanhMucTaiLieu dm,
			final RedirectAttributes redirectAttributes) {
		try {
			danhMucService.updateDanhMuc(dm);
			redirectAttributes.addFlashAttribute("messageSuccess", "thay đổi thông tin thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return new ModelAndView("redirect:/QuanTriTaiLieu/danh_muc/");
	}
	@RequestMapping(value="/delete/{maDanhMuc}",method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable String maDanhMuc,final RedirectAttributes redirectAttributes) {
		try {
			DanhMucTaiLieu dm  = danhMucService.getDanhMucByMa(maDanhMuc);
			dm.setIsDelete(Integer.parseInt("1"));
			danhMucService.updateDanhMuc(dm);
			redirectAttributes.addFlashAttribute("messageSuccess", "xóa thông tin thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return new ModelAndView("redirect:/QuanTriTaiLieu/danh_muc/");
	}
}
