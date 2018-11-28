package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.mvpquanliduan.LanguageDao;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Language;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {
	@Autowired
private LanguageDao languageDao;
	@Override
	public List<Language> getAll() {		
		return this.languageDao.getAll();
	}

	@Override
	public Language getById(String id) {
		// TODO Auto-generated method stub
		return languageDao.getById(id);
	}

	@Override
	public void add(Language language) {
		languageDao.add(language);

	}

	@Override
	public void update(Language language) {
		languageDao.update(language);

	}

	@Override
	public void delete(String id) {
		languageDao.delete(id);

	}

	@Override
	public int checkNameLanguage(String nameLanguage) {
		// TODO Auto-generated method stub
		return languageDao.checkNameLanguage(nameLanguage);
	}

	@Override
	public List<Language> listLanguage(int start, int maxRows) {
		
		return languageDao.listLanguage(start, maxRows);
	}

	@Override
	public int countLanguage() {
		
		return languageDao.countLanguage();
	}

	@Override
	public int checkMa(String idLanguage) {
		// TODO Auto-generated method stub
		return languageDao.checkMa(idLanguage);
	}

}
