package ftse1801.demo.spring.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ftse1801.demo.spring.model.entity.Diem;
import ftse1801.demo.spring.model.entity.SinhVien;

public class HibernateSinhVienDao implements SinhVienDAOIML {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addSinhVien(String maSV, String tenSV, String pass, String tuoi, String image,List<Diem>diem) {
		boolean statusExecute = false;
		Session session = null;
		try {

			session = this.sessionFactory.getCurrentSession();
			session.beginTransaction();
            SinhVien sv  =new SinhVien(maSV, tenSV, pass, tuoi, image, null);
			session.save(sv);
			Diem point = diem.get(0);
			
			point.setSinhVien(sv);

			session.save(point);
			session.getTransaction().commit();
			statusExecute = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return statusExecute;
	}

	@Override
	public boolean addDiemSV(String maSV,String monHoc, int diem) {
		boolean statusExecute = false;
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.beginTransaction();
			List<Diem> listDiem = new ArrayList<Diem>();
            Diem poin  = new Diem(listDiem.get(0).getSinhVien(), monHoc, diem);
			session.save(poin);
			session.getTransaction().commit();
			statusExecute = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return statusExecute;
		
	}

	@Override
	public boolean updateSV(String maSV, String ten, String pass,String tuoi,List<Diem>diem) {
		boolean statusExecute = false;
		Session session = null;
		SinhVien sv = SinhVienByMa(maSV);
		try {

			session = this.sessionFactory.openSession();
			session.beginTransaction();
            sv.setListDiem(diem);
			sv = new SinhVien(maSV, ten, pass, tuoi, null, null);
			Diem point = diem.get(0);		
			point.setSinhVien(sv);

			session.update(sv);
			session.update(point);

			session.getTransaction().commit();
			statusExecute = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return statusExecute;
		
	}

	@Override
	public boolean deleteDiemSV(SinhVien sinhVien) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSV(String maSinhVien) {
		boolean statusExecute = false;
		Session session = null;
		SinhVien sv = SinhVienByMa(maSinhVien);
		try {
			session = this.sessionFactory.openSession();
			session.beginTransaction();

			session.delete(sv);
			session.getTransaction().commit();
			statusExecute = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return statusExecute;
	}

	@Override
	public boolean UpdateDiemSV(String maSV, String MH, int diem) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public ArrayList<SinhVien> getAllSinhVien(int trang, int soDong) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		ArrayList<SinhVien> list = (ArrayList<SinhVien>) session.createQuery("from SinhVien").setFirstResult(trang)
				.setMaxResults(soDong).list();

		session.getTransaction().commit();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<SinhVien> getAllSinhVien1() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		ArrayList<SinhVien> list = (ArrayList<SinhVien>) session.createQuery("from SinhVien").list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public ArrayList<SinhVien> getSinhVienTheoTen(SinhVien sinhVien) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public SinhVien SinhVienByMa(String maSV) {
		Session session = null;
		SinhVien sv =null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.beginTransaction();
			sv = session.get(SinhVien.class, maSV);
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} 
		return sv;
	}

	@Override
	public int getCount(int soDong) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addAllSinhVien(SinhVien sinhvien) {
		boolean statusExecute = false;
		Session session = null;
	
		try {
			
			session = this.sessionFactory.getCurrentSession();
			session.beginTransaction();
//			SinhVien sinhVien = new SinhVien();
//			//List<Diem> diem  = new ArrayList<Diem>();
//			Diem point = new Diem();
//			point.setSinhVien(sinhVien);
//			//diem.add(point);
//			sinhvien.getListDiem().add(point);
			session.save(sinhvien);
			session.getTransaction().commit();
			statusExecute = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return statusExecute;
		
	}

}
