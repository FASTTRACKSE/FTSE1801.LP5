package fasttrackse.ftse1801.fbms.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageNotFoundController {
	@RequestMapping("/error")
	public String pageNotFound() {
		return "Page Not Found";
	}
}