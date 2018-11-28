package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Domain;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.KhachHang;

@Repository
@Transactional
public class KhachHangDaoImpl implements KhachHangDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void add(KhachHang khachHang) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(khachHang);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<KhachHang> listKhachHang(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<KhachHang> List = (List<KhachHang>) session.createQuery("FROM KhachHang where status = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return List;
	}
	@SuppressWarnings("deprecation")
	@Override
	public int countKhachHang() {
		Session session = sessionFactory.getCurrentSession();
		List<KhachHang> dm = session.createQuery("from KhachHang where status = 1", KhachHang.class).list();
		return  dm.size();
	}
	

	@Override
	public KhachHang getById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(KhachHang.class, id);
	}

	@Override
	public List<KhachHang> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from KhachHang where status =1", KhachHang.class).list();
	}

	@Override
	public void update(KhachHang khachHang) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(khachHang);

	}

	@Override
	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		KhachHang khachHang = session.get(KhachHang.class, id);
		khachHang.setStatus(0);
		session.update(khachHang);
	}

	@Override
	public int checkIdKhachHang(String idKhachHang) {
		Session session = sessionFactory.getCurrentSession();
		List<KhachHang> kh=session.createQuery("from KhachHang where idKhachHang = '"+idKhachHang+"' ", KhachHang.class).list();
		return kh.size();
	}
	

	


}
