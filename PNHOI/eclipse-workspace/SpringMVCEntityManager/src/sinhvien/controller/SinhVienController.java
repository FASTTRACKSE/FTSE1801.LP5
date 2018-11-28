package sinhvien.controller;

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

import sinhvien.model.dao.ISinhVienDAO;
import sinhvien.model.entity.SinhVien;

@Controller

public class SinhVienController {
	@Autowired
	ISinhVienDAO dao;
	private static final String UPLOAD_DIRECTORY = "/images";
	int total = 5;
	
	@RequestMapping(value="/QuanLySinhVien2", method = RequestMethod.GET)
	public ModelAndView showAllSinhVien2() {
		ArrayList<SinhVien> list = dao.getAllSinhVien();
		return new ModelAndView("QuanLySinhVien", "list", list);
	}
	
	@RequestMapping(value="/QuanLySinhVien", method = RequestMethod.GET)
	public ModelAndView showAllSinhVien1(Model model) {
		int soTrang = dao.getCount(total);
		model.addAttribute("soTrang", soTrang);
		ArrayList<SinhVien> list = dao.getAll(0,total);
		return new ModelAndView("QuanLySinhVien", "list", list);
	}
	
	@RequestMapping(value="/QuanLySinhVien/{page}", method = RequestMethod.GET)
	public ModelAndView showAllSinhVien(@PathVariable int page, Model model) {
		int soTrang = dao.getCount(total);
		model.addAttribute("soTrang", soTrang);
		ArrayList<SinhVien> list = dao.getAll((page-1)*total,total);
		return new ModelAndView("QuanLySinhVien", "list", list);
	}
	
	@RequestMapping(value="/updateSinhVien/{id}", method = RequestMethod.GET)
	public ModelAndView getSinhVienById(@PathVariable int id) {
		SinhVien sinhVien = dao.getSinhVien(String.valueOf(id));
		return new ModelAndView("UpdateForm","update", sinhVien);
		
	}
	
	@RequestMapping(value="/updateSinhVien",method  = RequestMethod.POST)
	public ModelAndView updateSinhVien(@ModelAttribute("update") SinhVien sinhVien) {
		dao.updateSinhVien(sinhVien, sinhVien.getId());
		return new ModelAndView("redirect:/QuanLySinhVien");
	}
	
	@RequestMapping(value="/deleteSinhVien/{id}",method = RequestMethod.GET)  
    public ModelAndView deleteSinhVien(@PathVariable String id){  
        dao.deleteSinhVien(id);  
        return new ModelAndView("redirect:/QuanLySinhVien");  
    }  
	
	@RequestMapping(value="/addSinhVien", method = RequestMethod.GET)
	public ModelAndView sinhVienForm() {
		return new  ModelAndView("AddForm","add", new SinhVien());
	}
	
	@RequestMapping(value="/addSinhVien", method = RequestMethod.POST)
	public ModelAndView addSinhVien(@ModelAttribute("add") SinhVien sv) {
		dao.addNewSinhVien(sv);
		return new  ModelAndView("redirect:/QuanLySinhVien");
	}
	
	@RequestMapping(value = "/upload")
	public ModelAndView upload() {
		return new ModelAndView("uploadForm");
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

		return new ModelAndView("QuanLySinhVien", "filename", filename);
	}
}
