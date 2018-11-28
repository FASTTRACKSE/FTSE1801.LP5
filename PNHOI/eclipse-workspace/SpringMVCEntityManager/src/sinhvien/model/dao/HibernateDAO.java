package sinhvien.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import sinhvien.model.entity.SinhVien;

public class HibernateDAO implements ISinhVienDAO{
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public ArrayList<SinhVien> getAllSinhVien() {
		entityManagerFactory =Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		ArrayList<SinhVien> list=(ArrayList<SinhVien>) entityManager.createQuery("from SinhVien", SinhVien.class).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return list;
	}

	@Override
	public boolean deleteSinhVien(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addNewSinhVien(SinhVien sinhvien) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSinhVien(SinhVien sinhvien, String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SinhVien getSinhVien(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SinhVien> getAll(int trang, int soDong) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount(int soDong) {
		// TODO Auto-generated method stub
		return 0;
	}
}
