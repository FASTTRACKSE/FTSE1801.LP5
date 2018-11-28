package fasttrackse.ffse1703.fbms.controller.mvpquanliduan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Technical;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.TechnicalService;

@Controller
@RequestMapping("/mvpquanliduan/technical")
public class TechnicalController {
	@Autowired
	private TechnicalService technicalService;
	
	
	public void setTechnicalService(TechnicalService technicalService) {
		this.technicalService = technicalService;
	}


	@RequestMapping("/list-technical")
	public String listTechnical(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIdTn") == null) {
			pageId = 1;
		} else {
			pageId = (int) session.getAttribute("pageIdTn");
		}
		return "redirect: list-technical/"+pageId;
	}
	@RequestMapping(value = "/list-technical/{pageId}", method = RequestMethod.GET)
	public String listPersons(@PathVariable int pageId, Model model,HttpSession session) {
		int maxRows= 5;
		int start = (pageId - 1) * maxRows;
		int totalTechnical = technicalService.countTechnical();
		int totalPage = (int) Math.ceil(totalTechnical / (double) maxRows);
		if (pageId == 0) {
			pageId = 1;
		}
		model.addAttribute("listTechnical", this.technicalService.listTechnical(start, maxRows));
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("pageIdTn", pageId);
		return "MvpQuanLiDuAn/technical/listtechnical";
	}

	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new Technical());
		return "MvpQuanLiDuAn/technical/addtechnical";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") Technical technical, BindingResult result,
			final RedirectAttributes redirectAttributes,Model model) {
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/technical/addtechnical";
		}
		int checkName= technicalService.checkNameTechnical(technical.getNameTechnical());
		if(checkName >=1) {
			model.addAttribute("messageName", "Tên Kĩ thuật đã được sử dụng");
			return "MvpQuanLiDuAn/technical/addtechnical";
		}
		int checkMa= technicalService.checkMaTechnical(technical.getIdTechnical());
		if(checkMa >=1) {
			model.addAttribute("messageMa", "Mã Kĩ thuật đã được sử dụng");
			return "MvpQuanLiDuAn/technical/addtechnical";
		}
		technical.setStatus(1);
		technicalService.addNew(technical);
		redirectAttributes.addFlashAttribute("success", "<script>alert('Th�m th�nh c�ng');</script>");
		return "redirect: list-technical";
	}

	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable String id) {
		Technical technical = technicalService.findById(id);
		model.addAttribute("technical", technical);
		return "MvpQuanLiDuAn/technical/updatetechnical";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("Technical") Technical technical, BindingResult result,
			final RedirectAttributes redirectAttributes,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("technical", technical);
			return "MvpQuanLiDuAn/technical/updatetechnical";
		}
		technical.setStatus(1);
		technicalService.update(technical);
		return "redirect: list-technical";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable String id, final RedirectAttributes redirectAttributes) {
		Technical technical = technicalService.findById(id);
		technical.setStatus(0);
		technicalService.update(technical);
		return "redirect: /ffse-fbms/mvpquanliduan/technical/list-technical";
	}
	 @ModelAttribute("technicalList")
	   public Map<String, String> getTechnicalList() {
		  List<Technical> list = technicalService.findAll();
	      Map<String, String> technicalList = new HashMap<String, String>();
	      for(Technical x: list) {
	    	  technicalList.put(x.getIdTechnical(), x.getNameTechnical());
	      }
	      return technicalList;
	   }
}