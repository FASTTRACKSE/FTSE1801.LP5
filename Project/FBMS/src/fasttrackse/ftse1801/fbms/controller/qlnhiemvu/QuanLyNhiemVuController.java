package fasttrackse.ftse1801.fbms.controller.qlnhiemvu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("QuanLyNhiemVu/")
public class QuanLyNhiemVuController {

	@Autowired
	private QuanLyNhiemVuService quanLyNhiemVuService;

	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public String viewDanhSach(Model model) {
	// return "QuanLyNhiemVu/list";
	// }

	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		int size = 1;
		int total = quanLyNhiemVuService.getAll().size() / size
				+ (quanLyNhiemVuService.getAll().size() % size == 0 ? 0 : 1);
		model.addAttribute("total", total);
		model.addAttribute("page", 1);
		model.addAttribute("size", size);
		List<QuanLyNhiemVu> list = quanLyNhiemVuService.getAllpage(0, size);
		return new ModelAndView("QuanLyNhiemVu/list", "list", list);
	}

	@RequestMapping(value = "/{page}")
	public ModelAndView viewList1(@PathVariable int page, Model model) {
		int size = 1;
		int total = quanLyNhiemVuService.getAll().size() / size
				+ (quanLyNhiemVuService.getAll().size() % size == 0 ? 0 : 1);
		model.addAttribute("total", total);
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		List<QuanLyNhiemVu> list = quanLyNhiemVuService.getAllpage((page - 1) * size, size);
		return new ModelAndView("QuanLyNhiemVu/list", "list", list);
	}

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

	@RequestMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id, Model model) {
		QuanLyNhiemVu quanLyNhiemVu = new QuanLyNhiemVu();
		quanLyNhiemVu = quanLyNhiemVuService.findById(id);
		List<TrangThaiNhiemVu> listTrangThai = quanLyNhiemVuService.trangThai();
		model.addAttribute("listTrangThai", listTrangThai);
		List<HoSoNhanSu> listNhanVien = quanLyNhiemVuService.hoSoNhanVien();
		model.addAttribute("listNhanVien", listNhanVien);
		List<LoaiCongViec> listLoaiCongViec = quanLyNhiemVuService.loaiCongViec();
		model.addAttribute("listCongViec", listLoaiCongViec);
		List<PhongBan> listPhongBan = quanLyNhiemVuService.phongBan();
		model.addAttribute("listPhongBan", listPhongBan);
		return new ModelAndView("QuanLyNhiemVu/edit", "edit", quanLyNhiemVu);
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("edit") QuanLyNhiemVu quanLyNhiemVu,
			final RedirectAttributes redirectAttributes) {
		try {
			quanLyNhiemVuService.edit(quanLyNhiemVu);
			redirectAttributes.addFlashAttribute("messageSuccess", "Sửa thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageSuccess", "Lỗi xin thử lại!");
			return new ModelAndView("redirect:/QuanLyNhiemVu/edit/{" + quanLyNhiemVu.getId() + "}");
		}
		return new ModelAndView("redirect:/QuanLyNhiemVu/");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id, final RedirectAttributes redirectAttributes) {
		try {
			QuanLyNhiemVu quanLyNhiemVu = quanLyNhiemVuService.findById(id);
			quanLyNhiemVu.setIsDelete(1);
			quanLyNhiemVuService.delete(quanLyNhiemVu);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageSuccess", "Lỗi xin thử lại!");
		}
		return new ModelAndView("redirect:/QuanLyNhiemVu/");
	}

	@RequestMapping(value = "/view/{maNhiemVu}", method = RequestMethod.GET)
	public ModelAndView viewOneNhiemVu(@PathVariable("maNhiemVu") int maNhiemVu) {
		QuanLyNhiemVu quanLyNhiemVu = quanLyNhiemVuService.findById(maNhiemVu);
		return new ModelAndView("/QuanLyNhiemVu/viewOne", "quanLyNhiemVu", quanLyNhiemVu);
	}

	@RequestMapping(value = "/calender", method = RequestMethod.GET)
	public String calender(Model model, HttpServletRequest request) {
		String maDuAnSearch = " and duAn.maDuAn = " + request.getParameter("maDuAn");
		if (request.getParameter("maDuAn") == null || request.getParameter("maDuAn").equals("0")) {
			maDuAnSearch = "";
		}
		String maNhanVienSearch = " and idNhanVien.maNhanVien = " + request.getParameter("maNhanVien");
		if (request.getParameter("maNhanVien") == null || request.getParameter("maNhanVien").equals("0")) {
			maNhanVienSearch = "";
		}
		String IDtrangthaiSearch = " and idTrangThai.id = " + request.getParameter("id");
		if (request.getParameter("id") == null || request.getParameter("id").equals("0")) {
			IDtrangthaiSearch = "";
		}
		String search = maDuAnSearch + maNhanVienSearch + IDtrangthaiSearch;
		List<QuanLyNhiemVu> list = quanLyNhiemVuService.searchAll(search);
		String json = quanLyNhiemVuService.toJson(list);
		model.addAttribute("js", json);
		model.addAttribute("trangthai", quanLyNhiemVuService.trangThai());
		model.addAttribute("nhanVienHLP", quanLyNhiemVuService.hoSoNhanVien());
		return "QuanLyNhiemVu/calender";
	}
}
