package fasttrackse.ffse1703.fbms.controller.mvpquanliduan;

import java.util.List;

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

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.KhachHang;

import fasttrackse.ffse1703.fbms.service.mvpquanliduan.KhachHangService;

@Controller
@RequestMapping("/mvpquanliduan/khachhang")
public class KhachHangController {
	@Autowired
	private KhachHangService khachHangService;

	public void setKhachHangService(KhachHangService khachHangService) {
		this.khachHangService = khachHangService;
	}


	@RequestMapping("/list-khachhang")
	public String listKhachHang(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIdKh") == null) {
			pageId = 1;
		} else {
			pageId = (int) session.getAttribute("pageIdKh");
		}
		return "redirect: list-khachhang/"+pageId;
	}
	@RequestMapping(value = "/list-khachhang/{pageId}", method = RequestMethod.GET)
	public String listPersons(@PathVariable int pageId, Model model,HttpSession session) {
		int maxRows= 5;
		int start = (pageId - 1) * maxRows;
		int totalKhachHang = khachHangService.countKhachHang();
		int totalPage = (int) Math.ceil(totalKhachHang / (double) maxRows);
		if (pageId == 0) {
			pageId = 1;
		}
		
		model.addAttribute("listKhachHang", this.khachHangService.listKhachHang(start, maxRows));
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("pageIdKh", pageId);
		return "MvpQuanLiDuAn/khachhang/list";
	}

	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new KhachHang());
		return "MvpQuanLiDuAn/khachhang/add_form";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") KhachHang khachHang, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/khachhang/add_form";
		}
		int checkMa=khachHangService.checkIdKhachHang(khachHang.getIdKhachHang());
		if(checkMa >=1) {
			model.addAttribute("messageMa", "Mã khách hàng đã được sử dụng");
			return "MvpQuanLiDuAn/khachhang/add_form";
		}
		
		khachHang.setStatus(1);
		khachHangService.add(khachHang);
		;
		redirectAttributes.addFlashAttribute("success", "<script>alert('Th�m th�nh c�ng');</script>");
		return "redirect: list-khachhang";
	}

	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable String id) {
		KhachHang khachHang = khachHangService.getById(id);
		model.addAttribute("khachHang", khachHang);
		return "MvpQuanLiDuAn/khachhang/update_form";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/khachhang/update_form";
		}
		khachHang.setStatus(1);
		khachHangService.update(khachHang);
		return "redirect: /ffse-fbms/mvpquanliduan/khachhang/list-khachhang";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable String id, final RedirectAttributes redirectAttributes) {
		KhachHang khachHang = khachHangService.getById(id);
		khachHang.setStatus(0);
		khachHangService.update(khachHang);
		return "redirect: /ffse-fbms/mvpquanliduan/khachhang/list-khachhang";
	}
}
