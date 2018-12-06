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

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Database;
import fasttrackse.ftse1801.fbms.service.quanlyduan.DatabaseServices;

@Controller
@RequestMapping("/QuanLyDuAn/Database")
public class DatabaseController {
	@Autowired
	private DatabaseServices databaseServices;
	

	public void setDatabaseService(DatabaseServices databaseServices) {
		this.databaseServices = databaseServices;
	}

	@RequestMapping("/list-database")
	public String listDatabase(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIdDt") == null) {
			pageId = 1;
		} else {
			pageId = (int) session.getAttribute("pageIdDt");
		}
		return "redirect: list-database/"+pageId;
	}
	
	@RequestMapping(value = "/list-database/{pageId}", method = RequestMethod.GET)
	public String listPersons(@PathVariable int pageId, Model model,HttpSession session) {
		int maxRows= 5;
		int start = (pageId - 1) * maxRows;
		int totalDatabase = databaseServices.countDatabase();
		int totalPage = (int) Math.ceil(totalDatabase / (double) maxRows);
		if (pageId == 0) {
			pageId = 1;
		}
		model.addAttribute("listDatabase", this.databaseServices.listDatabase(start, maxRows));
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("pageIdDt", pageId);
		return "QuanLyDuAn/Database/listdatabase";
	}
	

	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new Database());
		return "QuanLyDuAn/Database/adddatabase";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") Database database, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		
		//validation form 
		if (result.hasErrors()) {
			return "QuanLyDuAn/Database/adddatabase";
		}
		//check trùng namedatabase
		int checkName= databaseServices.checkNameDatabase(database.getTenDatabase());
		if(checkName >=1) {
			model.addAttribute("messageName", "Tên database đã được sử dụng");
			return "QuanLyDuAn/Database/adddatabase";
		}
		int checkMa= databaseServices.checkMaDatabase(database.getMaDatabase());
		if(checkMa >=1) {
			model.addAttribute("messageMa", "Mã database đã được sử dụng");
			return "QuanLyDuAn/Database/adddatabase";
		}
		database.setIsDelete(1);
		databaseServices.addNew(database);
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-database";
	}

	@RequestMapping(value = "/show-form-edit/{maDatabase}")
	public String showFormEdit(Model model, @PathVariable String maDatabase) {
		Database dm = databaseServices.findById(maDatabase);
		model.addAttribute("database", dm);
		return "QuanLyDuAn/Database/updatedatabase";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("Database") Database database, BindingResult result,
			final RedirectAttributes redirectAttributes,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("database", database);
			return "QuanLyDuAn/Database/updatedatabase";
		}
		database.setIsDelete(1);
		databaseServices.update(database);
		return "redirect: list-database";
	}

	@RequestMapping(value = "/delete/{maDatabase}")
	public String delete(@PathVariable String maDatabase, final RedirectAttributes redirectAttributes) {
		Database dm = databaseServices.findById(maDatabase);
		dm.setIsDelete(0);
		databaseServices.update(dm);
		return "redirect: /FBMS/QuanLyDuAn/Database/list-database";
	}
}
