package ftse1801.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Hello {
	@RequestMapping(value="/demo", method=RequestMethod.GET)
	public String hello() {
		return "Demo";
	}
}
