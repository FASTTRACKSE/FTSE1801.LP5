package fasttrackse.ffse1703.fbms.controller.qttl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.qttl.*;
import fasttrackse.ffse1703.fbms.service.qttl.*;



@Controller
@RequestMapping("/QuanTriTaiLieu/DanhMuc")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	@Qualifier(value = "categoryServiceImpl")
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	
	@RequestMapping({"/list" , ""})
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = categoryService.getAll().size();
		int recordsPerPage = 3;
		int totalPages = 0;
		if ((totalRecords / recordsPerPage) % 2 == 0) {
			totalPages = totalRecords / recordsPerPage;
		} else {
			totalPages = totalRecords / recordsPerPage + 1;
		}
		int startPosition = recordsPerPage * (currentPage - 1);

		model.addAttribute("list", categoryService.findAllForPaging(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);

		return "QuanTriTaiLieu/DanhMuc/listDanhMuc";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("category", new Category());
		return "QuanTriTaiLieu/DanhMuc/addDanhMuc";
	}
	
	@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("category") @Valid Category category, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "QuanTriTaiLieu/DanhMuc/add";
		}

		if (categoryService.getById(category.getId()) != null) {
			Category db = categoryService.getById(category.getId());
			if (db.getId() == 1) {
				categoryService.update(category);
				return "redirect:list";

			} else {
				redirectAttributes.addFlashAttribute("message", "<script>alert('Mã đã tồn tại.');</script>");
				return "redirect:/QuanTriTaiLieu/DanhMuc/add";
			}
		}
		
		redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");
		categoryService.addNew(category);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String edit(Model model, @PathVariable("id") int id) {
		model.addAttribute("category", categoryService.getById(id));
		return "QuanTriTaiLieu/DanhMuc/editDanhMuc";

	}
	@RequestMapping(value = "/update")
	public String update(@ModelAttribute("category") @Valid Category category, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanTriTaiLieu/DanhMuc/editDanhMuc";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		categoryService.update(category);
		return "redirect:list";

	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(Model model, @PathVariable("id") int id) {
		categoryService.delete(id);
		return "redirect:/QuanTriTaiLieu/DanhMuc";

	}
	
}
