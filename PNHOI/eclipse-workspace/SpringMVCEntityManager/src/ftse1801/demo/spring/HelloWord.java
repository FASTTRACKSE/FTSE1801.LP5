package ftse1801.demo.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWord {
	@RequestMapping(value="/HelloWord", method=RequestMethod.GET)
	public ModelAndView getSayHello() {
		String mess = "HelloWord..............";
		return new ModelAndView("HelloWord","mess",mess);
	}
}
