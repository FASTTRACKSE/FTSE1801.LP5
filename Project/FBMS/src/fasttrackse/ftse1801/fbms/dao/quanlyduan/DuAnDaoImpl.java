package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.DuAn;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.entity.security.UserAccount;

@Repository
public class DuAnDaoImpl implements DuAnDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<DuAn> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DuAn where isDelete = 1", DuAn.class).list();
	}

	@Override
	public DuAn findById(String maDuAn) {
		Session session = sessionFactory.getCurrentSession();
		DuAn dm = session.get(DuAn.class, maDuAn);
		return dm;
	}

	@Override
	public void addNew(DuAn duAn) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(duAn);
	}

	@Override
	public void update(DuAn duAn) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(duAn);

	}

	@Override
	public void delete(DuAn duAn) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(duAn);

	}

	@Override
	public int checkNameProjects(String tenDuAn) {
		Session session = sessionFactory.getCurrentSession();
		List<DuAn> dm = session.createQuery("from DuAn where tenDuAn = '" + tenDuAn + "' and status = 1", DuAn.class)
				.list();

		return dm.size();
	}

	@Override
	public int checkMaProjects(String maDuAn) {
		Session session = sessionFactory.getCurrentSession();
		List<DuAn> dm = session.createQuery("from DuAn where maDuAn = '" + maDuAn + "' ", DuAn.class).list();
		return dm.size();
	}

	@Override
	public List<HoSoNhanSu> getPm(String maPhongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from HoSoNhanVien where isDelete = 0 and maPhongBan = '" + maPhongBan + "'",
				HoSoNhanSu.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DuAn> listDuAn(String search, int start, int maxRows) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DuAn where isDelete = 1 " + search).setFirstResult(start)
				.setMaxResults(maxRows).list();
	}

	@Override
	public UserAccount getAccount(String userName) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from UserAccount where username='" + userName + "'", UserAccount.class)
				.getSingleResult();
	}

	@Override
	public int count(String search) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DuAn where isDelete =0 " + search).list().size();
	}

}
