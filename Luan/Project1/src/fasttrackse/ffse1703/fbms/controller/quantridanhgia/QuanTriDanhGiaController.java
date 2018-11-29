package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;
import fasttrackse.ffse1703.fbms.service.quantridanhgia.QuanTriDanhGiaService;
import fasttrackse.ffse1703.fbms.service.security.UserAccountService;

@Controller
@RequestMapping("/quantridanhgia")
public class QuanTriDanhGiaController {

	private int start = 1;

	private int maxItems = 5;

	private int currentPage = 1;

	public QuanTriDanhGiaService service;

	public UserAccountService accountService;

	@Autowired
	@Qualifier("quanTriDanhGiaServiceImpl")
	public void setService(QuanTriDanhGiaService service) {
		this.service = service;
	}

	@Autowired
	@Qualifier(value = "userAccountServiceImpl")
	public void setAccountService(UserAccountService accountService) {
		this.accountService = accountService;
	}

	public HoSoNhanVien getInfo(HttpSession httpSession) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserAccount userAccount = accountService.loadUserByUsername(auth.getName());
		httpSession.setAttribute("roles", auth.getAuthorities().toString().substring(
				auth.getAuthorities().toString().indexOf("[") + 1, auth.getAuthorities().toString().lastIndexOf("]")));
		httpSession.setAttribute("chucDanh", userAccount.getNhanVien().getChucDanh().getMaChucDanh());
		return userAccount.getNhanVien();
	}

	@RequestMapping(value = { "/", "", "/home" })
	private String loadHome(Model model, HttpSession httpSession) {
		HoSoNhanVien hoSo = getInfo(httpSession);
		KyDanhGia kyDanhGia = service.getKyDanhGiaActive();
		model.addAttribute("danhGia", service.getDanhGiaBanThan(kyDanhGia, hoSo));
		return "quantridanhgia/home";
	}

	@RequestMapping(value = "/danhgiabanthan")
	private String getDanhGiaBanThan(Model model, HttpSession httpSession) {
		HoSoNhanVien hoSo = getInfo(httpSession);
		KyDanhGia kyDanhGia = service.getKyDanhGiaActive();
		model.addAttribute("danhGia", service.getDanhGiaBanThan(kyDanhGia, hoSo));
		return "quantridanhgia/nhanvien/danhgiabanthan";
	}

	@RequestMapping("/danhgiabanthan/add")
	public String addDanhGiaBanThan(Model model, HttpSession httpSession) {
		HoSoNhanVien nhanVien = getInfo(httpSession);
		KyDanhGia kyDanhGia = service.getKyDanhGiaActive();
		DanhGiaBanThan danhGia = new DanhGiaBanThan();
		danhGia.setKyDanhGia(kyDanhGia);
		danhGia.setPhongBan(nhanVien.getPhongBan());
		danhGia.setNhanVien(nhanVien);
		model.addAttribute("command", danhGia);
		return "quantridanhgia/nhanvien/formdanhgiabanthan";
	}

	@RequestMapping("/danhgiabanthan/edit")
	private String editDanhGiaBanThan(Model model, HttpSession httpSession) {
		HoSoNhanVien nhanVien = getInfo(httpSession);
		KyDanhGia kyDanhGia = service.getKyDanhGiaActive();
		DanhGiaBanThan danhGia = new DanhGiaBanThan();
		danhGia = service.getDanhGiaBanThan(kyDanhGia, nhanVien);
		model.addAttribute("command", danhGia);
		return "quantridanhgia/nhanvien/formdanhgiabanthan";
	}

	@RequestMapping(value = "/danhgiabanthan/sumit", method = RequestMethod.POST)
	public String submitDanhGiaBanThan(Model model, @ModelAttribute("command") @Valid DanhGiaBanThan danhGia,
			BindingResult result) {
		if (result.hasErrors()) {
			return "QuanTriDanhGia/nhanvien/formdanhgiabanthan";
		}
		if (danhGia.getId() == 0) {
			service.addDanhGiaBanthan(danhGia);
		} else {
			service.updateDanhGiaBanThan(danhGia);
		}
		return "redirect:/quantridanhgia/danhgiabanthan";
	}

	@RequestMapping("/danhgianhanvien")
	public String getListDanhGiaNhanVien(Model model, HttpSession httpSession) {
		HoSoNhanVien nhanVien = getInfo(httpSession);
		KyDanhGia kyDanhGia = service.getKyDanhGiaActive();
		model.addAttribute("listDanhGiaNhanVien", service.getDanhGiaNhanVien(kyDanhGia, nhanVien));
		return "quantridanhgia/nhanvien/danhgianhanvien";
	}

	@RequestMapping("/danhgianhanvien/add/{id}")
	public String addDanhGiaNhanVien(Model model, @PathVariable("id") int id) {
		DanhGiaNhanVien danhGiaNhanVien = service.getDanhGiaNhanVien(id);
		KyDanhGia kyDanhGia = service.getKyDanhGiaActive();
		DanhGiaBanThan danhGiaBanThan = service.getDanhGiaBanThan(kyDanhGia, danhGiaNhanVien.getNhanVien());
		model.addAttribute("command", danhGiaNhanVien);
		model.addAttribute("danhGia", danhGiaBanThan);
		return "quantridanhgia/nhanvien/formdanhgianhanvien";
	}

	@RequestMapping("/danhgianhanvien/view/{id}")
	public String viewDanhGiaNhanVien(Model model, @PathVariable("id") int id) {
		DanhGiaNhanVien danhGiaNhanVien = service.getDanhGiaNhanVien(id);
		model.addAttribute("danhGia", danhGiaNhanVien);
		return "quantridanhgia/nhanvien/viewdanhgianhanvien";
	}

	@RequestMapping("/danhgianhanvien/edit/{id}")
	public String editDanhGiaNhanVien(Model model, @PathVariable("id") int id) {
		DanhGiaNhanVien danhGiaNhanVien = service.getDanhGiaNhanVien(id);
		KyDanhGia kyDanhGia = service.getKyDanhGiaActive();
		DanhGiaBanThan danhGiaBanThan = service.getDanhGiaBanThan(kyDanhGia, danhGiaNhanVien.getNhanVien());
		model.addAttribute("command", danhGiaNhanVien);
		model.addAttribute("danhGia", danhGiaBanThan);
		return "quantridanhgia/nhanvien/formdanhgianhanvien";
	}

	@RequestMapping(value = "/danhgianhanvien/submit", method = RequestMethod.POST)
	public String submitDanhGiaNhanVien(Model model, @ModelAttribute("command") @Valid DanhGiaNhanVien danhGiaNhanVien,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "quantridanhgia/nhanvien/formdanhgianhanvien";
		}
		service.updateDanhGiaNhanVien(danhGiaNhanVien);
		return "redirect:/quantridanhgia/danhgianhanvien";
	}

	@RequestMapping("/nhanviendanhgia")
	public String getListNhanVienDanhGia(Model model, HttpSession httpSession) {
		HoSoNhanVien nhanVien = getInfo(httpSession);
		KyDanhGia kyDanhGia = service.getKyDanhGiaActive();
		model.addAttribute("listNhanVienDanhGia", service.getNhanVienDanhGia(kyDanhGia, nhanVien));
		return "quantridanhgia/nhanvien/nhanviendanhgia";
	}

	@RequestMapping("/nhanviendanhgia/{id}")
	public String viewNhanVienDanhGia(Model model, @PathVariable("id") int id) {
		DanhGiaNhanVien danhGiaNhanVien = service.getDanhGiaNhanVien(id);
		model.addAttribute("danhGia", danhGiaNhanVien);
		return "quantridanhgia/nhanvien/viewnhanviendanhgia";
	}

	@RequestMapping("/danhgiacuatruongphong")
	public String getDanhGiaCuaTruongPhong(Model model, HttpSession httpSession) {
		HoSoNhanVien nhanVien = getInfo(httpSession);
		KyDanhGia kyDanhGia = service.getKyDanhGiaActive();
		model.addAttribute("danhGia", service.getTruongPhongDanhGia(kyDanhGia, nhanVien));
		return "quantridanhgia/nhanvien/danhgiacuatruongphong";
	}

	@RequestMapping(value = "/kydanhgia")
	private String redirectListKyDanhgia(HttpSession session) {
		if (session.getAttribute("pageKy") != null) {
			currentPage = (int) session.getAttribute("pageKy");
		}
		return "redirect:/quantridanhgia/kydanhgia/" + currentPage;
	}

	@RequestMapping("/kydanhgia/{page}")
	private String showListKyDanhgia(@PathVariable(required = false) int page, Model model, HttpSession session) {
		start = (page - 1) * maxItems;
		model.addAttribute("command", new KyDanhGia());
		model.addAttribute("total", (int) Math.ceil((double) service.getListKyDanhGia() / (double) maxItems));
		session.setAttribute("pageKy", page);
		model.addAttribute("listKyDanhGia", service.getListKyDanhGia(start, maxItems));
		model.addAttribute("listPhongBan", service.getListPhongBan());
		return "quantridanhgia/phongnhansu/kydanhgia";
	}

	@RequestMapping("/kydanhgia/edit/{maKy}")
	private String showEdit(Model model, @PathVariable String maKy) {
		model.addAttribute("command", service.getKyDanhGia(maKy));
		model.addAttribute("listKyDanhGia", service.getListKyDanhGia());
		model.addAttribute("listPhongBan", service.getListPhongBan());
		return "QuanTriDanhGia/phongnhansu/kydanhgia";
	}

	@RequestMapping(value = "/kydanhgia/save", method = RequestMethod.POST)
	private String insertKyDanhgia(Model model, @ModelAttribute("command") @Valid KyDanhGia kyDanhGia,
			BindingResult result, HttpSession session, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			start = ((int) session.getAttribute("pageKy") - 1) * maxItems;
			model.addAttribute("listKyDanhGia", service.getListKyDanhGia(start, maxItems));
			model.addAttribute("total", Math.ceil((double) service.getListKyDanhGia() / (double) maxItems));
			return "QuanTriDanhGia/phongnhansu/kydanhgia";
		}
		if (service.checkKyDanhGia(kyDanhGia) < 1) {
			this.service.addKyDanhGia(kyDanhGia);
			session.setAttribute("pageKy", (int) Math.ceil((double) service.getListKyDanhGia() / (double) maxItems));
			attributes.addFlashAttribute("message", "<script>alert('Đã có hoạt động đánh giá tồn tại')</script>");
		} else {
			this.service.updateKyDanhGia(kyDanhGia);
		}
		return "redirect:/quantridanhgia/kydanhgia";
	}

	@RequestMapping("/kydanhgia/active/{maKy}")
	private String activeDanhgia(Model model, @PathVariable String maKy, HttpSession session) {
		KyDanhGia kyDanhGia = service.getKyDanhGia(maKy);
		kyDanhGia.setIsActive(1);
		service.updateKyDanhGia(kyDanhGia);
		return "redirect:/quantridanhgia/kydanhgia";
	}

	@RequestMapping("/kydanhgia/deactive/{maKy}")
	private String deactiveDanhgia(Model model, @PathVariable String maKy, HttpSession session) {
		KyDanhGia kyDanhGia = service.getKyDanhGia(maKy);
		kyDanhGia.setIsActive(2);
		service.updateKyDanhGia(kyDanhGia);
		return "redirect:/quantridanhgia/kydanhgia";
	}

	@RequestMapping(value = "/phancongdanhgia", method = RequestMethod.POST)
	public String createPhanCongDanhGia(Model model, @RequestParam("phongBan") String maPhongBan) {
		PhongBan phongBan = service.getPhongBanBy(maPhongBan);
		KyDanhGia kyDanhGia = service.getKyDanhGiaActive();
		if (service.checkPhanCongDanhGiaExist(kyDanhGia, phongBan) > 0) {
			model.addAttribute("message", "<script>alert('Đã có phân công đánh gia cho phòng ban này')</script>");
		} else {
			if (service.getListNhanVienPhongBan(phongBan).size() < 1) {
				model.addAttribute("message", "<script>alert('Phòng ban này không có nhân viên nào')</script>");
			} else {
				List<HoSoNhanVien> listNhanVien = service.getListNhanVienPhongBan(phongBan);
				List<DanhGiaNhanVien> danhGiaNhanVien = new ArrayList<>();
				for (HoSoNhanVien x : listNhanVien) {
					List<HoSoNhanVien> listNhanVienLimit = service.getNhanVienLimit(x.getMaNhanVien(), phongBan);
					for (HoSoNhanVien y : listNhanVienLimit) {
						DanhGiaNhanVien danhGia = new DanhGiaNhanVien();
						danhGia.setKyDanhGia(kyDanhGia);
						danhGia.setPhongBan(phongBan);
						danhGia.setNhanVienDanhGia(x.getMaNhanVien());
						danhGia.setNhanVien(y);
						danhGiaNhanVien.add(danhGia);
					}
				}
				service.createPhanCongDanhGia(danhGiaNhanVien);
			}
		}
		return "redirect:/quantridanhgia/kydanhgia";
	}

	@RequestMapping("/danhsachdanhgia")
	private String redirectListDanhgiaBanThan(HttpSession session) {
		if (session.getAttribute("pageDanhGia") != null) {
			currentPage = (int) session.getAttribute("pageDanhGia");
		}
		return "redirect:/quantridanhgia/danhsachdanhgia/" + currentPage;
	}

	@RequestMapping("/danhsachdanhgia/{page}")
	private String showListDanhgiaBanThan(Model model, @PathVariable(required = false) int page, HttpSession session) {
		KyDanhGia kyDanhGia = service.getKyDanhGiaActive();
		start = (page - 1) * maxItems;
		model.addAttribute("command", new KyDanhGia());
		session.setAttribute("pageDanhGia", page);
		model.addAttribute("total",
				Math.ceil((double) service.getListDanhGiaBanThanToanCongTy(kyDanhGia) / (double) maxItems));
		model.addAttribute("listDanhgia", service.getListDanhGiaBanThanToanCongTy(start, maxItems, kyDanhGia));
		return "quantridanhgia/phongnhansu/danhsachdanhgia";
	}

	@RequestMapping("/duyetdanhgia")
	public String redirectDuyetDanhGia(Model model, HttpSession session) {
		if (session.getAttribute("pageDDG") != null) {
			currentPage = (int) session.getAttribute("pageDDG");
		}
		return "redirect:/quantridanhgia/duyetdanhgia/" + currentPage;
	}

	@RequestMapping("/duyetdanhgia/{page}")
	public String getListDanhGiaBanThan(Model model, @PathVariable int page, HttpSession session) {
		HoSoNhanVien nhanVien = getInfo(session);
		KyDanhGia kyDanhGia = service.getKyDanhGiaActive();
		int start = (page - 1) * maxItems;
		model.addAttribute("start", start);
		session.setAttribute("pageDDG", page);
		model.addAttribute("total", Math.ceil(
				(double) service.getListDanhGiaBanThanPhongBan(kyDanhGia, nhanVien.getPhongBan()) / (double) maxItems));
		model.addAttribute("listNhanVien",
				service.getListDanhGiaBanThanPhongBan(start, maxItems, kyDanhGia, nhanVien.getPhongBan()));
		return "quantridanhgia/truongphong/duyetdanhgia";
	}

	@RequestMapping("/duyetdanhgia/duyet/{id}")
	public String acceptDanhGiaNhanVien(Model model, @PathVariable int id) {
		DanhGiaBanThan danhGiaBanThan = service.getDanhGiaBanThan(id);
		danhGiaBanThan.getTrangThai().setMaTrangThai(3);
		service.updateDanhGiaBanThan(danhGiaBanThan);
		return "redirect:/quantridanhgia/duyetdanhgia";
	}

	@RequestMapping("/duyetdanhgia/huy/{id}")
	public String ignoreDanhGiaNhanVien(Model model, @PathVariable int id) {
		DanhGiaBanThan danhGiaBanThan = service.getDanhGiaBanThan(id);
		danhGiaBanThan.getTrangThai().setMaTrangThai(1);
		service.updateDanhGiaBanThan(danhGiaBanThan);
		return "redirect:/quantridanhgia/duyetdanhgia";
	}

	@RequestMapping("/duyetdanhgia/view/{id}")
	public String showDanhGiaNhanVien(Model model, @PathVariable int id) {
		model.addAttribute("command", service.getDanhGiaBanThan(id));
		return "quantridanhgia/truongphong/viewdanhgia";
	}

	@RequestMapping(value = "/truongphongdanhgia")
	public String redirectDanhGiaNhanVien(Model model, HttpSession session) {
		if (session.getAttribute("pageTPDG") != null) {
			currentPage = (int) session.getAttribute("pageTPDG");
		}
		return "redirect:/quantridanhgia/truongphongdanhgia/" + currentPage;
	}

	@RequestMapping(value = "/truongphongdanhgia/{page}")
	public String getListDanhGiaNhanVien(@PathVariable int page, Model model, HttpSession session) {
		HoSoNhanVien nhanVien = getInfo(session);
		KyDanhGia kyDanhGia = service.getKyDanhGiaActive();
		if (service.getListNhanVienPhongBan(nhanVien.getPhongBan()).size() < 1) {
			createListDanhGiaNhanVien(kyDanhGia, nhanVien.getPhongBan());
			return "redirect:/quantridanhgia/truongphongdanhgia";
		}
		int start = (page - 1) * maxItems;
		session.setAttribute("pageTPDG", page);
		model.addAttribute("start", start);
		model.addAttribute("total", Math.ceil(
				(double) service.getListTruongPhongDanhGia(kyDanhGia, nhanVien.getPhongBan()) / (double) maxItems));
		model.addAttribute("listDanhGia",
				service.getListTruongPhongDanhGia(start, maxItems, kyDanhGia, nhanVien.getPhongBan()));
		return "quantridanhgia/truongphong/danhgianhanvien";
	}

	@RequestMapping(value = "/truongphongdanhgia/add/{id}")
	public String addTruongPhongDanhGia(Model model, @PathVariable int id) {
		model.addAttribute("command", service.getTruongPhongDanhGia(id));
		return "quantridanhgia/truongphong/formdanhgianhanvien";
	}

	@RequestMapping(value = "/truongphongdanhgia/edit/{id}")
	public String editTruongPhongDanhGia(Model model, @PathVariable int id) {
		model.addAttribute("command", service.getTruongPhongDanhGia(id));
		return "quantridanhgia/truongphong/formdanhgianhanvien";
	}

	@RequestMapping(value = "/truongphongdanhgia/view/{id}")
	public String showTruongPhongDanhGia(Model model, @PathVariable int id) {
		model.addAttribute("command", service.getTruongPhongDanhGia(id));
		return "quantridanhgia/truongphong/viewtruongphongdanhgia";
	}

	@RequestMapping(value = "/truongphongdanhgia/update", method = RequestMethod.POST)
	public String updateDanhGiaNhanVien(Model model, @ModelAttribute("command") TruongPhongDanhGia danhGia) {
		service.updateDanhGiaNhanVien(danhGia);
		return "redirect:/quantridanhgia/truongphongdanhgia";
	}

	public void createListDanhGiaNhanVien(KyDanhGia kyDanhGia, PhongBan phongBan) {
		if (service.getListNhanVienPhongBan(phongBan).size() > 0) {
			List<HoSoNhanVien> listNhanVien = service.getListNhanVienPhongBan(phongBan);
			List<TruongPhongDanhGia> truongPhongDanhGia = new ArrayList<>();
			for (HoSoNhanVien x : listNhanVien) {
				TruongPhongDanhGia danhGia = new TruongPhongDanhGia();
				danhGia.setKyDanhGia(kyDanhGia);
				danhGia.setPhongBan(phongBan);
				danhGia.setNhanVien(x);
				truongPhongDanhGia.add(danhGia);
			}
			service.createTruongPhongDanhGia(truongPhongDanhGia);
		}
	}
}
