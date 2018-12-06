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

import fasttrackse.ftse1801.fbms.entity.quanlyduan.Contact;
import fasttrackse.ftse1801.fbms.service.quanlyduan.ContactService;

@Controller
@RequestMapping("/QuanLyDuAn/Contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}


	@RequestMapping("/list-Contact")
	public String listContact(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIdKh") == null) {
			pageId = 1;
		} else {
			pageId = (int) session.getAttribute("pageIdKh");
		}
		return "redirect: list-Contact/"+pageId;
	}
	@RequestMapping(value = "/list-Contact/{pageId}", method = RequestMethod.GET)
	public String listPersons(@PathVariable int pageId, Model model,HttpSession session) {
		int maxRows= 3;
		int start = (pageId - 1) * maxRows;
		int totalContact = contactService.countContact();
		int totalPage = (int) Math.ceil(totalContact / (double) maxRows);
		if (pageId == 0) {
			pageId = 1;
		}
		
		model.addAttribute("listContact", this.contactService.listContact(start, maxRows));
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("pageIdKh", pageId);
		return "QuanLyDuAn/Contact/list";
	}
	
	
	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new Contact());
		return "QuanLyDuAn/Contact/add_form";
	}
	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") Contact contact, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/Contact/add_form";
		}
		int checkMa = contactService.checkMaContact(contact.getMakh());
		if(checkMa >= 1) {
			model.addAttribute("messageMa", "Mã khách hàng đã được sử dụng");
			return "QuanLyDuAn/Contact/add_form";
		}
		
		contact.setIs_delete(1);
		contactService.add(contact);
		;
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-Contact";
	}

	
	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable String id) {
		Contact contact = contactService.getById(id);
		model.addAttribute("contact", contact);
		return "QuanLyDuAn/Contact/update_form";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("contact") Contact contact, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/Contact/update_form";
		}
		contact.setIs_delete(1);
		contactService.update(contact);
		return "redirect: /FBMS/QuanLyDuAn/Contact/list-Contact";
	}

	
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable String id, final RedirectAttributes redirectAttributes) {
		Contact contact = contactService.getById(id);
		contact.setIs_delete(0);
		contactService.update(contact);
		return "redirect: /FBMS/QuanLyDuAn/Contact/list-Contact";
	}

}
