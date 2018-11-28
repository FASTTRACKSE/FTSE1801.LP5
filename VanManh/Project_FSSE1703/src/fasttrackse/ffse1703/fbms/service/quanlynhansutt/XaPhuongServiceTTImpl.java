package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.XaPhuongDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.XaPhuongTT;
@Service
public class XaPhuongServiceTTImpl implements XaPhuongServiceTT{
	@Autowired
	private XaPhuongDaoTT xaPhuongDaoTT;

	public void setXaPhuongDaoTT(XaPhuongDaoTT xaPhuongDaoTT) {
		this.xaPhuongDaoTT = xaPhuongDaoTT;
	}
	
	@Override
	@Transactional
	public List<XaPhuongTT> getAllXaPhuong(String maQuanHuyen) {
	
		return this.xaPhuongDaoTT.listXaPhuong(maQuanHuyen);
	}
}
