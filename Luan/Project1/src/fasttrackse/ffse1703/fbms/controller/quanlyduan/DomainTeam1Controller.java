package fasttrackse.ffse1703.fbms.controller.quanlyduan;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.DomainTeam1;
import fasttrackse.ffse1703.fbms.service.quanlyduan.DomainTeam1Service;
@Controller
@RequestMapping("/qlda/domain")
public class DomainTeam1Controller {
	DomainTeam1Service domainServiceTeam1;

	@Autowired
	public void setDomainService(DomainTeam1Service domainServiceTeam1) {
		this.domainServiceTeam1 = domainServiceTeam1;
	}

	@RequestMapping(value = "/add_form", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("domain", new DomainTeam1());
		return "QuanLyDuAn/Domain/add_form";
	}
	/*@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String createDomain(@ModelAttribute("domain") @Valid Domain domain) {
		
		domainService.add(domain);
		return "redirect:/qlda/domain/list";
	}*/
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("domain") @Valid DomainTeam1 domainTeam1, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (domainServiceTeam1.findById(domainTeam1.getMaNghiepVu()) != null) {
			return "redirect:/qlda/domain/edit_form/" + domainTeam1.getMaNghiepVu();
		} else {
			if (result.hasErrors()) {
				redirectAttributes.addFlashAttribute("message", "<script>alert('Tên Domain đã tồn tại.');</script>");
				return "QuanLyDuAn/Domain/add_form";
			}
			domainServiceTeam1.add(domainTeam1);
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Thêm mới thành công, chúc mừng bạn.');</script>");
		return "redirect:list";
	}
	/*@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listDonNhap(Model model)  {
		model.addAttribute("list", domainServiceTeam1.getAll());
		return "QuanLyDuAn/Domain/list";
	}*/

	/*@RequestMapping("/delete/{maNghiepVu}")
	public String delete(@PathVariable String maNghiepVu, HttpServletRequest request, Model model) {
		domainService.delete(maNghiepVu);
		return "redirect:/qlda/domain/list";
	}*/
	@RequestMapping("/delete/{maNghiepVu}")
	public String delete(@PathVariable String maNghiepVu, HttpServletRequest request, Model model) {
		DomainTeam1 domainTeam1 = domainServiceTeam1.findById(maNghiepVu);
		domainTeam1.setIs_delete("1");
		domainServiceTeam1.delete(domainTeam1);
		return "redirect:/qlda/domain/list";
	}

	@RequestMapping(value = "/edit_form/{maNghiepVu}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable("maNghiepVu") String maNghiepVu) {
		model.addAttribute("domain", domainServiceTeam1.findById(maNghiepVu));
		return "QuanLyDuAn/Domain/edit_form";
	}
	@RequestMapping(value = "/view/{maNghiepVu}", method = RequestMethod.GET)
	public String viewDomain(Model model, @PathVariable("maNghiepVu") String maNghiepVu) {
		model.addAttribute("domain", domainServiceTeam1.findById(maNghiepVu));
		return "QuanLyDuAn/Domain/info";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST )
	public String update(@ModelAttribute("domain") @Valid DomainTeam1 domainTeam1, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/Domain/edit_form";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		domainServiceTeam1.update(domainTeam1);
		return "redirect:/qlda/domain/list";

	}
	@RequestMapping("/list")
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = domainServiceTeam1.getAll().size();
		int recordsPerPage = 4;
		int totalPages = 0;
		if ((totalRecords / recordsPerPage) % 2 == 0) {
			totalPages = totalRecords / recordsPerPage;
		} else {
			totalPages = totalRecords / recordsPerPage + 1;
		}
		int startPosition = recordsPerPage * (currentPage - 1);

		model.addAttribute("list", domainServiceTeam1.findAllForPaging(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);

		return "QuanLyDuAn/Domain/list";
	}


}
