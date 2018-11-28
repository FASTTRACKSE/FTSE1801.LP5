package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlyduan.ProgramingLanguageTeam1Dao;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.ProgramingLanguageTeam1;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.VendorTeam1;

@Service
public class ProgramingLanguageTeam1ServiceImpl implements ProgramingLanguageTeam1Service {
	@Autowired
	private ProgramingLanguageTeam1Dao languageDao;

	@Override
	@Transactional
	public List<ProgramingLanguageTeam1> getAll() {
		return this.languageDao.getAll();
	}

	@Override
	@Transactional
	public void delete(String maNgonNgu) {
		this.languageDao.delete(maNgonNgu);
		
	}

	@Override
	@Transactional
	public void addNew(ProgramingLanguageTeam1 nn) {
		this.languageDao.addNew(nn);
		
	}

	@Override
	@Transactional
	public ProgramingLanguageTeam1 getById(String maNgonNgu) {
		return this.languageDao.getById(maNgonNgu);
	}

	@Override
	@Transactional
	public void update(ProgramingLanguageTeam1 nn) {
		this.languageDao.update(nn);
		
	}

	@Override
	@Transactional
	public void setIsDelete(String maNgonNgu) {
		this.languageDao.setIsDelete(maNgonNgu);
		
	}

	
	@Override
	@Transactional
	public int getMa(String maNgonNgu) {
		return this.languageDao.getMa(maNgonNgu);
	}

	@Override
	@Transactional
	public List<ProgramingLanguageTeam1> findAllForPaging(int startPosition, int maxResult) {
		return this.languageDao.findAllForPaging(startPosition, maxResult);
	}



}
