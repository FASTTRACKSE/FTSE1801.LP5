package fasttrackse.ftse1801.fbms.controller.qlnhiemvu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.QuanLyNhiemVu;
import fasttrackse.ftse1801.fbms.service.qlnhiemvu.QuanLyNhiemVuService;

@Controller
@RequestMapping("QuanLyNhiemVu")
public class QuanLyNhiemVuController {

	@Autowired
	private QuanLyNhiemVuService quanLyNhiemVuService;

	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public String viewDanhSach(Model model) {
	// return "QuanLyNhiemVu/list";
	// }

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		// int size = 5;
		// int total = qLyNhiemVuService.getAll().size() / size +
		// (qLyNhiemVuService.getAll().size() % size == 0 ? 0 : 1);
		// model.addAttribute("total", total);
		// model.addAttribute("page", 1);
		List<QuanLyNhiemVu> list = quanLyNhiemVuService.getAll();
		return new ModelAndView("QuanLyNhiemVu/list", "list", list);
	}

	/*
	 * @RequestMapping(value ="list") public ModelAndView viewList1(@PathVariable
	 * int page, Model model) { int size = 5; int total =
	 * qLyNhiemVuService.getAll().size() / size + (qLyNhiemVuService.getAll().size()
	 * % size == 0 ? 0 : 1); model.addAttribute("total", total);
	 * model.addAttribute("page", 1); List<QuanLyNhiemVu> list =
	 * qLyNhiemVuService.getAllpage((page-1)*size, size); return new
	 * ModelAndView("list", "view",list); }
	 */
}
