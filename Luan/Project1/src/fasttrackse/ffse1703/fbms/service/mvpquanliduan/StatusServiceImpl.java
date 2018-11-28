package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.mvpquanliduan.StatusDAO;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.StatusProject;
@Service
public class StatusServiceImpl implements StatusService{
	@Autowired
	private StatusDAO statusDAO;
	@Override
	@Transactional
	public List<StatusProject> findAll() {
		
		return statusDAO.findAll();
	}

	@Override
	@Transactional
	public StatusProject findById(int id) {
	
		return statusDAO.findById(id);
	}

	@Override
	@Transactional
	public void addNew(StatusProject status) {
		statusDAO.addNew(status);
		
	}

	@Override
	@Transactional
	public void update(StatusProject status) {
		statusDAO.update(status);
		
	}

	@Override
	@Transactional
	public void delete(StatusProject status) {
		statusDAO.delete(status);
		
	}

	@Override
	@Transactional
	public int checkNameStatus(String nameStatus) {
	
		return statusDAO.checkNameStatus(nameStatus);
	}

	@Override
	@Transactional
	public List<StatusProject> listStatusProject(int start, int maxRows) {
		return statusDAO.listStatusProject(start, maxRows);
	}

	@Override
	@Transactional
	public int countStatusProject() {
		return statusDAO.countStatusProject();
	}

}
