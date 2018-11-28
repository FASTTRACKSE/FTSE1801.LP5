package fasttrackse.ffse1703.fbms.controller.qlvn1;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fasttrackse.ffse1703.fbms.entity.qlvn1.DonNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn1.LyDo;
import fasttrackse.ffse1703.fbms.entity.qlvn1.TinhTrangNghi;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;
import fasttrackse.ffse1703.fbms.service.qlvn1.QuanLyVangNghiService;

@Controller
@RequestMapping("/QuanLyVangNghi")
public class DonXinNghiCotroller {
	@Autowired
	private QuanLyVangNghiService service;

	public void setService(QuanLyVangNghiService service) {
		this.service = service;
	}

	@RequestMapping(value = "/donxinnghi", method = RequestMethod.GET)
	public String viewChucDanh(Model model, Authentication auth) {
		UserAccount user = service.getThongTinUser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		model.addAttribute("nhanVien", nhanVien);
		TinhTrangNghi tinhTrang = service.getTinhTrang(nhanVien.getMaNhanVien());
		model.addAttribute("tinhTrang", tinhTrang);
		List<LyDo> arrLyDo = new ArrayList<LyDo>();
		arrLyDo = service.listLyDo();
		model.addAttribute("arrLyDo", arrLyDo);
		model.addAttribute("donNghi", new DonNghi());
		return "QuanLyVangNghi/donxinnghi";
	}

	@RequestMapping(value = "/savechoduyet", method = RequestMethod.POST)
	public String saveSaveChoDuyet(Model model, @ModelAttribute("donNghi") DonNghi dn, @RequestParam int ngay_da_nghi,
			@RequestParam int ngay_con_lai) {
		dn.setTinh_trang(1);
		dn.getTg_bat_dau();
		TinhTrangNghi tt = new TinhTrangNghi();
		tt.setId_nv(dn.getId_nv());
		service.addDon(dn);
		int days = (int) ((dn.getTg_ket_thuc().getTime() - dn.getTg_bat_dau().getTime()) / (1000 * 60 * 60 * 24));
		if (ngay_da_nghi == 0) {
			tt.setId_nv(dn.getId_nv());
			tt.setNgay_da_nghi(days);
			tt.setNgay_con_lai((12 - days));
			service.insertUpdateTinhTrang(dn.getId_nv(), tt);
		} else {
			tt.setId_nv(dn.getId_nv());
			tt.setNgay_da_nghi((ngay_da_nghi + days));
			tt.setNgay_con_lai((ngay_con_lai - days));
			TinhTrangNghi ttCu = service.getTinhTrang(dn.getId_nv());
			tt.setId_tinh_trang(ttCu.getId_tinh_trang());
			service.updateTinhTrang(tt);

		}		
		return "redirect:/QuanLyVangNghi/choduyet";
	}

	@RequestMapping(value = "/luunhap", method = RequestMethod.GET)
	public String viewLuuNhap(Model model, Authentication auth) {
		UserAccount user = service.getThongTinUser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		List<DonNghi> dn = new ArrayList<DonNghi>();
		System.out.println(nhanVien.getMaNhanVien());
		dn = service.listDonNghiNhap(nhanVien.getMaNhanVien());
		model.addAttribute("list", dn);
		return "QuanLyVangNghi/luunhap";
	}
	

	@RequestMapping(value = "/savenhap", method = RequestMethod.POST)
	public String saveNhapPost(Model model, @ModelAttribute("donNghi") DonNghi dn) {
		dn.setTinh_trang(0);
		service.addDon(dn);
		return "redirect:/QuanLyVangNghi/luunhap";
	}

	@RequestMapping(value = "/choduyet", method = RequestMethod.GET)
	public String viewChoDuyet(Model model, Authentication auth) {
		UserAccount user = service.getThongTinUser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		List<DonNghi> dn = new ArrayList<DonNghi>();
		dn = service.listDonNghiChoDuyet(nhanVien.getMaNhanVien());
		model.addAttribute("list", dn);
		return "QuanLyVangNghi/choduyet";
	}

	@RequestMapping(value = "/edit/{id_don}", method = RequestMethod.GET)
	public String viewSua(@PathVariable("id_don") int id_don, Model model, DonNghi donNghi) {
		donNghi = service.getDonNghiNv(id_don);
		model.addAttribute("donNghi", donNghi);
		TinhTrangNghi tinhTrang = service.getTinhTrang(donNghi.getId_nv());
		model.addAttribute("tinhTrang", tinhTrang);
		List<LyDo> arrLyDo = new ArrayList<LyDo>();
		arrLyDo = service.listLyDo();
		model.addAttribute("arrLyDo", arrLyDo);
		return "QuanLyVangNghi/sua";
	}
	
	@RequestMapping(value = "/duyetvong1", method = RequestMethod.GET)
	public String viewDuyetVong1(Model model, Authentication auth) {
		List<DonNghi> dn = new ArrayList<DonNghi>();
		UserAccount user = service.getThongTinUser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		dn = service.listDonNghiPheDuyet1(nhanVien.getPhongBan().getTenPhongBan());
		model.addAttribute("list", dn);
		if(nhanVien.getChucDanh().getMaChucDanh().equals("TP")) {
			return "QuanLyVangNghi/duyetvong1";
		}else {
			return "QuanLyVangNghi/ghichutp";
		}
		
	}
	
	@RequestMapping(value = "/pheduyetvong1/{id_don}", method = RequestMethod.GET)
	public String pheDuyetVong1(@PathVariable("id_don") int id_don, Model model, DonNghi donNghi) {
		donNghi = service.getDonNghiNv(id_don);
		donNghi.setTinh_trang(2);
		service.updateDon(donNghi);
		return "redirect:/QuanLyVangNghi/duyetvong1";
	}
	
	@RequestMapping(value = "/duyetvong2", method = RequestMethod.GET)
	public String viewDuyetVong2(Model model, Authentication auth) {
		List<DonNghi> dn = new ArrayList<DonNghi>();
		dn = service.listDonNghiPheDuyet2();
		model.addAttribute("list", dn);
		return "QuanLyVangNghi/duyetvong2";
	}
	
	@RequestMapping(value = "/pheduyetvong2/{id_don}", method = RequestMethod.GET)
	public String pheDuyetVong2(@PathVariable("id_don") int id_don, Model model, DonNghi donNghi) {
		donNghi = service.getDonNghiNv(id_don);
		donNghi.setTinh_trang(3);
		service.updateDon(donNghi);
		return "redirect:/QuanLyVangNghi/duyetvong2";
	}

	@RequestMapping(value = "/saveedit", method = RequestMethod.POST)
	public String saveEditPost(Model model, @ModelAttribute("donNghi") DonNghi dn) {
		dn.setTinh_trang(0);
		service.updateDon(dn);
		return "redirect:/QuanLyVangNghi/luunhap";
	}

	@RequestMapping(value = "/savechoduyetnhap/{id_don}", method = RequestMethod.GET)
	public String saveChoDuyetNhap(@PathVariable("id_don") int id_don, Model model, DonNghi donNghi) {
		donNghi = service.getDonNghiNv(id_don);
		TinhTrangNghi tinhTrang = service.getTinhTrang(donNghi.getId_nv());
		donNghi.setTinh_trang(1);
		donNghi.getTg_bat_dau();
		int days = (int) ((donNghi.getTg_ket_thuc().getTime() - donNghi.getTg_bat_dau().getTime())
				/ (1000 * 60 * 60 * 24));
		TinhTrangNghi tt = new TinhTrangNghi();
		if (tinhTrang == null) {
			tt.setId_nv(donNghi.getId_nv());
			tt.setNgay_da_nghi(days);
			tt.setNgay_con_lai((12 - days));
			service.insertUpdateTinhTrang(donNghi.getId_nv(), tt);
		} else {
			tt.setId_nv(donNghi.getId_nv());
			tt.setNgay_da_nghi((tinhTrang.getNgay_da_nghi() + days));
			tt.setNgay_con_lai((tinhTrang.getNgay_con_lai() - days));
			TinhTrangNghi ttCu = service.getTinhTrang(donNghi.getId_nv());
			tt.setId_tinh_trang(ttCu.getId_tinh_trang());
			service.updateTinhTrang(tt);
		}

		service.updateDon(donNghi);
		return "redirect:/QuanLyVangNghi/choduyet";
	}
	
	@RequestMapping(value = "/dontuchoi/{id_don}", method = RequestMethod.GET)
	public String dontuchoi(@PathVariable("id_don") int id_don, Model model, DonNghi donNghi) {
		donNghi = service.getDonNghiNv(id_don);
		donNghi.setTinh_trang(4);
		service.updateDon(donNghi);
		return "redirect:/QuanLyVangNghi/duyetvong1";
	}
	
	@RequestMapping(value = "/tuchoi/{pageId}", method = RequestMethod.GET)
	public String viewTuChoi(Model model, Authentication auth,@PathVariable int pageId) {
		UserAccount user = service.getThongTinUser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		Long tongSo = service.countListTuChoi(nhanVien.getMaNhanVien());
		int total=2;
		int soTrang = (int)Math.ceil(tongSo/(total*1.0));
		int pageTrang = pageId;
		
		List<DonNghi> dn = new ArrayList<DonNghi>();
		dn = service.listDonNghiTuChoi(nhanVien.getMaNhanVien(),((pageTrang-1)*total), total);
		model.addAttribute("page",pageTrang);
		model.addAttribute("soTrang",soTrang);
		model.addAttribute("list", dn);
		return "QuanLyVangNghi/dontuchoi";
	}
	
	@RequestMapping(value = "/tuchoi")
	public String viewTuChoiPage0(Model model) {
		
		return "redirect:/QuanLyVangNghi/tuchoi/1";
	}
	
	@RequestMapping(value = "/dondaduyet/{id_don}", method = RequestMethod.GET)
	public String dondaduyet(@PathVariable("id_don") int id_don, Model model, DonNghi donNghi) {
		donNghi = service.getDonNghiNv(id_don);
		donNghi.setTinh_trang(3);
		service.updateDon(donNghi);
		return "redirect:/QuanLyVangNghi/duyetvong2";
	}

	@RequestMapping(value = "/daduyet")
	public String viewDaDuyetPage0(Model model) {
		
		return "redirect:/QuanLyVangNghi/daduyet/1";
	}
	
	@RequestMapping(value = "/daduyet/{pageId}", method = RequestMethod.GET)
	public String viewDaDuyet(Model model, Authentication auth,@PathVariable int pageId) {
		
		UserAccount user = service.getThongTinUser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		Long tongSo = service.countListDaDuyet(nhanVien.getMaNhanVien());
		int total=2;
		int soTrang = (int)Math.ceil(tongSo/(total*1.0));
		int pageTrang = pageId;
		
		List<DonNghi> dn = new ArrayList<DonNghi>();
		dn = service.listDanhSachPheDuyet(nhanVien.getMaNhanVien(),((pageTrang-1)*total), total);
		model.addAttribute("page",pageTrang);
		model.addAttribute("soTrang",soTrang);
		model.addAttribute("list", dn);
		return "QuanLyVangNghi/daduyet";
	}
	
	@RequestMapping(value = "/dontuchoi2/{id_don}", method = RequestMethod.GET)
	public String dontuchoi2(@PathVariable("id_don") int id_don, Model model, DonNghi donNghi) {
		donNghi = service.getDonNghiNv(id_don);
		donNghi.setTinh_trang(4);
		service.updateDon(donNghi);
		return "redirect:/QuanLyVangNghi/duyetvong2";
	}

	@RequestMapping(value = "/xemdanhsachdaduyet")
	public String viewXemPheDuyet(Model model, Authentication auth) {
		UserAccount user = service.getThongTinUser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		List<DonNghi> dn = service.listdanhsachpheduyetcty();
		model.addAttribute("list", dn);
		if(nhanVien.getPhongBan().getMaPhongBan().equals("PNS")) {
			return "QuanLyVangNghi/xemdanhsachpheduyet";
		}else {
			return "QuanLyVangNghi/ghichu";
		}
		
	}
	
	@RequestMapping(value ="/delete/{id_don}")
    public String deleteNhap(@PathVariable("id_don") int id_don){
		service.deleteDon(id_don);
        return "redirect:/QuanLyVangNghi/luunhap";
    }

}
