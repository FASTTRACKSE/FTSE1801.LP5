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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ftse1801.fbms.entity.quantritailieu.DanhMucTaiLieu;
import fasttrackse.ftse1801.fbms.entity.quantritailieu.IconTaiLieu;
import fasttrackse.ftse1801.fbms.entity.quantritailieu.TaiLieu;
import fasttrackse.ftse1801.fbms.entity.quantritailieu.TrangThaiTaiLieu;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;
import fasttrackse.ftse1801.fbms.service.quantritailieu.TaiLieuService;

@Controller
@RequestMapping(value = "QuanTriTaiLieu/tai_lieu")
public class TaiLieuController {
	@Autowired
	private TaiLieuService taiLieuService;
	private static final String UPLOAD_DIRECTORY = "/upload";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView listAllTLDel0(Model model) {
		int record = 5;
		int pages = taiLieuService.getAllTaiLieuDel0().size() / record;
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
		List<TaiLieu> listTl = taiLieuService.getAllTaiLieuDel0(0, record);
		return new ModelAndView("/QuanTriTaiLieu/tailieu/list", "taiLieu", listTl);
	}

	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public ModelAndView listAllTLDel0(@PathVariable int page, Model model) {
		int record = 5;
		int pages = taiLieuService.getAllTaiLieuDel0().size() / record
				+ (taiLieuService.getAllTaiLieuDel0().size() / record == 0 ? 0 : 1);
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
		List<TaiLieu> listTl = taiLieuService.getAllTaiLieuDel0((page - 1) * record, record);
		return new ModelAndView("/QuanTriTaiLieu/tailieu/list", "taiLieu", listTl);
	}

	@RequestMapping(value = "/addTL", method = RequestMethod.GET)
	public ModelAndView addTL(Model model) {
		List<DanhMucTaiLieu> listDM = taiLieuService.listDanhMuc();
		model.addAttribute("listDM", listDM);
		List<IconTaiLieu> listIC = taiLieuService.listIcon();
		model.addAttribute("listIC", listIC);
		List<PhongBan> listPB = taiLieuService.listPhongBan();
		model.addAttribute("listPB", listPB);
		List<TrangThaiTaiLieu> listTT = taiLieuService.listTrangThai();
		model.addAttribute("listTT", listTT);
		return new ModelAndView("/QuanTriTaiLieu/tailieu/add_TL", "taiLieu", new TaiLieu());
	}

	@RequestMapping(value = "/addTL", method = RequestMethod.POST)
	public ModelAndView doAddTL(@ModelAttribute("taiLieu") TaiLieu tl, @RequestParam MultipartFile file,
			HttpSession session, final RedirectAttributes redirectAttributes) {
		try {
			ServletContext context = session.getServletContext();
			String path = context.getRealPath(UPLOAD_DIRECTORY);

			String filename = file.getOriginalFilename();
			File quanTriTaiLieu = new File(path);

			if (!quanTriTaiLieu.exists()) {
				quanTriTaiLieu.mkdirs();
			}
			File tailieu = new File(path + "/quanTriTaiLieu");
			if (!tailieu.exists()) {
				tailieu.mkdirs();
			}
			File fileTL = new File(path + "/quanTriTaiLieu/tailieu");
			if (!fileTL.exists()) {
				fileTL.mkdirs();
			}
			File idTaiLieu = new File(path + "/quanTriTaiLieu/tailieu/" + tl.getIdTL());
			if (!idTaiLieu.exists()) {
				idTaiLieu.mkdirs();

			}
			tl.setTenTaiLieu(filename);
			tl.setLinkTaiLieu(path + "/quanTriTaiLieu/tailieu/" + tl.getIdTL() + filename);
			taiLieuService.insertTaiLieu(tl);
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(idTaiLieu + File.separator + filename)));
			stream.write(bytes);
			stream.flush();
			stream.close();
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("messageError");
		}

		return new ModelAndView("redirect:/QuanTriTaiLieu/tai_lieu/");
	}
}
