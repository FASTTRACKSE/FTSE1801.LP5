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

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Framework;
import fasttrackse.ftse1801.fbms.service.quanlyduan.FrameworkService;

@Controller
@RequestMapping("/QuanLyDuAn/Framework")
public class FrameworkController {
	@Autowired
	private FrameworkService frameworkService;

	public void setFrameworkService(FrameworkService frameworkService) {
		this.frameworkService = frameworkService;
	}


	@RequestMapping("/list-framework")
	public String listFramework(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIdFr") == null) {
			pageId = 1;
		} else {
			pageId = (int) session.getAttribute("pageIdFr");
		}
		return "redirect: list-framework/"+pageId;
	}
	@RequestMapping(value = "/list-framework/{pageId}", method = RequestMethod.GET)
	public String listPersons(@PathVariable int pageId, Model model,HttpSession session) {
		int maxRows= 5;
		int start = (pageId - 1) * maxRows;
		int totalFramework = frameworkService.countFramework();
		int totalPage = (int) Math.ceil(totalFramework / (double) maxRows);
		if (pageId == 0) {
			pageId = 1;
		}
		
		model.addAttribute("listFramework", this.frameworkService.listFramework(start, maxRows));
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("pageIdFr", pageId);
		return "QuanLyDuAn/Framework/list";
	}

	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new Framework());
		return "QuanLyDuAn/Framework/add_form";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") Framework framework, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		
			//validation form 
		if (result.hasErrors()) {
			return "QuanLyDuAn/Framework/add_form";
		}
		//check trùng nameDomain
		int checkName= frameworkService.checkMaFramework(framework.getMaFramework());
		if(checkName >=1) {
			model.addAttribute("messageName", "Tên Framework đã được sử dụng");
			return "QuanLyDuAn/Framework/add_form";
		}
		int checkMa= frameworkService.checkMaFramework(framework.getMaFramework());
		if(checkMa >=1) {
			model.addAttribute("messageMa", "Mã Framework đã được sử dụng");
			return "QuanLyDuAn/Framework/add_form";
		}

		framework.setIsDelete(1);
		frameworkService.add(framework);
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-framework";
	}

	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable String id) {
		Framework framework = frameworkService.getById(id);
		model.addAttribute("framework", framework);
		return "QuanLyDuAn/Framework/update_form";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("framework") Framework framework, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/Framework/update_form";
		}
		framework.setIsDelete(1);
		System.out.println(framework);
		frameworkService.update(framework);
		return "redirect: /FBMS/QuanLyDuAn/Framework/list-framework";
	}

	@RequestMapping(value = "/delete/{maFramework}")
	public String delete(@PathVariable String maFramework, final RedirectAttributes redirectAttributes) {
		Framework framework = frameworkService.getById(maFramework);
		framework.setIsDelete(0);
		frameworkService.update(framework);
		return "redirect: /FBMS/QuanLyDuAn/Framework/list-framework";
	}
}

