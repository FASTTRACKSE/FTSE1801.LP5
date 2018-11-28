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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.DatabaseTeam1;
import fasttrackse.ffse1703.fbms.service.quanlyduan.DatabaseTeam1Service;

@Controller
@RequestMapping("/qlda/Database")

public class DatabaseTeam1Controller {
	@Autowired
	DatabaseTeam1Service databaseService;

	@RequestMapping(value = { "/list", "" })
	public String list(Model model , HttpServletRequest request) {
		
		
		model.addAttribute("list", databaseService.getAll());
		return "QuanLyDuAn/Database/list";

	}

	@RequestMapping(value = { "/delete/{maDatabase}" })
	public String delete(Model model, @PathVariable("maDatabase") String maDatabase) {
		databaseService.delete(maDatabase);
		return "redirect:/qlda/Database";

	}

	@RequestMapping(value = { "/add_form" })
	public String redirect(Model model) {
		model.addAttribute("database", new DatabaseTeam1());
		return "QuanLyDuAn/Database/add_form";
	}

	@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("database") @Valid DatabaseTeam1 database, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "QuanLyDuAn/Database/add_form";
		}
		int checkTen = databaseService.getName(database.getTenDatabase());
		System.out.println(checkTen);
		if (checkTen >= 1) {
			redirectAttributes.addFlashAttribute("message", "<script>alert('Tên Database đã tồn tại.');</script>");
			return "redirect:/qlda/Database/add_form";
		}

		if (databaseService.getById(database.getMaDatabase()) != null) {
			DatabaseTeam1 db = databaseService.getById(database.getMaDatabase());
			if (db.getIsDelete() == 1) {
				databaseService.update(database);
				return "redirect:list";

			} else {
				redirectAttributes.addFlashAttribute("message", "<script>alert('Mã Database đã tồn tại.');</script>");
				return "redirect:/qlda/Database/add_form";
			}
		}

		redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");
		databaseService.save(database);
		return "redirect:list";
	}

	/*
	 * @ModelAttribute public void addAttributes(Model model) {
	 * model.addAttribute("msg", "Welcome to the Netherlands!"); }
	 */
	@RequestMapping(value = "/edit/{maDatabase}")
	public String edit(Model model, @PathVariable("maDatabase") String maDatabase) {
		model.addAttribute("database", databaseService.getById(maDatabase));
		return "QuanLyDuAn/Database/edit_form";

	}

	@RequestMapping(value = "/update")
	public String update(@ModelAttribute("database") @Valid DatabaseTeam1 database, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/Database/edit_form";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		databaseService.update(database);
		return "redirect:list";

	}

}
