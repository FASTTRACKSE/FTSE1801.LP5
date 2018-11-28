package ftse1801.demo.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ftse1801.demo.spring.model.dao.SinhVienDAOIML;
import ftse1801.demo.spring.model.entity.Diem;
import ftse1801.demo.spring.model.entity.SinhVien;

@Controller
public class SinhVienController {
	int soDong = 4;
	private static final String UPLOAD_DIRECTORY = "/images/";
	@Autowired
	SinhVienDAOIML sinhVienDAO;

	@RequestMapping(value = "/SinhVienView")
	public ModelAndView Cout(Model model) {
		int page = sinhVienDAO.getAllSinhVien1().size() / soDong;
		int start = 1;
		int end = 3;
		if (page < 3) {
			start = 1;
			end = page;
		}
		model.addAttribute("page", page);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("trang", 1);
		ArrayList<SinhVien> list = sinhVienDAO.getAllSinhVien(0, soDong);
		return new ModelAndView("SinhVienView", "listSV", list);
	}

	@RequestMapping(value = "/SinhVienView/{trang}", method = RequestMethod.GET)
	public ModelAndView AllSinhVien(@PathVariable int trang, Model model) {
		int page = sinhVienDAO.getAllSinhVien1().size() / soDong
				+ (sinhVienDAO.getAllSinhVien1().size() % soDong == 0 ? 0 : 1);
		int start = 1;
		int end = 3;
		if (trang <= 0) {
			trang = 1;
		} else if (trang > page) {
			trang = 1;
		} else if (trang == page) {
			start = page - 2;
			end = page;
		} else if (trang == 1) {
			start = 1;
			end = 3;
		} else {
			start = trang - 1;
			end = trang + 1;
		}
		if (page < 3) {
			start = 1;
			end = page;
		}
		model.addAttribute("page", page);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("trang", trang);
		ArrayList<SinhVien> list = sinhVienDAO.getAllSinhVien((trang - 1) * soDong, soDong);
		return new ModelAndView("SinhVienView", "listSV", list);
	}
	// @RequestMapping(value = "/SinhVienView", method = RequestMethod.GET)
	// public ModelAndView getAllSV() {
	// ArrayList<SinhVien>list = sinhVienDAO.getAllSinhVien1();
	// return new ModelAndView("SinhVienView", "listSV", list);
	// }

	@RequestMapping(value = "/addSV")
	public ModelAndView showAdd(Model model) {
		return new ModelAndView("addSV", "add", new SinhVien());
	}

	@RequestMapping(value = "/AddSinhVien", method = RequestMethod.POST)
	public ModelAndView AddSinhVien(@ModelAttribute("add") SinhVien sv1, @RequestParam CommonsMultipartFile file,
			HttpSession session) throws Exception {
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		String filename = file.getOriginalFilename();
		File folderUpload = new File(path);

		String Ma = folderUpload + "/" + sv1.getMaSinhVien();
		if (sinhVienDAO.addSinhVien(sv1.getMaSinhVien(), sv1.getTensinhVien(), sv1.getPassword(), sv1.getTuoi(),
				sv1.getImg(),sv1.getListDiem()))
				 {

			// if (!folderUpload.exists()) {
			// folderUpload.mkdirs();
			// File maSV = new File(Ma);
			// if (maSV.mkdirs()) {
			//
			// }
			// } else {
			// File maSV = new File(Ma);
			// if (maSV.mkdirs()) {
			//
			// }
			// }
			//
			// System.out.println(path + "" + filename);
			// byte[] bytes = file.getBytes();
			// BufferedOutputStream stream = new BufferedOutputStream(
			// new FileOutputStream(new File(Ma + File.separator + filename)));
			// stream.write(bytes);
			// stream.flush();
			// stream.close();

			return new ModelAndView("redirect:/SinhVienView");
		} else {
			return new ModelAndView("redirect:/addSV");
		}

	}

	@RequestMapping(value = "/editsv/{maSinhVien}")
	public ModelAndView EditSinhVien(@PathVariable String maSinhVien) {
		SinhVien sinhVien = sinhVienDAO.SinhVienByMa(maSinhVien);
		return new ModelAndView("editSV", "add", sinhVien);
	}

	@RequestMapping(value = "/EditSV", method = RequestMethod.POST)
	public ModelAndView editSinhVien(@ModelAttribute("add") SinhVien sv) {
		sinhVienDAO.updateSV(sv.getMaSinhVien(), sv.getTensinhVien(), sv.getPassword(), sv.getTuoi(), sv.getListDiem());
		return new ModelAndView("redirect:/SinhVienView");
	}

	@RequestMapping(value = "deletesv/{maSinhVien}", method = RequestMethod.GET)
	public ModelAndView deleteSinhVien(@PathVariable String maSinhVien) {
		sinhVienDAO.deleteSV(maSinhVien);
		return new ModelAndView("redirect:/SinhVienView");
	}

	@RequestMapping(value = "/upload")
	public ModelAndView upload() {
		return new ModelAndView("upload");
	}

	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public ModelAndView saveimage(@RequestParam CommonsMultipartFile file, HttpSession session) throws Exception {
		ServletContext context = session.getServletContext();

		String path = context.getRealPath(UPLOAD_DIRECTORY);
		String filename = file.getOriginalFilename();

		File folderUpload = new File(path);
		if (!folderUpload.exists())
			folderUpload.mkdirs();
		System.out.println(folderUpload);

		System.out.println(path + "" + filename);
		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(path + File.separator + filename)));
		stream.write(bytes);
		stream.flush();
		stream.close();

		return new ModelAndView("success", "filename", filename);
	}
}
