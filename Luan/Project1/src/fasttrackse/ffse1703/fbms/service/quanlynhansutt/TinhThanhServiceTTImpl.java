package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.TinhThanhDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.TinhThanhTT;
@Service
public class TinhThanhServiceTTImpl implements TinhThanhServiceTT {
	@Autowired
	private TinhThanhDaoTT tinhThanhDaoTT;

	@Override
	@Transactional
	public List<TinhThanhTT> getAllTinhThanh() {
		// TODO Auto-generated method stub
		return this.tinhThanhDaoTT.listTinhThanh();
	}
}
