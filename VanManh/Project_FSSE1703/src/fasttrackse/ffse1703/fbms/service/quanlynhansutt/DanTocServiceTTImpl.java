package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.DanTocDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.DanTocTT;

@Service
public class DanTocServiceTTImpl implements DanTocServiceTT {
	@Autowired
	private DanTocDaoTT danTocDaoTT;

	@Override
	@Transactional
	public List<DanTocTT> listDanTocTT() {
		// TODO Auto-generated method stub
		
		return this.danTocDaoTT.listDanTocTT();
	}
}
