package fasttrackse.ftse1801.fbms.controller.vang_nghi;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import fasttrackse.ftse1801.fbms.entity.vang_nghi.DonXinNghi;
import fasttrackse.ftse1801.fbms.entity.vang_nghi.LoaiNghiPhep;
import fasttrackse.ftse1801.fbms.entity.vang_nghi.TinhTrangNghi;
import fasttrackse.ftse1801.fbms.entity.vang_nghi.TrangThaiVN;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;
import fasttrackse.ftse1801.fbms.service.vang_nghi.QuanLyVangNghiService;


@Controller
@RequestMapping("QuanLyVangNghi/")
public class QuanLyVangNghiController {
	@Autowired
	private QuanLyVangNghiService service;

	public void setService(QuanLyVangNghiService service) {
		this.service = service;
	}
	
	
	@RequestMapping(value = {"/danhsachcho" }, method = RequestMethod.GET)
	public String danhSachChoDuyet(Model model,HttpServletRequest request,HttpSession session,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
	
			String maNhanVien = " and  maNhanVien = " + request.getParameter("idnhanvien") + "";
			if (request.getParameter("idnhanvien") == null || request.getParameter("idnhanvien").equals("0")) {
				maNhanVien = "";
			}
			String maPhongBan = " and idPhongBan = '"+ request.getParameter("maphongban") +"'";
			if (request.getParameter("maphongban") == null || request.getParameter("maphongban").equals("0")  ) {
				maPhongBan = "";
			}
			String search = maNhanVien + maPhongBan;
			int totalRecords = service.danhSachXinNghiChoDuyet().size();
			int recordsPerPage = 4;
			int totalPages = (int)Math.ceil((double)totalRecords/recordsPerPage);
			int startPosition = recordsPerPage * (currentPage - 1);
			model.addAttribute("danhsachcho", service.findAllForPagingCD(startPosition, recordsPerPage,search));
			model.addAttribute("maphongbans", request.getParameter("maphongban"));
			model.addAttribute("maNhanViens", request.getParameter("manhanvien"));
			model.addAttribute("lastPage", totalPages);
			model.addAttribute("currentPage", currentPage);
			
		
		return "QuanLyVangNghi/danhsachcho";
		
	}
	
	@RequestMapping(value = {"/danhsachduyet" }, method = RequestMethod.GET)
	public String danhSachDuyet(Model model,HttpServletRequest request,HttpSession session,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		String maNhanVien = " and  ngayNghi = " + request.getParameter("manhanvien") + "";
		if (request.getParameter("manhanvien") == null || request.getParameter("manhanvien").equals("0")  ) {
			maNhanVien = "";
		}
		String maPhongBan = " and maPhongBan = '"+ request.getParameter("maphongban") +"'";
		if (request.getParameter("maphongban") == null || request.getParameter("maphongban").equals("0")  ) {
			maPhongBan = "";
		}
		String search = maNhanVien + maPhongBan;
		int totalRecords = service.danhSachXinNghiDuyet().size();
		int recordsPerPage = 4;
		int totalPages = (int)Math.ceil((double)totalRecords/recordsPerPage);
		int startPosition = recordsPerPage * (currentPage - 1);
		model.addAttribute("danhsachduyet", service.findAllForPagingD(startPosition, recordsPerPage, search));
		model.addAttribute("maphongbans", request.getParameter("maphongban"));
		model.addAttribute("maNhanViens", request.getParameter("manhanvien"));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		return "QuanLyVangNghi/danhsachduyet";
	}
	
	@RequestMapping(value = {"/danhsachnhap" }, method = RequestMethod.GET)
	public String danhSachNhap(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = service.danhSachXinNghiNhap().size();
		int recordsPerPage = 4;
		int totalPages = (int)Math.ceil((double)totalRecords/recordsPerPage);
		int startPosition = recordsPerPage * (currentPage - 1);
		model.addAttribute("danhsachnhap", service.findAllForPaging(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		return "QuanLyVangNghi/danhsachnhap";
	}
	
	@RequestMapping(value = {"/danhsachbituchoi" }, method = RequestMethod.GET)
	public String danhSachTuChoi(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = service.danhSachXinNghiTuChoi().size();
		int recordsPerPage = 4;
		int totalPages = (int)Math.ceil((double)totalRecords/recordsPerPage);
		int startPosition = recordsPerPage * (currentPage - 1);
		model.addAttribute("danhsachtuchoi", service.findAllForPagingTC(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		return "QuanLyVangNghi/danhsachbituchoi";
	}
	
	@RequestMapping(value = {"/danhsachngaynghi" }, method = RequestMethod.GET)
	public String danhSachNgayNghi(Model model,HttpServletRequest request,HttpSession session,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		
		String maNhanVien = " where  maNhanVien = " + request.getParameter("idnhanvien") + "";
		if (request.getParameter("idnhanvien") == null || request.getParameter("idnhanvien").equals("0")) {
			maNhanVien = "";
		}
		String search = maNhanVien;
		int totalRecords = service.danhSachNgayNghi().size();
		int recordsPerPage = 4;
		int totalPages = (int)Math.ceil((double)totalRecords/recordsPerPage);
		int startPosition = recordsPerPage * (currentPage - 1);
		model.addAttribute("danhsachngaynghi", service.findAllForPagingNN(startPosition, recordsPerPage, search));
		model.addAttribute("maNhanViens", request.getParameter("manhanvien"));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		return "QuanLyVangNghi/danhsachngaynghi";
	}
	
	@RequestMapping(value ="/deleteDate/{maNhanVien}")
	public String deleteDateOff(@PathVariable int maNhanVien, HttpSession session, Model model) {
		service.deleteDateOff(maNhanVien);
		return "redirect:/QuanLyVangNghi/danhsachngaynghi";
	}
	
	@RequestMapping(value = "/updateDate/{maNhanVien}", method = RequestMethod.GET)
	public String editDate(@PathVariable("maNhanVien") int maNhanVien, Model model) {
		model.addAttribute("editDate", service.findByIdDateOff(maNhanVien));
		return "QuanLyVangNghi/editDate";
	}
	
	@RequestMapping(value = "/editDate/save", method = RequestMethod.POST)
	public String editStatus(  @ModelAttribute("editDate") @Valid TinhTrangNghi nn,Model model,
			BindingResult result,final RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
			return "QuanLyVangNghi/editDate";
		}
		service.updateNgayNghi(nn);
		redirectAttributes.addFlashAttribute("messageSuccess", "Sửa thành công...");
		return "redirect:/QuanLyVangNghi/danhsachngaynghi";
	}
	
	@RequestMapping(value = "/themmoi", method = RequestMethod.GET)
	public String listDonNgayNghi(Model model) {
		model.addAttribute("createDate", new TinhTrangNghi());
		return "QuanLyVangNghi/createDate";
}
	@RequestMapping(value = {"/createDate/submit"}, method = RequestMethod.POST)
	public String createTrangThai( @ModelAttribute("createDate") @Valid TinhTrangNghi nn,
			BindingResult result,final RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
			return "QuanLyVangNghi/createDate";
		}
		service.createNgayNghi(nn);
		redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công...");
		return "redirect:/QuanLyVangNghi/danhsachngaynghi";
	}
	
	
	@RequestMapping(value = "/soandonmoi", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("taodonmoi", new DonXinNghi());
		return "QuanLyVangNghi/soandonmoi";
	}
	
	@RequestMapping(value = {"/taodonmoi/nhap"}, method = RequestMethod.POST)
	public String listDonNhap( @ModelAttribute("taodonmoi") @Valid DonXinNghi nv,
			BindingResult result,Model model,final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("messageER", "Lỗi. Xin thử lại!");
			return "QuanLyVangNghi/soandonmoi";
		} 
		service.create(nv);
		redirectAttributes.addFlashAttribute("messageSC", "Lưu nháp thành công...");
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/taodonmoi/choduyet", method = RequestMethod.POST)
	public String listDonChoDuyet(@Valid @ModelAttribute("taodonmoi")  DonXinNghi nv,BindingResult result,
			Model model,final RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("messageER", "Lỗi. Xin thử lại!");
			return "QuanLyVangNghi/soandonmoi";}
		service.createWait(nv);
		redirectAttributes.addFlashAttribute("messageSC", "Đã thêm vào danh sách chờ...");
		return "redirect:/home";
	}
	
	
	@ModelAttribute("lydo")
	public List<LoaiNghiPhep> danhSachLyDo() {
		return this.service.loadAllLyDo();
	}
	
	@ModelAttribute("hoso")
	public List<HoSoNhanSu> danhSachHoSoNhanSu() {
		return this.service.loadAllHoSo();
	}
	
	@ModelAttribute("ngaynghi")
	public List<TinhTrangNghi> danhSachNgayNghi(){
		return this.service.danhSachNgayNghi();
	}
	
	@ModelAttribute("phongban")
	public List<PhongBan> danhSachPhongBan(){
		return this.service.loadAllPhongBan();
	}
	
	@RequestMapping(value = {"/delete/{id}","/taodonmoi/choduyet"})
	public String delete(@PathVariable int id, HttpSession session, Model model) {
		service.delete(id);
		return "redirect:/QuanLyVangNghi/danhsachnhap";
	}
	
	@RequestMapping(value = {"/deleteBrowse/{id}"})
	public String deleteBrowse(@PathVariable int id, HttpSession session, Model model) {
		service.delete(id);
		return "redirect:/QuanLyVangNghi/danhsachduyet";
	}
	
	@RequestMapping(value = "/suanhap/{id}", method = RequestMethod.GET)
	public String edit_view(@PathVariable("id") int id, Model model) {
		model.addAttribute("suadon", service.findById(id));
		service.delete(id);
		return "QuanLyVangNghi/suanhap";
	}

	@RequestMapping(value = "/trove/nhap", method = RequestMethod.POST)
	public String editNhap( @ModelAttribute("suadon") @Valid DonXinNghi nv,
			BindingResult result,Model model)
			throws SQLException {
		return "QuanLyVangNghi/danhsachnhap";
	}
	
	@RequestMapping(value = "/updatenhap/choduyet", method = RequestMethod.POST)
	public String editChoDuyet(  @ModelAttribute("suadon") @Valid DonXinNghi nv,Model model,
			BindingResult result,final RedirectAttributes redirectAttributes)
			throws SQLException {
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
			return "/QuanLyVangNghi/suanhap";
		}
		service.updateNhap(nv);
		redirectAttributes.addFlashAttribute("messageSuccess", "Đã thêm vào danh sách chờ...");
		return "redirect:/QuanLyVangNghi/danhsachcho";
	}
	
	@RequestMapping(value = "/suachoduyet/{id}", method = RequestMethod.GET)
	public String edit_wait(@PathVariable("id") int id, Model model) {
		model.addAttribute("suachoduyet", service.findById(id));
		service.delete(id);
		return "QuanLyVangNghi/suachoduyet";
	}
	
	@RequestMapping(value = "/updateduyet/duyet", method = RequestMethod.POST)
	public String listDonDuyet( @ModelAttribute("suachoduyet") @Valid DonXinNghi nv,
			BindingResult result,Model model,final RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
			return "/QuanLyVangNghi/suachoduyet";
		} 
		service.createBrowse(nv);
		redirectAttributes.addFlashAttribute("messageSuccess", "Đã duyệt đơn...");
		return "redirect:/QuanLyVangNghi/danhsachduyet";
	}
	
	@RequestMapping(value = "/updatenhap/tuchoi", method = RequestMethod.POST)
	public String listDonTuChoi( @ModelAttribute("suachoduyet") @Valid DonXinNghi nv,
			BindingResult result,Model model,final RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
			return "/QuanLyVangNghi/suachoduyet";
		}
		service.createfeedback(nv);
		redirectAttributes.addFlashAttribute("messageSuccess", "Đã thêm vào danh sách  bị từ chối...");
		return "redirect:/QuanLyVangNghi/danhsachbituchoi";
	}
	
	@RequestMapping(value = "/danhsachtrangthai", method = RequestMethod.GET)
	public String danhSachTrangThai(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = service.danhSachTrangThai().size();
		int recordsPerPage = 4;
		int totalPages = (int)Math.ceil((double)totalRecords/recordsPerPage);
		int startPosition = recordsPerPage * (currentPage - 1);
		model.addAttribute("danhsachtrangthai", service.findAllForPagingTrangThai(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		return "QuanLyVangNghi/danhsachtrangthai";
	}
		@RequestMapping(value = "/createstatus", method = RequestMethod.GET)
		public String listDonTrangThai(Model model) {
			model.addAttribute("createstatus", new TrangThaiVN());
			return "QuanLyVangNghi/createstatus";
}
		@RequestMapping(value = {"/createstatus/submit"}, method = RequestMethod.POST)
		public String createTrangThai( @ModelAttribute("createstatus") @Valid TrangThaiVN tt,
				BindingResult result,Model model,final RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
				return "QuanLyVangNghi/createstatus";
			}
			service.createTrangThai(tt);
			redirectAttributes.addFlashAttribute("messageSuccess", "Đã được thêm mới...");
			return "redirect:/QuanLyVangNghi/danhsachtrangthai";
		}
		
		@RequestMapping(value = {"/deleteStatus/${.id}"})
		public String deleteStatus(@PathVariable int id, HttpSession session, Model model) {
			service.deleteTrangThai(id);;
			return "redirect:/QuanLyVangNghi/danhsachtrangthai";
		}
		
		@RequestMapping(value = "/suatrangthai/{id}", method = RequestMethod.GET)
		public String listFormStatus(@PathVariable("id") int id, Model model) {
			model.addAttribute("editStatus", service.findByIdTrangThai(id));
			return "QuanLyVangNghi/editstatus";
		}
		
		@RequestMapping(value = "/editstatus/save", method = RequestMethod.POST)
		public String editStatus(  @ModelAttribute("editStatus") @Valid TrangThaiVN tt,Model model,
				BindingResult result,final RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
				return "QuanLyVangNghi/editstatus";
			}
			service.updateTrangThai(tt);;
			redirectAttributes.addFlashAttribute("messageSuccess", "Sửa thành công...");
			return "redirect:/QuanLyVangNghi/danhsachtrangthai";
		}
		
		@RequestMapping("/viewNhap/{id}")
		public String viewNhap(@PathVariable("id") int id, Model model) {
			model.addAttribute("list", service.findById(id));
			return "QuanLyVangNghi/xemTTNVNhap";
		}
		
		@RequestMapping("/viewTuChoi/{id}")
		public String viewTuChoi(@PathVariable("id") int id, Model model) {
			model.addAttribute("list", service.findById(id));
			return "QuanLyVangNghi/xemTTNVTuChoi";
		}
		
		@RequestMapping("/viewChoDuyet/{id}")
		public String viewChoDuyet(@PathVariable("id") int id, Model model) {
			model.addAttribute("list", service.findById(id));
			return "QuanLyVangNghi/xemTTNVChoDuyet";
		}
		
		@RequestMapping("/viewDuyet/{id}")
		public String viewDuyet(@PathVariable("id") int id, Model model) {
			model.addAttribute("list", service.findById(id));
			return "QuanLyVangNghi/xemTTNVDuocDuyet";
		}
		
		@RequestMapping("/viewNgayNghi/{maNhanVien}")
		public String viewNgayNghi(@PathVariable("maNhanVien") int maNhanVien, Model model) {
			model.addAttribute("list", service.findByIdDateOff(maNhanVien));
			return "QuanLyVangNghi/xemTTNNNV";
		}
		
		@RequestMapping("/viewTrangThai/{id}")
		public String viewTrangThai(@PathVariable("id") int id, Model model) {
			model.addAttribute("list", service.findByIdTrangThai(id));
			return "QuanLyVangNghi/xemTTTT";
		}
}
