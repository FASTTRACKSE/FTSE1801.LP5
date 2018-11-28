package fasttrackse.ffse1703.fbms.controller.quanlyduan;

import java.beans.PropertyEditorSupport;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.DatabaseTeam1;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.DomainTeam1;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.DuAnTeam1;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.FrameworkTeam1;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.HoSoNhanVienTeam1;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.KhachHangTeam1;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.NhiemVuTeam1;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.ProgramingLanguageTeam1;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.TechnicalTeam1;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.TrangThaiTeam1;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.VendorTeam1;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.service.quanlyduan.DatabaseTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.DomainTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.DuAnTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.FrameworkTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.HoSoNhanVienTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.KhachHangTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.NhiemVuTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.ProgramingLanguageTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.TechnicalTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.TrangThaiTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.VaiTroTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.VendorTeam1Service;
import fasttrackse.ffse1703.fbms.service.security.PhongBanService;

@Controller
@RequestMapping("/qlda/DuAn")
public class DuAnTeam1Controller {
	@Autowired
	DuAnTeam1Service duAnTeam1Service;
	@Autowired
	DatabaseTeam1Service databaseTeam1Service;
	@Autowired
	KhachHangTeam1Service khachHangTeam1Service;
	@Autowired
	TrangThaiTeam1Service trangThaiTeam1Service;
	@Autowired
	DomainTeam1Service domainTeam1Service;
	@Autowired
	FrameworkTeam1Service frameTeam1Service;
	@Autowired
	TechnicalTeam1Service technicalTeam1Service;
	@Autowired
	VendorTeam1Service vendorTeam1Service;
	@Autowired
	ProgramingLanguageTeam1Service ngonNguTeam1Service;
	@Autowired
	PhongBanService phongBanService;
	@Autowired
	VaiTroTeam1Service vaiTroTeam1Service;
	@Autowired
	NhiemVuTeam1Service nhiemVuService;
	@Autowired
	HoSoNhanVienTeam1Service hoSoNhanVienTeam1Service;

	private int perPage = 3;

	@RequestMapping("/")
	public String viewlist(HttpSession session, @ModelAttribute("message") String flashAttr, RedirectAttributes redirectAttributes) {
		int currentPage;
		if (session.getAttribute("page") == null) {
			currentPage = 1;
		} else {
			currentPage = (int) session.getAttribute("page");
		}
		redirectAttributes.addFlashAttribute("message", flashAttr);
		return "redirect:list/" + currentPage;
	}

	@RequestMapping(value = "/list/{page}")
	public String listDuAn(Model model, @PathVariable("page") int page, HttpServletRequest request) {
		String maDuanSearch = " and maDuAn = '" + request.getParameter("maDuAn") + "'";
		if (request.getParameter("maDuAn") == null || request.getParameter("maDuAn").equals("0")) {
			maDuanSearch = "";
		}
		String maKhachHangSearch = " and khachHang.makh = '" + request.getParameter("makh") + "'";
		if (request.getParameter("makh") == null || request.getParameter("makh").equals("0")) {
			maKhachHangSearch = "";
		}
		String maPhongBanSearch = " and phongBan.maPhongBan = '" + request.getParameter("maPhongBan") + "'";
		if (request.getParameter("maPhongBan") == null || request.getParameter("maPhongBan").equals("0")) {
			maPhongBanSearch = "";
		}
		String trangThaiSearch = " and trangThai.maTrangThai = '" + request.getParameter("maTrangThai") + "'";
		if (request.getParameter("maTrangThai") == null || request.getParameter("maTrangThai").equals("0")) {
			trangThaiSearch = "";
		}
		String search = maDuanSearch + maKhachHangSearch + maPhongBanSearch + trangThaiSearch;

		int start = (page - 1) * perPage;
		List<DuAnTeam1> list = duAnTeam1Service.findAll(start, perPage, search);

		model.addAttribute("list", list);
		model.addAttribute("total", totalPage(perPage, search));
		model.addAttribute("page", page);
		model.addAttribute("duan", duAnTeam1Service.getAll());
		model.addAttribute("khachHang", khachHangTeam1Service.getAll());
		model.addAttribute("phongBan", phongBanService.findAll());
		model.addAttribute("trangThai", trangThaiTeam1Service.getAll());

		return "QuanLyDuAn/DuAn/list";
	}

	public int totalPage(int perPage, String search) {
		int totalPage = (int) Math.ceil((double) duAnTeam1Service.count(search) / (double) perPage);
		return totalPage;
	}

	@RequestMapping(value = { "/delete/{maDuAn}" })
	public String delete(Model model, @PathVariable("maDuAn") String maDuAn, RedirectAttributes redirectAttributes) {
		duAnTeam1Service.delete(maDuAn);
		redirectAttributes.addFlashAttribute("message",
				"<script>alert('Xóa thành công');</script>");
		return "redirect:/qlda/DuAn/";
	}

	@RequestMapping(value = { "/add_form" })
	public String redirect(Model model) {

		model.addAttribute("duAn", new DuAnTeam1());
		getData(model);


		return "QuanLyDuAn/DuAn/add_form";
	}

	@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("duAn") @Valid DuAnTeam1 duAn, BindingResult result,
			RedirectAttributes redirectAttributes, Model model) {

		if (result.hasErrors()) {
			System.out.println(result);
			return "redirect:/qlda/DuAn/add_form";
		}
		int checkTen = duAnTeam1Service.getName(duAn.getTenDuAn());
		if (checkTen >= 1) {
			redirectAttributes.addFlashAttribute("message",
					"<script>alert('Tên dự án đã tồn tại.');</script>");
			getData(model);
			return "redirect:/qlda/DuAn/add_form";
		}
		if (duAnTeam1Service.getById(duAn.getMaDuAn()) != null) {
			DuAnTeam1 db = duAnTeam1Service.getById(duAn.getMaDuAn());
			if (db.getIsDelete() == 1) {
				duAnTeam1Service.update(duAn);
				return "redirect:list";

			} else {
				redirectAttributes.addFlashAttribute("message",
						"<script>alert('Mã dự án đã tồn tại.');</script>");
				getData(model);
				return "redirect:/qlda/DuAn/add_form";
			}
		}

		redirectAttributes.addFlashAttribute("message", "<script>alert('Thêm thành công.');</script>");
		duAnTeam1Service.save(duAn);
		return "redirect:/qlda/DuAn/";
	}

	@RequestMapping(value = "/edit/{maDuAn}")
	public String edit(Model model, @PathVariable("maDuAn") String maDuAn) {
		DuAnTeam1 dA = duAnTeam1Service.getById(maDuAn);
		model.addAttribute("database", databaseTeam1Service.getAll());
		model.addAttribute("trangThai", trangThaiTeam1Service.getAll());
		model.addAttribute("domain", domainTeam1Service.getAll());
		model.addAttribute("framework", frameTeam1Service.getAll());
		model.addAttribute("technical", technicalTeam1Service.getAll());
		model.addAttribute("vendor", vendorTeam1Service.getAll());
		model.addAttribute("ngonNgu", ngonNguTeam1Service.getAll());
		model.addAttribute("phongBan", phongBanService.findAll());
		String maPB = dA.getPhongBan().getMaPhongBan();

		model.addAttribute("pms", hoSoNhanVienTeam1Service.findAll(maPB));

		model.addAttribute("duAn", dA);
		return "QuanLyDuAn/DuAn/edit_form";

	}

	@RequestMapping(value = "/update")
	public String update(@ModelAttribute("duAn") @Valid DuAnTeam1 duAn, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {

			return "QuanLyDuAn/DuAn/edit_form";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Sửa thành công.');</script>");
		duAnTeam1Service.update(duAn);
		return "redirect:list";
	}

	@RequestMapping(value = "/view/{maDuAn}")
	public String demo(Model model, @PathVariable("maDuAn") String maDuAn) {
		model.addAttribute("duAn", duAnTeam1Service.getById(maDuAn));
		return "QuanLyDuAn/DuAn/view";

	}

	public void getData(Model model) {
		model.addAttribute("database", databaseTeam1Service.getAll());
		model.addAttribute("khachhang", khachHangTeam1Service.getAll());
		model.addAttribute("trangThai", trangThaiTeam1Service.getAll());
		model.addAttribute("domain", domainTeam1Service.getAll());
		model.addAttribute("framework", frameTeam1Service.getAll());
		model.addAttribute("technical", technicalTeam1Service.getAll());
		model.addAttribute("vendor", vendorTeam1Service.getAll());
		model.addAttribute("ngonNgu", ngonNguTeam1Service.getAll());
		model.addAttribute("phongBan", phongBanService.findAll());

	}

	@RequestMapping(value = "selectPhongBan/{phongBan}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody //trả về trang html
	public String select(@PathVariable String phongBan, Model model) {
		List<HoSoNhanVienTeam1> listNhanVien = hoSoNhanVienTeam1Service.findAll(phongBan);

		String json = "[";

		for (int i = 0; i < listNhanVien.size(); i++) {

			if (i == listNhanVien.size() - 1) {
				json += "{\"maPhongBan\":" + "\"" + listNhanVien.get(i).getMaNhanVien() + "\"" + ", \"tenPM\" :" + "\""
						+ listNhanVien.get(i).getHoDem() + " " + listNhanVien.get(i).getTen() + "\"" + "}";
			} else {
				json += "{\"maPhongBan\":" + "\"" + listNhanVien.get(i).getMaNhanVien() + "\"" + ", \"tenPM\" :" + "\""
						+ listNhanVien.get(i).getHoDem() + " " + listNhanVien.get(i).getTen() + "\"" + "},";
			}
		}
		json += "]";

		return json;

	}

	/*
	 * Phân công nhiệm vụ
	 */
	@RequestMapping(value = { "/PhanCongNhienVu/create/{maDuAn}" })
	public String phanCongNhiemVu(@PathVariable("maDuAn") String maDuAn, Model model) {
		model.addAttribute("duAn", duAnTeam1Service.getById(maDuAn));
		model.addAttribute("nhiemvu", new NhiemVuTeam1());
		model.addAttribute("vaitro", vaiTroTeam1Service.getAll());
		model.addAttribute("nhanvien", hoSoNhanVienTeam1Service.getAll());
		return "QuanLyDuAn/DuAn/PhanCongNhiemVu/add_form";

	}

	@RequestMapping(value = { "/PhanCongNhiemVu/create" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("nhiemvu") @Valid NhiemVuTeam1 nhiemvu, BindingResult result,
			RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "redirect:/PhanCongNhiemVu/add_form";
		}

		redirectAttributes.addFlashAttribute("message", "<script>alert('Thêm thành công.');</script>");
		nhiemVuService.save(nhiemvu);
		String maDuAn = nhiemvu.getMaDuAn();
		return "redirect:/qlda/DuAn/PhanCongNhiemVu/list/" + maDuAn;
	}

	@RequestMapping(value = "/PhanCongNhiemVu/list/{maDuAn}")
	public String listNhiemVu(Model model, @PathVariable("maDuAn") String maDuAn) {
		model.addAttribute("nhiemvu", nhiemVuService.getAll(maDuAn));
		model.addAttribute("duan", duAnTeam1Service.getById(maDuAn));

		return "QuanLyDuAn/DuAn/PhanCongNhiemVu/list";
	}

	@RequestMapping(value = { "/PhanCongNhiemVu/delete/{maDuAn}/{maNhanVien}/{maVaiTro}" })
	public String phanCongNhiemVuDelete(final RedirectAttributes redirectAttributes, Model model,
			@PathVariable("maDuAn") String maDuAn, @PathVariable("maNhanVien") int maNhanVien,
			@PathVariable("maVaiTro") String maVaiTro) {

		nhiemVuService.delete(nhiemVuService.getDetailNhiemVu(maDuAn, maNhanVien, maVaiTro));
		redirectAttributes.addFlashAttribute("message", "<script>alert('Xóa thành công.');</script>");
		return "redirect:/qlda/DuAn/PhanCongNhiemVu/list" + maDuAn;
	}

	@RequestMapping(value = { "/PhanCongNhiemVu/edit/{maDuAn}/{maNhanVien}/{maVaiTro}" })
	public String phanCongNhiemVuUpdate(Model model, @PathVariable("maDuAn") String maDuAn,
			@PathVariable("maNhanVien") int maNhanVien, @PathVariable("maVaiTro") String maVaiTro) {

		model.addAttribute("duAn", duAnTeam1Service.getById(maDuAn));
		model.addAttribute("nhanvien", hoSoNhanVienTeam1Service.getById(maNhanVien));
		model.addAttribute("nhiemvu", nhiemVuService.getDetailNhiemVu(maDuAn, maNhanVien, maVaiTro));
		model.addAttribute("vaitro", vaiTroTeam1Service.getAll());
		return "QuanLyDuAn/DuAn/PhanCongNhiemVu/edit_form";

	}

	@RequestMapping(value = { "/PhanCongNhiemVu/update" }, method = RequestMethod.POST)
	public String phanCongNhiemVuUpdate(final RedirectAttributes redirectAttributes, Model model,
			@ModelAttribute("nhiemvu") NhiemVuTeam1 nhiemvu, BindingResult result,
			@RequestParam("oldVaitro") String oldVaiTro) {
		String maDuAn = nhiemvu.getMaDuAn();

		NhiemVuTeam1 oldNhiemVu = new NhiemVuTeam1();
		oldNhiemVu.setMaDuAn(maDuAn);
		oldNhiemVu.setMaNhanVien(nhiemvu.getMaNhanVien());
		oldNhiemVu.setMaVaiTro(oldVaiTro);
		nhiemVuService.update(nhiemvu, oldNhiemVu);
		redirectAttributes.addFlashAttribute("message", "<script>alert('Sửa thành công.');</script>");
		return "redirect:list/" + maDuAn;
	}

	/*
	 * Phân công nhiệm vụ
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(DatabaseTeam1.class, "database", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(databaseTeam1Service.getById(text));
			}
		});

		binder.registerCustomEditor(KhachHangTeam1.class, "khachHang", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(khachHangTeam1Service.findById(text));
			}
		});
		binder.registerCustomEditor(TrangThaiTeam1.class, "trangThai", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(trangThaiTeam1Service.findById(text));
			}
		});
		binder.registerCustomEditor(DomainTeam1.class, "domain", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(domainTeam1Service.findById(text));
			}
		});
		binder.registerCustomEditor(FrameworkTeam1.class, "framework", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(frameTeam1Service.getById(text));
			}
		});
		binder.registerCustomEditor(TechnicalTeam1.class, "technical", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(technicalTeam1Service.getById(text));
			}
		});
		binder.registerCustomEditor(VendorTeam1.class, "vendor", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(vendorTeam1Service.getById(text));
			}
		});
		binder.registerCustomEditor(ProgramingLanguageTeam1.class, "ngonNgu", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(ngonNguTeam1Service.getById(text));
			}
		});
		binder.registerCustomEditor(PhongBan.class, "phongBan", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(hoSoNhanVienTeam1Service.findAll(text));
			}
		});
		binder.registerCustomEditor(HoSoNhanVienTeam1.class, "hoSoNhanVien", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(hoSoNhanVienTeam1Service.findAll(text));
			}
		});
		binder.registerCustomEditor(DuAnTeam1.class, "duAn", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(duAnTeam1Service.getAll());
			}
		});

	}

}