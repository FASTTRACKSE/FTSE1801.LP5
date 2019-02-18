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

import fasttrackse.ftse1801.fbms.entity.quanlyduan.VaiTroThanhVien;
import fasttrackse.ftse1801.fbms.service.quanlyduan.VaiTroThanhVienService;

@Controller
@RequestMapping("/QuanLyDuAn/VaiTro")
public class VaiTroThanhVienController {
	
	@Autowired
	private VaiTroThanhVienService vaiTroThanhVienService;

	public void setVaiTroThanhVienService(VaiTroThanhVienService vaiTroThanhVienService) {
		this.vaiTroThanhVienService = vaiTroThanhVienService;
	}
	@RequestMapping("/list-vaiTro")
	public String listVaiTro(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIdVt") == null) {
			pageId = 1;
		} else {
			pageId = (int) session.getAttribute("pageIdVt");
		}
		return "redirect: list-vaiTro/"+pageId;
	}
	@RequestMapping(value = "/list-vaiTro/{pageId}", method = RequestMethod.GET)
	public String listVaiTro(@PathVariable int pageId, Model model,HttpSession session) {
		int maxRows= 3;
		int start = (pageId - 1) * maxRows;
		int totalVaiTro = vaiTroThanhVienService.countVaiTro();
		int totalPage = (int) Math.ceil(totalVaiTro / (double) maxRows);
		if (pageId == 0) {
			pageId = 1;
		}
		
		model.addAttribute("listVaiTro", this.vaiTroThanhVienService.listVaiTro(start, maxRows));
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("pageIdVt", pageId);
		return "QuanLyDuAn/VaiTro/list";
	}
	
	
	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new VaiTroThanhVien());
		return "QuanLyDuAn/VaiTro/add_form";
	}
	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") VaiTroThanhVien vaiTroThanhVien, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/VaiTro/add_form";
		}
		int checkTen = vaiTroThanhVienService.checkTenVaiTro(vaiTroThanhVien.getTenVaiTro());
		if(checkTen >= 1) {
			model.addAttribute("messageMa", "Tên vai trò đã được sử dụng");
			return "QuanLyDuAn/VaiTro/add_form";
		}
		
		vaiTroThanhVien.setIsDelete(1);
		vaiTroThanhVienService.add(vaiTroThanhVien);
		;
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-vaiTro";
	}

	
	@RequestMapping(value = "/show-form-edit/{maVaiTro}")
	public String showFormEdit(Model model, @PathVariable String maVaiTro) {
		VaiTroThanhVien vaiTroThanhVien = vaiTroThanhVienService.findById(maVaiTro);
		model.addAttribute("vaiTro", vaiTroThanhVien);
		return "QuanLyDuAn/VaiTro/update_form";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("vaiTro") VaiTroThanhVien vaiTroThanhVien, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/VaiTro/update_form";
		}
		vaiTroThanhVien.setIsDelete(1);
		vaiTroThanhVienService.update(vaiTroThanhVien);
		return "redirect: /FBMS/QuanLyDuAn/VaiTro/list-vaiTro";
	}

	
	@RequestMapping(value = "/delete/{maVaiTro}")
	public String delete(@PathVariable String maVaiTro, final RedirectAttributes redirectAttributes) {
		VaiTroThanhVien vaiTroThanhVien = vaiTroThanhVienService.findById(maVaiTro);
		vaiTroThanhVien.setIsDelete(0);
		vaiTroThanhVienService.update(vaiTroThanhVien);
		return "redirect: /FBMS/QuanLyDuAn/VaiTro/list-vaiTro";
	}

}
