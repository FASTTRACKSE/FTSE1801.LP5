package fasttrackse.ffse1703.fbms.controller.quanlyduan;



import javax.servlet.http.HttpServletRequest;
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

import fasttrackse.ffse1703.fbms.entity.quanlyduan.KhachHangTeam1;
import fasttrackse.ffse1703.fbms.service.quanlyduan.KhachHangTeam1Service;

@Controller
@RequestMapping("/qlda/khachhang")
public class KhachHangTeam1Controller {
	KhachHangTeam1Service khachHangServiceTeam1;

	@Autowired
	public void setStudentService(KhachHangTeam1Service khachHangServiceTeam1) {
		this.khachHangServiceTeam1 = khachHangServiceTeam1;
	}

	@RequestMapping(value = "/add_form", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("khachhang", new KhachHangTeam1());
		return "QuanLyDuAn/KhachHang/add_form";
	}
	/*
	 * @RequestMapping(value = "/save", method = RequestMethod.POST) public String
	 * createStudent(@ModelAttribute("khachhang") @Valid KhachHang khachhang) {
	 * khachHangService.add(khachhang); return "redirect:/qlda/khachhang/list"; }
	 */

	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("khachhang") @Valid KhachHangTeam1 khachhang, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (khachHangServiceTeam1.findById(khachhang.getMakh()) != null) {
			return "redirect:/qlda/khachhang/edit_form/" + khachhang.getMakh();
		} else {
			if (result.hasErrors()) {
				return "QuanLyDuAn/KhachHang/add_form";
			}
			khachHangServiceTeam1.add(khachhang);
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");
		return "redirect:list";
	}

	/*@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listDonNhap(Model model) {
		model.addAttribute("list", khachHangServiceTeam1.getAll());
		return "QuanLyDuAn/KhachHang/list";
	}*/

	@RequestMapping("/delete/{makh}")
	public String delete(@PathVariable String makh, HttpServletRequest request, Model model) {
		KhachHangTeam1 khachhang = khachHangServiceTeam1.findById(makh);
		khachhang.setIs_delete("1");
		khachHangServiceTeam1.delete(khachhang);
		return "redirect:/qlda/khachhang/list";
	}

	@RequestMapping(value = "/edit_form/{makh}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable("makh") String makh) {
		model.addAttribute("khachhang", khachHangServiceTeam1.findById(makh));
		return "QuanLyDuAn/KhachHang/edit_form";
	}

	@RequestMapping(value = "/view/{makh}", method = RequestMethod.GET)
	public String viewKhachHang(Model model, @PathVariable("makh") String makh) {
		model.addAttribute("khachhang", khachHangServiceTeam1.findById(makh));
		return "QuanLyDuAn/KhachHang/info";
	}

	/*
	 * @RequestMapping(value = "/update", method = RequestMethod.POST) public String
	 * edit(Model model, @ModelAttribute("khachhang") @Valid KhachHang khachhang,
	 * HttpServletRequest request,
	 * 
	 * @RequestParam("file") MultipartFile file, BindingResult bindingResult) throws
	 * IllegalStateException, IOException { if (bindingResult.hasErrors()) { return
	 * "edit"; }
	 * 
	 * khachHangService.update(khachhang); return "redirect://qlda/khachhang"; }
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST )
	public String update(@ModelAttribute("khachhang") @Valid KhachHangTeam1 khachhang, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/KhachHang/edit_form";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		khachHangServiceTeam1.update(khachhang);
		return "redirect:/qlda/khachhang/list";

	}
	
	@RequestMapping("/list")
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = khachHangServiceTeam1.getAll().size();
		int recordsPerPage = 4;
		int totalPages = 0;
		if ((totalRecords / recordsPerPage) % 2 == 0) {
			totalPages = totalRecords / recordsPerPage;
		} else {
			totalPages = totalRecords / recordsPerPage + 1;
		}
		int startPosition = recordsPerPage * (currentPage - 1);

		model.addAttribute("list", khachHangServiceTeam1.findAllForPaging(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);

		return "QuanLyDuAn/KhachHang/list";
	}

}
