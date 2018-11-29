package ftse1801.demo.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
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

import ftse1801.demo.spring.dao.ISinhVienDao;
import ftse1801.demo.spring.entity.SinhVien;

@Controller
public class UserController {
	int soDong = 2;
	// @RequestMapping(value="/demo", method=RequestMethod.GET)
	// public String hello() {
	// return "Demo";
	// }
	// @RequestMapping("/hello")
	// public ModelAndView helloWorld() {
	// String message = "Chào bạn";
	// return new ModelAndView("hello", "message", message);
	// }
	@Autowired
	ISinhVienDao sinhvienDao;

	@RequestMapping(value = "/listSV/{paging}")
	public ModelAndView listSinhVien(@PathVariable int paging, Model model) {
		int total = sinhvienDao.getAllSinhVien().size() / soDong
				+ (sinhvienDao.getAllSinhVien().size() % soDong == 0 ? 0 : 1);
		int start = 1;
		int end = 3;
		int pagingstart = 0;
		if (paging <= 0) {
			paging = 1;
		} else if (paging > total) {
			paging = 1;
		} else if (paging == total) {
			start = total - 2;
			end = total;
			pagingstart = (paging - 1) * soDong;
		} else if (paging == 1) {
			start = 1;
			end = 3;
		} else {
			start = paging - 1;
			end = paging + 1;
			pagingstart = (paging - 1) * soDong;
		}
		if (total < 3) {
			start = 1;
			end = total;
		}
		model.addAttribute("paging", paging);
		model.addAttribute("Start", start);
		model.addAttribute("End", end);
		model.addAttribute("total", total);
		ArrayList<SinhVien> list = sinhvienDao.getAllSinhVien1(pagingstart, soDong);
		return new ModelAndView("index", "listSv", list);
	}

	@RequestMapping(value = "/listSV", method = RequestMethod.GET)
	public ModelAndView listSinhVien(Model model) {
		int total = sinhvienDao.getAllSinhVien().size() / soDong
				+ (sinhvienDao.getAllSinhVien().size() % soDong == 0 ? 0 : 1);
		int start = 1;
		int end = 3;
		if (total < 3) {
			start = 1;
			end = total;
		}
		model.addAttribute("Start", start);
		model.addAttribute("End", end);
		model.addAttribute("paging", 1);
		model.addAttribute("total", total);
		List<SinhVien> list = sinhvienDao.getAllSinhVien1(0, soDong);
		model.addAttribute("soTrang", total);
		return new ModelAndView("index", "listSv", list);
	}

	/* Thêm sinh viên */
	@RequestMapping(value = "/addSV")
	public ModelAndView addSV() {
		return new ModelAndView("addSV", "add", new SinhVien());
	}	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("add") SinhVien sinhvien, @RequestParam CommonsMultipartFile file,
			HttpSession session) {
		int id0 = sinhvienDao.getCount(1);
		int id = id0 +1;
		String path = "D:\\Thuvienanh";
		String filename = file.getOriginalFilename();
		File dir = new File(path);
		File img = new File(path + "/" + id);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		if (!img.exists()) {
			if (img.mkdirs()) {
				try {
					byte barr[] = file.getBytes();

					BufferedOutputStream bout = new BufferedOutputStream(
							new FileOutputStream(path + "/" + id + "/" + filename));
					bout.write(barr);
					bout.flush();
					bout.close();
					sinhvienDao.addSinhVien(sinhvien.getTen(), sinhvien.getTuoi(), sinhvien.getDiachi(), sinhvien.getLop(), filename);

				} catch (Exception e) {
					System.out.println(e);
				}
				// sinhvienDao.addSinhVien(sinhvien.getTen(), sinhvien.getTuoi(),
				// sinhvien.getDiachi(), sinhvien.getLop());
			}
		}
		return new ModelAndView("redirect:/listSV");
	}

	/* Sữa sinh viên */
	@RequestMapping(value = "/UpdateSV/{id}")
	public ModelAndView UpdateSV(@PathVariable int id) {
		SinhVien sinhvien = sinhvienDao.getAllSvById(id);
		return new ModelAndView("UpdateSV", "update", sinhvien);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("update") SinhVien sinhvien) {
		sinhvienDao.UpdateSinhVien(sinhvien, sinhvien.getId());
		return new ModelAndView("redirect:/listSV/1");
	}

	/* Xóa sinh viên */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		sinhvienDao.DeleteSinhVien(id);
		return new ModelAndView("redirect:/listSV/1");
	}
	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public String login(Model model) {
	// model.addAttribute("msg","Vui lòng nhập thông tin");
	// return "login";
	// }
	//
	// @RequestMapping(value="/submit", method = RequestMethod.POST)
	// public ModelAndView submit(Model model, @ModelAttribute("loginBean")
	// LoginBean loginBean) {
	// if(loginBean!=null && loginBean.getUserName()!=null &
	// loginBean.getPassword()!=null) {
	// if(loginBean.getUserName().equals("admin") &&
	// loginBean.getPassword().equals("admin123")) {
	// model.addAttribute("msg", loginBean.getUserName());
	// return new ModelAndView("redirect:/listSV/1");
	// }else {
	// model.addAttribute("error", "Chi tiết không hợp lệ");
	// return new ModelAndView("login");
	// }
	// }else {
	// model.addAttribute("error", "Vui lòng nhập chi tiết");
	// return new ModelAndView("login");
	// }
	// }

}
