package fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TaiLieu;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TrangThaiTaiLieu;

@Repository
public class TrangThaiDaoImpl implements TrangThaiDao {
	@Autowired
	private SessionFactory sessionFac;

	@SuppressWarnings("unchecked")
	public List<TrangThaiTaiLieu> listAllTrangThaiDel0() {
		Session session = this.sessionFac.openSession();
		List<TrangThaiTaiLieu> list = session.createQuery("from TrangThaiTaiLieu where isDelete = 0").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<TrangThaiTaiLieu> listAllTrangThaiDel1() {
		Session session = this.sessionFac.openSession();
		List<TrangThaiTaiLieu> list = session.createQuery("from TrangThaiTaiLieu where isDelete = 1").list();
		session.close();
		return list;
	}

	@Override
	public void addTT(TrangThaiTaiLieu tt) {
		Session session = this.sessionFac.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(tt);
		tx.commit();
		session.close();
	}

	@Override
	public void updateTT(TrangThaiTaiLieu tt) {
		Session session = this.sessionFac.openSession();
		Transaction tx = session.beginTransaction();
		session.update(tt);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteTT(String id) {
		Session session = this.sessionFac.openSession();
		Transaction tt = session.beginTransaction();
		session.delete(session.get(TrangThaiTaiLieu.class, id));
		tt.commit();
		session.close();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaiLieu> listAllbyMaTT(String maTT) {
		Session session = this.sessionFac.openSession();
		Query sql = session.createQuery("from TaiLieu where ma_trang_thai = "+maTT+" ");
		List<TaiLieu> list = sql.getResultList();
		session.close();
		return list;
	}

	@Override
	public TrangThaiTaiLieu getTTbyID(String id) {
		Session session = this.sessionFac.openSession();
		TrangThaiTaiLieu tt = session.get(TrangThaiTaiLieu.class, id);
		session.close();
		return tt;
	}

}
