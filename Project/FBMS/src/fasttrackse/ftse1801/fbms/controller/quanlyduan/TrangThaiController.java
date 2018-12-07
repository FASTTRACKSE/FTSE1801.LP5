package fasttrackse.ftse1801.fbms.controller.quanlyduan;

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

import fasttrackse.ftse1801.fbms.entity.quanlyduan.TrangThai;
import fasttrackse.ftse1801.fbms.service.quanlyduan.TrangThaiService;

@Controller
@RequestMapping("/QuanLyDuAn/TrangThai")
public class TrangThaiController {
	
	@Autowired
	private TrangThaiService trangThaiService;

	public void setTrangThaiService(TrangThaiService trangThaiService) {
		this.trangThaiService = trangThaiService;
	}
	
	@RequestMapping(value="/list-trangThai", method = RequestMethod.GET )
	public String showList(Model model) {
		model.addAttribute("listTrangThai", this.trangThaiService.findAll());
		return "QuanLyDuAn/TrangThai/list";
	}
	
	
	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new TrangThai());
		return "QuanLyDuAn/TrangThai/add_form";
	}
	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") TrangThai trangThai, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		//validation form 
		if (result.hasErrors()) {
			return "QuanLyDuAn/TrangThai/add_form";
		}
		//check trùng namestatus
		int checkTen = trangThaiService.checkTenTrangThai(trangThai.getTenTrangThai());
		if(checkTen >=1) {
			model.addAttribute("messageName", "Tên trạng thái đã được sử dụng");
			return "QuanLyDuAn/TrangThai/add_form";
		}
		
		trangThai.setIsDelete(1);
		trangThaiService.add(trangThai);
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-trangThai";
	}

	
	@RequestMapping(value = "/show-form-edit/{maTrangThai}")
	public String showFormEdit(Model model, @PathVariable String maTrangThai) {
		TrangThai trangThai = trangThaiService.findById(maTrangThai);
		model.addAttribute("trangThai", trangThai);
		return "QuanLyDuAn/TrangThai/update";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("trangThai") TrangThai trangThai, BindingResult result,
			final RedirectAttributes redirectAttributes,Model model) {
		if (result.hasErrors()) {
//			model.addAttribute("trangThai", trangThai);
			return "QuanLyDuAn/TrangThai/update";
		}
		trangThai.setIsDelete(1);
		trangThaiService.update(trangThai);
		return "redirect: /FBMS/QuanLyDuAn/TrangThai/list-trangThai";
	}

	
	@RequestMapping(value = "/delete/{maTrangThai}")
	public String delete(@PathVariable String maTrangThai, final RedirectAttributes redirectAttributes) {
		TrangThai trangThai = trangThaiService.findById(maTrangThai);
		trangThai.setIsDelete(0);
		trangThaiService.update(trangThai);
		return "redirect: /FBMS/QuanLyDuAn/TrangThai/list-trangThai";
	}
}
