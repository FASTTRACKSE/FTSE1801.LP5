package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.DuAn;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.entity.security.UserAccount;

public class DuAnDaoImpl implements DuAnDao{
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<DuAn> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DuAn where isDelete = 1", DuAn.class).list();
	}

	@Override
	public DuAn findById(int maDuAn) {
		Session session = sessionFactory.getCurrentSession();
		DuAn duAn = session.get(DuAn.class, maDuAn);
		return duAn;
	}

	@Override
	public void add(DuAn duAn) {
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
	public int checkTenDuAn(String tenDuAn) {
		Session session = sessionFactory.getCurrentSession();
		List<DuAn> dm = session.createQuery("from DuAn where tenDuAn = '"+ tenDuAn +"' and isDelete = 1", DuAn.class).list();
		return  dm.size();
	}

	@Override
	public int checkMaDuAn(int maDuAn) {
		Session session = sessionFactory.getCurrentSession();
		List<DuAn> listDuAn = session.createQuery("from DuAn where maDuAn = '"+ maDuAn +"' ", DuAn.class).list();
		return  listDuAn.size();
	}

	@Override
	public List<HoSoNhanSu> getPm(String maPhongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from HoSoNhanSu where trangThai = 2 and maPhongBan = '"+ maPhongBan +"'", HoSoNhanSu.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DuAn> listDuAn(String search, int start, int maxRows) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DuAn where isDelete = 1 "+ search).setFirstResult(start)
				.setMaxResults(maxRows).list();
	}

	@Override
	public UserAccount getAccount(String userName) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from UserAccount where username='"+ userName +"'", UserAccount.class).getSingleResult();
	}

}
