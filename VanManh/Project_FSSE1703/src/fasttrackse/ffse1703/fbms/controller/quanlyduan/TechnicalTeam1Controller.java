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

import fasttrackse.ffse1703.fbms.entity.quanlyduan.TechnicalTeam1;
import fasttrackse.ffse1703.fbms.service.quanlyduan.TechnicalTeam1Service;

@Controller
@RequestMapping("/qlda/Technical")
public class TechnicalTeam1Controller {
	@Autowired
	TechnicalTeam1Service TechnicalTeam1Service;

	@RequestMapping(value = { "/list", "" })
	public String list(Model model) {
		model.addAttribute("list", TechnicalTeam1Service.getAll());
		return "QuanLyDuAn/Technical/list";

	}

	@RequestMapping(value = { "/delete/{ma_cong_nghe}" })
	public String delete(Model model, @PathVariable("ma_cong_nghe") String ma_cong_nghe) {
		TechnicalTeam1Service.delete(ma_cong_nghe);
		return "redirect:/qlda/Technical";

	}

	@RequestMapping(value = { "/add_form" })
	public String redirect(Model model) {
		model.addAttribute("technical", new TechnicalTeam1());
		return "QuanLyDuAn/Technical/add_form";
	}

	@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("technical") @Valid TechnicalTeam1 technical, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "QuanLyDuAn/Technical/add_form";
		}
		int checkTen = TechnicalTeam1Service.getName(technical.getTen_cong_nghe());
		if (checkTen >= 1) {
			redirectAttributes.addFlashAttribute("message", "<script>alert('Tên Database đã tồn tại.');</script>");
			return "redirect:/qlda/Technical/add_form";
		}

		if (TechnicalTeam1Service.getById(technical.getMa_cong_nghe()) != null) {
			TechnicalTeam1 tc = TechnicalTeam1Service.getById(technical.getMa_cong_nghe());
			if (tc.getIs_delete() == 1) {
				TechnicalTeam1Service.update(technical);
				redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");

				return "redirect:list";

			} else {
				redirectAttributes.addFlashAttribute("message", "<script>alert('Mã Technical đã tồn tại.');</script>");
				return "redirect:/qlda/Technical/add_form";
			}
		}

		redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");
		TechnicalTeam1Service.save(technical);
		return "redirect:list";
	}

	@RequestMapping(value = "/edit/{ma_cong_nghe}")
	public String edit(Model model, @PathVariable("ma_cong_nghe") String ma_cong_nghe) {
		model.addAttribute("technical", TechnicalTeam1Service.getById(ma_cong_nghe));
		return "QuanLyDuAn/Technical/edit_form";

	}

	@RequestMapping(value = "/update")
	public String update(@ModelAttribute("technical") @Valid TechnicalTeam1 congNghe, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/Technical/edit_form";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		TechnicalTeam1Service.update(congNghe);
		return "redirect:/qlda/Technical/list";

	}

	

}
