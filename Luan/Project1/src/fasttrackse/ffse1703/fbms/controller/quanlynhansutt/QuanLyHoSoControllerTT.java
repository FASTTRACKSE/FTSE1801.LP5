package fasttrackse.ffse1703.fbms.controller.quanlynhansutt;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.QuanHuyenTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.XaPhuongTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.DanTocServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.QuanHuyenServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.QuanLyHoSoServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.QuocTichServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.ThongTinBangCapServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.ThongTinGiaDinhServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.TinhThanhServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.TinhTrangHonNhanServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.XaPhuongServiceTT;
import fasttrackse.ffse1703.fbms.service.security.ChucDanhService;
import fasttrackse.ffse1703.fbms.service.security.PhongBanService;
import fasttrackse.ffse1703.fbms.controller.quanlynhansutt.FileExcelQuanLyNhanSuTT;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/quanlynhansutt/ho_so/")
public class QuanLyHoSoControllerTT {

	@Autowired
	private QuanLyHoSoServiceTT quanLyHoSoServiceTT;

	@Autowired
	private QuocTichServiceTT quocTichServiceTT;

	@Autowired
	private DanTocServiceTT danTocServiceTT;

	@Autowired
	private TinhThanhServiceTT tinhThanhServiceTT;

	@Autowired
	private QuanHuyenServiceTT quanHuyenServiceTT;

	@Autowired
	private XaPhuongServiceTT xaPhuongServiceTT;

	@Autowired
	private ChucDanhService chucDanhService;

	@Autowired
	private PhongBanService phongBanService;

	@Autowired
	private ThongTinBangCapServiceTT thongTinBangCapServiceTT;

	@Autowired
	private ThongTinGiaDinhServiceTT thongTinGiaDinhServiceTT;

	public void setThongTinBangCapServiceTT(ThongTinBangCapServiceTT thongTinBangCapServiceTT) {
		this.thongTinBangCapServiceTT = thongTinBangCapServiceTT;
	}

	public void setThongTinGiaDinhServiceTT(ThongTinGiaDinhServiceTT thongTinGiaDinhServiceTT) {
		this.thongTinGiaDinhServiceTT = thongTinGiaDinhServiceTT;
	}

	@Autowired
	private TinhTrangHonNhanServiceTT tinhTrangHonNhanServiceTT;

	public TinhTrangHonNhanServiceTT getTinhTrangHonNhanServiceTT() {
		return tinhTrangHonNhanServiceTT;
	}

	public void setTinhTrangHonNhanServiceTT(TinhTrangHonNhanServiceTT tinhTrangHonNhanServiceTT) {
		this.tinhTrangHonNhanServiceTT = tinhTrangHonNhanServiceTT;
	}

	public QuanLyHoSoServiceTT getQuanLyHoSoServiceTT() {
		return quanLyHoSoServiceTT;
	}

	public void setQuanLyHoSoServiceTT(QuanLyHoSoServiceTT quanLyHoSoServiceTT) {
		this.quanLyHoSoServiceTT = quanLyHoSoServiceTT;
	}

	public void setQuocTichServiceTT(QuocTichServiceTT quocTichServiceTT) {
		this.quocTichServiceTT = quocTichServiceTT;
	}

	public void setDanTocServiceTT(DanTocServiceTT danTocServiceTT) {
		this.danTocServiceTT = danTocServiceTT;
	}

	public void setTinhThanhServiceTT(TinhThanhServiceTT tinhThanhServiceTT) {
		this.tinhThanhServiceTT = tinhThanhServiceTT;
	}

	public void setQuanHuyenServiceTT(QuanHuyenServiceTT quanHuyenServiceTT) {
		this.quanHuyenServiceTT = quanHuyenServiceTT;
	}

	public void setXaPhuongServiceTT(XaPhuongServiceTT xaPhuongServiceTT) {
		this.xaPhuongServiceTT = xaPhuongServiceTT;
	}

	public void setChucDanhService(ChucDanhService chucDanhService) {
		this.chucDanhService = chucDanhService;
	}

	public void setPhongBanService(PhongBanService phongBanService) {
		this.phongBanService = phongBanService;
	}

	private static final String UPLOAD_DIRECTORY = "/upload";

	HoSoNhanVienTT getNhanVien = new HoSoNhanVienTT();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indext(Model model) {
		model.addAttribute("listHoSo", quanLyHoSoServiceTT.getAllHoSo());
		return "QuanLyNhanSuTT/QuanLyHoSoTT/list";
	}

	// test thử chi tiết cv cho nhan viên
	@RequestMapping(value = "/viewOne/{maNhanVien}", method = RequestMethod.GET)
	public String viewOne(@PathVariable("maNhanVien") int maNhanVien, Model model) {
		model.addAttribute("hoSoNhanVienTT", quanLyHoSoServiceTT.findByMaNhanVien(maNhanVien));
		model.addAttribute("thongTinBangCap", thongTinBangCapServiceTT.viewOne(maNhanVien));
		model.addAttribute("thongTinGiaDinh", thongTinGiaDinhServiceTT.viewOne(maNhanVien));
		return "QuanLyNhanSuTT/QuanLyHoSoTT/viewOne";
	}

	// test xuất file excel
	@RequestMapping("excelfile/{maNhanVien}")
	public ModelAndView exportExcelFile(@PathVariable("maNhanVien") int maNhanVien) {
		ModelAndView model = new ModelAndView("FileExcelHoSoNhanVien");
		model.addObject("hoSoNhanVienTT", quanLyHoSoServiceTT.findByMaNhanVien(maNhanVien));
		model.addObject("thongTinGiaDinhTT", thongTinGiaDinhServiceTT.viewOne(maNhanVien));
		return model;
	}

	// page view thông tin một Nhân viên
	@RequestMapping("view/{maNhanVien}")
	public String view(@PathVariable int maNhanVien, Model model) throws IllegalStateException, IOException {
		model.addAttribute("formHoso", quanLyHoSoServiceTT.findByMaNhanVien(maNhanVien));
		model.addAttribute("viewOne", this.quanLyHoSoServiceTT.viewOne(maNhanVien));
		model.addAttribute("maNhanVien", maNhanVien);
		model.addAttribute("listTrangTrangHonNhan", tinhTrangHonNhanServiceTT.findAll());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		model.addAttribute("listQuocTich", quocTichServiceTT.getAllQuocTich());
		model.addAttribute("listChucDanh", chucDanhService.findAll());
		model.addAttribute("listDanToc", danTocServiceTT.listDanTocTT());
		model.addAttribute("listThanhPho", tinhThanhServiceTT.getAllTinhThanh());
		return "QuanLyNhanSuTT/QuanLyHoSoTT/view";
	}

	// thêm nhân viên
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String formAdd(Model model, final RedirectAttributes redirectAttributes) {

		model.addAttribute("formHoso", new HoSoNhanVienTT());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		model.addAttribute("listQuocTich", quocTichServiceTT.getAllQuocTich());
		model.addAttribute("listChucDanh", chucDanhService.findAll());
		model.addAttribute("listDanToc", danTocServiceTT.listDanTocTT());
		model.addAttribute("listThanhPho", tinhThanhServiceTT.getAllTinhThanh());
		model.addAttribute("listTrangTrangHonNhan", tinhTrangHonNhanServiceTT.findAll());
		return "QuanLyNhanSuTT/QuanLyHoSoTT/add_hoso";
	}

	// xử lý lưu khi thêm nhân viên
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String addsave(@ModelAttribute("formHoso") @Valid HoSoNhanVienTT hoSoNhanVienTT, BindingResult result,
			Model model, @RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
		if (result.hasErrors()) {
			model.addAttribute("listPhongBan", phongBanService.findAll());
			model.addAttribute("listQuocTich", quocTichServiceTT.getAllQuocTich());
			model.addAttribute("listChucDanh", chucDanhService.findAll());
			model.addAttribute("listDanToc", danTocServiceTT.listDanTocTT());
			model.addAttribute("listThanhPho", tinhThanhServiceTT.getAllTinhThanh());
			model.addAttribute("listTrangTrangHonNhan", tinhTrangHonNhanServiceTT.findAll());
			return "QuanLyNhanSuTT/QuanLyHoSoTT/add_hoso";

		}
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		File fileUpload = new File(path);
		if (!fileUpload.exists()) {
			fileUpload.mkdir();
		}

		String filename = file.getOriginalFilename();
		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(path + File.separator + filename)));
		hoSoNhanVienTT.setAnhDaiDien(filename);
		stream.write(bytes);
		stream.flush();
		stream.close();
		hoSoNhanVienTT.setIsdelete(1);
		quanLyHoSoServiceTT.addHoSoNhanVien(hoSoNhanVienTT);
		return "redirect:/quanlynhansutt/ho_so/";
	}

	// sửa nhân viên
	@RequestMapping("/edit/{maNhanVien}")
	public String showFormUpdate(@PathVariable("maNhanVien") int maNhanVien, Model model)
			throws IllegalStateException, IOException {
		model.addAttribute("formHoso", quanLyHoSoServiceTT.findByMaNhanVien(maNhanVien));
		model.addAttribute("listTrangTrangHonNhan", tinhTrangHonNhanServiceTT.findAll());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		model.addAttribute("listQuocTich", quocTichServiceTT.getAllQuocTich());
		model.addAttribute("listChucDanh", chucDanhService.findAll());
		model.addAttribute("listDanToc", danTocServiceTT.listDanTocTT());
		model.addAttribute("listThanhPho", tinhThanhServiceTT.getAllTinhThanh());
		return "QuanLyNhanSuTT/QuanLyHoSoTT/edit";
	}

	// xử lý sửa khi lưu
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String editSave(@ModelAttribute("formHoso") HoSoNhanVienTT hoSoNhanVienTT, BindingResult result,
			@RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
		hoSoNhanVienTT.setAnhDaiDien(getNhanVien.getAnhDaiDien());
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		File fileUpload = new File(path);
		if (!fileUpload.exists()) {
			fileUpload.mkdir();
		}
		String filename = file.getOriginalFilename();
		if (!filename.isEmpty()) {
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator + filename)));
			hoSoNhanVienTT.setAnhDaiDien(filename);
			stream.write(bytes);
			stream.flush();
			stream.close();
		}
		hoSoNhanVienTT.setIsdelete(1);
		quanLyHoSoServiceTT.updateHoSoNhanVien(hoSoNhanVienTT);
		return "redirect:/quanlynhansutt/ho_so/";
	}

	// hiển thị thành phố
	@RequestMapping(value = "selectquan/{maThanhPho}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String selectQuan(@PathVariable String maThanhPho) {
		List<QuanHuyenTT> listQuanHuyen = quanHuyenServiceTT.listQuanHuyen(maThanhPho);

		String json = "[";

		for (int i = 0; i < listQuanHuyen.size(); i++) {

			if (i == listQuanHuyen.size() - 1) {
				json += "{\"maQuanHuyen\":" + "\"" + listQuanHuyen.get(i).getMaQuanHuyen() + "\""
						+ ", \"tenQuanHuyen\" :" + "\"" + listQuanHuyen.get(i).getTenQuanHuyen() + "\"" + "}";
			} else {
				json += "{\"maQuanHuyen\":" + "\"" + listQuanHuyen.get(i).getMaQuanHuyen() + "\""
						+ ", \"tenQuanHuyen\" :" + "\"" + listQuanHuyen.get(i).getTenQuanHuyen() + "\"" + "},";
			}
		}
		json += "]";

		return json;

	}

	// quận huyện
	@RequestMapping(value = "selectphuong/{maQuanHuyen}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String selectPhuong(@PathVariable String maQuanHuyen) {
		List<XaPhuongTT> listPhuong = xaPhuongServiceTT.getAllXaPhuong(maQuanHuyen);

		String json = "[";

		for (int i = 0; i < listPhuong.size(); i++) {
			if (i == listPhuong.size() - 1) {
				json += "{\"maXa\": \"" + listPhuong.get(i).getMaXa() + "\", " + "\"tenXa\": \""
						+ listPhuong.get(i).getTenXa() + "\"}";
			} else {
				json += "{\"maXa\": \"" + listPhuong.get(i).getMaXa() + "\", " + "\"tenXa\": \""
						+ listPhuong.get(i).getTenXa() + "\"}" + ",";
			}
		}
		json += "]";

		return json;
	}

	// delete an employee's contract
	@RequestMapping("/delete/{maNhanVien}")
	public String remove(@PathVariable("maNhanVien") int maNhanVien, final RedirectAttributes redirectAttributes) {
		HoSoNhanVienTT hd = quanLyHoSoServiceTT.findByMaNhanVien(maNhanVien);
		hd.setIsdelete(0);
		quanLyHoSoServiceTT.updateHoSoNhanVien(hd);
		return "redirect:/quanlynhansutt/ho_so/";
	}

}
