package fasttrackse.ffse1703.fbms.controller.mvpquanliduan;

import java.beans.PropertyEditorSupport;
import java.security.Principal;
import java.util.ArrayList;
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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Database;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Domain;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Framework;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.KhachHang;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Language;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Nhiemvu;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Projects;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.StatusProject;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Technical;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Vendor;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;

import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.DatabaseServices;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.DomainService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.FrameworkService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.KhachHangService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.LanguageService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.NhiemVuService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.ProjectService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.StatusService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.TechnicalService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.VendorService;
import fasttrackse.ffse1703.fbms.service.security.PhongBanService;

@Controller
@RequestMapping("/mvpquanliduan/project")
@SessionAttributes({ "khachHang", "domain", "technical", "vendor", "framework", "database", "status", "framework",
		"language", "status", "phongDuAn" })
public class ProjectController {
	@Autowired
	private KhachHangService khachHangService;

	@Autowired
	private PhongBanService phongBanService;

	@Autowired
	private StatusService statusService;

	@Autowired
	private DomainService domainService;

	@Autowired
	private TechnicalService technicalService;

	@Autowired
	private DatabaseServices databaseService;

	@Autowired
	private FrameworkService frameworkService;

	@Autowired
	private LanguageService languageService;

	@Autowired
	private VendorService vendorService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private NhiemVuService nhiemVuService;

	@RequestMapping("/list-project")
	public String listDomain(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIdPr") == null) {
			pageId = 1;
		} else {
			pageId = (int) session.getAttribute("pageIdPr");
		}
		return "redirect: list-project/" + pageId;
	}

	@RequestMapping(value = "/list-project/{pageId}")
	public String listproject(@PathVariable int pageId, Model model, HttpServletRequest request, HttpSession session,
			final Principal pr, ModelMap mm) {
		try {
		List<Projects> list = new ArrayList<>();
		Collection<? extends GrantedAuthority> vaiTro = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();
		String khachHang = " and khachHang.idKhachHang = '" + request.getParameter("khachhang") + "'";
		if (request.getParameter("khachhang") == null || request.getParameter("khachhang").equals("0")) {
			khachHang = "";
		}
		String roomProject = " and roomProject.maPhongBan = '" + request.getParameter("roomproject") + "'";
		if (request.getParameter("roomproject") == null || request.getParameter("roomproject").equals("0")) {
			roomProject = "";
		}
		String domain = " and domain.idDomain = '" + request.getParameter("domain") + "'";
		if (request.getParameter("domain") == null || request.getParameter("domain").equals("0")) {
			domain = "";
		}
		String status = " and status.idStatus = '" + request.getParameter("status") + "'";
		if (request.getParameter("status") == null || request.getParameter("status").equals("0")) {
			status = "";
		}
		String isPIT = "";
		String isTpp = "";
		String isPm = "";
		String isNv = "";
		String vaiTros = "";
		for (int i = 0; i < vaiTro.size(); i++) {
			vaiTros = vaiTro.toArray()[i] + "";
		}
		if (vaiTros.indexOf("PIT") > 0) {
			isPIT = "";
		} else if (!isTPP().isEmpty()) {
			List<PhongBan> listPhongBan = phongBanService.findAll();
			String granted = isTPP();

			for (PhongBan x : listPhongBan) {
				if (granted.indexOf(x.getMaPhongBan()) > 0) {
					isTpp = " and roomProject.maPhongBan = '" + x.getMaPhongBan() + "'";
				}
			}
		} else if (!isPM().isEmpty()) {			
			isPm = " and pm.maNv = '" + isPM() + "'";
		} else if (!isNv().isEmpty()) {
			String nv = isNv();
			list.addAll(listProjectNv(nv));
			isNv = " and pm.maNv = '999999999'";
			mm.addAttribute("disable", "disabled");
		}
		String search = khachHang + roomProject + domain + status + isTpp + isPm + isNv + isPIT;

		int maxRows = 5;
		int start = (pageId - 1) * maxRows;
		list.addAll(projectService.listProject(search, start, maxRows));
		int totalProject = list.size();
		int totalPage = (int) Math.ceil(totalProject / (double) maxRows);

		model.addAttribute("listProject", list);
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("khachHangs", request.getParameter("khachhang"));
		model.addAttribute("phongDuAns", request.getParameter("roomproject"));
		model.addAttribute("domains", request.getParameter("domain"));
		model.addAttribute("statuss", request.getParameter("status"));
		model.addAttribute("totalProject", totalProject);
		session.setAttribute("pageIdPr", pageId);

		return "MvpQuanLiDuAn/project/listproject";
		}catch(Exception e) {
			return "QuanTriHeThong/error-404";
		}
	}

	public List<Projects> listProjectNv(String nv) {
		List<Projects> listDuAn = new ArrayList<>();
		List<Projects> listPr = projectService.findAll();
		List<Nhiemvu> listNv = nhiemVuService.getByMaNhanVien(nv);
		for (Projects duan : listPr) {
			for (Nhiemvu x : listNv) {
				if (duan.getIdProject().equals(x.getProjects().getIdProject())) {
					listDuAn.add(duan);
				}
			}
		}
		return listDuAn;
	}

	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		try {
		model.addAttribute("command", new Projects());
		return "MvpQuanLiDuAn/project/addproject";
		}catch(Exception e) {
			return "QuanTriHeThong/error-404";
		}
	}

	@RequestMapping(value = "detail-project/{id}")
	public String detailProject(Model model, @PathVariable String id) {
		try {
		Collection<? extends GrantedAuthority> vaiTro = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();
		String vaiTros= "";
		for (int i = 0; i < vaiTro.size(); i++) {
			vaiTros = vaiTro.toArray()[i] + "";
		}
		if (vaiTros.indexOf("PIT") > 0) {	
		} else if (!isTPP().isEmpty()) {
		} else if (!isPM().isEmpty()) {
		} else if (!isNv().isEmpty()) {
			System.out.println("Đâng la nhân viên");
			model.addAttribute("disable", "disabled");
		}
		Projects pr = projectService.findById(id);
		model.addAttribute("project", pr);
		return "MvpQuanLiDuAn/project/detailproject";
		}catch(Exception e) {
			return "QuanTriHeThong/error-404";
		}
	}


	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable String id) {
		try {
		Projects pr = projectService.findById(id);
		String maPB = pr.getRoomProject().getMaPhongBan();
		model.addAttribute("pm", projectService.getPm(maPB));
		model.addAttribute("projects", pr);
		return "MvpQuanLiDuAn/project/updateproject";
		}catch(Exception e) {
			return "QuanTriHeThong/error-404";
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("projects") Projects project, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		try {
		if (result.hasErrors()) {
			model.addAttribute("projects", project);
			return "MvpQuanLiDuAn/project/updateproject";
		}
		project.setIsDelete(1);
		projectService.update(project);
		return "redirect: detail-project/" + project.getIdProject();
		}catch(Exception e) {
			return "QuanTriHeThong/error-404";
		}
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable String id, final RedirectAttributes redirectAttributes) {
		try {
		Projects pr = projectService.findById(id);
		pr.setIsDelete(0);
		projectService.update(pr);
		redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		return "redirect: /ffse-fbms/mvpquanliduan/project/list-project";
		}catch(Exception e) {
			return "QuanTriHeThong/error-404";
		}
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") Projects project, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		try {
		// validation form
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/project/addproject";
		}
		// check trùng nameproject
		int checkName = projectService.checkNameProjects(project.getNameProject());
		if (checkName >= 1) {
			model.addAttribute("messageName", "Tên Du an đã được sử dụng");
			return "MvpQuanLiDuAn/project/addproject";
		}
		int checkMa = projectService.checkMaProjects(project.getIdProject());
		if (checkMa >= 1) {
			model.addAttribute("messageMa", "Mã Du an đã được sử dụng");
			return "MvpQuanLiDuAn/project/addproject";
		}
		project.setIsDelete(1);
		projectService.addNew(project);
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-project";
		}catch(Exception e) {
			return "QuanTriHeThong/error-404";
		}
	}

	// check có phải TPP
	public String isTPP() {
		Collection<? extends GrantedAuthority> granted = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();
		String role = null;

		for (int i = 0; i < granted.size(); i++) {
			role = granted.toArray()[i] + "";
			if (role.indexOf("TPP") > 0 || role.indexOf("PGD") > 0 || role.indexOf("PNS") > 0) {
				return role;
			}
			;
		}
		return "";
	}

	// check có phải PM
	public String isPM() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Projects> listPr = projectService.findAll();
		UserAccount acc = projectService.getAccount(userName);
		String maNvAcc = String.valueOf(acc.getNhanVien().getMaNhanVien());
		for (Projects x : listPr) {
			Integer.parseInt(x.getPm().getMaNv());
			if (Integer.parseInt(maNvAcc) == Integer.parseInt(x.getPm().getMaNv())) {
				return maNvAcc;
			}
		}
		return "";
	}
//check có phải Nhân viên
	public String isNv() {
		Collection<? extends GrantedAuthority> granted = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		UserAccount acc = projectService.getAccount(userName);
		String maNvAcc = String.valueOf(acc.getNhanVien().getMaNhanVien());
		String role;
		for (int i = 0; i < granted.size(); i++) {
			role = granted.toArray()[i] + "";
			if (role.indexOf("NV") > 0) {
				return maNvAcc;
			}
			;
		}
		return "";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Technical.class, "technical", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(technicalService.findById(text));
			}
		});

		binder.registerCustomEditor(Database.class, "database", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(databaseService.findById(text));
			}
		});
		binder.registerCustomEditor(Framework.class, "framework", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(frameworkService.getById(text));
			}
		});
		binder.registerCustomEditor(Language.class, "language", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(languageService.getById(text));
			}
		});
		binder.registerCustomEditor(Vendor.class, "vendor", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(vendorService.findById(text));
			}
		});
		binder.registerCustomEditor(KhachHang.class, "khachHang", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(khachHangService.getById(text));
			}
		});
		binder.registerCustomEditor(Domain.class, "domain", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(domainService.findById(text));
			}
		});
		binder.registerCustomEditor(StatusProject.class, "status", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(statusService.findById(Integer.parseInt(text)));
			}
		});

	}

	@RequestMapping(value = "get-pm/{maPhongBan}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String selectQuan(@PathVariable String maPhongBan) {
		List<HoSoNhanVienPikalong> listPM = projectService.getPm(maPhongBan);

		String json = "[";

		for (int i = 0; i < listPM.size(); i++) {

			if (i == listPM.size() - 1) {
				json += "{\"maNhanVien\":" + "\"" + listPM.get(i).getMaNv() + "\"" + ", \"tenNhanVien\" :" + "\""
						+ listPM.get(i).getMaNv() + " - " + listPM.get(i).getHoTenNv() + "\"" + "}";
			} else {
				json += "{\"maNhanVien\":" + "\"" + listPM.get(i).getMaNv() + "\"" + ", \"tenNhanVien\" :" + "\""
						+ listPM.get(i).getMaNv() + " - " + listPM.get(i).getHoTenNv() + "\"" + "},";
			}
		}
		json += "]";

		return json;

	}

	// Get model cho các form
	@ModelAttribute("khachHang")
	public List<KhachHang> itemKhachHang() {
		return khachHangService.getAll();
	}

	@ModelAttribute("domain")
	public List<Domain> itemDomain() {
		return domainService.findAll();
	}

	@ModelAttribute("technical")
	public List<Technical> itemTechnical() {
		return technicalService.findAll();
	}

	@ModelAttribute("vendor")
	public List<Vendor> itemVendor() {
		return vendorService.findAll();
	}

	@ModelAttribute("database")
	public List<Database> itemDatabase() {
		return databaseService.findAll();
	}

	@ModelAttribute("framework")
	public List<Framework> itemFramework() {
		return frameworkService.getAll();
	}

	@ModelAttribute("language")
	public List<Language> itemLanguage() {
		return languageService.getAll();
	}

	@ModelAttribute("status")
	public List<StatusProject> itemStatus() {
		return statusService.findAll();
	}

	@ModelAttribute("phongDuAn")
	public List<PhongBan> itemPhongDuAn() {

		return phongBanService.findAll();
	}

}
