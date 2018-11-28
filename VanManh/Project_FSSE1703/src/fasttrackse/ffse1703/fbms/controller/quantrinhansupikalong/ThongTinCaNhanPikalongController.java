package fasttrackse.ffse1703.fbms.controller.quantrinhansupikalong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.entity.security.UserAccount;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.NhiemVuService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.BangCapPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.GiaDinhPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HoSoNhanVienPikalongService;
import fasttrackse.ffse1703.fbms.service.security.UserAccountService;

@Controller
@RequestMapping("/quantrinhansu/thongtincanhan/")
public class ThongTinCaNhanPikalongController {
	
	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	private HoSoNhanVienPikalongService hoSoNhanVienPikalongService;
	@Autowired
	private GiaDinhPikalongService giaDinhPikalongService;
	
	@Autowired
	private BangCapPikalongService bangCapPikalongService;
	
	@Autowired
	private NhiemVuService nhiemVuService;
	
	public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final char BREAK_LINE = '\n';

	
	@RequestMapping("/")
	public String viewThongTinCaNhan(Model model) {
		String maNv = String.valueOf(getMaNv().getNhanVien().getMaNhanVien());
		int totalChar = countWords(maNv);
		String str;
		if(totalChar == 1) {
			 str = "0000";
		} else if(totalChar == 2) {
			str = "000";
		}  else if(totalChar == 3) {
			str = "00";
		}  else if(totalChar == 4) {
			str = "0";
		} else {
			str = "";
		}
		System.out.println("ma nhan vien: " + str.concat(maNv));
		model.addAttribute(str.concat(maNv));
		model.addAttribute("hoSoNhanVien", hoSoNhanVienPikalongService.getEdit(str.concat(maNv)));
		model.addAttribute("thongTinGiaDinh", giaDinhPikalongService.viewOne(str.concat(maNv)));
		model.addAttribute("thongTinBangCap", bangCapPikalongService.viewOne(str.concat(maNv)));
		model.addAttribute("kinhNghiem", nhiemVuService.getByMaNhanVien(str.concat(maNv)));
		return "QuanTriNhanSuPikalong/ThongTinHoSo/hosochitiet";
	}
	
	public UserAccount getMaNv() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userTest = auth.getName();
		System.out.println("user name: " + userTest);
		UserAccount user = userAccountService.loadUserByUsername(auth.getName());
		return user;
	}
	
	
	public static int countWords(String input) {
        if (input == null) {
            return -1;
        }
        int count = 0;
        int size = input.length();
        for (int i = 0; i < size; i++) {
                    count++;
            }
        
        return count;
    }

}
