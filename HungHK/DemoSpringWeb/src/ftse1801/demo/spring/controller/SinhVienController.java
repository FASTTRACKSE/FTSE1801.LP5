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

import ftse1801.demo.spring.model.SinhVienDAO;
import ftse1801.demo.spring.model.entity.SinhVien;

@Controller
public class SinhVienController {
	@Autowired
	private SinhVienDAO sinhVienDAO;
	
//	private SinhVienDAO2 sinhVienDAO = new SinhVienDAO2();
//	
////	@RequestMapping(value="/getSv", method = RequestMethod.GET)
////	public String showList(Model model) {
////		model.addAttribute("sinhvien", sinhVienDAO.getAllSinhVien());
////		return "index";
////	}
//	
	int soDong = 5;
	@RequestMapping(value="/")
	public ModelAndView getCount(Model model) {
		int page = sinhVienDAO.getCount(soDong)/soDong;
		int start = 1;
		int end = 3;
		if(page<3) {
			start = 1;
			end = page;
		}
		model.addAttribute("page", page);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("trang", 1);
		List<SinhVien> list = sinhVienDAO.getAllSinhVien(0, soDong);
		return new ModelAndView("index", "list", list);
		
	}
	@RequestMapping(value="/{trang}", method = RequestMethod.GET)
	public ModelAndView showsv(@PathVariable int trang, Model model) {
		int page = sinhVienDAO.getCount(soDong)/soDong+(sinhVienDAO.getCount(soDong)%soDong==0?0:1);
		int start = 1;
		int end = 3;
		if(trang<=0) {
			trang = 1;
		} else if(trang>page) {
			trang = 1;
		} else if(trang==page) {
			start = page-2;
			end = page;
		}else if(trang==1) {
			start = 1;
			end = 3;
		}else {
			start = trang-1;
			end = trang+1;
		}if(page<3) {
			start=1;
			end = page;
		}
		model.addAttribute("page", page);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("trang", trang);
		List<SinhVien> list = sinhVienDAO.getAllSinhVien((trang-1)*soDong, soDong);
		return new ModelAndView("index", "list", list);
	}
//	
//	@RequestMapping(value="/insert")
//	public ModelAndView showAdd() {
//		return new ModelAndView("insert", "add", new SinhVien());
//	}
//	@RequestMapping(value="/addSv", method = RequestMethod.POST)
//	public ModelAndView addSv(@ModelAttribute("add") SinhVien sinhVien) {
//		if (sinhVienDAO.addSinhVienByMaSV(sinhVien.getMaSv(), sinhVien.getName(), sinhVien.getAge())) {
//			return new ModelAndView("redirect:/viewsv");
//		} else {
//			return new ModelAndView("redirect:/insert");
//		}
//	}
//	
//	@RequestMapping(value="/update/{maSv}", method = RequestMethod.GET)
//	public ModelAndView update(@PathVariable String maSv) {
//		SinhVien sinhVien = sinhVienDAO.getSinhVienByMasv(maSv);
//		return new ModelAndView("update", "sua", sinhVien);
//	}
//	@RequestMapping(value="/updateSv", method = RequestMethod.POST)
//	public ModelAndView updateSv(@ModelAttribute("sua") SinhVien sinhVien) {
//		sinhVienDAO.updateSinhVienByMaSV(sinhVien.getName(), sinhVien.getAge(), sinhVien.getMaSv()); 
//			return new ModelAndView("redirect:/viewsv");
//		
//	}
//	
//	@RequestMapping(value="/delete/{maSv}", method=RequestMethod.GET)
//	public ModelAndView delete(@PathVariable String maSv) {
//		sinhVienDAO.deleteSinhVienByMaSV(maSv);
//		return new ModelAndView("redirect:/viewsv");
//	}
	
	
//	@RequestMapping(value="/")
//	public ModelAndView listSv(ModelAndView model) throws IOException {
//		List<SinhVien> list = sinhVienDAO.getAllSinhVien1();
//		model.addObject("list", list);
//		model.setViewName("index");
//		return model;
//	}
	
	@RequestMapping(value="/insert", method = RequestMethod.GET)
	public ModelAndView addSv(ModelAndView model) {
		SinhVien sinhVien = new SinhVien();
		model.addObject("add", sinhVien);
		model.setViewName("insert");
		return model;
	}
	@RequestMapping(value="/addSv", method = RequestMethod.POST)
	public ModelAndView addSv(@ModelAttribute SinhVien sinhVien) {
		sinhVienDAO.addSinhVien(sinhVien);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/update/{maSv}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable String maSv) {
		SinhVien sinhVien = sinhVienDAO.getSinhVienByMasv(maSv);
		return new ModelAndView("update", "sua", sinhVien);
	}
	@RequestMapping(value="/updateSv", method = RequestMethod.POST)
	public ModelAndView updateSv(@ModelAttribute("sua") SinhVien sinhVien) {
		sinhVienDAO.updateSinhVienByMasv(sinhVien); 
			return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/delete/{maSv}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable String maSv) {
		sinhVienDAO.deleteSinhVienByMasv(maSv);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/savefile",method=RequestMethod.POST)  
	public ModelAndView upload(@RequestParam CommonsMultipartFile file,HttpSession session){  
	        String path=session.getServletContext().getRealPath("/images");  
	        String filename=file.getOriginalFilename();  
	          
	        System.out.println(path+" "+filename);  
	        try{  
	        byte barr[]=file.getBytes();  
	         File file2 = new File(path);
	         if (!file2.exists()) {
	        	 file2.mkdirs();
	         }
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path+"/"+filename));  
	        bout.write(barr);  
	        bout.flush();
	        bout.close();  
	          
	        }catch(Exception e){System.out.println(e);}  
	        return new ModelAndView("upload","filename",filename);  
	    } 
}
