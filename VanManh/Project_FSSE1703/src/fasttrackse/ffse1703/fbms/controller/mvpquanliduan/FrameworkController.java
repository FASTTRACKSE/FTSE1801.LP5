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

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Framework;

import fasttrackse.ffse1703.fbms.service.mvpquanliduan.FrameworkService;

@Controller
@RequestMapping("/mvpquanliduan/framework")
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
		return "MvpQuanLiDuAn/framework/list";
	}

	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new Framework());
		return "MvpQuanLiDuAn/framework/add_form";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") Framework framework, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/framework/add_form";
		}

		framework.setStatus(1);
		frameworkService.add(framework);
		;
		redirectAttributes.addFlashAttribute("success", "<script>alert('Th�m th�nh c�ng');</script>");
		return "redirect: list-framework";
	}

	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable String id) {
		Framework framework = frameworkService.getById(id);
		model.addAttribute("framework", framework);
		return "MvpQuanLiDuAn/framework/update_form";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("framework") Framework framework, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/framework/update_form";
		}
		framework.setStatus(1);
		System.out.println(framework);
		frameworkService.update(framework);
		return "redirect: /ffse-fbms/mvpquanliduan/framework/list-framework";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable String id, final RedirectAttributes redirectAttributes) {
		Framework framework = frameworkService.getById(id);
		framework.setStatus(0);
		frameworkService.update(framework);
		return "redirect: /ffse-fbms/mvpquanliduan/framework/list-framework";
	}
}
