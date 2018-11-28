package fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.sun.org.apache.regexp.internal.recompile;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;

@Repository
public class HoSoNhanVienPikalongDaoImpl implements HoSoNhanVienPikalongDao {
	@Autowired 
	public SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	@Override
	@SuppressWarnings("rawtypes")
	public List<HoSoNhanVienPikalong> listNhanVien() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from HoSoNhanVienPikalong where isActive = :active");
		query.setParameter("active", 0);
		
		@SuppressWarnings("unchecked")
		List<HoSoNhanVienPikalong> nhanVienList = query.list();
		return nhanVienList;
	}
	
	@Override
	public List<HoSoNhanVienPikalong> listNhanVienPagination(int start, int end) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from HoSoNhanVienPikalong where isActive = :active").setFirstResult(start).setMaxResults(end);
		query.setParameter("active", 0);
		
		@SuppressWarnings("unchecked")
		List<HoSoNhanVienPikalong> nhanVienListPagination = query.list();
		return nhanVienListPagination;
	}


	@Override
	@SuppressWarnings("rawtypes")
	public void delete(String maNv) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update HoSoNhanVienPikalong set isActive = :active" 
												 + " where maNv = :maNv");
		query.setParameter("active", 1);
		query.setParameter("maNv", maNv);
		
		query.executeUpdate();
		
	}


	@Override
	public void insert(HoSoNhanVienPikalong hoSoNhanVien) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(hoSoNhanVien);
		
	}


	@Override
	public HoSoNhanVienPikalong getEdit(String maNv) {
		Session sesion = this.sessionFactory.getCurrentSession();
		
		return sesion.get(HoSoNhanVienPikalong.class, maNv);
	}


	@Override
	public void update(HoSoNhanVienPikalong hoSoNhanVienPikalong) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(hoSoNhanVienPikalong);
		
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public String getAutoId() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(
				"SELECT `AUTO_INCREMENT` FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'ffse1703' AND TABLE_NAME = 'thongtinhoso'");
		String index = query.getSingleResult().toString();
		return index;
	}
	
	@Override
	public HoSoNhanVienPikalong getHoSoNhanVienById (String maNv) {
		Session session = this.sessionFactory.getCurrentSession();
		HoSoNhanVienPikalong hsnv = session.load(HoSoNhanVienPikalong.class, new Integer(maNv));
		System.out.println(hsnv);
		return hsnv;
	}


	@Override
	public Long countAll() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("select count(*) from HoSoNhanVienPikalong where isActive = :active");
		query.setParameter("active", 0);
		Long total = (Long)query.uniqueResult();
		
		return total;
	}


	@Override
	public boolean checkExistMaNv(String maNv) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("select count(*) from HoSoNhanVienPikalong where maNv = :maNv");
		query.setParameter("maNv", maNv);
		
		Long exist = (Long) query.uniqueResult();
		if(exist > 0) {
			return false;
		}
		
		return true;
	}


	@Override
	public boolean checkIsActive(String maNv) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("select count(*) from HoSoNhanVienPikalong where maNv = :maNv and isActive = :isActive");
		query.setParameter("maNv", maNv);
		query.setParameter("isActive", 0);
		
		Long isActive = (Long) query.uniqueResult();
		
		if(isActive > 0) {
			return true;
		}
		
		return false;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanVienPikalong> listNhanVienByPhongBan(String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from HoSoNhanVienPikalong where isActive = :active and maPhongBan.maPhongBan = :maPhongBan");
		query.setParameter("active", 0);
		query.setParameter("maPhongBan", phongBan);
		@SuppressWarnings("unused")
		List<HoSoNhanVienPikalong> nhanVienListByPhongBan = query.list();
		return nhanVienListByPhongBan;
	}

}
