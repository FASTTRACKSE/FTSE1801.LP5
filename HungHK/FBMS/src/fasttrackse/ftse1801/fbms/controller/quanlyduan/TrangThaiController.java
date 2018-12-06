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
	
	@RequestMapping(value="/listTrangThai", method = RequestMethod.GET )
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
		return "redirect: listTrangThai";
	}

	
	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable String id) {
		TrangThai trangThai = trangThaiService.findById(id);
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
		return "redirect: /FBMS/QuanLyDuAn/TrangThai/listTrangThai";
	}

	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable String id, final RedirectAttributes redirectAttributes) {
		TrangThai trangThai = trangThaiService.findById(id);
		trangThai.setIsDelete(0);
		trangThaiService.update(trangThai);
		return "redirect: /FBMS/QuanLyDuAn/TrangThai/listTrangThai";
	}
}
