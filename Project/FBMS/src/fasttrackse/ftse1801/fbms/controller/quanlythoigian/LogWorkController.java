package fasttrackse.ftse1801.fbms.controller.quanlythoigian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftse1801.fbms.entity.quanlythoigian.LogWork;
import fasttrackse.ftse1801.fbms.service.quanlythoigian.LogWorkServiceIplm;

@Controller
@RequestMapping("QuanLyThoiGian/")
public class LogWorkController {
	@Autowired
	private LogWorkServiceIplm logWorkServiceIplm;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView viewLogWork(Model model) {
			List<LogWork> list = logWorkServiceIplm.getAllLogWork();
		return new ModelAndView("QuanLyThoiGian/list","listLogwork",list);
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editView(@PathVariable("id") int id) {
		LogWork logWork = logWorkServiceIplm.getLogWorkByID(id);
		return new ModelAndView("QuanLyThoiGian/edit","logWork",logWork);
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView doEdit(Model model, @ModelAttribute("logWork") LogWork logWork,
			final RedirectAttributes redirectAttributes) {
		try {
			logWorkServiceIplm.updateLogWork(logWork);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return new ModelAndView("redirect:/QuanLyThoiGian/");
	}
}
