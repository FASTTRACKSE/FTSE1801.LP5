package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ThongTinGiaDinhTT;

@Repository
public class ThongTinGiaDinhDaoTTImpl implements ThongTinGiaDinhDaoTT {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addGiaDinh(ThongTinGiaDinhTT p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);

	}

	@Override
	public void updateGiaDinh(ThongTinGiaDinhTT p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
	}
	
	@Override
	public void removeGiaDinh(ThongTinGiaDinhTT p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
	}

	@Override
	public ThongTinGiaDinhTT getGiaDinhById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(ThongTinGiaDinhTT.class, id);
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ThongTinGiaDinhTT> viewOne(int maNhanVien) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from ThongTinGiaDinhTT where ma_nhan_vien = " + maNhanVien + " and isdelete = 1");
		@SuppressWarnings("unchecked")
		List<ThongTinGiaDinhTT> viewOne = query.list();
		return viewOne;
	}

	@Override
	public int checkQuanHe(String quanHe, int maNhanVien) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<ThongTinGiaDinhTT> dm = session.createQuery(
				"from ThongTinGiaDinhTT where quan_he = '" + quanHe + "' and ma_nhan_vien = '" + maNhanVien + "'",
				ThongTinGiaDinhTT.class).list();
		return dm.size();
	}

	@Override
	public HoSoNhanVienTT findByMaNhanVien(int maNhanVien) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(HoSoNhanVienTT.class, maNhanVien);
	}

}
