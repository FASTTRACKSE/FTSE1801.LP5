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
import fasttrackse.ffse1703.fbms.entity.quanlyduan.TrangThaiTeam1;
import fasttrackse.ffse1703.fbms.service.quanlyduan.TrangThaiTeam1Service;

@Controller
@RequestMapping("/qlda/trangthai")
public class TrangThaiTeam1Controller {
	TrangThaiTeam1Service trangthaiServiceTeam1;

	@Autowired
	public void setTrangThaiService(TrangThaiTeam1Service trangthaiServiceTeam1) {
		this.trangthaiServiceTeam1 = trangthaiServiceTeam1;
	}

	@RequestMapping(value = "/add_form", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("trangthai", new TrangThaiTeam1());
		return "QuanLyDuAn/TrangThai/add_form";
	}

	/*
	 * @RequestMapping(value = "/save", method = RequestMethod.POST) public String
	 * createDomain(@ModelAttribute("domain") @Valid Domain domain) {
	 * 
	 * domainService.add(domain); return "redirect:/qlda/domain/list"; }
	 */
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("trangthai") @Valid TrangThaiTeam1 trangthaiTeam1, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (trangthaiServiceTeam1.findById(trangthaiTeam1.getMaTrangThai()) != null) {
			return "redirect:/qlda/trangthai/edit_form/" + trangthaiTeam1.getMaTrangThai();
		} else {
			if (result.hasErrors()) {
				return "QuanLyDuAn/TrangThai/add_form";
			}
			trangthaiServiceTeam1.add(trangthaiTeam1);
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");
		return "redirect:list";
	}
/*
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listDonNhap(Model model) {
		model.addAttribute("list", trangthaiServiceTeam1.getAll());
		return "QuanLyDuAn/TrangThai/list";
	}*/

	/*
	 * @RequestMapping("/delete/{maNghiepVu}") public String delete(@PathVariable
	 * String maNghiepVu, HttpServletRequest request, Model model) {
	 * domainService.delete(maNghiepVu); return "redirect:/qlda/domain/list"; }
	 */
	@RequestMapping("/delete/{maTrangThai}")
	public String delete(@PathVariable String maTrangThai, HttpServletRequest request, Model model) {
		TrangThaiTeam1 trangthaiTeam1 = trangthaiServiceTeam1.findById(maTrangThai);
		trangthaiTeam1.setIs_delete("1");
		trangthaiServiceTeam1.delete(trangthaiTeam1);
		return "redirect:/qlda/trangthai/list";
	}

	@RequestMapping(value = "/edit_form/{maTrangThai}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable("maTrangThai") String maTrangThai) {
		model.addAttribute("trangthai", trangthaiServiceTeam1.findById(maTrangThai));
		return "QuanLyDuAn/TrangThai/edit_form";
	}

	@RequestMapping(value = "/view/{maTrangThai}", method = RequestMethod.GET)
	public String viewTrangThai(Model model, @PathVariable("maTrangThai") String maTrangThai) {
		model.addAttribute("trangthai", trangthaiServiceTeam1.findById(maTrangThai));
		return "QuanLyDuAn/TrangThai/info";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("trangthai") @Valid TrangThaiTeam1 trangthaiTeam1, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/TrangThai/edit_form";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		trangthaiServiceTeam1.update(trangthaiTeam1);
		return "redirect:/qlda/trangthai/list";

	}

	@RequestMapping("/list")
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = trangthaiServiceTeam1.getAll().size();
		int recordsPerPage = 4;
		int totalPages = 0;
		if ((totalRecords / recordsPerPage) % 2 == 0) {
			totalPages = totalRecords / recordsPerPage;
		} else {
			totalPages = totalRecords / recordsPerPage + 1;
		}
		int startPosition = recordsPerPage * (currentPage - 1);

		model.addAttribute("list", trangthaiServiceTeam1.findAllForPaging(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);

		return "QuanLyDuAn/TrangThai/list";
	}


}
