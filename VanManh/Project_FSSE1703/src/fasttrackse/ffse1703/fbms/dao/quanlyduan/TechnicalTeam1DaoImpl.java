package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.TechnicalTeam1;

@Repository

public class TechnicalTeam1DaoImpl implements TechnicalTeam1Dao {
		@Autowired
		private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		@Override
		public List<TechnicalTeam1> getAll() {
			Session session = this.sessionFactory.getCurrentSession();
			return session.createQuery("from TechnicalTeam1 where is_delete =0",TechnicalTeam1.class).list();
		}

		@Override
		public void delete(String maCongNghe) {
			Session session = this.sessionFactory.getCurrentSession();
			TechnicalTeam1 db=session.get(TechnicalTeam1.class,maCongNghe);	
			db.setIs_delete(1);
			session.update(db);			
		}

		@Override
		public void save(TechnicalTeam1 congNghe) {
			Session session=this.sessionFactory.getCurrentSession();
			session.save(congNghe);
			
		}

		@Override
		public TechnicalTeam1 getById(String maCongNghe) {
			Session session=this.sessionFactory.getCurrentSession();
			return session.get(TechnicalTeam1.class,maCongNghe);	
		}

		@Override
		public void update(TechnicalTeam1 congNghe) {
			Session session=this.sessionFactory.getCurrentSession();
			session.update(congNghe);		
		}

		@Override
		public void setIsDelete(String maCongNghe) {
			Session session = this.sessionFactory.getCurrentSession();
			TechnicalTeam1 db=session.get(TechnicalTeam1.class,maCongNghe);	
			db.setIs_delete(0);
			session.update(db);	
			
		}

		@Override
		public int getName(String tenCongNghe) {
			Session session = this.sessionFactory.getCurrentSession();
			List<TechnicalTeam1> db = session.createQuery("from TechnicalTeam1 where ten_cong_nghe = '"+tenCongNghe+"' AND is_delete =0", TechnicalTeam1.class).list();	
			return  db.size();
		}
}
