package fasttrackse.ftse1801.fbms.controller.quanlyduan;

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

import fasttrackse.ftse1801.fbms.entity.quanlyduan.NhiemVu;
import fasttrackse.ftse1801.fbms.service.quanlyduan.DuAnService;
import fasttrackse.ftse1801.fbms.service.quanlyduan.NhiemVuService;
import fasttrackse.ftse1801.fbms.service.quanlyduan.VaiTroThanhVienService;
import fasttrackse.ftse1801.fbms.service.quanlynhansu.HoSoNhanSuService;

@Controller
@RequestMapping("/QuanLyDuAn/PhanCongNhiemVu")
public class NhiemVuController {
	
	@Autowired
	private NhiemVuService nhiemVuService;
	@Autowired
	private HoSoNhanSuService hoSoNhanSuService;
	@Autowired
	private VaiTroThanhVienService vaiTroThanhVienService;
	@Autowired 
	private DuAnService duAnService;
	
	@RequestMapping(value = { "/PhanCongNhienVu/create/{maDuAn}" })
	public String phanCongNhiemVu(@PathVariable("maDuAn") int maDuAn, Model model) {
		model.addAttribute("duAn", duAnService.findById(maDuAn));
		model.addAttribute("nhiemVu", new NhiemVu());
		model.addAttribute("vaiTro", vaiTroThanhVienService.findAll());
		model.addAttribute("nhanVien", hoSoNhanSuService.getAll());
		return "QuanLyDuAn/DuAn/PhanCongNhiemVu/add_form";

	}

//	@RequestMapping(value = { "/PhanCongNhiemVu/create" }, method = RequestMethod.POST)
//	public String creat(@ModelAttribute("nhiemVu") @Valid NhiemVu nhiemVu, BindingResult result,
//			RedirectAttributes redirectAttributes, Model model) {
//		if (result.hasErrors()) {
//			System.out.println(result);
//			return "redirect:/PhanCongNhiemVu/add_form";
//		}
//
//		redirectAttributes.addFlashAttribute("message", "<script>alert('Thêm thành công.');</script>");
//		nhiemVuService.add(nhiemVu);
//		int maDuAn = nhiemVu.getMaDuAn();
//		return "redirect:/QuanLyDuAn/PhanCongNhiemVu/list/" + maDuAn;
//	}

	@RequestMapping(value = "/PhanCongNhiemVu/list/{maDuAn}")
	public String listNhiemVu(Model model, @PathVariable("maDuAn") int maDuAn) {
		model.addAttribute("nhiemvu", nhiemVuService.getByDuAn(maDuAn));
		model.addAttribute("duan", duAnService.findById(maDuAn));

		return "QuanLyDuAn/DuAn/PhanCongNhiemVu/list";
	}

	@RequestMapping(value = { "/PhanCongNhiemVu/delete/{maDuAn}/{maNhanVien}/{maVaiTro}" })
	public String phanCongNhiemVuDelete(final RedirectAttributes redirectAttributes, Model model,
			@PathVariable("maDuAn") int maDuAn, @PathVariable("maNhanVien") int maNhanVien,
			@PathVariable("maVaiTro") String maVaiTro) {

		nhiemVuService.delete(nhiemVuService.checkVaiTro(maNhanVien, maVaiTro, maDuAn));
		redirectAttributes.addFlashAttribute("message", "<script>alert('Xóa thành công.');</script>");
		return "redirect:/qlda/DuAn/PhanCongNhiemVu/list" + maDuAn;
	}

	@RequestMapping(value = { "/PhanCongNhiemVu/edit/{maDuAn}/{maNhanVien}/{maVaiTro}" })
	public String phanCongNhiemVuUpdate(Model model, @PathVariable("maDuAn") int maDuAn,
			@PathVariable("maNhanVien") int maNhanVien, @PathVariable("maVaiTro") String maVaiTro) {

		model.addAttribute("duAn", duAnService.findById(maDuAn));
		model.addAttribute("nhanvien", hoSoNhanSuService.getById(maNhanVien));
		model.addAttribute("nhiemvu", nhiemVuService.checkVaiTro(maNhanVien, maVaiTro, maDuAn));
		model.addAttribute("vaitro", vaiTroThanhVienService.findAll());
		return "QuanLyDuAn/DuAn/PhanCongNhiemVu/edit_form";

	}

//	@RequestMapping(value = { "/PhanCongNhiemVu/update" }, method = RequestMethod.POST)
//	public String phanCongNhiemVuUpdate(final RedirectAttributes redirectAttributes, Model model,
//			@ModelAttribute("nhiemvu") NhiemVu nhiemVu, BindingResult result,
//			@RequestParam("oldVaitro") String oldVaiTro) {
//		int maDuAn = nhiemVu.getMaDuAn();
//
//		NhiemVu oldNhiemVu = new NhiemVu();
//		oldNhiemVu.setMaDuAn(maDuAn);
//		oldNhiemVu.setMaNhanVien(nhiemVu.getMaNhanVien());
//		oldNhiemVu.setMaVaiTro(oldVaiTro);
//		nhiemVuService.update(oldNhiemVu);
//		redirectAttributes.addFlashAttribute("message", "<script>alert('Sửa thành công.');</script>");
//		return "redirect:list/" + maDuAn;
//	}

}
