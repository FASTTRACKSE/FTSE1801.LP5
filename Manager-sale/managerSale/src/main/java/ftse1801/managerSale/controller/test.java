package ftse1801.managerSale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/managerSale")
public class test {
	@GetMapping("/admin")
	public String index() {
		return "back-end/index.html";
	}
	@GetMapping("/")
	public String index1() {
		return "front-end/index.html";
	}
	@GetMapping("/a")
	public String index2() {
		return "index.html";
	}
}
