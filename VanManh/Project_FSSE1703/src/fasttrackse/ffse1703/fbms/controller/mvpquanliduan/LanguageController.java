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

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Language;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.LanguageService;

@Controller
@RequestMapping("/mvpquanliduan/language")
public class LanguageController {
	@Autowired
	private LanguageService languageService;
	public void setLanguageService(LanguageService languageService) {
		this.languageService=languageService;
	}
	@RequestMapping("/list-language")
	public String listLanguage(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIdLg") == null) {
			pageId = 1;
		} else {
			pageId = (int) session.getAttribute("pageIdLg");
		}
		return "redirect: list-language/"+pageId;
	}
	@RequestMapping(value = "/list-language/{pageId}", method = RequestMethod.GET)
	public String listPersons(@PathVariable int pageId, Model model,HttpSession session) {
		int maxRows= 5;
		int start = (pageId - 1) * maxRows;
		int totalLanguage = languageService.countLanguage();
		int totalPage = (int) Math.ceil(totalLanguage / (double) maxRows);
		if (pageId == 0) {
			pageId = 1;
		}
		
		model.addAttribute("listLanguage", this.languageService.listLanguage(start, maxRows));
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("pageIdLg", pageId);
		return "MvpQuanLiDuAn/programlanguage/list";
	}

	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new Language());
		return "MvpQuanLiDuAn/programlanguage/add_form";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") Language language, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/programlanguage/add_form";
		}
		int checkMa = languageService.checkMa(language.getIdLanguage());
		if(checkMa >=1) {
			model.addAttribute("messageMa", "Mã ngôn ngữ đã được sử dụng");
			return "MvpQuanLiDuAn/programlanguage/add_form";
		}
		int checkName=languageService.checkNameLanguage(language.getNameLanguage());
		if(checkName >=1) {
			model.addAttribute("messageName", "Tên ngôn ngữ đã được sử dụng");
			return "MvpQuanLiDuAn/programlanguage/add_form";
		}
		
		language.setStatus(1);
		languageService.add(language);
		;
		redirectAttributes.addFlashAttribute("success", "<script>alert('Th�m th�nh c�ng');</script>");
		return "redirect: list-language";
	}

	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable String id) {
		Language language= 		languageService.getById(id);
		model.addAttribute("language", language);
		return "MvpQuanLiDuAn/programlanguage/update_form";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/programlanguage/update_form";
		}
		language.setStatus(1);
		languageService.update(language);
		return "redirect: /ffse-fbms/mvpquanliduan/language/list-language";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable String id, final RedirectAttributes redirectAttributes) {
		Language language = languageService.getById(id);
		language.setStatus(0);
		languageService.update(language);
		return "redirect: /ffse-fbms/mvpquanliduan/language/list-language";
	}
}
