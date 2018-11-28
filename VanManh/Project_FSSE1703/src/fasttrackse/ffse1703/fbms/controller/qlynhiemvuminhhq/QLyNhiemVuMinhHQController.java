package fasttrackse.ffse1703.fbms.controller.qlynhiemvuminhhq;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViecMinhHQ;
import fasttrackse.ffse1703.fbms.service.qlynhiemvuminhhq.CongViecService;

@Controller
@RequestMapping("/QuanLyNhiemVuMinhHQ")
public class QLyNhiemVuMinhHQController {
	CongViecService congViecService;

	@Autowired
	public void setCongViecService(CongViecService congViecService) {
		this.congViecService = congViecService;
	}
	
	public int totalPage(int perPage, String search) {
		int totalPage = (int) Math.ceil((double) congViecService.findAll(search).size() / (double) perPage);
		return totalPage;
	}

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String viewTaiLieu(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage,
			HttpServletRequest request) {

		String maDuanSearch = " and duAn.maDuAn = " + request.getParameter("maDuAn");
		if (request.getParameter("maDuAn") == null || request.getParameter("maDuAn").equals("0")) {
			maDuanSearch = "";
		}
		String maNhanVienSearch = " and phanCong.maNhanVien = " + request.getParameter("maNhanVien");
		if (request.getParameter("maNhanVien") == null || request.getParameter("maNhanVien").equals("0")) {
			maNhanVienSearch = "";
		}
		String IDtrangthaiSearch = " and maTrangThai.maTrangThai = " + request.getParameter("maTrangThai");
		if (request.getParameter("maTrangThai") == null || request.getParameter("maTrangThai").equals("0")) {
			IDtrangthaiSearch = "";
		}
		String search = maDuanSearch + maNhanVienSearch + IDtrangthaiSearch;

		int perPage = 2;

		int totalPage = totalPage(perPage,search);
		int start = (currentPage - 1) * perPage;
		model.addAttribute("listCongViec", congViecService.findAllForPaging(start, perPage, search));
		model.addAttribute("lastPage", totalPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("TrangThai", congViecService.trangThai());
		model.addAttribute("DuAn", congViecService.duAn());
		model.addAttribute("NhanVien", congViecService.nhanVien());
		return "/QuanLyNhiemVuMinhHQ/list";
	}

	@RequestMapping(value = "/view/{ID}")
	public String viewOne(@PathVariable("ID") int id, Model model) {
		model.addAttribute("list", congViecService.findByID(id));
		return "/QuanLyNhiemVuMinhHQ/viewOne";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("CongViec", new CongViecMinhHQ());
		model.addAttribute("TrangThai", congViecService.trangThai());
		model.addAttribute("LoaiCongViec", congViecService.loaiCongViec());
		model.addAttribute("DuAn", congViecService.duAn());
		model.addAttribute("NhanVien", congViecService.nhanVien());
		return "/QuanLyNhiemVuMinhHQ/add_form";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createCongViec(Model model, @ModelAttribute("CongViec") @Valid CongViecMinhHQ cv,
			BindingResult bingding, final RedirectAttributes redirectAttributes) {
		try {
			cv.setIsDelete(1);
			congViecService.addNew(cv);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công...");
		} catch (Exception e) {

			redirectAttributes.addFlashAttribute("messageError", "Lỗi. xin thử lại!");
			return "redirect:/QuanLyNhiemVuMinhHQ/create";
		}
		return "redirect:/QuanLyNhiemVuMinhHQ/list";
	}

	@RequestMapping("/delete/{ID}")
	public String delete(@PathVariable("ID") int id, HttpServletRequest request, Model model) {
		CongViecMinhHQ cv = congViecService.findByID(id);
		cv.setIsDelete(0);
		congViecService.delete(cv);
		return "redirect:/QuanLyNhiemVuMinhHQ/list";
	}

	@RequestMapping(value = "/edit/{ID}", method = RequestMethod.GET)
	public String edit_view(@PathVariable("ID") int id, Model model) {
		model.addAttribute("CongViec", congViecService.findByID(id));
		model.addAttribute("TrangThai", congViecService.trangThai());
		model.addAttribute("LoaiCongViec", congViecService.loaiCongViec());
		model.addAttribute("DuAn", congViecService.duAn());
		model.addAttribute("NhanVien", congViecService.nhanVien());
		return "/QuanLyNhiemVuMinhHQ/edit_form";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String edit(Model model, @ModelAttribute("CongViec") @Valid CongViecMinhHQ CongViec, BindingResult bingding,
			final RedirectAttributes redirectAttributes) {
		try {
			congViecService.update(CongViec);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công...");
		} catch (Exception e) {

			redirectAttributes.addFlashAttribute("messageError", "Lỗi. xin thử lại!");
			return "redirect:/QuanLyNhiemVuMinhHQ/edit/" + CongViec.getID();
		}

		return "redirect:/QuanLyNhiemVuMinhHQ/list";
	}

	@RequestMapping(value = {"/Calendar" }, method = RequestMethod.GET)
	public String viewCalendar(Model model,
			HttpServletRequest request) {

		String maDuanSearch = " and duAn.maDuAn = " + request.getParameter("maDuAn");
		if (request.getParameter("maDuAn") == null || request.getParameter("maDuAn").equals("0")) {
			maDuanSearch = "";
		}
		String maNhanVienSearch = " and phanCong.maNhanVien = " + request.getParameter("maNhanVien");
		if (request.getParameter("maNhanVien") == null || request.getParameter("maNhanVien").equals("0")) {
			maNhanVienSearch = "";
		}
		String IDtrangthaiSearch = " and maTrangThai.maTrangThai = " + request.getParameter("maTrangThai");
		if (request.getParameter("maTrangThai") == null || request.getParameter("maTrangThai").equals("0")) {
			IDtrangthaiSearch = "";
		}
		String search = maDuanSearch + maNhanVienSearch + IDtrangthaiSearch;
		List<CongViecMinhHQ> list = congViecService.searchAll(search);
		String Json = congViecService.toJson(list);
		model.addAttribute("js", Json);
		model.addAttribute("TrangThai", congViecService.trangThai());
		model.addAttribute("DuAn", congViecService.duAn());
		model.addAttribute("NhanVien", congViecService.nhanVien());
		return "/QuanLyNhiemVuMinhHQ/calender";
	}
}
