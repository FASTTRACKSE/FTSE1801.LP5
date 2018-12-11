package fasttrackse.ftse1801.fbms.controller.quantritailieu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ftse1801.fbms.entity.quantritailieu.TaiLieu;
import fasttrackse.ftse1801.fbms.service.quantritailieu.TaiLieuService;

@Controller
@RequestMapping(value = "QuanTriTaiLieu/tai_lieu")
public class TaiLieuController {
	@Autowired
	private TaiLieuService taiLieuService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView listAllTLDel0(Model model) {
		List<TaiLieu> listTl = taiLieuService.getAllTaiLieuDel0();
		return new ModelAndView("/QuanTriTaiLieu/tailieu/list", "taiLieu", listTl);
	}
}
