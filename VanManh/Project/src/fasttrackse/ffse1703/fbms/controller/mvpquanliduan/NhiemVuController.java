package fasttrackse.ffse1703.fbms.controller.mvpquanliduan;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Nhiemvu;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Projects;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Roles;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.NhiemVuService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.ProjectService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.RolesService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HoSoNhanVienPikalongService;

@Controller
@RequestMapping("/mvpquanliduan/nhiemvu")
public class NhiemVuController {
	@Autowired
	private NhiemVuService nhiemVuService;
	@Autowired
	private HoSoNhanVienPikalongService hoSoNhanVienPikalongService;
	@Autowired
	private RolesService rolesService;
	@Autowired
	private ProjectService projectService;
	

	public void setNhiemVuService(NhiemVuService nhiemVuService) {
		this.nhiemVuService = nhiemVuService;
	}
	@RequestMapping(value = "/list-nhiemvu/{idProjects}/{pageId}")
	public String listNhiemVu(Model model,@PathVariable String idProjects,@PathVariable  int pageId,HttpServletRequest request,HttpSession session) {
		
		try {
		//  and hoSoNhanVien.maNv = "00001"
		String maNVSearch =	" and hoSoNhanVien.maNv = '" + request.getParameter("maNV")+"'";
		if(request.getParameter("maNV")==null || request.getParameter("maNV").equals("0")) {
			maNVSearch="";
		}
		String vaiTroSearch = "and roles.idRoles=" +request.getParameter("vaiTro");
		if(request.getParameter("vaiTro")==null || request.getParameter("vaiTro").equals("0") ) {
			vaiTroSearch="";
		}
		String search= maNVSearch + vaiTroSearch;
		int maxRows= 5;
		int start = (pageId - 1) * maxRows;
		int totalLanguage = nhiemVuService.countNhiemvu(idProjects, search);
		int totalPage = (int) Math.ceil(totalLanguage / (double) maxRows);
		if (pageId == 0) {
			pageId = 1;
		}
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
			
			model.addAttribute("disable", "disabled");
		}
		
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("pageIds", pageId);
		
		List<Nhiemvu> list=nhiemVuService.getByDuAn(idProjects, search, start, maxRows);
		//Nhiemvu listID = nhiemVuService.getByID(id);

		model.addAttribute("idProjects", idProjects);
		model.addAttribute("listNhiemVu", list);
		List<HoSoNhanVienPikalong> nhanVienList = hoSoNhanVienPikalongService.listNhanVien();
		model.addAttribute("nhanVienList", nhanVienList);
		List<Roles> listRoles = rolesService.findAll();
		model.addAttribute("listRoles", listRoles);
		model.addAttribute("project",projectService.findById(idProjects));
		
		
		return "MvpQuanLiDuAn/phancongnhiemvu/list";
		}catch(Exception e) {
			return "QuanTriHeThong/error-404";
		}
	}
	@RequestMapping("/show-form-add/{idProjects}")
	public String showFormAdd(Model model,@PathVariable String idProjects) {
		try {
		Projects pr = projectService.findById(idProjects);
		model.addAttribute("duAn", pr);
		model.addAttribute("command", new Nhiemvu());
		List<HoSoNhanVienPikalong> nhanVienList = hoSoNhanVienPikalongService.listNhanVien();
		model.addAttribute("nhanVienList", nhanVienList);
		List<Roles> list = rolesService.findAll();

		List<Roles> listRoles = new ArrayList<>();
		for (Roles r : list) {
			if (!r.getNameRoles().equals("PM")) {
				listRoles.add(r);
			}
		}
		model.addAttribute("listRoles", listRoles);
		model.addAttribute("idProjects",idProjects);

		return "MvpQuanLiDuAn/phancongnhiemvu/add_form";
		}catch(Exception e) {
			return "QuanTriHeThong/error-404";
		}
	}
	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") Nhiemvu nhiemVu, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		try {
		if (result.hasErrors()) {
			List<HoSoNhanVienPikalong> nhanVienList = hoSoNhanVienPikalongService.listNhanVien();
			model.addAttribute("nhanVienList", nhanVienList);
			List<Roles> list1 = rolesService.findAll();
			model.addAttribute("listRoles", list1);
			model.addAttribute("idProjects",nhiemVu.getProjects().getIdProject());
			return "MvpQuanLiDuAn/phancongnhiemvu/add_form";
		}
		int checkRole=nhiemVuService.checkRole(nhiemVu.getHoSoNhanVien().getMaNv(),nhiemVu.getRoles().getIdRoles(), nhiemVu.getProjects().getIdProject());
		if(checkRole >=1) {
			model.addAttribute("messageRole", "Vai trò đã tồn tại");
			List<HoSoNhanVienPikalong> nhanVienList = hoSoNhanVienPikalongService.listNhanVien();
			model.addAttribute("nhanVienList", nhanVienList);
			List<Roles> list1 = rolesService.findAll();
			model.addAttribute("listRoles", list1);
			return "MvpQuanLiDuAn/phancongnhiemvu/add_form";
		}
		nhiemVu.setStatus(1);
		nhiemVuService.add(nhiemVu);
		;
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-nhiemvu/" + nhiemVu.getProjects().getIdProject() +"/1";
		}catch(Exception e) {
			return "QuanTriHeThong/error-404";
		}
	}

	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable int id) {
		try {
		List<HoSoNhanVienPikalong> nhanVienList = hoSoNhanVienPikalongService.listNhanVien();
		model.addAttribute("nhanVienList", nhanVienList);
		List<Roles> list = rolesService.findAll();
		List<Roles> listRoles = new ArrayList<>();
		for (Roles r : list) {
			if (!r.getNameRoles().equals("PM")) {
				listRoles.add(r);
			}
		}
		model.addAttribute("listRoles", listRoles);
		Nhiemvu nhiemVu = nhiemVuService.getByid(id);
		model.addAttribute("nhiemVu", nhiemVu);
		return "MvpQuanLiDuAn/phancongnhiemvu/update_form";
		}catch(Exception e) {
			return "QuanTriHeThong/error-404";
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("nhiemVu") Nhiemvu nhiemVu, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		try {
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/phancongnhiemvu/update_form";
		}	
		nhiemVu.setStatus(1);
		nhiemVuService.update(nhiemVu);
		return "redirect: /ffse-fbms/mvpquanliduan/nhiemvu/list-nhiemvu/" + nhiemVu.getProjects().getIdProject()+"/1";
		}catch(Exception e) {
			return "QuanTriHeThong/error-404";
		}
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable int id, final RedirectAttributes redirectAttributes) {
		try {
		Nhiemvu nhiemVu  = nhiemVuService.getByid(id);
		nhiemVu.setStatus(0);
		nhiemVuService.update(nhiemVu);
		return "redirect: /ffse-fbms/mvpquanliduan/nhiemvu/list-nhiemvu/"+ nhiemVu.getProjects().getIdProject() +"/1";
		}catch(Exception e) {
			return "QuanTriHeThong/error-404";
		}
	}
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
	public String isPM() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Projects> listPr = projectService.findAll();
		UserAccount acc = projectService.getAccount(userName);
		String maNvAcc = String.valueOf(acc.getNhanVien().getMaNhanVien());
		System.out.println("my account la " + maNvAcc);
		for (Projects x : listPr) {
			Integer.parseInt(x.getPm().getMaNv());
			if (Integer.parseInt(maNvAcc) == Integer.parseInt(x.getPm().getMaNv())) {
				return maNvAcc;
			}
		}
		return "";
	}

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
}
