package fasttrackse.ftse1801.fbms.controller.quanlyduan;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.DuAn;
import fasttrackse.ftse1801.fbms.service.quanlyduan.CongNgheService;
import fasttrackse.ftse1801.fbms.service.quanlyduan.ContactService;
import fasttrackse.ftse1801.fbms.service.quanlyduan.DatabaseServices;
import fasttrackse.ftse1801.fbms.service.quanlyduan.DomainService;
import fasttrackse.ftse1801.fbms.service.quanlyduan.DuAnService;
import fasttrackse.ftse1801.fbms.service.quanlyduan.FrameworkService;
import fasttrackse.ftse1801.fbms.service.quanlyduan.NgonNguService;
import fasttrackse.ftse1801.fbms.service.quanlyduan.TrangThaiService;
import fasttrackse.ftse1801.fbms.service.quanlyduan.VaiTroThanhVienService;
import fasttrackse.ftse1801.fbms.service.quanlynhansu.HoSoNhanSuService;
import fasttrackse.ftse1801.fbms.service.security.PhongBanService;

@Controller
@RequestMapping("/QuanLyDuAn/DuAn")

public class DuAnController {
@Autowired
private DuAnService duAnService;
@Autowired
private CongNgheService congNgheService;
@Autowired
private DatabaseServices databaseServices;
@Autowired
private DomainService domainService;
@Autowired
private FrameworkService frameworkService;
@Autowired
private TrangThaiService trangThaiService;
@Autowired
private VaiTroThanhVienService vaiTroThanhVienService;
@Autowired
private ContactService contactService;
@Autowired
private NgonNguService ngonNguService;
@Autowired
private PhongBanService phongBanService;
@Autowired
private HoSoNhanSuService hoSoNhanSuService;
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
	String maContactSearch = " and contact.maContact = '" + request.getParameter("maContact") + "'";
	if (request.getParameter("maContact") == null || request.getParameter("maContact").equals("0")) {
		maContactSearch = "";
	}
	String maPhongBanSearch = " and phongBan.maPhongBan = '" + request.getParameter("maPhongBan") + "'";
	if (request.getParameter("maPhongBan") == null || request.getParameter("maPhongBan").equals("0")) {
		maPhongBanSearch = "";
	}
	String trangThaiSearch = " and trangThai.maTrangThai = '" + request.getParameter("maTrangThai") + "'";
	if (request.getParameter("maTrangThai") == null || request.getParameter("maTrangThai").equals("0")) {
		trangThaiSearch = "";
	}
	String search = maDuanSearch + maContactSearch + maPhongBanSearch + trangThaiSearch;

	int start = (page - 1) * perPage;
	List<DuAn> list = duAnService.listDuAn(search,perPage,start );

	model.addAttribute("list", list);
	model.addAttribute("total", totalPage(perPage, search));
	model.addAttribute("page", page);
	model.addAttribute("duan", duAnService.findAll());
	model.addAttribute("contact", contactService.getAll());
	model.addAttribute("phongBan", phongBanService.findAll());
	model.addAttribute("trangThai", trangThaiService.findAll());

	return "QuanLyDuAn/DuAn/list";
}
public int totalPage(int perPage, String search) {
	int totalDuAn = duAnService.count(search);
	int totalPage = (int) Math.ceil(totalDuAn  / (double) perPage);
	return totalPage;
}

}
	