package ftse1801.demo.spring.model.dao;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ftse1801.demo.spring.model.IQLSinhVienDAO;
import ftse1801.demo.spring.model.entity.SinhVien;

public class SinhVienDAO implements IQLSinhVienDAO {
	@Autowired
	private SessionFactory session;

	public void setSession(SessionFactory factory) {
		this.session = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<SinhVien> displayAllSinhVien(int page, int size) {
		Session session = this.session.getCurrentSession();
		session.beginTransaction();
		ArrayList<SinhVien> list = (ArrayList<SinhVien>) session.createQuery("from SinhVien").setFirstResult(page)
				.setMaxResults(size).list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public boolean deleteSinhVienByMaSV(String id) {
		Session session = this.session.getCurrentSession();
		boolean statusExucute = false;
		try {
			session.beginTransaction();
			session.delete(displaySinhVientheoMa(id));
			session.getTransaction().commit();
			statusExucute = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return statusExucute;
	}

	@Override
	public boolean addSinhVien(String image, String id, String name, int age) {
		Session session = this.session.getCurrentSession();
		boolean statusExucute = false;
		SinhVien sinhVien = new SinhVien(id, name, age, image);
		session.beginTransaction();
		Serializable count = session.save(sinhVien);
		if (count != null) {
			statusExucute = true;
		}
		session.getTransaction().commit();
		return statusExucute;
	}

	@Override
	public boolean updateSinhVienByMaSV(String name, int age, String image, String id) {
		Session session = this.session.getCurrentSession();
		boolean statusExucute = false;
		SinhVien sinhVien = new SinhVien(id,name, age, image);
		try {
			session.beginTransaction();
			session.update(sinhVien);
			session.getTransaction().commit();
			statusExucute = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return statusExucute;
	}

	@Override
	public int soTrang(int soDong) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SinhVien displaySinhVientheoMa(String id) {
		Session session = this.session.getCurrentSession();
		session.beginTransaction();
		SinhVien sinhVien;
		sinhVien = session.get(SinhVien.class, id);
		session.getTransaction().commit();
		return sinhVien;
	}

	@Override
	public boolean login(String name, String pass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SinhVien displaySV(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<SinhVien> displayAllSinhVien() {
		Session session = this.session.getCurrentSession();
		session.beginTransaction();
		ArrayList<SinhVien> list = (ArrayList<SinhVien>) session.createQuery("from SinhVien").list();
		session.getTransaction().commit();
		return list;
	}

}
