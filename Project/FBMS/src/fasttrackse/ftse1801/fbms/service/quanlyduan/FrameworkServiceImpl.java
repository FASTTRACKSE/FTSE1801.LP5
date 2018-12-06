package fasttrackse.ftse1801.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ftse1801.fbms.dao.quanlyduan.FrameworkDao;
import fasttrackse.ftse1801.fbms.entity.quanlyduan.Framework;
@Service
public class FrameworkServiceImpl implements FrameworkService{
	@Autowired
	private FrameworkDao frameworkDao;

	@Override
	@Transactional
	public List<Framework> getAll() {
		return frameworkDao.getAll();
	}

	@Override
	@Transactional
	public Framework getById(String maFramework) {
		return frameworkDao.getById(maFramework);
	}

	@Override
	@Transactional
	public void add(Framework framework) {
		frameworkDao.add(framework);		
	}

	@Override
	@Transactional
	public void update(Framework framework) {
		frameworkDao.update(framework);		
	}

	@Override
	@Transactional
	public void delete(String maFramework) {
		frameworkDao.delete(maFramework);		
	}

	@Override
	@Transactional
	public int checkNameFramework(String tenFramework) {
		return frameworkDao.checkNameFramework(tenFramework);
	}

	@Override
	@Transactional
	public int checkMaFramework(String maFramework) {
		return frameworkDao.checkMaFramework(maFramework);
	}

	@Override
	@Transactional
	public List<Framework> listFramework(int start, int maxRows) {
		return frameworkDao.listFramework(start, maxRows);
	}

	@Override
	@Transactional
	public int countFramework() {
		return frameworkDao.countFramework();
	}

}
