package fasttrackse.ffse1703.fbms.controller.quanlyduan;

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

import fasttrackse.ffse1703.fbms.entity.quanlyduan.FrameworkTeam1;
import fasttrackse.ffse1703.fbms.service.quanlyduan.FrameworkTeam1Service;

@Controller
@RequestMapping("/qlda/Framework")
public class FrameworkTeam1Controller {
	@Autowired
	FrameworkTeam1Service frameworkService;

	@RequestMapping(value = { "/list", "" })
	public String list(Model model) {
		model.addAttribute("list", frameworkService.getAll());
		return "QuanLyDuAn/Framework/list";

	}

	@RequestMapping(value = { "/delete/{ma_framework}" })
	public String delete(Model model, @PathVariable("ma_framework") String ma_framework) {
		frameworkService.delete(ma_framework);
		return "redirect:/qlda/Framework";

	}

	@RequestMapping(value = { "/add_form" })
	public String redirect(Model model) {
		model.addAttribute("framework", new FrameworkTeam1());
		return "QuanLyDuAn/Framework/add_form";
	}

	@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("framework") @Valid FrameworkTeam1 framework, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "QuanLyDuAn/Framework/add_form";
		}
		int checkTen = frameworkService.getName(framework.getTen_framework());
		if (checkTen >= 1) {
			redirectAttributes.addFlashAttribute("message", "<script>alert('Tên Database đã tồn tại.');</script>");
			return "redirect:/qlda/Framework/add_form";
		}

		if (frameworkService.getById(framework.getMa_framework()) != null) {
			FrameworkTeam1 fw = frameworkService.getById(framework.getMa_framework());
			if (fw.getIs_delete() == 1) {
				frameworkService.update(framework);
				return "redirect:list";

			} else {
				redirectAttributes.addFlashAttribute("message", "<script>alert('Mã Database đã tồn tại.');</script>");
				return "redirect:/qlda/Framework/add_form";
			}
		}

		redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");
		frameworkService.save(framework);
		return "redirect:list";
	}

	@RequestMapping(value = "/edit/{ma_framework}")
	public String edit(Model model, @PathVariable("ma_framework") String ma_framework) {
		model.addAttribute("framework", frameworkService.getById(ma_framework));
		return "QuanLyDuAn/Framework/edit_form";

	}

	@RequestMapping(value = "/update")
	public String update(@ModelAttribute("framework") @Valid FrameworkTeam1 frameworkTeam1, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/Framework/edit_form";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		frameworkService.update(frameworkTeam1);
		return "redirect:list";

	}
	 }
