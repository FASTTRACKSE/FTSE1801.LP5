package fasttrackse.ffse1703.fbms.service.qlvn1;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlvn1.DonNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn1.LyDo;
import fasttrackse.ffse1703.fbms.entity.qlvn1.TinhTrangNghi;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;

public interface QuanLyVangNghiService {
	public void addDon(DonNghi dn);
	public List<DonNghi> listDonNghiNhap(int id_nv);
	public UserAccount getThongTinUser(String username);
	public TinhTrangNghi getTinhTrang(int id_nv);
	public List<LyDo> listLyDo();
	public void insertUpdateTinhTrang(int id_nv, TinhTrangNghi tt);
	public List<DonNghi> listDonNghiChoDuyet(int id_nv);
	public DonNghi getDonNghiNv(int id_don);
	public void updateDon(DonNghi dn); 
	public void deleteDon(int id_don);
	public List<DonNghi> listDonNghiPheDuyet1(String tenPhongBan);
	public List<DonNghi> listDonNghiPheDuyet2();
	public List<DonNghi> listDonNghiTuChoi(int id_nv,int start,int end);
	public List<DonNghi> listDanhSachPheDuyet(int id_nv,int start,int end);
	public void updateTinhTrang(TinhTrangNghi tt);
	public Long countListDaDuyet(int id_nv);
	public Long countListTuChoi(int id_nv);
	public List<DonNghi> listdanhsachpheduyetcty();
}