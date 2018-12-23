package ftse1801.demo.spring.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.annotations.PolymorphismType;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ftse1801.demo.spring.entity.SinhVien;

public class JPASinhVienDao implements ISinhVienDao{
	
	@PersistenceContext
	private EntityManager entityManagerFactory;
	
	public void setEntityManagerFactory(EntityManager entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<SinhVien> getAllSinhVien() {
		return (ArrayList<SinhVien>) entityManagerFactory.createQuery("from SinhVien").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<SinhVien> getAllSinhVien1(int paging, int soDong) {
//		ArrayList<SinhVien> list = new ArrayList<>();
//		list = (ArrayList<SinhVien>) entityManagerFactory.createEntityGraph(SinhVien.class);
//		entityManagerFactory.close();
		Query query = entityManagerFactory.createQuery("from SinhVien");
		if(paging!=0) {
			query.setFirstResult(paging);
		}
		if(soDong!=0) {
			query.setMaxResults(soDong);
		}
		return (ArrayList<SinhVien>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getCount(int soDong) {
		Query query = entityManagerFactory.createQuery("from SinhVien sv order by sv.id desc");
		ArrayList<SinhVien> list = (ArrayList<SinhVien>) query.getResultList();
		return list.get(0).getId();
	}

	@Override
	public ArrayList<SinhVien> getSinhVien() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean DeleteSinhVien(int id) {
		boolean check = false;
		SinhVien sinhvien = getAllSvById(id);
		if(entityManagerFactory.contains(sinhvien)) {
			entityManagerFactory.remove(sinhvien);
			entityManagerFactory.flush();
			check=true;
		}
		entityManagerFactory.close();
		return check;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean UpdateSinhVien(SinhVien sinhvien, int id) {
		boolean check = false;
		sinhvien.setId(id);
		if(!entityManagerFactory.contains(sinhvien)) {
			entityManagerFactory.merge(sinhvien);
			entityManagerFactory.flush();
			check=true;
		}
		entityManagerFactory.close();
		return check;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean addSinhVien(String ten, String tuoi, String diachi, String lop, String img) {
		boolean check=false;
		SinhVien sinhVien = new SinhVien();
		sinhVien.setTen(ten);
		sinhVien.setTuoi(tuoi);
		sinhVien.setDiachi(diachi);
		sinhVien.setLop(lop);
		sinhVien.setImg(img);
		if(!entityManagerFactory.contains(sinhVien)) {
			entityManagerFactory.persist(sinhVien);
			entityManagerFactory.flush();
			check=true;
		}
		entityManagerFactory.close();
		return check;
	}

	@Override
	public SinhVien getAllSvById(int id) {
		SinhVien sinhvien = entityManagerFactory.find(SinhVien.class, id);
		entityManagerFactory.close();
		return sinhvien;
	}

	@Override
	public ArrayList<SinhVien> getSinhVien1() {
		// TODO Auto-generated method stub
		return null;
	}

}
