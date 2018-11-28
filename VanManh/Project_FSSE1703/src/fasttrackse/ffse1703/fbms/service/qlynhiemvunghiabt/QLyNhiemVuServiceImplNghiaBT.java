package fasttrackse.ffse1703.fbms.service.qlynhiemvunghiabt;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.qlynhiemvunghiabt.QLyNhiemVuDaoNghiaBT;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt.NhiemVu;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt.DuAnNghiaBT;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt.LoaiCongViecNghiaBT;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt.TrangThaiNghiaBT;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Service
public class QLyNhiemVuServiceImplNghiaBT implements QLyNhiemVuServiceNghiaBT {

	@Autowired
	private QLyNhiemVuDaoNghiaBT congViecDao;

	@Override
	@Transactional
	public List<NhiemVu> findAll(String search) {
		return congViecDao.findAll(search);
	}

	@Override
	@Transactional
	public void addNew(NhiemVu cv) {
		congViecDao.addNew(cv);
	}

	@Override
	@Transactional
	public void update(NhiemVu cv) {
		congViecDao.update(cv);
	}

	@Override
	@Transactional
	public void delete(NhiemVu cv) {
		congViecDao.delete(cv);
	}

	@Override
	@Transactional
	public NhiemVu findByID(int ID) {
		return congViecDao.findByID(ID);
	}

//	@Override
//	public List<NhiemVu> findAll(int iDisplayStart, int iDisplayLength, String sql) {
//		return congViecDao.findAll(iDisplayStart, iDisplayLength, sql);
//	}
	
	@Override
	@Transactional
	public List<NhiemVu> findAllForPaging(int iDisplayStart, int iDisplayLength, String search) {
		return congViecDao.findAllForPaging(iDisplayStart, iDisplayLength, search);
	}

	@Override
	@Transactional
	public List<TrangThaiNghiaBT> trangThai() {
		return congViecDao.trangThai();
	}

	@Override
	@Transactional
	public List<LoaiCongViecNghiaBT> loaiCongViec() {
		return congViecDao.loaiCongViec();
	}

	@Override
	@Transactional
	public List<DuAnNghiaBT> duAn() {
		return congViecDao.duAn();
	}

	@Override
	@Transactional
	public List<HoSoNhanVien> nhanVien() {
		return congViecDao.nhanVien();
	}
	//@Override
	//@Transactional
	//public List<NhiemVu> findAllForPaging(int startPosition, int maxResult) {
	//	return congViecDao.findAllForPaging(startPosition,maxResult);
	//}

	@Override
	public List<NhiemVu> searchAll(String search) {
		return congViecDao.searchAll(search);
	}

	@Override
	public String toJson(List<NhiemVu> list) {
		int j= list.size();
		int i=0;
		String y="[";
		
		for(NhiemVu x :list) {
			i++;
			String tenCongviec = x.getTenCongViec();
			Date tgBatdau =x.getTgBatDau();
			Date tgKetthuc = x.getTgKetThuc();
			if(i==j) {
					y += "{\"title\": \"" + tenCongviec + "\", \"start\": \"" + tgBatdau + "\", \"end\":\"" + tgKetthuc + "\"}";
			}else {
				y+= "{\"title\": \"" + tenCongviec + "\",\"start\": \"" + tgBatdau + "\", \"end\": \"" + tgKetthuc + "\"}"+",";
			}
		}
		//return "[{\"title\":\"Làm crud\",\"start\":\"2018-09-11\",\"end\":\"2018-09-11\"}]" ;
		return y + "]" ;
	}
	
	
	
	// @Override
	// public String getRecordsTotal() {
	// return congViecDao.getRecordsTotal();
	// }
	//
	// @Override
	// public String getRecordsFiltered(String sql) {
	// return congViecDao.getRecordsFiltered(sql);
	// }

	// String action = "<a href='/ffse-fbms/QuanLyNhiemVuMinhHQ/view/"
	// + ID + "'><i class='fa fa-eye'></i></a>"
	// + "<a href='/ffse-fbms/QuanLyNhiemVuMinhHQ/edit/"
	// + ID + "'><i class='fa fa-pencil'></i></a>"
	// + "<a href='javascript:void(0);' data-toggle='modal'
	// data-target='#confirm-delete'
	// data-href='/ffse-fbms/QuanLyNhiemVuMinhHQ/delete/"
	// +ID + "'><i class='fa fa-trash'></i></a>";

	// return "[\"" + tenCongViec + "\",\"" + loaiCongViec + "\",\"" + moTa +
	// "\",\"" + tgBatDau + "\",\"" + tgKetThuc + "\",\"" + phanCong + "\",\"" +
	// tgDuKien + "\",\"" + trangThai + "\",\"" + duAn + "\",\"" + action + "\"]";

}
