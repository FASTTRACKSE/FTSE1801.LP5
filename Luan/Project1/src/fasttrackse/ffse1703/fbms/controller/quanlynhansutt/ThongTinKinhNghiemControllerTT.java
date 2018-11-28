package fasttrackse.ffse1703.fbms.controller.quanlynhansutt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.service.quanlynhansutt.NhiemVuServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.QuanLyHoSoServiceTT;

@Controller
@RequestMapping("/quanlynhansutt/kinh_Nghiem/")
public class ThongTinKinhNghiemControllerTT {
 
	@Autowired
	private NhiemVuServiceTT nhiemVuServiceTT;
	
	@Autowired 
	private QuanLyHoSoServiceTT quanLyHoSoServiceTT;

	public void setNhiemVuServiceTT(NhiemVuServiceTT nhiemVuServiceTT) {
		this.nhiemVuServiceTT = nhiemVuServiceTT;
	}

	public void setQuanLyHoSoServiceTT(QuanLyHoSoServiceTT quanLyHoSoServiceTT) {
		this.quanLyHoSoServiceTT = quanLyHoSoServiceTT;
	}
	
	// Show an employee's family information
	@RequestMapping("/viewOneKinhNghiem/{maNhanVien}")
	public String viewOneKinhNghiem(@PathVariable int maNhanVien, Model model) {
	    
		model.addAttribute("viewOne", nhiemVuServiceTT.getByMaNhanVien(maNhanVien));
		model.addAttribute("maNhanVien", maNhanVien);
		return "QuanLyNhanSuTT/ThongTinKinhNghiem/viewOneKinhNghiem";
	}
}
