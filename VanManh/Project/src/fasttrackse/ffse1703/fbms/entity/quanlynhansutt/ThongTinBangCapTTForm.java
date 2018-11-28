package fasttrackse.ffse1703.fbms.entity.quanlynhansutt;

import java.util.List;

import javax.validation.Valid;

public class ThongTinBangCapTTForm {
	@Valid
	private List<ThongTinBangCapTT> listThongTinBangCap;

	public ThongTinBangCapTTForm(List<ThongTinBangCapTT> listThongTinBangCap) {
		super();
		this.listThongTinBangCap = listThongTinBangCap;
	}

	public List<ThongTinBangCapTT> getListThongTinBangCap() {
		return listThongTinBangCap;
	}

	public void setListThongTinBangCap(List<ThongTinBangCapTT> listThongTinBangCap) {
		this.listThongTinBangCap = listThongTinBangCap;
	}

}
