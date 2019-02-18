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

import fasttrackse.ftse1801.fbms.entity.quanlyduan.NgonNgu;
import fasttrackse.ftse1801.fbms.service.quanlyduan.NgonNguService;

@Controller
@RequestMapping("/QuanLyDuAn/NgonNgu")
public class NgonNguController {
	@Autowired
	private NgonNguService ngonNguService;
	
	public NgonNguService getNgonNguService() {
		return ngonNguService;
	}
	public void setNgonNguService(NgonNguService ngonNguService) {
		this.ngonNguService = ngonNguService;
	}
	@RequestMapping("/list-ngonNgu")
	public String listNgonNgu(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIdLg") == null) {
			pageId = 1;
		} else {
			pageId = (int) session.getAttribute("pageIdLg");
		}
		return "redirect: list-ngonNgu/"+pageId;
	}
	@RequestMapping(value = "/list-ngonNgu/{pageId}", method = RequestMethod.GET)
	public String listPersons(@PathVariable int pageId, Model model,HttpSession session) {
		int maxRows= 5;
		int start = (pageId - 1) * maxRows;
		int totalLanguage = ngonNguService.countLanguage();
		int totalPage = (int) Math.ceil(totalLanguage / (double) maxRows);
		if (pageId == 0) {
			pageId = 1;
		}
		
		model.addAttribute("listNgonNgu", this.ngonNguService.listNgonNgu(start, maxRows));
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("pageIdLg", pageId);
		return "QuanLyDuAn/NgonNgu/list";
	}
	
	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new NgonNgu());
		return "QuanLyDuAn/NgonNgu/add_form";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") NgonNgu ngonNgu, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			return  "QuanLyDuAn/NgonNgu/add_form";
		}
		int checkMa = ngonNguService.checkMa(ngonNgu.getMaNgonNgu());
		if(checkMa >=1) {
			model.addAttribute("messageMa", "Mã ngôn ngữ đã được sử dụng");
			return  "QuanLyDuAn/NgonNgu/add_form";
		}
		int checkName=ngonNguService.checkName(ngonNgu.getTenNgonNgu());
		if(checkName >=1) {
			model.addAttribute("messageName", "Tên ngôn ngữ đã được sử dụng");
			return  "QuanLyDuAn/NgonNgu/add_form";
		}
		
		ngonNgu.setIsDelete(1);
		ngonNguService.add(ngonNgu);
		
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-ngonNgu";
	}
	@RequestMapping(value = "/show-form-edit/{maNgonNgu}")
	public String showFormEdit(Model model, @PathVariable String maNgonNgu) {
		NgonNgu ngonNgu= ngonNguService.getById(maNgonNgu);
		model.addAttribute("ngonNgu", ngonNgu);
		return "QuanLyDuAn/NgonNgu/update_form";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("ngonNgu") NgonNgu ngonNgu, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/NgonNgu/update_form";
		}
		ngonNgu.setIsDelete(1);
		ngonNguService.update(ngonNgu);
		return "redirect: /FBMS/QuanLyDuAn/NgonNgu/list-ngonNgu";
	}

	@RequestMapping(value = "/delete/{maNgonNgu}")
	public String delete(@PathVariable String maNgonNgu, final RedirectAttributes redirectAttributes) {
		NgonNgu ngonNgu = ngonNguService.getById(maNgonNgu);
		ngonNgu.setIsDelete(0);
		ngonNguService.update(ngonNgu);
		return "redirect: /FBMS/QuanLyDuAn/NgonNgu/list-ngonNgu";
	}
}
