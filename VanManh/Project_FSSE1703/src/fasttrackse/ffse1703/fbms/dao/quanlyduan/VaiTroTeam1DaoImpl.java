package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.VaiTroThanhVienTeam1;

@Repository
public class VaiTroTeam1DaoImpl implements VaiTroTeam1Dao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<VaiTroThanhVienTeam1> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from VaiTroThanhVienTeam1 where isDelete =0",VaiTroThanhVienTeam1.class).list();
	}

	@Override
	public void delete(String maVaiTro) {
		Session session = this.sessionFactory.getCurrentSession();
		VaiTroThanhVienTeam1 db=session.get(VaiTroThanhVienTeam1.class,maVaiTro);	
		db.setIsDelete(1);
		session.update(db);	
	}

	@Override
	public void addNew(VaiTroThanhVienTeam1 vt) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(vt);
	}

	@Override
	public VaiTroThanhVienTeam1 getById(String maVaiTro) {
		Session session=this.sessionFactory.getCurrentSession();
		return session.get(VaiTroThanhVienTeam1.class,maVaiTro);	
	}

	@Override
	public void update(VaiTroThanhVienTeam1 vt) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(vt);
	}

	@Override
	public void setIsDelete(String maVaiTro) {
		Session session = this.sessionFactory.getCurrentSession();
		VaiTroThanhVienTeam1 db=session.get(VaiTroThanhVienTeam1.class,maVaiTro);	
		db.setIsDelete(0);
		session.update(db);
	}

	@Override
	public int getMa(String maVaiTro) {
		Session session = this.sessionFactory.getCurrentSession();
		List<VaiTroThanhVienTeam1> db = session.createQuery("from VaiTroThanhVienTeam1 where mavt = '"+maVaiTro+"' AND isDelete =0", VaiTroThanhVienTeam1.class).list();	
		return  db.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VaiTroThanhVienTeam1 > findAllForPaging(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from VaiTroThanhVienTeam1 where isDelete =0").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}

}
