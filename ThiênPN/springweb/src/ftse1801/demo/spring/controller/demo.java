package ftse1801.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class demo {
	@RequestMapping(value="demo", method=RequestMethod.GET)
   public String getXuat() {
	   return "demo";
   }
}
