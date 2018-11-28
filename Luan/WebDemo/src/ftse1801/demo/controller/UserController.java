package ftse1801.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ftse1801.demo.service.UserService;

@Controller
public class UserController {
	private UserService service;
	
	@Autowired(required=true)
	@Qualifier(value="service")
	public void setService(UserService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/show")
	public String listUser(Model model) {
		model.addAttribute("list", this.service.showAllUser());
		return "index";
	}
	
}
