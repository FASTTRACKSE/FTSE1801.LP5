package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;


import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Language;

public interface LanguageDao {
	public List<Language> getAll();
	public Language getById(String id);
	public void add(Language language);
	public void update(Language language);
	public void delete(String id);
	public int checkNameLanguage(String nameLanguage);
	public List<Language> listLanguage(int start, int maxRows);
	public int countLanguage();
	public int checkMa(String idLanguage);
}
