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

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Roles;

import fasttrackse.ffse1703.fbms.service.mvpquanliduan.RolesService;

@Controller
@RequestMapping("/mvpquanliduan/roles")
public class RolesController {
	@Autowired
	private RolesService rolesService;
	

	public void setRolesService(RolesService rolesService) {
		this.rolesService = rolesService;
	}

	@RequestMapping("/list-roles")
	public String listRoles(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIdRl") == null) {
			pageId = 1;
		} else {
			pageId = (int) session.getAttribute("pageIdRl");
		}
		return "redirect: list-roles/"+pageId;
	}
	@RequestMapping(value = "/list-roles/{pageId}", method = RequestMethod.GET)
	public String listPersons(@PathVariable int pageId, Model model,HttpSession session) {
		int maxRows= 5;
		int start = (pageId - 1) * maxRows;
		int totalRoles = rolesService.countRoles();
		int totalPage = (int) Math.ceil(totalRoles / (double) maxRows);
		if (pageId == 0) {
			pageId = 1;
		}
		model.addAttribute("listRoles", this.rolesService.listRoles(start, maxRows));
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("pageIdRl", pageId);
		return "MvpQuanLiDuAn/roles/listroles";
	}
	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new Roles());
		return "MvpQuanLiDuAn/roles/addroles";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") Roles roles, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		
		//validation form 
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/roles/addroles";
		}
		//check trùng nameroles
		int checkName= rolesService.checkNameRoles(roles.getNameRoles());
		if(checkName >=1) {
			model.addAttribute("messageName", "Tên vai trò đã được sử dụng");
			return "MvpQuanLiDuAn/roles/addroles";
		}
		
		roles.setStatus(1);
		rolesService.addNew(roles);
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-roles";
	}

	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable int id) {
		Roles dm = rolesService.findById(id);
		model.addAttribute("roles", dm);
		return "MvpQuanLiDuAn/roles/updateroles";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("Roles") Roles roles, BindingResult result,
			final RedirectAttributes redirectAttributes,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("roles", roles);
			return "MvpQuanLiDuAn/roles/updateroles";
		}
		roles.setStatus(1);
		rolesService.update(roles);
		return "redirect: list-roles";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable int id, final RedirectAttributes redirectAttributes) {
		Roles dm = rolesService.findById(id);
		dm.setStatus(0);
		rolesService.update(dm);
		return "redirect: /ffse-fbms/mvpquanliduan/roles/list-roles";
	}
}
