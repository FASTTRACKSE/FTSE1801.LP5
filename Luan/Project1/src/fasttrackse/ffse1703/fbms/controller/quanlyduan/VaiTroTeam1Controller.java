package fasttrackse.ffse1703.fbms.controller.quanlyduan;

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

import fasttrackse.ffse1703.fbms.entity.quanlyduan.VaiTroThanhVienTeam1;
import fasttrackse.ffse1703.fbms.service.quanlyduan.VaiTroTeam1Service;

@Controller
@RequestMapping("QuanLyDuAn/VaiTro")
public class VaiTroTeam1Controller {
	@Autowired
	VaiTroTeam1Service vaiTroService;


	@RequestMapping("/list")
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = vaiTroService.getAll().size();
		int recordsPerPage = 4;
		int totalPages = 0;
		if ((totalRecords / recordsPerPage) % 2 == 0) {
			totalPages = totalRecords / recordsPerPage;
		} else {
			totalPages = totalRecords / recordsPerPage + 1;
		}
		int startPosition = recordsPerPage * (currentPage - 1);

		model.addAttribute("list", vaiTroService.findAllForPaging(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);

		return "QuanLyDuAn/VaiTro/listVaiTro";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("vaitro", new VaiTroThanhVienTeam1());
		return "QuanLyDuAn/VaiTro/addVaiTro";
	}

	@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("vaitro") @Valid VaiTroThanhVienTeam1 vaitro1, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "QuanLyDuAn/VaiTro/addVaiTro";
		}

		if (vaiTroService.getById(vaitro1.getMavt()) != null) {
			VaiTroThanhVienTeam1 db = vaiTroService.getById(vaitro1.getMavt());
			if (db.getIsDelete() == 1) {
				vaiTroService.update(vaitro1);
				return "redirect:list";

			} else {
				redirectAttributes.addFlashAttribute("message", "<script>alert('Mã Vai Trò Đã Tồn Tại.');</script>");
				return "redirect:/QuanLyDuAn/VaiTro/add";
			}
		}

		redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");
		vaiTroService.addNew(vaitro1);
		return "redirect:list";
	}

	@RequestMapping(value = "/edit/{mavt}")
	public String edit(Model model, @PathVariable("mavt") String mavt) {
		model.addAttribute("vaitro", vaiTroService.getById(mavt));
		return "QuanLyDuAn/VaiTro/editVaiTro";
	}

	@RequestMapping(value = "/update")
	public String update(@ModelAttribute("vendor") @Valid VaiTroThanhVienTeam1 vendorTeam1, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/VaiTro/editVaiTro";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		vaiTroService.update(vendorTeam1);
		return "redirect:list";

	}

	@RequestMapping(value = { "/delete/{mavt}" })
	public String delete(Model model, @PathVariable("mavt") String mavt) {
		vaiTroService.delete(mavt);
		return "redirect:/QuanLyDuAn/VaiTro";

	}
}
