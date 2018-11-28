package ftse1801.demo.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller

public class HelloHoi {
	@RequestMapping(value="/HelloHoi", method = RequestMethod.GET)
	public ModelAndView getHello() {
		return new ModelAndView("HelloHoi", "mess", "Hello Hoi...........");
		
	}
}
