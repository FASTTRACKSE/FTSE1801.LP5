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


import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.StatusProject;

import fasttrackse.ffse1703.fbms.service.mvpquanliduan.StatusService;

@Controller
@RequestMapping("/mvpquanliduan/status")
public class StatusController {
	@Autowired
	private StatusService statusService;
	

	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}

	@RequestMapping("/list-status")
	public String listStatus(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIdSt") == null) {
			pageId = 1;
		} else {
			pageId = (int) session.getAttribute("pageIdSt");
		}
		return "redirect: list-status/"+pageId;
	}
	@RequestMapping(value = "/list-status/{pageId}", method = RequestMethod.GET)
	public String listPersons(@PathVariable int pageId, Model model,HttpSession session) {
		int maxRows= 5;
		int start = (pageId - 1) * maxRows;
		int totalStatus = statusService.countStatusProject();
		int totalPage = (int) Math.ceil(totalStatus / (double) maxRows);
		if (pageId == 0) {
			pageId = 1;
		}
		model.addAttribute("listStatus", this.statusService.listStatusProject(start, maxRows));
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("pageIdSt", pageId);
		return "MvpQuanLiDuAn/statuss/liststatus";
	}
	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new StatusProject());
		return "MvpQuanLiDuAn/statuss/addstatus";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") StatusProject status, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		
		//validation form 
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/statuss/addstatus";
		}
		//check trùng namestatus
		int checkName= statusService.checkNameStatus(status.getNameStatus());
		if(checkName >=1) {
			model.addAttribute("messageName", "Tên status đã được sử dụng");
			return "MvpQuanLiDuAn/statuss/addstatus";
		}
		
		status.setStatus(1);
		statusService.addNew(status);
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-status";
	}

	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable int id) {
		StatusProject dm = statusService.findById(id);
		model.addAttribute("status", dm);
		return "MvpQuanLiDuAn/statuss/updatestatus";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("Status") StatusProject status, BindingResult result,
			final RedirectAttributes redirectAttributes,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("status", status);
			return "MvpQuanLiDuAn/statuss/updatestatus";
		}
		status.setStatus(1);
		statusService.update(status);
		return "redirect: list-status";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable int id, final RedirectAttributes redirectAttributes) {
		StatusProject dm = statusService.findById(id);
		dm.setStatus(0);
		statusService.update(dm);
		return "redirect: /ffse-fbms/mvpquanliduan/status/list-status";
	}
}
