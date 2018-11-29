package ftse1801.demo.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

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

import ftse1801.demo.spring.bean.SinhVien;
import ftse1801.demo.spring.model.dao.ISinhVienDAO;

@Controller
public class SinhVienController {
	@Autowired
	ISinhVienDAO sinhVienDao;

	@RequestMapping(value = "/listSV/{page}", method = RequestMethod.GET)
	public ModelAndView displayListSV(@PathVariable int page, Model model) {
		int record = 2;
		int total = sinhVienDao.showAllSinhVien().size() / record
				+ (sinhVienDao.showAllSinhVien().size() % record == 0 ? 0 : 1);
		int start = 1;
		int end = 3;
		int pageStart = 0;
		if (page <= 0) {
			page = 1;
		} else if (page > total) {
			page = 1;
		} else if (page == total) {
			start = total - 2;
			end = total;
			pageStart = (page - 1) * record;
		} else if (page == 1) {
			start = 1;
			end = 3;
		} else {
			start = page - 1;
			end = page + 1;
			pageStart = (page - 1) * record;
		}
		if (total < 3) {
			start = 1;
			end = total;
		}
		model.addAttribute("pages", page);
		model.addAttribute("Start", start);
		model.addAttribute("End", end);
		model.addAttribute("total", total);
		List<SinhVien> listSV = sinhVienDao.getSinhVienRecord(pageStart, record);
		return new ModelAndView("listSinhVien", "listSV", listSV);
	}

	@RequestMapping(value = "/listSV", method = RequestMethod.GET)
	public ModelAndView displayListSVNoPage(Model model) {
		int record = 2;
		int total = sinhVienDao.showAllSinhVien().size() / record
				+ (sinhVienDao.showAllSinhVien().size() % record == 0 ? 0 : 1);
		int start = 1;
		int end = 3;
		int pageStart = 0;
		if (total < 3) {
			start = 1;
			end = total;
		}
		model.addAttribute("Start", start);
		model.addAttribute("End", end);
		model.addAttribute("pages", 1);
		model.addAttribute("total", total);
		List<SinhVien> listSV = sinhVienDao.getSinhVienRecord(pageStart, record);
		return new ModelAndView("listSinhVien", "listSV", listSV);
	}

	@RequestMapping(value = "/editSinhVienView/{maSV}", method = RequestMethod.GET)
	public ModelAndView editSinhVienView(@PathVariable int maSV, Model model) {
		SinhVien sinhVien = sinhVienDao.showSinhVienInMaSV(maSV);
		return new ModelAndView("editSinhVien", "editSV", sinhVien);
	}

	@RequestMapping(value = "/editSinhVien", method = RequestMethod.POST)
	public ModelAndView editSinhVien(@ModelAttribute("editSV") SinhVien sinhVien) {
		if (sinhVienDao.upDateSV(sinhVien.getMaSV(), sinhVien.getName(), sinhVien.getAge(), sinhVien.getImg())) {
			return new ModelAndView("redirect:/listSV");
		} else {
			return new ModelAndView("redirect:/editSinhVienView/{sinhVien.getMaSV()}");
		}

	}

	@RequestMapping(value = "/addSinhVienView", method = RequestMethod.GET)
	public ModelAndView addSinhVienView() {
		return new ModelAndView("addSinhVien", "addSV", new SinhVien());
	}

	@RequestMapping(value = "/addSinhVien", method = RequestMethod.POST)
	public ModelAndView addSinhVien(@ModelAttribute("addSV") SinhVien sinhVien, @RequestParam CommonsMultipartFile file,
			HttpSession session) {
		int maSV = sinhVienDao.getMaSV()+1;
		String path = "D:\\Hinhnen";
		String filename = file.getOriginalFilename();
		File dir = new File(path);
		File img = new File(path+"/"+maSV);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		if (!img.exists()) {
			if (img.mkdirs()) {
				try {
					byte barr[] = file.getBytes();

					BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" +maSV+"/"+ filename));
					bout.write(barr);
					bout.flush();
					bout.close();
					sinhVienDao.addSV(sinhVien.getName(), sinhVien.getAge(), filename);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		return new ModelAndView("redirect:/listSV");
	}

	@RequestMapping(value = "/deleteSV/{maSV}/{pages}")
	public ModelAndView deleteSV(@PathVariable int maSV) {
		sinhVienDao.deleteSV(maSV);
		return new ModelAndView("redirect:/listSV/{pages}");
	}

}
