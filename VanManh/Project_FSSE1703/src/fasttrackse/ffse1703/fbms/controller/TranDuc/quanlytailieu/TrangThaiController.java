package fasttrackse.ffse1703.fbms.controller.TranDuc.quanlytailieu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TaiLieu;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TrangThaiTaiLieu;
import fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu.TaiLieuService;
import fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu.TrangThaiService;

@Controller
@RequestMapping("/TranDuc-QuanLyTaiLieu/TrangThai")
public class TrangThaiController {
	@Autowired
	private TaiLieuService serviceTL;
	@Autowired
	private TrangThaiService serviceTT;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewTrangThai(Model model) {
		model.addAttribute("listTrangThai", serviceTT.listAllTrangThaiDel0());
		return "TranDuc-QuanLyTaiLieu/TrangThai/TrangThaiList";
	}

	@RequestMapping(value = "/add_formTT", method = RequestMethod.GET)
	public String addFormTT(Model model) {
		model.addAttribute("TrangThai", new TrangThaiTaiLieu());
		return "TranDuc-QuanLyTaiLieu/TrangThai/add_formTT";
	}

	@RequestMapping(value = "/add_formTT", method = RequestMethod.POST)
	public String doAddTT(@ModelAttribute("TrangThai") TrangThaiTaiLieu tt, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		try {
			if (result.hasErrors()) {
				return "TranDuc-QuanLyTaiLieu/TrangThai/edit_formTT";
			}
			tt.setIsDelete(0);
			serviceTT.addTT(tt);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm Mới Thành Công !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin Thử Lại !");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TrangThai/";
	}

	@RequestMapping(value = "/sua/{maTT}", method = RequestMethod.GET)
	public String editFormTT(@PathVariable("maTT") String maTT, Model model) {
		model.addAttribute("TrangThai", serviceTT.getTTbyID(maTT));
		return "TranDuc-QuanLyTaiLieu/TrangThai/edit_formTT";
	}

	@RequestMapping(value = "/sua/{maTT}", method = RequestMethod.POST)
	public String doEditTT(@ModelAttribute("TrangThai") TrangThaiTaiLieu tt, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		try {
			if (result.hasErrors()) {
				return "TranDuc-QuanLyTaiLieu/TrangThai/edit_formTT";
			}
			tt.setIsDelete(0);
			serviceTT.updateTT(tt);
			redirectAttributes.addFlashAttribute("messageSuccess", "Update Thành Công !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có Lỗi. Xin Thử Lại!");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TrangThai/";
	}

	@RequestMapping(value = "/xoa/{maTT}", method = RequestMethod.GET)
	public String deleteTT(@PathVariable("maTT") String maTT, final RedirectAttributes redirectAttributes) {
		try {
			if (maTT.equalsIgnoreCase("Draft")) {
				redirectAttributes.addFlashAttribute("messageError", "Trạng thái cơ bản, không thể xóa!");
				return "redirect:/TranDuc-QuanLyTaiLieu/TrangThai/";
			}
			if (maTT.equalsIgnoreCase("Approved")) {
				redirectAttributes.addFlashAttribute("messageError", "Trạng thái cơ bản, không thể xóa!");
				return "redirect:/TranDuc-QuanLyTaiLieu/TrangThai/";
			}
			if (maTT.equalsIgnoreCase("Denied")) {
				redirectAttributes.addFlashAttribute("messageError", "Trạng thái cơ bản, không thể xóa!");
				return "redirect:/TranDuc-QuanLyTaiLieu/TrangThai/";
			}
			if (maTT.equalsIgnoreCase("unknow")) {
				redirectAttributes.addFlashAttribute("messageError", "Trạng thái cơ bản, không thể xóa!");
				return "redirect:/TranDuc-QuanLyTaiLieu/TrangThai/";
			}
			if (maTT.equalsIgnoreCase("Wait")) {
				redirectAttributes.addFlashAttribute("messageError", "Trạng thái cơ bản, không thể xóa!");
				return "redirect:/TranDuc-QuanLyTaiLieu/TrangThai/";
			} else {
				List<TaiLieu> listtl = serviceTT.listAllbyMaTT(maTT);
				for(TaiLieu x: listtl) {
					x.setTrangThai(serviceTT.getTTbyID("unknow"));
					serviceTL.updateTL(x);
				}
				serviceTT.deleteTT(maTT);
				redirectAttributes.addFlashAttribute("messageSuccess", "Xóa Thành Công !");
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có lỗi, xin thử lại !");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TrangThai/";
	}

	@RequestMapping(value = "/view/{maTT}", method = RequestMethod.GET)
	public String viewOneTT(@PathVariable("maTT") String maTT, Model model) {
		model.addAttribute("TrangThai", serviceTT.getTTbyID(maTT));
		return "TranDuc-QuanLyTaiLieu/TrangThai/view_oneTT";
	}

	@RequestMapping(value = "/bin", method = RequestMethod.GET)
	public String gotoBin(Model model) {
		model.addAttribute("listTrangThai", serviceTT.listAllTrangThaiDel1());
		return "TranDuc-QuanLyTaiLieu/TrangThai/BinTT";
	}

	@RequestMapping(value = "/trashBin/{maTT}", method = RequestMethod.GET)
	public String trashBin(@PathVariable("maTT") String maTT, Model model,
			final RedirectAttributes redirectAttributes) {
		try {
			TrangThaiTaiLieu tt = serviceTT.getTTbyID(maTT);
			tt.setIsDelete(1);
			redirectAttributes.addFlashAttribute("messageWarning", "Tài Liệu Đã Được Cho Vào Thùng Rác!");
			serviceTT.updateTT(tt);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có lỗi, xin thử lại !");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TrangThai/";
	}

	@RequestMapping(value = "/returnDel0/{maTT}", method = RequestMethod.GET)
	public String returnDel0(@PathVariable("maTT") String maTT, Model model,
			final RedirectAttributes redirectAttributes) {
		try {
			TrangThaiTaiLieu tt = serviceTT.getTTbyID(maTT);
			tt.setIsDelete(0);
			redirectAttributes.addFlashAttribute("messageWarning", "Tài Liệu Đã Được Phục Hồi!");
			serviceTT.updateTT(tt);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có lỗi, xin thử lại !");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TrangThai/";
	}
}
