package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.mvpquanliduan.NhiemVuDao;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Nhiemvu;
@Service
@Transactional
public class NhiemVuServiceImpl implements NhiemVuService {
@Autowired
private NhiemVuDao nhiemVuDao;
@Override
	public void add(Nhiemvu nhiemVu) {
		
	nhiemVuDao.add(nhiemVu);
	}

	@Override
	public Nhiemvu getByID(String idProjects) {
		
		return nhiemVuDao.getByID(idProjects);
	}

	@Override
	public List<Nhiemvu> getByDuAn(String idProjects) {
		
		return nhiemVuDao.getByDuAn(idProjects);
	}

	@Override
	public void update(Nhiemvu nhiemVu) {
		nhiemVuDao.update(nhiemVu);

	}

	@Override
	public void delete(int id) {
		nhiemVuDao.delete(id);
	}

	@Override
	public List<Nhiemvu> getByMaNhanVien(String idNv) {
		
		return nhiemVuDao.getByMaNhanVien(idNv);
	}

	@Override
	public List<Nhiemvu> getByDuAn(String idProjects, String search,int start,int maxRows) {
		
		return nhiemVuDao.getByDuAn(idProjects, search, start, maxRows);
	}

	@Override
	public int countNhiemvu(String idProjects, String search) {
		// TODO Auto-generated method stub
		return nhiemVuDao.countNhiemvu(idProjects, search);
	}

	@Override
	public Nhiemvu getByid(int id) {
		// TODO Auto-generated method stub
		return nhiemVuDao.getByid(id);
	}

	@Override
	public int checkRole(String maNv, int idRole, String idProject) {
		// TODO Auto-generated method stub
		return nhiemVuDao.checkRole(maNv, idRole, idProject);
	}

}
