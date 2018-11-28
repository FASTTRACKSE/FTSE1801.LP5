package fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.DanhMuc;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TaiLieu;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

@Repository
public class TaiLieuDaoImpl implements TaiLieuDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSession(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaiLieu> listAllDel0() {
		Session session = this.sessionFactory.openSession();
		Query sql = session.createQuery("from TaiLieu where isDelete = 0");
		List<TaiLieu> list = sql.getResultList();
		session.close();
		return list;
	}

	@Override
	public void addTL(TaiLieu tl) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(tl);
		tx.commit();
		session.close();
	}

	@Override
	public void updateTL(TaiLieu tl) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(tl);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteTL(Integer idTL) {
		Session session = this.sessionFactory.openSession();
		Transaction tl = session.beginTransaction();
		session.delete(session.get(TaiLieu.class, idTL));
		tl.commit();
		session.close();
	}

	@Override
	public TaiLieu getTLbyID(Integer idTL) {
		Session session = this.sessionFactory.openSession();
		TaiLieu tl = session.get(TaiLieu.class, idTL);
		session.close();
		return tl;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaiLieu> listAllDel0(int start, int limit) {
		Session session = this.sessionFactory.openSession();
		Query sql = session.createQuery("from TaiLieu where isDelete=0");
		sql.setFirstResult((int) Math.ceil(start));
		sql.setMaxResults((int) Math.ceil(limit));
		List<TaiLieu> list = sql.getResultList();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PhongBan> listPhongBan() {
		Session session = this.sessionFactory.openSession();
		List<PhongBan> list = session.createQuery("from PhongBan").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhMuc> listDanhMuc() {
		Session session = this.sessionFactory.openSession();
		List<DanhMuc> list = session.createQuery("from DanhMuc where isDelete = 0").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaiLieu> listAllDel1() {
		Session session = this.sessionFactory.openSession();
		Query sql = session.createQuery("from TaiLieu where isDelete = 1");
		List<TaiLieu> list = sql.getResultList();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaiLieu> listAllDel1(int start, int limit) {
		Session session = this.sessionFactory.openSession();
		Query sql = session.createQuery("from TaiLieu where isDelete = 1");
		sql.setFirstResult((int) Math.ceil(start));
		sql.setMaxResults((int) Math.ceil(limit));
		List<TaiLieu> list = sql.getResultList();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaiLieu> listbyPhongBan(int start, int limit, String maPB) {
		Session session = this.sessionFactory.openSession();
		Query sql = session.createQuery("from TaiLieu where isDelete = 0 and ma_phong_ban = '"+maPB+"' ");
		List<TaiLieu> list = sql.getResultList();
		session.close();
		return list;
	}
}
