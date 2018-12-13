package fasttrackse.ftse1801.fbms.controller.quanlyduan;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.KhachHang;
import fasttrackse.ftse1801.fbms.service.quanlyduan.KhachHangService;

@Controller
@RequestMapping("/QuanLyDuAn/KhachHang")
public class KhachHangController {
	
	@Autowired
	private KhachHangService khachHangService;

	public void setContactService(KhachHangService khachHangService) {
		this.khachHangService = khachHangService;
	}


	@RequestMapping("/list-khachHang")
	public String listContact(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIdKh") == null) {
			pageId = 1;
		} else {
			pageId = (int) session.getAttribute("pageIdKh");
		}
		return "redirect: list-khachHang/"+pageId;
	}
	@RequestMapping(value = "/list-khachHang/{pageId}", method = RequestMethod.GET)
	public String listPersons(@PathVariable int pageId, Model model,HttpSession session) {
		int maxRows= 3;
		int start = (pageId - 1) * maxRows;
		int totalKh = khachHangService.countKhachHang();
		int totalPage = (int) Math.ceil(totalKh / (double) maxRows);
		if (pageId == 0) {
			pageId = 1;
		}
		
		model.addAttribute("listKh", this.khachHangService.listKh(start, maxRows));
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("pageIdKh", pageId);
		return "QuanLyDuAn/KhachHang/list";
	}
	
	
	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new KhachHang());
		return "QuanLyDuAn/KhachHang/add_form";
	}
	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") KhachHang khachHang, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/KhachHang/add_form";
		}
		int checkMa = khachHangService.checkMaKhachHang(khachHang.getMaKh());
		if(checkMa >= 1) {
			model.addAttribute("messageMa", "Mã khách hàng đã được sử dụng");
			return "QuanLyDuAn/KhachHang/add_form";
		}
		
		khachHang.setIsDelete(1);
		khachHangService.add(khachHang);
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-khachHang";
	}

	
	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable String id) {
		KhachHang khachHang = khachHangService.getById(id);
		model.addAttribute("khachHang", khachHang);
		return "QuanLyDuAn/KhachHang/update_form";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/KhachHang/update_form";
		}
		khachHang.setIsDelete(1);
		khachHangService.update(khachHang);
		return "redirect: /FBMS/QuanLyDuAn/KhachHang/list-khachHang";
	}

	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable String id, final RedirectAttributes redirectAttributes) {
		KhachHang khachHang = khachHangService.getById(id);
		khachHang.setIsDelete(0);
		khachHangService.update(khachHang);
		return "redirect: /FBMS/QuanLyDuAn/KhachHang/list-khachHang";
	}

}
