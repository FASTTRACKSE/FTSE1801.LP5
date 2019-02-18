package fasttrackse.ftse1801.fbms.controller.quanlyduan;

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

import fasttrackse.ftse1801.fbms.entity.quanlyduan.CongNghe;
import fasttrackse.ftse1801.fbms.service.quanlyduan.CongNgheService;

@Controller
@RequestMapping("/QuanLyDuAn/CongNghe")
public class CongNgheController {
	@Autowired
	private CongNgheService congNgheService;
	
	@RequestMapping("/list-congNghe")
	public String listCongNghe(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIdCn") == null) {
			pageId = 1;
		} else {
			pageId = (int) session.getAttribute("pageIdCn");
		}
		return "redirect: list-congNghe/"+pageId;
	}
	@RequestMapping(value = "/list-congNghe/{pageId}", method = RequestMethod.GET)
	public String listPersons(@PathVariable int pageId, Model model,HttpSession session) {
		int maxRows= 5;
		int start = (pageId - 1) * maxRows;
		int totalCongNghe = congNgheService.countCongNghe();
		int totalPage = (int) Math.ceil(totalCongNghe / (double) maxRows);
		if (pageId == 0) {
			pageId = 1;
		}
		model.addAttribute("listCongNghe", this.congNgheService.listCongNghe(start, maxRows));
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("pageIdTn", pageId);
		return "QuanLyDuAn/CongNghe/list";
	}

	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new CongNghe());
		return "QuanLyDuAn/CongNghe/addcongnghe";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") CongNghe congNghe, BindingResult result,
			final RedirectAttributes redirectAttributes,Model model) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/CongNghe/addcongnghe";
		}
		int checkName= congNgheService.checkNameCongNghe(congNghe.getTenCongNghe());
		if(checkName >=1) {
			model.addAttribute("messageName", "Tên Công Nghệ đã được sử dụng");
			return "QuanLyDuAn/CongNghe/addcongnghe";
		}
		int checkMa= congNgheService.checkMaCongNghe(congNghe.getMaCongNghe());
		if(checkMa >=1) {
			model.addAttribute("messageMa", "Mã Công Nghệ  đã được sử dụng");
			return "QuanLyDuAn/CongNghe/addcongnghe";
		}
		congNghe.setIsDelete(1);
		congNgheService.addNew(congNghe);
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-congNghe";
	}

	@RequestMapping(value = "/show-form-edit/{maCongNghe}")
	public String showFormEdit(Model model, @PathVariable String maCongNghe) {
		CongNghe congNghe = congNgheService.findById(maCongNghe);
		model.addAttribute("congNghe", congNghe);
		return "QuanLyDuAn/CongNghe/updatecongnghe";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("Technical") CongNghe congNghe, BindingResult result,
			final RedirectAttributes redirectAttributes,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("congNghe", congNghe);
			return "QuanLyDuAn/CongNghe/updatecongnghe";
		}
		congNghe.setIsDelete(1);
		congNgheService.update(congNghe);
		return "redirect: list-congNghe";
	}

	@RequestMapping(value = "/delete/{maCongNghe}")
	public String delete(@PathVariable String maCongNghe, final RedirectAttributes redirectAttributes) {
		CongNghe congNghe = congNgheService.findById(maCongNghe);
		congNghe.setIsDelete(0);
		congNgheService.delete(congNghe);
		return "redirect: /FBMS/QuanLyDuAn/CongNghe/list-congNghe";
	}
	
}
