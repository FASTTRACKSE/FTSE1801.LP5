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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.VendorTeam1;
import fasttrackse.ffse1703.fbms.service.quanlyduan.VendorTeam1Service;



@Controller
@RequestMapping("/QuanLyDuAn/vendor")
public class VendorTeam1Controller {
	@Autowired
	VendorTeam1Service vendorServiceTeam1;
	

	
	@RequestMapping("/list")
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = vendorServiceTeam1.getAll().size();
		int recordsPerPage = 4;
		int totalPages = 0;
		if ((totalRecords / recordsPerPage) % 2 == 0) {
			totalPages = totalRecords / recordsPerPage;
		} else {
			totalPages = totalRecords / recordsPerPage + 1;
		}
		int startPosition = recordsPerPage * (currentPage - 1);

		model.addAttribute("list", vendorServiceTeam1.findAllForPaging(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);

		return "QuanLyDuAn/Vendor/list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("vendor", new VendorTeam1());
		return "QuanLyDuAn/Vendor/addVendor";
	}
	
	@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("vendor") @Valid VendorTeam1 vendor1, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "QuanLyDuAn/Vendor/addVendor";
		}

		if (vendorServiceTeam1.getById(vendor1.getMavd()) != null) {
			VendorTeam1 db = vendorServiceTeam1.getById(vendor1.getMavd());
			if (db.getIs_delete() == 1) {
				vendorServiceTeam1.update(vendor1);
				return "redirect:list";

			} else {
				redirectAttributes.addFlashAttribute("message", "<script>alert('Mã Vendor Đã Tồn Tại.');</script>");
				return "redirect:/QuanLyDuAn/vendor/add";
			}
		}
		
		redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");
		vendorServiceTeam1.addNew(vendor1);
		return "redirect:list";
	}
	@RequestMapping(value = "/edit/{mavd}")
	public String edit(Model model, @PathVariable("mavd") String mavd) {
		model.addAttribute("vendor", vendorServiceTeam1.getById(mavd));
		return "QuanLyDuAn/Vendor/editVendor";

	}
	
	@RequestMapping(value = "/update")
	public String update(@ModelAttribute("vendor") @Valid VendorTeam1 vendorTeam1, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/Vendor/editVendor";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		vendorServiceTeam1.update(vendorTeam1);
		return "redirect:list";

	}
	@RequestMapping(value = { "/delete/{mavd}" })
	public String delete(Model model, @PathVariable("mavd") String mavd) {
		vendorServiceTeam1.delete(mavd);
		return "redirect:/QuanLyDuAn/vendor";

	}
	
}
