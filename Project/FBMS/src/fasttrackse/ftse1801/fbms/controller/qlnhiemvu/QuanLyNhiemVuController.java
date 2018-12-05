package fasttrackse.ftse1801.fbms.controller.qlnhiemvu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.LoaiCongViec;
import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.QuanLyNhiemVu;
import fasttrackse.ftse1801.fbms.entity.qlnhiemvu.TrangThaiNhiemVu;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;
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
	
	@InitBinder
	public void initBinder(final WebDataBinder binder){
	  final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
	  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

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

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		List<TrangThaiNhiemVu> listTrangThai = quanLyNhiemVuService.trangThai();
		model.addAttribute("listTrangThai", listTrangThai);
		List<HoSoNhanSu> listNhanVien = quanLyNhiemVuService.hoSoNhanVien();
		model.addAttribute("listNhanVien", listNhanVien);
		List<LoaiCongViec> listLoaiCongViec = quanLyNhiemVuService.loaiCongViec();
		model.addAttribute("listCongViec", listLoaiCongViec);
		List<PhongBan> listPhongBan = quanLyNhiemVuService.phongBan();
		model.addAttribute("listPhongBan", listPhongBan);
		return new ModelAndView("QuanLyNhiemVu/add", "nhiemVu", new QuanLyNhiemVu());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("nhiemVu") QuanLyNhiemVu quanLyNhiemVu,
			final RedirectAttributes redirectAttributes) {
		try {
			quanLyNhiemVuService.add(quanLyNhiemVu);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageSuccess", "Lỗi xin thử lại!");
			return new ModelAndView("redirect:/QuanLyNhiemVu/add");
		}
		return new ModelAndView("redirect:/QuanLyNhiemVu/");
	}

	// @RequestMapping(value = "/edit/{id}")
	// public ModelAndView edit(@PathVariable int id) {
	// QuanLyNhiemVu quanLyNhiemVu = new QuanLyNhiemVu();
	// quanLyNhiemVu = quanLyNhiemVuService.findById(id);
	// return new ModelAndView("QuanLyNhiemVu","command",quanLyNhiemVu);
	// }
}
