package fasttrackse.ftse1801.fbms.controller.quanlynhansu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.KinhNghiemDuAn;
import fasttrackse.ftse1801.fbms.service.quanlynhansu.KinhNghiemDuAnService;

@Controller
@RequestMapping("QuanLyNhanSu/kinhNghiemDuAn")
public class KinhNghiemDuAnController {
	@Autowired
	private KinhNghiemDuAnService kinhNghiemDuAnService;
	
	@RequestMapping(value="/")
	public String viewKinhNghiem(Model model) {
		List<KinhNghiemDuAn> list = kinhNghiemDuAnService.list();
		model.addAttribute("list", list);
		return "QuanLyNhanSu/kinhNghiemDuAn/list";
		
	}
}
