package fasttrackse.ffse1703.fbms.service.qlynhiemvuminhhq;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.qlynhiemvuminhhq.QLyNhiemvuMinhHQDao;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.DuAnMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.LoaiCongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.TrangThaiMinhHQ;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;



@Service
public class CongViecServiceImpl implements CongViecService{



	@Autowired
	private QLyNhiemvuMinhHQDao congViecDao;
	
	@Override
	@Transactional
	public List<CongViecMinhHQ> findAll(String search) {
		return congViecDao.findAll(search);
	}

	@Override
	@Transactional
	public void addNew(CongViecMinhHQ cv) {
		congViecDao.addNew(cv);
	}

	@Override
	@Transactional
	public void update(CongViecMinhHQ cv) {
		congViecDao.update(cv);
	}

	@Override
	@Transactional
	public void delete(CongViecMinhHQ cv) {
		congViecDao.delete(cv);
	}

	@Override
	@Transactional
	public CongViecMinhHQ findByID(int ID) {
		return congViecDao.findByID(ID);
	}

	@Override
	@Transactional
	public List<CongViecMinhHQ> findAllForPaging(int iDisplayStart, int iDisplayLength, String search) {
		return congViecDao.findAllForPaging(iDisplayStart, iDisplayLength, search);
	}

	@Override
	@Transactional
	public List<TrangThaiMinhHQ> trangThai() {
		return congViecDao.trangThai();
	}

	@Override
	@Transactional
	public List<LoaiCongViecMinhHQ> loaiCongViec() {
		 return congViecDao.loaiCongViec();
	}

	@Override
	@Transactional
	public List<DuAnMinhHQ> duAn() {
		return congViecDao.duAn();
	}

	@Override
	@Transactional
	public List<HoSoNhanVien> nhanVien() {
		return congViecDao.nhanVien();
	}

	@Override
	public List<CongViecMinhHQ> searchAll(String search) {
		return congViecDao.searchAll(search);
	}

	@Override
	public String toJson(List<CongViecMinhHQ> list) {
		int j= list.size();
		int i=0;
		String y="[";
		
		for(CongViecMinhHQ x :list) {
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
}

