package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.QuanHuyenDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.QuanHuyenTT;
@Service
public class QuanHuyenServiceTTImpl implements QuanHuyenServiceTT {

	@Autowired
	private QuanHuyenDaoTT quanHuyenDaoTT;

	public void setQuanHuyenDaoTT(QuanHuyenDaoTT quanHuyenDaoTT) {
		this.quanHuyenDaoTT = quanHuyenDaoTT;
	}
	
	@Override
	@Transactional
	public List<QuanHuyenTT> listQuanHuyen(String maThanhPho) {

		return quanHuyenDaoTT.listQuanHuyen(maThanhPho);
	}

}
