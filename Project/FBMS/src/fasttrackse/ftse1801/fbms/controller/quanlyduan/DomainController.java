package fasttrackse.ftse1801.fbms.controller.quanlyduan;

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

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Domain;
import fasttrackse.ftse1801.fbms.service.quanlyduan.DomainService;

@Controller
@RequestMapping("/QuanLyDuAn/Domain")
public class DomainController {
	@Autowired
	private DomainService domainService;
	

	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	@RequestMapping("/list-domain")
	public String listDomain(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIdDm") == null) {
			pageId = 1;
		} else {
			pageId = (int) session.getAttribute("pageIdDm");
		}
		return "redirect: list-domain/"+pageId;
	}
	
	@RequestMapping(value = "/list-domain/{pageId}", method = RequestMethod.GET)
	public String listPersons(@PathVariable int pageId, Model model,HttpSession session) {
		int maxRows= 5;
		int start = (pageId - 1) * maxRows;
		List<Domain> list = this.domainService.listDomain(start, maxRows);
		int totalDomain =this.domainService.countDomain();
		int totalPage = (int) Math.ceil(totalDomain / (double) maxRows);
		if (pageId == 0) {
			pageId = 1;
		}
		
		model.addAttribute("listDomain", list );
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("pageIdDm", pageId);
		return "QuanLyDuAn/Domain/listdomain";
	}

	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new Domain());
		return "QuanLyDuAn/Domain/adddomain";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") Domain domain, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		
		//validation form 
		if (result.hasErrors()) {
			return "QuanLyDuAn/Domain/adddomain";
		}
		//check trùng nameDomain
		int checkName= domainService.checkNameDomain(domain.getTenDomain());
		if(checkName >=1) {
			model.addAttribute("messageName", "Tên Nghiệp vụ đã được sử dụng");
			return "QuanLyDuAn/Domain/adddomain";
		}
		int checkMa= domainService.checkMaDomain(domain.getMaDomain());
		if(checkMa >=1) {
			model.addAttribute("messageMa", "Mã Nghiệp vụ đã được sử dụng");
			return "QuanLyDuAn/Domain/adddomain";
		}
		domain.setIsDelete(1);
		domainService.addNew(domain);
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-domain";
	}

	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable String id) {
		Domain dm = domainService.findById(id);
		model.addAttribute("domain", dm);
		return "QuanLyDuAn/Domain/updatedomain";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("Domain") Domain domain, BindingResult result,
			final RedirectAttributes redirectAttributes,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("domain", domain);
			return "QuanLyDuAn/Domain/updatedomain";
		}
		domain.setIsDelete(1);;
		domainService.update(domain);
		return "redirect: list-domain";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable String id, final RedirectAttributes redirectAttributes) {
		Domain dm = domainService.findById(id);
		dm.setIsDelete(0);
		domainService.update(dm);
		return "redirect: /FBMS/QuanLyDuAn/Domain/list-domain";
	}
}