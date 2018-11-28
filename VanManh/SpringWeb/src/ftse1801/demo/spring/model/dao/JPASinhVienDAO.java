package ftse1801.demo.spring.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ftse1801.demo.spring.bean.MonHoc;
import ftse1801.demo.spring.bean.SinhVien;

public class JPASinhVienDAO implements ISinhVienDAO{
	@PersistenceContext
	private EntityManager entityManagerFactory;
	public void setEntityManagerFactory(EntityManager entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SinhVien> getSinhVienRecord(int start, int recordPage) {
		Query query = entityManagerFactory.createQuery("from SinhVien");
		if (start!=0) {
			query.setFirstResult(start);
		}
		if (recordPage!=0) {
			query.setMaxResults(recordPage);
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SinhVien> showAllSinhVien() {
//		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
//		sessionFactory.getCurrentSession().createQuery("from SinhVien").list();
		return  entityManagerFactory.createQuery("from SinhVien").getResultList();
	}

	@Override
	public SinhVien showSinhVienInMaSV(int maSV) {
		SinhVien sinhVien = entityManagerFactory.find(SinhVien.class, maSV);
		return sinhVien;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean addSV(String name, String age, String img) {
		boolean check=false;
		SinhVien sinhVien = new SinhVien();
		sinhVien.setName(name);
		sinhVien.setAge(age);
		sinhVien.setImg(img);
		if (!entityManagerFactory.contains(sinhVien)) {
			entityManagerFactory.persist(sinhVien);
			entityManagerFactory.flush();
			check=true;
		}
		entityManagerFactory.close();
		return check;
	}

	@Override
	public boolean addDiem(int maSV, MonHoc monHoc) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean upDateSV(int maSV, String name, String age, String img) {
		boolean check = false;
		SinhVien sinhVien = new SinhVien();
		sinhVien.setMaSV(maSV);
		sinhVien.setName(name);
		sinhVien.setAge(age);
		sinhVien.setImg(img);
		if (!entityManagerFactory.contains(sinhVien)) {
			Session session = entityManagerFactory.unwrap(Session.class);
//			entityManagerFactory.merge(sinhVien);
			session.update(sinhVien);
			entityManagerFactory.flush();
			check=true;
		}
		entityManagerFactory.close();
		return check;
	}

	@Override
	public boolean upDateDiem(int maSV, MonHoc monHoc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDiem(int maSV) {
		
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean deleteSV(int maSV) {
		boolean check = false;
		SinhVien sinhVien = showSinhVienInMaSV(maSV);
		if (entityManagerFactory.contains(sinhVien)) {
			entityManagerFactory.remove(sinhVien);
			entityManagerFactory.flush();
			check=true;
		}
		return check;
	}

	@Override
	public boolean kiemTraDelete(int maSV) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getMaSV() {
		ArrayList<SinhVien> list = (ArrayList<SinhVien>) entityManagerFactory.createQuery("from SinhVien sv order by sv.maSV desc").setFirstResult(0).setMaxResults(1).getResultList();
		return list.get(0).getMaSV();
	}

}
