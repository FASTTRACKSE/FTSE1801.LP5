package fasttrackse.ftse1801.fbms.controller.quantritailieu;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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

import fasttrackse.ftse1801.fbms.entity.quantritailieu.IconTaiLieu;
import fasttrackse.ftse1801.fbms.service.quantritailieu.IConService;

@Controller
@RequestMapping(value = "QuanTriTaiLieu/i_con")
public class IConController {
	@Autowired
	private IConService iConService;
	private static final String UPLOAD_DIRECTORY = "/upload";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getListIcon(Model model) {
		int record = 1;
		int pages = iConService.getAllIcon().size()/record;
		int end = 3;
		int start = 1;
		if (pages < 3) {
			start = 1;
			end = pages;
		}
		model.addAttribute("pages", pages);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("page", 1);
		List<IconTaiLieu> list = iConService.getAllIcon(0, record);
		return new ModelAndView("QuanTriTaiLieu/icon/list", "listIC", list);
	}
	@RequestMapping(value="/{page}",method=RequestMethod.GET)
	public ModelAndView getListIcon1(@PathVariable int page, Model model) {
		int record = 1;
		int pages =iConService.getAllIcon().size()/record + (iConService.getAllIcon().size() % record == 0 ? 0 : 1);
		int end = 3;
		int start = 1;
		if (page <= 0) {
			page = 1;
		} else if (page > pages) {
			page = 1;
		} else if (page == pages) {
			start = pages - 2;
			end = pages;
		} else if (page == 1) {
			start = 1;
			end = 3;
		} else {
			start = page - 1;
			end = page + 1;
		}
		if (pages < 3) {
			start = 1;
			end = pages;
		}
		model.addAttribute("pages", pages);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("page", page);
		List<IconTaiLieu> list = iConService.getAllIcon((page-1)*record, record);
		return new ModelAndView("QuanTriTaiLieu/icon/list", "listIC", list);
	}
	@RequestMapping(value = "/addIcon", method = RequestMethod.GET)
	public ModelAndView addIcon(Model model) {
		return new ModelAndView("QuanTriTaiLieu/icon/add_ic", "icon", new IconTaiLieu());
	}

	@RequestMapping(value = "/addIcon", method = RequestMethod.POST)
	public ModelAndView doAddIcon(@ModelAttribute("icon") IconTaiLieu ic, @RequestParam MultipartFile file,
			HttpSession session, final RedirectAttributes redirectAttributes) throws Exception {
		try {
			ServletContext context = session.getServletContext();
			String path = context.getRealPath(UPLOAD_DIRECTORY);

			String filename = file.getOriginalFilename();
			File quanTriTaiLieu = new File(path);

			if (!quanTriTaiLieu.exists()) {
				quanTriTaiLieu.mkdirs();
			}
			File folderIcon = new File(path + "/quanTriTaiLieu");
			if (!folderIcon.exists()) {
				folderIcon.mkdirs();
			}
			File fileIcon = new File(path + "/quanTriTaiLieu/fileIcon");
			if (!fileIcon.exists()) {
				fileIcon.mkdirs();
			}
			File Icon = new File(path + "/quanTriTaiLieu/fileIcon/" + ic.getMaIcon());
			if (!Icon.exists()) {
				Icon.mkdirs();

			}
			ic.setTenIcon(filename);
			ic.setLinkIcon(path + "/quanTriTaiLieu/fileIcon/" + ic.getMaIcon() + filename);
			iConService.insertIcon(ic);

			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(Icon + File.separator+filename)));
			stream.write(bytes);
			stream.flush();
			stream.close();

			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}

		return new ModelAndView("redirect:/QuanTriTaiLieu/i_con/");
	}
	@RequestMapping(value="/editIcon/{maIcon}",method=RequestMethod.GET)
	public ModelAndView editFormIc(@PathVariable("maIcon") String maIcon) {
		return new ModelAndView("QuanTriTaiLieu/icon/edit_ic","icon",iConService.getIconbyMa(maIcon));
	}
	@RequestMapping(value="/editIcon", method=RequestMethod.POST)
	public ModelAndView doEditIc(@ModelAttribute("icon") IconTaiLieu ic,@RequestParam MultipartFile file,HttpSession session,BindingResult result, final RedirectAttributes redirectAttributes)throws Exception {
		try {
			if(result.hasErrors()) {
				return new ModelAndView("redirect:/QuanTriTaiLieu/i_con/");
			}
			ServletContext context = session.getServletContext();
			String path = context.getRealPath(UPLOAD_DIRECTORY);

			String filename = file.getOriginalFilename();
			File quanTriTaiLieu = new File(path);

			if (!quanTriTaiLieu.exists()) {
				quanTriTaiLieu.mkdirs();
			}
			File folderIcon = new File(path + "/quanTriTaiLieu");
			if (!folderIcon.exists()) {
				folderIcon.mkdirs();
			}
			File fileIcon = new File(path + "/quanTriTaiLieu/fileIcon");
			if (!fileIcon.exists()) {
				fileIcon.mkdirs();
			}
			File Icon = new File(path + "/quanTriTaiLieu/fileIcon/" + ic.getMaIcon());
			if (!Icon.exists()) {
				Icon.mkdirs();

			}
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(Icon + File.separator+filename)));
			stream.write(bytes);
			stream.flush();
			stream.close();
			ic.setTenIcon(filename);
			ic.setLinkIcon(path + "/quanTriTaiLieu/fileIcon/" + ic.getMaIcon() + filename);
			iConService.updateIcon(ic);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thay đổi dữ liệu thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return new ModelAndView("redirect:/QuanTriTaiLieu/i_con/");
	}
	@RequestMapping(value="/deleteIcon/{maIcon}",method=RequestMethod.GET)
	public ModelAndView deleteIC(@PathVariable String maIcon, final RedirectAttributes redirectAttributes) {
		try {
			iConService.deleteIcon(maIcon);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return new ModelAndView("redirect:/QuanTriTaiLieu/i_con/");
	}
}
