package fasttrackse.ffse1703.fbms.controller.TranDuc.quanlytailieu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.DanhMuc;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.IconTaiLieu;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TaiLieu;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TrangThaiTaiLieu;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu.IconService;
import fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu.TaiLieuService;
import fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu.TrangThaiService;

@Controller
@RequestMapping("/TranDuc-QuanLyTaiLieu/TaiLieu")
public class TaiLieuController {
	private static final String UPLOAD_DIRECTORY = "/upload";
	@Autowired
	private TaiLieuService serviceTL;
	@Autowired
	private TrangThaiService serviceTT;
	@Autowired
	private IconService serviceIC;

	private int totalPageDel1(int perPage) {
		int totalPage = (int) Math.ceil((double) serviceTL.listAllDel1().size() / (double) perPage);
		return totalPage;
	}

	private int totalPageDel0(int perPage, List<TaiLieu> tl) {
		int totalPage = (int) Math.ceil((double) tl.size() / (double) perPage);
		return totalPage;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewTaiLieu(Model model, final RedirectAttributes redirectAttributes,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int perPage = 5;
		int start = (currentPage - 1) * perPage;
		List<PhongBan> listpb = serviceTL.listPhongBan();
		String rolepb = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
		int validRole = 0;
		String mapb="";
		for(PhongBan x:listpb) {
			if(rolepb.substring(rolepb.lastIndexOf("_") + 1,rolepb.length()-1).contains(x.getMaPhongBan())) {
				mapb=x.getMaPhongBan();
				validRole=1;
				break;
			}
		}
		if (validRole==1) {
			List<TaiLieu> tl = serviceTL.listbyPhongBan(start, perPage, mapb);
			int totalPage = totalPageDel0(perPage, tl);
			model.addAttribute("listPhongBan", listpb);
			model.addAttribute("lastPage", totalPage);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("listTaiLieu", tl);
		} else {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin Thử Lại !");
		}
		return "TranDuc-QuanLyTaiLieu/TaiLieu/TaiLieuList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addFormTL(Model model) {
		List<DanhMuc> listdm = serviceTL.listDanhMuc();
		model.addAttribute("listDanhMuc", listdm);
		model.addAttribute("TaiLieu", new TaiLieu());
		List<PhongBan> listpb = serviceTL.listPhongBan();
		model.addAttribute("listPhongBan", listpb);
		return "TranDuc-QuanLyTaiLieu/TaiLieu/add_formTL";
	}

	@RequestMapping(value = "/download/{idTL}", method = RequestMethod.GET)
	public void download(@PathVariable("idTL") Integer idTL, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		try {
			TaiLieu tl = serviceTL.getTLbyID(idTL);
			File file = new File(
					request.getServletContext().getRealPath(UPLOAD_DIRECTORY + File.separator + tl.getTenTL()));
			byte[] data = FileUtils.readFileToByteArray(file);
			response.setHeader("Content-disposition", "attachment; filename=" + file.getName());
			response.setContentLength(data.length);
			InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
			FileCopyUtils.copy(inputStream, response.getOutputStream());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submitTL(@ModelAttribute("TaiLieu") TaiLieu tl, @RequestParam("file") MultipartFile file,
			BindingResult result, HttpServletRequest request, Model model,
			final RedirectAttributes redirectAttributes) {
		try {
			if (result.hasErrors()) {
				return "TranDuc-QuanLyTaiLieu/TaiLieu/add_formTL";
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
			tl.setTenTL(nameFile);
			tl.setLink(File.separator + "upload" + File.separator + nameFile);
			tl.setIsDelete(0);
			String format = nameFile.substring(nameFile.lastIndexOf(".") + 1, nameFile.length());
			List<IconTaiLieu> listIC = serviceIC.listAllIconTaiLieu();
			boolean validDocument = false;
			for (IconTaiLieu x : listIC) {
				if (format.equalsIgnoreCase(x.getMaIcon())) {
					validDocument = true;
					break;
				}
			}
			if (validDocument) {
				IconTaiLieu x = new IconTaiLieu();
				x.setMaIcon(format);
				tl.setIconTaiLieu(x);
				tl.setTrangThai(serviceTT.getTTbyID("Wait"));
				serviceTL.addTL(tl);
				redirectAttributes.addFlashAttribute("messageSuccess", "Thêm Mới Thành Công !");
			} else {
				redirectAttributes.addFlashAttribute("messageWarning", "Không định dạng được file !");
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin Thử Lại !");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TaiLieu/";
	}

	@RequestMapping(value = "/draft", method = RequestMethod.POST)
	public String draftTL(@ModelAttribute("TaiLieu") TaiLieu tl, @RequestParam("file") MultipartFile file,
			BindingResult result, HttpServletRequest request, Model model,
			final RedirectAttributes redirectAttributes) {
		try {
			if (result.hasErrors()) {
				return "TranDuc-QuanLyTaiLieu/TaiLieu/add_formTL";
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
			tl.setTenTL(nameFile);
			tl.setLink(File.separator + "upload" + File.separator + nameFile);
			tl.setIsDelete(0);
			String format = nameFile.substring(nameFile.lastIndexOf(".") + 1, nameFile.length());
			List<IconTaiLieu> listIC = serviceIC.listAllIconTaiLieu();
			boolean validDocument = false;
			for (IconTaiLieu x : listIC) {
				if (format.equalsIgnoreCase(x.getMaIcon())) {
					validDocument = true;
					break;
				}
			}
			if (validDocument) {
				IconTaiLieu x = new IconTaiLieu();
				x.setMaIcon(format);
				tl.setIconTaiLieu(x);
				tl.setTrangThai(serviceTT.getTTbyID("Wait"));
				serviceTL.addTL(tl);
				redirectAttributes.addFlashAttribute("messageSuccess", "Thêm Mới Thành Công !");
			} else {
				redirectAttributes.addFlashAttribute("messageWarning", "Không định dạng được file !");
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin Thử Lại !");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TaiLieu/";
	}

	@RequestMapping(value = "/editForm/{idTL}", method = RequestMethod.GET)
	public String editFormTL(@PathVariable("idTL") Integer idTL, Model model) {
		List<DanhMuc> listdm = serviceTL.listDanhMuc();
		model.addAttribute("listDanhMuc", listdm);
		model.addAttribute("TaiLieu", serviceTL.getTLbyID(idTL));
		List<PhongBan> listpb = serviceTL.listPhongBan();
		model.addAttribute("listPhongBan", listpb);
		List<TrangThaiTaiLieu> listTT = serviceTT.listAllTrangThaiDel0();
		model.addAttribute("TrangThai", listTT);
		return "TranDuc-QuanLyTaiLieu/TaiLieu/edit_formTL";
	}

	@RequestMapping(value = "/editForm/{idTL}", method = RequestMethod.POST)
	public String doEditTL(@ModelAttribute("TaiLieu") TaiLieu tl, @RequestParam("file") MultipartFile file, Model model,
			BindingResult result, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		try {
			if (result.hasErrors()) {
				return "TranDuc-QuanLyTaiLieu/TaiLieu/edit_formTL";
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
			tl.setIsDelete(0);
			tl.setTenTL(nameFile);
			tl.setLink(File.separator + "upload" + File.separator + nameFile);
			String format = nameFile.substring(nameFile.lastIndexOf(".") + 1, nameFile.length());
			List<IconTaiLieu> listIC = serviceIC.listAllIconTaiLieu();
			boolean validDocument = false;
			for (IconTaiLieu x : listIC) {
				if (format.equalsIgnoreCase(x.getMaIcon())) {
					validDocument = true;
					break;
				}
			}
			if (validDocument) {
				IconTaiLieu x = new IconTaiLieu();
				x.setMaIcon(format);
				tl.setIconTaiLieu(x);
				tl.setTrangThai(serviceTT.getTTbyID("Wait"));
				serviceTL.addTL(tl);
				redirectAttributes.addFlashAttribute("messageSuccess", "Thêm Mới Thành Công !");
			} else {
				redirectAttributes.addFlashAttribute("messageWarning", "Không định dạng được file !");
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có lỗi, Xin Thử Lại!");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TaiLieu/";
	}

	@RequestMapping(value = "/bin", method = RequestMethod.GET)
	public String gotoBin(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int perPage = 5;
		int totalPage = totalPageDel1(perPage);
		int start = (currentPage - 1) * perPage;
		model.addAttribute("listTaiLieu", serviceTL.listAllPagingDel1(start, perPage));
		model.addAttribute("lastPage", totalPage);
		model.addAttribute("currentPage", currentPage);
		return "TranDuc-QuanLyTaiLieu/TaiLieu/BinTL";
	}

	@RequestMapping(value = "/cancel")
	public String cancelTL() {
		return "redirect:/TranDuc-QuanLyTaiLieu/TaiLieu/";
	}

	@RequestMapping(value = "/trashBin/{idTL}", method = RequestMethod.GET)
	public String trashBin(@PathVariable("idTL") Integer idTL, Model model,
			final RedirectAttributes redirectAttributes) {
		try {
			TaiLieu tl = serviceTL.getTLbyID(idTL);
			tl.setIsDelete(1);
			serviceTL.updateTL(tl);
			redirectAttributes.addFlashAttribute("messageWarning", "Tài Liệu Đã Được Cho Vào Thùng Rác!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có lỗi, xin thử lại !");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TaiLieu/";
	}

	@RequestMapping(value = "/xoa/{idTL}", method = RequestMethod.GET)
	public String delete(@PathVariable("idTL") Integer idTL, final RedirectAttributes redirectAttributes) {
		try {
			serviceTL.deleteTL(idTL);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa Tài Liệu Thành Công !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có lỗi, xin thử lại !");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TaiLieu/";
	}

	@RequestMapping(value = "/view/{idTL}", method = RequestMethod.GET)
	public String viewOneTL(@PathVariable("idTL") Integer idTL, Model model) {
		model.addAttribute("TaiLieu", serviceTL.getTLbyID(idTL));
		return "TranDuc-QuanLyTaiLieu/TaiLieu/view_oneTL";
	}

	@RequestMapping(value = "/returnDel0/{idTL}", method = RequestMethod.GET)
	public String returnDel0(@PathVariable("idTL") Integer idTL, Model model,
			final RedirectAttributes redirectAttributes) {
		try {
			TaiLieu tl = serviceTL.getTLbyID(idTL);
			tl.setIsDelete(0);
			serviceTL.updateTL(tl);
			redirectAttributes.addFlashAttribute("messageWarning", "Tài Liệu Đã Được Phục Hồi!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có lỗi, xin thử lại !");
		}
		return "redirect:/TranDuc-QuanLyTaiLieu/TaiLieu/";
	}

}
