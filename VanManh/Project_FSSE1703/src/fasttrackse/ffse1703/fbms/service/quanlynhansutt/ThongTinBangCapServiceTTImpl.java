package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.ThongTinBangCapDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ThongTinBangCapTT;

@Service
public class ThongTinBangCapServiceTTImpl implements ThongTinBangCapServiceTT {
	
	@Autowired
	private ThongTinBangCapDaoTT thongTinBangCapDaoTT;

	@Override
	@Transactional
	public void addThongTinBangCap(ThongTinBangCapTT ttbc) {
		this.thongTinBangCapDaoTT.addThongTinBangCap(ttbc);
	}

	@Override
	@Transactional
	public void updateThongTinBangCap(ThongTinBangCapTT ttbc) {
		this.thongTinBangCapDaoTT.updateThongTinBangCap(ttbc);
	}

	@Override
	@Transactional
	public void deleteThongTinBangCap(ThongTinBangCapTT ttbc) {
		this.thongTinBangCapDaoTT.deleteThongTinBangCap(ttbc);
	}
	
	@Override
	@Transactional
	public List<String> getErrorList(BindingResult bindingResult) {
		List<String> errorList = new ArrayList<String>();

		List<ObjectError> errors = bindingResult.getAllErrors();
		for (ObjectError error : errors) {
			String[] errorCodes = error.getCodes();
			String n = errorCodes[0].replaceFirst(".*?(\\d+).*", "$1");
			if (!errorList.contains(n)) {
				errorList.add(n);
			}
		}
		return errorList;
	}

	@Override
	@Transactional
	public List<String> getDeleteList(List<ThongTinBangCapTT> listThongTinBangcap) {
		List<String> deleteList = new ArrayList<String>();

		int size = listThongTinBangcap.size();
		for (int i = 0; i < size; i++) {
			int id = listThongTinBangcap.get(i).getId();
			if (id < 0) {
				deleteList.add(String.valueOf(i));
			}
		}
		return deleteList;
	}

	@Override
	@Transactional
	public List<ThongTinBangCapTT> listBangCap() {
		// TODO Auto-generated method stub
		return this.thongTinBangCapDaoTT.ListBangCap();
	}

	@Override
	@Transactional
	public ThongTinBangCapTT findByBangCap(int id) {
		// TODO Auto-generated method stub
		return this.thongTinBangCapDaoTT.findByBangCap(id);
	}

	@Override
	@Transactional
	public HoSoNhanVienTT getHoSoNhanVienById(int maNhanVien) {
		// TODO Auto-generated method stub
		return this.thongTinBangCapDaoTT.findByMaNhanVien(maNhanVien);	}

	@Override
	@Transactional
	public List<ThongTinBangCapTT> viewOne(int maNhanVien) {
		// TODO Auto-generated method stub
		return this.thongTinBangCapDaoTT.viewOne(maNhanVien);
	}


}
