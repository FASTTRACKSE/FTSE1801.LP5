package fasttrackse.ftse1801.fbms.controller.quanlynhansu;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.service.quanlynhansu.HoSoNhanSuService;
import fasttrackse.ftse1801.fbms.service.quanlynhansu.ThongTinChungChiService;
import fasttrackse.ftse1801.fbms.service.quanlynhansu.ThongTinGiaDinhService;

@Controller
@RequestMapping("QuanLyNhanSu/hoSoNhanVien")
public class HoSoNhanSuController {
	@Autowired
	private HoSoNhanSuService hoSoNhanSuService;

	@Autowired
	private ThongTinChungChiService thongTinChungChiService;

	@Autowired
	private ThongTinGiaDinhService thongTinGiaDinhService;

	private static final String UPLOAD_DIRECTORY = "/upload";

	@RequestMapping(value = "/")
	public String viewHoSoNhanVien(Model model) {
		List<HoSoNhanSu> list = hoSoNhanSuService.getAll();
		model.addAttribute("list", list);
		return "QuanLyNhanSu/hoSoNhanVien/list";
	}

	@RequestMapping(value = "/viewOne/{maNhanVien}", method = RequestMethod.GET)
	public String viewOne(@PathVariable("maNhanVien") int maNhanVien, Model model) {
		model.addAttribute("hoSoNhanVien", hoSoNhanSuService.getById(maNhanVien));
		model.addAttribute("thongTinChungChi", thongTinChungChiService.findByMaNhanVien(maNhanVien));
		model.addAttribute("thongTinGiaDinh", thongTinGiaDinhService.findByMaNhanVien(maNhanVien));
		return "QuanLyNhanSu/hoSoNhanVien/viewOne";
	}

	// test xuất file excel
	@RequestMapping("/excelfile/{maNhanVien}")
	public ModelAndView exportExcelFile(@PathVariable("maNhanVien") int maNhanVien) {
		ModelAndView model = new ModelAndView("fileExcelHoSoNhanVien");
		model.addObject("hoSoNhanVien", hoSoNhanSuService.getById(maNhanVien));
		model.addObject("thongTinChungChi", thongTinChungChiService.findByMaNhanVien(maNhanVien));
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("nhanVien", new HoSoNhanSu());
		return "QuanLyNhanSu/hoSoNhanVien/add_form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("nhanVien") HoSoNhanSu nhanVien, BindingResult result,
			@RequestParam("file") MultipartFile file, HttpSession session,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("nhanVien", new HoSoNhanSu());
			return "QuanLyNhanSu/hoSoNhanVien/add_form";
		}

		try {
			ServletContext context = session.getServletContext();
			String path = context.getRealPath(UPLOAD_DIRECTORY);
			File fileUpload = new File(path);
			if (!fileUpload.exists()) {
				fileUpload.mkdir();
			}
			hoSoNhanSuService.addNew(nhanVien);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyNhanSu/hoSoNhanVien/";
	}

	@RequestMapping(value = "/edit/{maNhanVien}", method = RequestMethod.GET)
	public String editForm(@PathVariable("maNhanVien") int maNhanVien, Model model) {
		model.addAttribute("nhanVien", hoSoNhanSuService.getById(maNhanVien));
		return "QuanLyNhanSu/hoSoNhanVien/edit_form";
	}

	@RequestMapping(value = "/edit/{maNhanVien}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("nhanVien") HoSoNhanSu nhanVien,
			final RedirectAttributes redirectAttributes) {
		try {
			hoSoNhanSuService.update(nhanVien);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/QuanLyNhanSu/hoSoNhanVien/";
	}

	public String upload(@RequestParam MultipartFile file) throws IllegalStateException, IOException {

		String fileName = file.getOriginalFilename();

		String path = "";
		if (fileName.isEmpty()) {
			fileName = "default.jpg";
		} else {
			File dir = new File(path);
			if (!dir.exists())
				dir.mkdirs();
			File fileSave = new File(dir, fileName);
			file.transferTo(fileSave);
		}
		return fileName;

	}
}
