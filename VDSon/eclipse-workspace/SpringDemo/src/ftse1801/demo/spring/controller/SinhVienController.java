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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ftse1801.demo.spring.model.IQLSinhVienDAO;
import ftse1801.demo.spring.model.entity.SinhVien;

@Controller
public class SinhVienController {
	@Autowired
	private IQLSinhVienDAO sinhvienDao;
	private static final String UPLOAD_DIRECTORY = "images";

	@RequestMapping(value = "addSinhVien")
	public ModelAndView addSinhVien() {
		return new ModelAndView("addSinhVien", "command", new SinhVien());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(SinhVien sinhVien, @RequestParam CommonsMultipartFile file, HttpSession session)
			throws Exception {
//		ServletContext context = session.getServletContext();
		// String path = context.getRealPath(UPLOAD_DIRECTORY);
		String filename = file.getOriginalFilename();
		File dir = new File("F:/work/" + UPLOAD_DIRECTORY);
		String folder = dir + "/" + sinhVien.getMASV();

		if (filename.matches("\\w*\\.jpg")) {
			if (!dir.exists())
				dir.mkdirs();
			File folder1 = new File(folder);
			if (folder1.mkdirs()) {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(folder + File.separator + filename)));
				stream.write(bytes);
				stream.flush();
				stream.close();
				sinhvienDao.addSinhVien(filename, sinhVien.getMASV(), sinhVien.getNAME(), sinhVien.getAGE());
			}
		} else {
			File folder1 = new File(folder);
			if (folder1.mkdirs()) {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(folder + File.separator + filename)));
				stream.write(bytes);
				stream.flush();
				stream.close();
				sinhvienDao.addSinhVien(filename, sinhVien.getMASV(), sinhVien.getNAME(), sinhVien.getAGE());
			}
		}

		return new ModelAndView("redirect:/display");
	}

	@RequestMapping(value = "/display/{page}")
	public ModelAndView displaySV(@PathVariable int page, Model model) {
		int size = 5;
		int total = sinhvienDao.displayAllSinhVien().size() / size
				+ (sinhvienDao.displayAllSinhVien().size() % size == 0 ? 0 : 1);
		model.addAttribute("total", total);
		model.addAttribute("page", page);
		ArrayList<SinhVien> list = sinhvienDao.displayAllSinhVien((page - 1) * size, size);
		return new ModelAndView("displaySV", "list", list);
	}

	@RequestMapping(value = "/display")
	public ModelAndView displaySV1(Model model) {
		int size = 5;
		int total = sinhvienDao.displayAllSinhVien().size() / size
				+ (sinhvienDao.displayAllSinhVien().size() % size == 0 ? 0 : 1);
		model.addAttribute("total", total);
		model.addAttribute("page", 1);
		ArrayList<SinhVien> list = sinhvienDao.displayAllSinhVien(0, size);
		return new ModelAndView("displaySV", "list", list);
	}

	@RequestMapping(value = "/editSV/{MASV}")
	public ModelAndView edit(@PathVariable String MASV) {
		SinhVien sinhVien = new SinhVien();
		sinhVien = sinhvienDao.displaySinhVientheoMa(MASV);
		return new ModelAndView("editSV", "command", sinhVien);
	}

	@RequestMapping(value = "/editSave", method = RequestMethod.POST)
	public ModelAndView editSave(SinhVien sinhVien) {
		sinhvienDao.updateSinhVienByMaSV(sinhVien.getNAME(), sinhVien.getAGE(), sinhVien.getImage(),sinhVien.getMASV());
		return new ModelAndView("redirect:/display");
	}

	@RequestMapping(value = "/deleteSV/{MASV}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable String MASV) {
		sinhvienDao.deleteSinhVienByMaSV(MASV);
		return new ModelAndView("redirect:/display");
	}

	@RequestMapping("uploadform")
	public ModelAndView uploadForm() {
		return new ModelAndView("uploadform");
	}

	@RequestMapping(value = "savefile", method = RequestMethod.POST)
	public ModelAndView saveimage(@RequestParam CommonsMultipartFile file, HttpSession session) throws Exception {
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		String filename = file.getOriginalFilename();
		File dir = new File(path);
		if (!dir.exists())
			dir.mkdirs();

		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(path + File.separator + filename)));
		stream.write(bytes);
		stream.flush();
		stream.close();

		return new ModelAndView("success", "filename", filename);
	}

}
