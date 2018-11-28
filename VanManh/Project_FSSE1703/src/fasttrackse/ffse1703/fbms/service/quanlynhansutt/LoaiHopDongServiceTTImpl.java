package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.LoaiHopDongDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.LoaiHopDongTT;

@Service
public class LoaiHopDongServiceTTImpl implements LoaiHopDongServiceTT {
	@Autowired
	private LoaiHopDongDaoTT loaiHopDongDaoTT;

	@Override
	@Transactional
	public List<LoaiHopDongTT> listLoaiHopDongTT() {
		// TODO Auto-generated method stub
		return this.loaiHopDongDaoTT.listLoaiHopDongTT();
	}

	@Override
	public List<LoaiHopDongTT> findAll() {
		// TODO Auto-generated method stub
		return loaiHopDongDaoTT.findAll();
	}

}
