package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Language;

@Repository
@Transactional
public class LanguageDaoImpl implements LanguageDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Language> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Language where status = 1", Language.class).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Language> listLanguage(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Language> List = (List<Language>) session.createQuery("FROM Language where status = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return List;
	}
	@SuppressWarnings("deprecation")
	@Override
	public int countLanguage() {
		Session session = sessionFactory.getCurrentSession();
		List<Language> dm = session.createQuery("from Language where status = 1", Language.class).list();
		return  dm.size();
	}
	

	@Override
	public Language getById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Language lg =session.get(Language.class, id);
		return lg;
	}

	@Override
	public void add(Language language) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(language);
	}

	@Override
	public void update(Language language) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(language);
	}

	@Override
	public void delete(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(id);
	}

	@Override
	public int checkNameLanguage(String nameLanguage) {
		Session session = sessionFactory.getCurrentSession();
		List<Language> lg = session.createQuery("from Language where nameLanguage = '"+nameLanguage+"' and status = 1", Language.class).list();
		
		return  lg.size();
	}
	@Override
	public int checkMa(String idLanguage) {
		Session session = sessionFactory.getCurrentSession();
		List<Language> lg = session.createQuery("from Language where idLanguage = '"+idLanguage+"'", Language.class).list();
		
		return  lg.size();
	}

}
