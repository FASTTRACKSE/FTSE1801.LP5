package fasttrackse.ffse1703.fbms.controller.TranDuc.quanlytailieu;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.IconTaiLieu;
import fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu.IconService;

@Controller
@RequestMapping("/TranDuc-QuanLyTaiLieu/Icon")
public class IconController {
	private static final String UPLOAD_DIRECTORY = "/upload";
	@Autowired
	private IconService serviceIC;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewIcon(Model model) {
		model.addAttribute("listIcon", serviceIC.listAllIconTaiLieu());
		return "TranDuc-QuanLyTaiLieu/Icon/IconList";
	}

	@RequestMapping(value = "/add_formIC", method = RequestMethod.GET)
	public String addFormIC(Model model) {
		model.addAttribute("Icon", new IconTaiLieu());
		return "TranDuc-QuanLyTaiLieu/Icon/add_formIC";
	}

	@RequestMapping(value = "/addIC", method = RequestMethod.POST)
	public String doAddIC(@ModelAttribute("Icon") IconTaiLieu ic, @RequestParam("file") MultipartFile file,
			HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		try {
			String nameFile = file.getOriginalFilename();
			File fileDir = new File(request.getServletContext().getRealPath(UPLOAD_DIRECTORY));
			byte[] bytes = file.getBytes();
			if (!fileDir.exists()) {
				fileDir.mkdir();
			}
			File serverFile = new File(fileDir.getAbsolutePath() + File.separator + nameFile);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.flush();
			stream.close();
			ic.setTen_icon(nameFile);
			ic.setLinkIcon(fileDir.getAbsolutePath() + File.separator + nameFile);
			ic.setIsDelete(0);
			serviceIC.addIC(ic);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm Mới Thành Công !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin Thử Lại !");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/Icon/";
	}

	@RequestMapping(value = "/editForm/{maIcon}", method = RequestMethod.GET)
	public String editFormIC(@PathVariable("maIcon") String maIcon, Model model) {
		model.addAttribute("icon", serviceIC.getICbyID(maIcon));
		return "TranDuc-QuanLyTaiLieu/Icon/edit_formIC";
	}

	@RequestMapping(value = "/editForm/{maIcon}", method = RequestMethod.POST)
	public String doEditIC(@ModelAttribute("icon") IconTaiLieu ic, @RequestParam("file") MultipartFile file, BindingResult result,
			HttpServletRequest request, Model model, final RedirectAttributes redirectAttributes) {
		try {
			if(result.hasErrors()) {
				return "redirect:/TranDuc-QuanLyTaiLieu/Icon/";
			}
			String nameFile = file.getOriginalFilename();
			File fileDir = new File(request.getServletContext().getRealPath(UPLOAD_DIRECTORY));
			byte[] bytes = file.getBytes();
			if (!fileDir.exists()) {
				fileDir.mkdir();
			}
			File serverFile = new File(fileDir.getAbsolutePath() + File.separator + nameFile);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.flush();
			stream.close();
			ic.setIsDelete(0);
			ic.setTen_icon(nameFile);
			ic.setLinkIcon(fileDir.getAbsolutePath() + File.separator + nameFile);
			serviceIC.updateIC(ic);
			redirectAttributes.addFlashAttribute("messageSuccess", "Update Thành Công !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có Lỗi. Xin Thử Lại!");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/Icon/";
	}

	@RequestMapping(value = "/xoa/{maIcon}", method = RequestMethod.GET)
	public String deleteIC(@PathVariable("maIcon") String maIcon, final RedirectAttributes redirectAttributes) {
		try {
			IconTaiLieu ic=serviceIC.getICbyID(maIcon);
			ic.setIsDelete(1);
			serviceIC.updateIC(ic);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa Thành Công !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có lỗi, xin thử lại !");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/Icon/";
	}

	@RequestMapping(value = "/viewForm/{maIcon}", method = RequestMethod.GET)
	public String viewOneIC(@PathVariable("maIcon") String maIcon, Model model) {
		model.addAttribute("Icon", serviceIC.getICbyID(maIcon));
		return "redirect:/TranDuc-QuanLyTaiLieu/Icon/";
	}
}
