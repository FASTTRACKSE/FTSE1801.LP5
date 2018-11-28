package ftse1801.demo.spring.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ftse1801.demo.spring.model.dao.SinhVienDAOIML;
import ftse1801.demo.spring.model.entity.SinhVien;

@Controller
public class SinhVienController {
	private SinhVienDAOIML dao;

	public SinhVienDAOIML getDao() {
		return dao;
	}

	public void setDao(SinhVienDAOIML dao) {
		this.dao = dao;
	}
	@RequestMapping(value="/SinhVienView", method=RequestMethod.GET)
	public ModelAndView getAllSV() {
		ArrayList<SinhVien> list = dao.getAllSinhVien1();
		return new ModelAndView("SinhVienView", "listSV", list);
	}
	
}
