package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.NhiemVuDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.NhiemVuTT;

@Service
public class NhiemVuServiceTTImpl implements NhiemVuServiceTT {
	@Autowired
	private NhiemVuDaoTT nhiemVuDaoTT;

	@Override
	@Transactional
	public void add(NhiemVuTT nhiemVuTT) {
		// TODO Auto-generated method stub
		nhiemVuDaoTT.add(nhiemVuTT);
	}

	@Override
	@Transactional
	public NhiemVuTT getByID(int id) {
		// TODO Auto-generated method stub
		return nhiemVuDaoTT.getByID(id);
	}

	@Override
	@Transactional
	public List<NhiemVuTT> getByDuAn(String idProjects) {
		// TODO Auto-generated method stub
		return nhiemVuDaoTT.getByDuAn(idProjects);
	}

	@Override
	@Transactional
	public void update(NhiemVuTT nhiemVuTT) {
		// TODO Auto-generated method stub
		nhiemVuDaoTT.update(nhiemVuTT);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		nhiemVuDaoTT.delete(id);
	}

	@Override
	@Transactional
	public List<NhiemVuTT> getByMaNhanVien(int maNhanVien) {
		// TODO Auto-generated method stub
		return nhiemVuDaoTT.getByMaNhanVien(maNhanVien);
	}

}
