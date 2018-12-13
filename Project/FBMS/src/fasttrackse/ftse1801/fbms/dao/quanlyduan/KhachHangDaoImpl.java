package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.KhachHang;


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
	public List<KhachHang> listKh(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<KhachHang> List = (List<KhachHang>) session.createQuery("FROM KhachHang where is_delete = 1").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return List;
	}
	
	@Override
	public int countKhachHang() {
		Session session = this.sessionFactory.getCurrentSession();
		List<KhachHang> dm = session.createQuery("from KhachHang where is_delete = 1", KhachHang.class).list();
		return  dm.size();
	}
	

	@Override
	public KhachHang getById(String maKh) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(KhachHang.class, maKh);
	}

	@Override
	public List<KhachHang> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from KhachHang where is_delete =1", KhachHang.class).list();
	}

	@Override
	public void update(KhachHang khachHang) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(khachHang);

	}

	@Override
	public void delete(String maKh) {
		Session session = this.sessionFactory.getCurrentSession();
		KhachHang khachHang = session.get(KhachHang.class, maKh);
		khachHang.setIsDelete(0);
		session.update(khachHang);
	}

	@Override
	public int checkMaKhachHang(String maKH) {
		Session session = this.sessionFactory.getCurrentSession();
		List<KhachHang> contact = session.createQuery("from KhachHang where maKh = '"+ maKH +"' ", KhachHang.class).list();
		return contact.size();
	}
	
}
