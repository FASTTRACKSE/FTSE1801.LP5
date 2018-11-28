package ftse1801.demo.spring.model.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import ftse1801.demo.spring.model.IQLSinhVienDAO;
import ftse1801.demo.spring.model.entity.SinhVien;

public class DAOSinhVien implements IQLSinhVienDAO {

	@PersistenceContext
	private EntityManager entitymanager;

	public void setEntitymanager(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<SinhVien> displayAllSinhVien(int page, int size) {
		ArrayList<SinhVien> list = (ArrayList<SinhVien>) entitymanager.createQuery("from SinhVien").setFirstResult(page).setMaxResults(size).getResultList();
		return list;
	}
	
	@Transactional
	@Override
	public boolean deleteSinhVienByMaSV(String id) {
		boolean statusExucute = false;
		entitymanager.getEntityManagerFactory().createEntityManager();
		Session session = entitymanager.unwrap(Session.class);
		try {
			session.delete(displaySinhVientheoMa(id));
			statusExucute = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return statusExucute;
	}
	
	@Transactional
	@Override
	public boolean addSinhVien(String image, String id, String name, int age) {
		boolean statusExucute = false;
		SinhVien sinhVien = new SinhVien(id, name, age, image);
		try {
			entitymanager.getEntityManagerFactory().createEntityManager();
			Session session = entitymanager.unwrap(Session.class);
			session.save(sinhVien);
			statusExucute = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return statusExucute;
	}
	
	@Transactional
	@Override
	public boolean updateSinhVienByMaSV(String name, int age, String id, String image) {
		boolean statusExucute = false;
		entitymanager.getEntityManagerFactory().createEntityManager();
		Session session = entitymanager.unwrap(Session.class);
		SinhVien sinhVien = new SinhVien(image, name, age, id);
		try {
			session.update(sinhVien);
			statusExucute = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return statusExucute;
	}

	@Override
	public int soTrang(int soDong) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Transactional
	@Override
	public SinhVien displaySinhVientheoMa(String id) {
		entitymanager.getEntityManagerFactory().createEntityManager();
		Session session = entitymanager.unwrap(Session.class);
		SinhVien sinhVien;
		sinhVien = session.get(SinhVien.class, id);
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
		ArrayList<SinhVien> list = (ArrayList<SinhVien>) entitymanager.createQuery("from SinhVien").getResultList();
		return list;
	}

}
