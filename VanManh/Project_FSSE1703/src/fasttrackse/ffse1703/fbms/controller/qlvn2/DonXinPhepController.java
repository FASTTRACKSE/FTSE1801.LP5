package fasttrackse.ffse1703.fbms.controller.qlvn2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import fasttrackse.ffse1703.fbms.entity.qlvn2.DonXinPhepEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.LyDoEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.TrangThaiEntity;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.service.qlvn2.DonXinPhepService;

@Controller
@RequestMapping(value = "/QuanlyvangnghiDanhLT")
public class DonXinPhepController {
	@Autowired
	DonXinPhepService DonXinPhepService;

	// @RequestMapping(value = {"/danhsachnhap003"}, method = RequestMethod.GET)
	// public String danhsachnhap003(Model model ) {
	// model.addAttribute("danhsachnhap003", DonXinPhepService.danhsachnhap003());
	// return "QuanlyvangnghiDanhLT/danhsachnhap003";
	// }
	//
	// @RequestMapping(value = {"/danhsachchoduyet003"}, method = RequestMethod.GET)
	// public String danhsachchoduyet003(Model model ) {
	// model.addAttribute("danhsachchoduyet003",
	// DonXinPhepService.danhsachchoduyet003());
	// return "QuanlyvangnghiDanhLT/danhsachchoduyet003";
	// }
	// @RequestMapping(value = {"/danhsachdaduyet003"}, method = RequestMethod.GET)
	// public String danhsachdaduyet003(Model model ) {
	// model.addAttribute("danhsachdaduyet003",
	// DonXinPhepService.danhsachdaduyet003());
	// return "QuanlyvangnghiDanhLT/danhsachdaduyet003";
	// }
	// @RequestMapping(value = {"/danhsachbituchoi003"}, method = RequestMethod.GET)
	// public String danhsachbituchoi003(Model model ) {
	// model.addAttribute("danhsachbituchoi003",
	// DonXinPhepService.danhsachbituchoi003());
	// return "QuanlyvangnghiDanhLT/danhsachbituchoi003";
	// }
	// form đơn
	@RequestMapping(value = "/donxinphep003", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("donxinphep003", new DonXinPhepEntity());
		return "QuanlyvangnghiDanhLT/donxinphep003";
	}

	// form sửa nháp
	@RequestMapping(value = "/suadonnhap", method = RequestMethod.GET)
	public String suanhap(Model model) {
		model.addAttribute("suadonnhap", new DonXinPhepEntity());
		return "QuanlyvangnghiDanhLT/suadonnhap";
	}

	// form sửa duyệt
	@RequestMapping(value = "/suadoncho", method = RequestMethod.GET)
	public String edit(Model model) {
		model.addAttribute("suadoncho", new DonXinPhepEntity());
		return "QuanlyvangnghiDanhLT/suadoncho";
	}

	@ModelAttribute("lyDo")
	public List<LyDoEntity> danhSachLyDo() {
		return this.DonXinPhepService.danhSachLyDo();
	}

	@ModelAttribute("trangthai")
	public List<TrangThaiEntity> danhSachTrangThai() {
		return this.DonXinPhepService.danhSachTrangThai();
	}

	@ModelAttribute("hoso")
	public List<HoSoNhanVien> danhSachHoSoNhanVien() {
		return this.DonXinPhepService.danhSachHoSo();
	}

	@ModelAttribute("phongban")
	public List<PhongBan> danhsachphongban() {
		return this.DonXinPhepService.danhSachPhong();
	}

	@RequestMapping(value = { "/delete/{id}", "/donxinphep003/nhap" })
	public String delete(@PathVariable int id, HttpSession session, Model model) {
		DonXinPhepService.delete(id);
		return "redirect:/QuanlyvangnghiDanhLT/danhsachnhap003";
	}

	@RequestMapping(value = { "/deleteBrowse/{id}" })
	public String deleteBrowse(@PathVariable int id, HttpSession session, Model model) {
		DonXinPhepService.delete(id);
		return "redirect:/QuanlyvangnghiDanhLT/danhsachduyet003";
	}

	// đơn mới
	@RequestMapping(value = { "/donxinphep003/nhap" }, method = RequestMethod.POST)
	public String listDonNhap(@ModelAttribute("donxinphep003") @Valid DonXinPhepEntity nv, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {
		try {
			DonXinPhepService.create(nv);
			redirectAttributes.addFlashAttribute("messageSuccess", "ThÃ nh cÃ´ng..");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lá»—i. Xin thá»­ láº¡i!");
			return "QuanlyvangnghiDanhLT/donxinphep003";
		}
		return "redirect:/QuanlyvangnghiDanhLT/danhsachnhap003";
	}

	@RequestMapping(value = { "/donxinphep003/choduyet" }, method = RequestMethod.POST)
	public String listDoncho(@ModelAttribute("donxinphep003") @Valid DonXinPhepEntity nv, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanlyvangnghiDanhLT/donxinphep003";
		}
		DonXinPhepService.createcho(nv);
		return "redirect:/QuanlyvangnghiDanhLT/danhsachchoduyet003";
	}

	// SỬA NHÁP
	@RequestMapping(value = "/suadonnhap/{id}", method = RequestMethod.GET)
	public String edit_view(@PathVariable("id") int id, Model model) {
		model.addAttribute("suadonnhap", DonXinPhepService.findById(id));
		DonXinPhepService.delete(id);
		return "QuanlyvangnghiDanhLT/suadonnhap";
	}

	@RequestMapping(value = "/quaylai/nhap", method = RequestMethod.POST)
	public String editNhap(@ModelAttribute("suadonnhap") @Valid DonXinPhepEntity nv, BindingResult result, Model model)
			throws SQLException {
		if (result.hasErrors()) {
			return "/QuanlyvangnghiDanhLT/suadonnhap";
		}
		DonXinPhepService.create(nv);
		return "redirect:/QuanlyvangnghiDanhLT/danhsachnhap003";
	}

	// sửa chờ THÀNH duyệt
	@RequestMapping(value = "/suadoncho/{id}", method = RequestMethod.GET)
	public String suacho(@PathVariable("id") int id, Model model) {
		model.addAttribute("suadoncho", DonXinPhepService.findById(id));
		DonXinPhepService.delete(id);
		return "QuanlyvangnghiDanhLT/suadoncho";
	}

	@RequestMapping(value = "/updatechoduyet/daduyet", method = RequestMethod.POST)
	public String listDonDuyet(@ModelAttribute("suadoncho") @Valid DonXinPhepEntity nv, BindingResult result,
			Model model) {
		if (result.hasErrors()) {

			return "/QuanlyvangnghiDanhLT/suadoncho";
		}
		DonXinPhepService.createduyet(nv);
		return "redirect:/QuanlyvangnghiDanhLT/danhsachdaduyet003";
	}
	// sửa chờ thanh từ chối

	@RequestMapping(value = "/updatechoduyet/tuchoi", method = RequestMethod.POST)
	public String listTuChoi(@ModelAttribute("suadoncho") @Valid DonXinPhepEntity nv, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "/QuanlyvangnghiDanhLT/suadoncho";
		}
		DonXinPhepService.createtuchoi(nv);
		return "redirect:/QuanlyvangnghiDanhLT/danhsachbituchoi003";
	}

	// phan trang vs phần quyền
	@RequestMapping("/danhsachnhap003")
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		Authentication role = SecurityContextHolder.getContext().getAuthentication();
		if (role.getName().contains("phongduan") == true) {
			List<DonXinPhepEntity> danhsachnhap003 = DonXinPhepService.listbyPhongBan("PDA");
			int recordsPerPage = 3;
			int totalPages = (int) Math.ceil((double) danhsachnhap003.size() / recordsPerPage);
			int startPosition = recordsPerPage * (currentPage - 1);
			// model.addAttribute("danhsachnhap003",
			// DonXinPhepService.findAllForPaging1(startPosition, recordsPerPage));
			model.addAttribute("danhsachnhap003", danhsachnhap003);
			model.addAttribute("lastPage", totalPages);
			model.addAttribute("currentPage", currentPage);
		}
		if (role.getName().contains("phongit") == true) {
			List<DonXinPhepEntity> danhsachnhap003 = DonXinPhepService.listbyPhongBan("PIT");
			int recordsPerPage = 3;
			int totalPages = (int) Math.ceil((double) danhsachnhap003.size() / recordsPerPage);
			int startPosition = recordsPerPage * (currentPage - 1);
			// model.addAttribute("danhsachnhap003",
			// DonXinPhepService.findAllForPaging1(startPosition, recordsPerPage));
			model.addAttribute("danhsachnhap003", danhsachnhap003);
			model.addAttribute("lastPage", totalPages);
			model.addAttribute("currentPage", currentPage);
		}
		if (role.getName().contains("phongdaotao") == true) {
			List<DonXinPhepEntity> danhsachnhap003 = DonXinPhepService.listbyPhongBan("PDT");
			int recordsPerPage = 3;
			int totalPages = (int) Math.ceil((double) danhsachnhap003.size() / recordsPerPage);
			int startPosition = recordsPerPage * (currentPage - 1);
			// model.addAttribute("danhsachnhap003",
			// DonXinPhepService.findAllForPaging1(startPosition, recordsPerPage));
			model.addAttribute("danhsachnhap003", danhsachnhap003);
			model.addAttribute("lastPage", totalPages);
			model.addAttribute("currentPage", currentPage);
		}
		if (role.getName().contains("phongnhansu") == true) {
			int recordsPerPage = 3;
			int startPosition = recordsPerPage * (currentPage - 1);
			List<DonXinPhepEntity> danhsachnhap003 = DonXinPhepService.findAllForPaging1(startPosition, recordsPerPage);
			int totalPages = (int) Math.ceil((double) danhsachnhap003.size() / recordsPerPage);
			
			// model.addAttribute("danhsachnhap003",
			// DonXinPhepService.findAllForPaging1(startPosition, recordsPerPage));
			model.addAttribute("danhsachnhap003", danhsachnhap003);
			model.addAttribute("lastPage", totalPages);
			model.addAttribute("currentPage", currentPage);
		}
		if (role.getName().contains("giamdoc") == true) {
			int recordsPerPage = 3;
			int startPosition = recordsPerPage * (currentPage - 1);
			List<DonXinPhepEntity> danhsachnhap003 = DonXinPhepService.findAllForPaging1(startPosition, recordsPerPage);
			int totalPages = (int) Math.ceil((double) danhsachnhap003.size() / recordsPerPage);
			// model.addAttribute("danhsachnhap003",
			// DonXinPhepService.findAllForPaging1(startPosition, recordsPerPage));
			model.addAttribute("danhsachnhap003", danhsachnhap003);
			model.addAttribute("lastPage", totalPages);
			model.addAttribute("currentPage", currentPage);
		}
		if (role.getName().contains("phongketoan") == true) {
			List<DonXinPhepEntity> danhsachnhap003 = DonXinPhepService.listbyPhongBan("PKT");
			int recordsPerPage = 3;
			int totalPages = (int) Math.ceil((double) danhsachnhap003.size() / recordsPerPage);
			int startPosition = recordsPerPage * (currentPage - 1);
			// model.addAttribute("danhsachnhap003",
			// DonXinPhepService.findAllForPaging1(startPosition, recordsPerPage));
			model.addAttribute("danhsachnhap003", danhsachnhap003);
			model.addAttribute("lastPage", totalPages);
			model.addAttribute("currentPage", currentPage);
		}
		return "QuanlyvangnghiDanhLT/danhsachnhap003";
	}
/////////////////////////////////////////////////////////
	//
	@RequestMapping("/danhsachchoduyet003")
	public String indexchoduyet(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		Authentication role = SecurityContextHolder.getContext().getAuthentication();
		if (role.getName().contains("phongduan") == true) {
			List<DonXinPhepEntity> danhsachchoduyet003 = DonXinPhepService.listbyPhongBan1("PDA");
			int recordsPerPage = 3;
			int totalPages = (int) Math.ceil((double) danhsachchoduyet003.size() / recordsPerPage);
			int startPosition = recordsPerPage * (currentPage - 1);
			// model.addAttribute("danhsachnhap003",
			// DonXinPhepService.findAllForPaging1(startPosition, recordsPerPage));
			model.addAttribute("danhsachchoduyet003", danhsachchoduyet003);
			model.addAttribute("lastPage", totalPages);
			model.addAttribute("currentPage", currentPage);
		}
		if (role.getName().contains("phongit") == true) {
			List<DonXinPhepEntity> danhsachchoduyet003 = DonXinPhepService.listbyPhongBan1("PIT");
			int recordsPerPage = 3;
			int totalPages = (int) Math.ceil((double) danhsachchoduyet003.size() / recordsPerPage);
			int startPosition = recordsPerPage * (currentPage - 1);
			// model.addAttribute("danhsachnhap003",
			// DonXinPhepService.findAllForPaging1(startPosition, recordsPerPage));
			model.addAttribute("danhsachnhap003", danhsachchoduyet003);
			model.addAttribute("lastPage", totalPages);
			model.addAttribute("currentPage", currentPage);
		}
		if (role.getName().contains("phongdaotao") == true) {
			List<DonXinPhepEntity> danhsachchoduyet003 = DonXinPhepService.listbyPhongBan1("PDT");
			int recordsPerPage = 3;
			int totalPages = (int) Math.ceil((double) danhsachchoduyet003.size() / recordsPerPage);
			int startPosition = recordsPerPage * (currentPage - 1);
			// model.addAttribute("danhsachnhap003",
			// DonXinPhepService.findAllForPaging1(startPosition, recordsPerPage));
			model.addAttribute("danhsachchoduyet003", danhsachchoduyet003);
			model.addAttribute("lastPage", totalPages);
			model.addAttribute("currentPage", currentPage);
		}
		if (role.getName().contains("phongnhansu") == true) {
			int recordsPerPage = 3;
			int startPosition = recordsPerPage * (currentPage - 1);
			List<DonXinPhepEntity> danhsachchoduyet003 = DonXinPhepService.findAllForPaging2(startPosition, recordsPerPage);
			int totalPages = (int) Math.ceil((double) danhsachchoduyet003.size() / recordsPerPage);
			// model.addAttribute("danhsachnhap003",
			// DonXinPhepService.findAllForPaging1(startPosition, recordsPerPage));
			model.addAttribute("danhsachchoduyet003", danhsachchoduyet003);
			model.addAttribute("lastPage", totalPages);
			model.addAttribute("currentPage", currentPage);
		}
		if (role.getName().contains("giamdoc") == true) {
			int recordsPerPage = 3;
			int startPosition = recordsPerPage * (currentPage - 1);
			List<DonXinPhepEntity> danhsachchoduyet003 = DonXinPhepService.findAllForPaging2(startPosition, recordsPerPage);
			int totalPages = (int) Math.ceil((double) danhsachchoduyet003.size() / recordsPerPage);
			// model.addAttribute("danhsachnhap003",
			// DonXinPhepService.findAllForPaging1(startPosition, recordsPerPage));
			model.addAttribute("danhsachchoduyet003", danhsachchoduyet003);
			model.addAttribute("lastPage", totalPages);
			model.addAttribute("currentPage", currentPage);
		}
		if (role.getName().contains("phongketoan") == true) {
			List<DonXinPhepEntity> danhsachchoduyet003 = DonXinPhepService.listbyPhongBan("PKT");
			int recordsPerPage = 3;
			int totalPages = (int) Math.ceil((double) danhsachchoduyet003.size() / recordsPerPage);
			int startPosition = recordsPerPage * (currentPage - 1);
			// model.addAttribute("danhsachnhap003",
			// DonXinPhepService.findAllForPaging1(startPosition, recordsPerPage));
			model.addAttribute("danhsachchoduyet003", danhsachchoduyet003);
			model.addAttribute("lastPage", totalPages);
			model.addAttribute("currentPage", currentPage);
		}
		return "QuanlyvangnghiDanhLT/danhsachchoduyet003";
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping("/danhsachdaduyet003")
	public String indexdaduyet(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = DonXinPhepService.danhsachdaduyet003().size();
		int recordsPerPage = 3;
		int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
		int startPosition = recordsPerPage * (currentPage - 1);
		model.addAttribute("danhsachdaduyet003", DonXinPhepService.findAllForPaging3(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);

		return "QuanlyvangnghiDanhLT/danhsachdaduyet003";
	}

	@RequestMapping("/danhsachbituchoi003")
	public String indextuchoi(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = DonXinPhepService.danhsachbituchoi003().size();
		int recordsPerPage = 3;
		int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
		int startPosition = recordsPerPage * (currentPage - 1);
		model.addAttribute("danhsachbituchoi003", DonXinPhepService.findAllForPaging4(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);

		return "QuanlyvangnghiDanhLT/danhsachbituchoi003";
	}
	//

	@RequestMapping(value = { "/ngaynghiphep" }, method = RequestMethod.GET)
	public String ngaynghi(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = DonXinPhepService.ngaynghiphep().size();
		int recordsPerPage = 4;
		int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
		int startPosition = recordsPerPage * (currentPage - 1);
		model.addAttribute("ngaynghiphep", DonXinPhepService.findAllForPagingngaynghi(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		return "QuanlyvangnghiDanhLT/ngaynghiphep";
	}

	@RequestMapping(value = { "/thongketrangthai" }, method = RequestMethod.GET)
	public String thongketrangthai(Model model) {

		model.addAttribute("thongketrangthai", DonXinPhepService.thongketrangthai());

		List<Integer> count = new ArrayList<Integer>();
		count.add(DonXinPhepService.danhsachnhap003().size());
		count.add(DonXinPhepService.danhsachchoduyet003().size());
		count.add(DonXinPhepService.danhsachdaduyet003().size());
		count.add(DonXinPhepService.danhsachbituchoi003().size());
		model.addAttribute("count", count);
		return "QuanlyvangnghiDanhLT/thongketrangthai";
	}
}
