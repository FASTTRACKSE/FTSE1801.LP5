package fasttrackse.ffse1703.fbms.service.qlynhiemvuhieulp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.qlynhiemvuhieulp.QLyNhiemVuDao;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.DuAnEntityHieuLp;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.HoSoNhanVienHLP;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.LoaicongviecEntity;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.LoaitrangthaiEntity;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.QLyNhiemVuEntity;

@Service
public class QLyNhiemVuServiceImpl implements QLyNhiemVuService {
	@Autowired
	private QLyNhiemVuDao qLyNhiemVuDao;

	public List<QLyNhiemVuEntity> getAll() {
		return this.qLyNhiemVuDao.getAll();
	}

	@Override
	@Transactional
	public void delete(QLyNhiemVuEntity nv) {
		this.qLyNhiemVuDao.delete(nv);
	}

	@Override
	@Transactional
	public QLyNhiemVuEntity findById(int id) {
		return this.qLyNhiemVuDao.findById(id);
	}

	@Override
	@Transactional
	public void add(QLyNhiemVuEntity nv) {
		this.qLyNhiemVuDao.create(nv);
	}

	@Override
	@Transactional
	public void update(QLyNhiemVuEntity nv) {
		this.qLyNhiemVuDao.update(nv);

	}

	@Override
	@Transactional
	public List<LoaitrangthaiEntity> trangThai() {
		return this.qLyNhiemVuDao.trangThai();
	}

	@Override
	@Transactional
	public List<LoaicongviecEntity> congViec() {
		return this.qLyNhiemVuDao.congViec();
	}

	@Override
	@Transactional
	public List<DuAnEntityHieuLp> duAn() {
		return this.qLyNhiemVuDao.duAn();
	}

	@Override
	@Transactional
	public List<HoSoNhanVienHLP> nhanVienHLP() {
		return this.qLyNhiemVuDao.nhanVienHLP();
	}

	@Override
	@Transactional
	public List<QLyNhiemVuEntity> findAll(Integer offset, Integer maxResult, String search) {
		return qLyNhiemVuDao.findAll(offset, maxResult, search);
	}

	@Override
	public String toJson(List<QLyNhiemVuEntity> list) {
		// duyet list => to json
		int j= list.size();
		int i=0;
		String y="[";
		
		for(QLyNhiemVuEntity x :list) {
			i++;
			String tenCongviec = x.getTenCongviec();
			Date tgBatdau =x.getTgBatdau();
			Date tgKetthuc = x.getTgKetthuc();
			if(i==j) {
					y += "{\"title\": \"" + tenCongviec + "\", \"start\": \"" + tgBatdau + "\", \"end\":\"" + tgKetthuc + "\"}";
			}else {
				y+= "{\"title\": \"" + tenCongviec + "\",\"start\": \"" + tgBatdau + "\", \"end\": \"" + tgKetthuc + "\"}"+",";
			}
		}
		//return "[{\"title\":\"Làm crud\",\"start\":\"2018-09-11\",\"end\":\"2018-09-11\"}]" ;
		return y + "]" ;
	}

	@Override
	public List<QLyNhiemVuEntity> searchAll(String search) {
		return qLyNhiemVuDao.searchAll(search);
	}

	
}
