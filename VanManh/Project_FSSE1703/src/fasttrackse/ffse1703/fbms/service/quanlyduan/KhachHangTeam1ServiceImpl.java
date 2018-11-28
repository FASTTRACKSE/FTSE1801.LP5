package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.quanlyduan.KhachHangTeam1Dao;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.KhachHangTeam1;
@Service
public class KhachHangTeam1ServiceImpl implements KhachHangTeam1Service {
	@Autowired
	KhachHangTeam1Dao khachHangDaoTeam1;

	public void setStudentDAO(KhachHangTeam1Dao khachHangDaoTeam1) {
		this.khachHangDaoTeam1 = khachHangDaoTeam1;

	}

	@Override
	@Transactional
	public List<KhachHangTeam1>getAll() {
		return this.khachHangDaoTeam1.getAll();
	}

	@Override
	@Transactional
	public KhachHangTeam1 findById(String makh) {
		return this.khachHangDaoTeam1.findById(makh) ;
	}

	@Override
	@Transactional
	public void add(KhachHangTeam1 khachhang) {
		this.khachHangDaoTeam1.create(khachhang);
	}

	@Override
	@Transactional
	public void update(KhachHangTeam1 khachhang) {
		this.khachHangDaoTeam1.update(khachhang);

	}

	@Override
	@Transactional
	public void delete(KhachHangTeam1 khachhang) {
		this.khachHangDaoTeam1.delete(khachhang);

	}

	@Override
	@Transactional
	public List<KhachHangTeam1> findAllForPaging(int startPosition, int maxResult) {
		return this.khachHangDaoTeam1.findAllForPaging(startPosition, maxResult);
	}

}
