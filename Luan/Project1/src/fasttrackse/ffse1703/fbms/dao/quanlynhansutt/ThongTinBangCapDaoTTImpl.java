package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ThongTinBangCapTT;

@Repository
public class ThongTinBangCapDaoTTImpl implements ThongTinBangCapDaoTT {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addThongTinBangCap(ThongTinBangCapTT ttbc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(ttbc);
	}

	@Override
	public void updateThongTinBangCap(ThongTinBangCapTT ttbc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(ttbc);
	}

	@Override
	public void deleteThongTinBangCap(ThongTinBangCapTT ttbc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(ttbc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinBangCapTT> ListBangCap() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<ThongTinBangCapTT> listBangCap = session.createQuery("from ThongTinBangCapTT where isdelete = 1").getResultList();
		return listBangCap;
	}

	@Override
	public ThongTinBangCapTT findByBangCap(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(ThongTinBangCapTT.class, id);
	}

	@Override
	public HoSoNhanVienTT findByMaNhanVien(int maNhanVien) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(HoSoNhanVienTT.class, maNhanVien);
	}

	@Override
	public List<ThongTinBangCapTT> viewOne(int maNhanVien) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from ThongTinBangCapTT where ma_nhan_vien = "+maNhanVien+" and isdelete = 1");
		@SuppressWarnings("unchecked")
		List<ThongTinBangCapTT> viewOne = query.list();
		return viewOne;
	}

}
