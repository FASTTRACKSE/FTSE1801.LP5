package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.ProgramingLanguageTeam1;



@Repository
public class ProgramingLanguageTeam1DaoImpl implements ProgramingLanguageTeam1Dao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ProgramingLanguageTeam1> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from ProgramingLanguageTeam1 where isDelete =0",ProgramingLanguageTeam1.class).list();
	}

	@Override
	public void delete(String maNgonNgu) {
		Session session = this.sessionFactory.getCurrentSession();
		ProgramingLanguageTeam1 db=session.get(ProgramingLanguageTeam1.class,maNgonNgu);	
		db.setIsDelete(1);
		session.update(db);	
	}

	@Override
	public void addNew(ProgramingLanguageTeam1 nn) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(nn);
	}

	@Override
	public ProgramingLanguageTeam1 getById(String maNgonNgu) {
		Session session=this.sessionFactory.getCurrentSession();
		return session.get(ProgramingLanguageTeam1.class,maNgonNgu);
	}

	@Override
	public void update(ProgramingLanguageTeam1 nn) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(nn);
		
	}

	@Override
	public void setIsDelete(String maNgonNgu) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(maNgonNgu);
		
	}

	@Override
	public int getMa(String maNgonNgu) {
		Session session = this.sessionFactory.getCurrentSession();
		List<ProgramingLanguageTeam1> db = session.createQuery("from ProgramingLanguageTeam1 where maNn = '"+maNgonNgu+"' AND isDelete =0", ProgramingLanguageTeam1.class).list();	
		return  db.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProgramingLanguageTeam1> findAllForPaging(int startPosition, int maxResult) {
		Session session=this.sessionFactory.getCurrentSession();
		return session.createQuery("from ProgramingLanguageTeam1 where isDelete =0").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}





}
