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


import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Vendor;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.VendorService;

@Controller
@RequestMapping("/mvpquanliduan/vendor")
public class VendorController {
	@Autowired
	private VendorService vendorService;
	
	public void setVendorService(VendorService vendorService) {
		this.vendorService = vendorService;
	}
	@RequestMapping("/list-vendor")
	public String listVendor(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIdVd") == null) {
			pageId = 1;
		} else {
			pageId = (int) session.getAttribute("pageIdVd");
		}
		return "redirect: list-vendor/"+pageId;
	}
	@RequestMapping(value = "/list-vendor/{pageId}", method = RequestMethod.GET)
	public String listPersons(@PathVariable int pageId, Model model,HttpSession session) {
		int maxRows= 5;
		int start = (pageId - 1) * maxRows;
		int totalVendor = vendorService.countVendor();
		int totalPage = (int) Math.ceil(totalVendor / (double) maxRows);
		if (pageId == 0) {
			pageId = 1;
		}
		model.addAttribute("listVendor", this.vendorService.listVendor(start, maxRows));
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("pageIdVd", pageId);
		return "MvpQuanLiDuAn/vendor/listvendor";
	}
	@RequestMapping(value= "/show-form-add")
	public String showAdd(Model model) {
		model.addAttribute("command", new Vendor());
		return "MvpQuanLiDuAn/vendor/addvendor";
	}
	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") Vendor vendor, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		
		//validation form 
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/vendor/addvendor";
		}
		//check trùng namevendor
		int checkName= vendorService.checkVendor(vendor.getIdVendor());
		if(checkName >=1) {
			model.addAttribute("messageName", "Mã nhà cung cấp đã được sử dụng");
			return "MvpQuanLiDuAn/vendor/addvendor";
		}
	
		vendor.setStatus(1);
		vendorService.addNew(vendor);
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-vendor";
	}

	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable String id) {
		Vendor dm = vendorService.findById(id);
		
		model.addAttribute("vendor", dm);
		return "MvpQuanLiDuAn/vendor/updatevendor";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("Vendor") Vendor vendor, BindingResult result,
			final RedirectAttributes redirectAttributes,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("vendor", vendor);
			return "MvpQuanLiDuAn/vendor/updatevendor";
		}
		vendor.setStatus(1);
		vendorService.update(vendor);
		return "redirect: list-vendor";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable String id, final RedirectAttributes redirectAttributes) {
		Vendor dm = vendorService.findById(id);
		dm.setStatus(0);
		vendorService.update(dm);
		return "redirect: /ffse-fbms/mvpquanliduan/vendor/list-vendor";
	}
	
}