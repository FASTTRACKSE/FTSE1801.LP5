package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.TinhTrangHonNhanDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.TinhTrangHonNhanTT;

@Service
public class TinhTrangHonNhanServiceTTImpl implements TinhTrangHonNhanServiceTT {
	@Autowired
	private TinhTrangHonNhanDaoTT tinhTrangHonNhanDaoTT;

	@Override
	@Transactional
	public List<TinhTrangHonNhanTT> getAllTinhTrangHonNhan() {
		// TODO Auto-generated method stub
		return this.tinhTrangHonNhanDaoTT.getAllTinhTrangHonNhan();
	}

	@Override
	@Transactional
	public List<TinhTrangHonNhanTT> findAll() {
		return tinhTrangHonNhanDaoTT.findAll();
	}

}
