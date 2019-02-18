package ftse1801.managerSale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/managerSale")
public class back {
	@GetMapping("/admin")
	public String index() {
		return "back-end/index.html";
	}
}
