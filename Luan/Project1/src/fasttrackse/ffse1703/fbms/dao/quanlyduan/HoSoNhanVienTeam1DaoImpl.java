package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.HoSoNhanVienTeam1;

@Repository
public class HoSoNhanVienTeam1DaoImpl implements HoSoNhanVienTeam1Dao {
	@Autowired
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<HoSoNhanVienTeam1> findAll(String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from HoSoNhanVienTeam1 where ma_phong_ban = '" + phongBan + "' AND Trang_Thai =1",HoSoNhanVienTeam1.class).list();
	}

	@Override
	public List<HoSoNhanVienTeam1> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from HoSoNhanVienTeam1 where Trang_Thai =1 ", HoSoNhanVienTeam1.class).list();
	}

	@Override
	public HoSoNhanVienTeam1 getById(int maNhanVien) {
		Session session= sessionFactory.getCurrentSession();
		return session.get(HoSoNhanVienTeam1.class,maNhanVien);
	}

}
