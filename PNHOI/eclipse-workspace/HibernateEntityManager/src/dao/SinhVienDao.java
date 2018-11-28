package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entity.SinhVien;

public class SinhVienDao {
	public List<SinhVien> getSinhVienList(){
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		List<SinhVien> list=entityManager.createQuery("from SinhVien", SinhVien.class).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return list;
	  }
	
//	@SuppressWarnings("unused")
//	public SinhVien getEmployeeById(int empId){
//		 
//	    Session session = null;
//	    SinhVien emp = null;
//	    try {
//	        session = SinhVienUtil.getSession();
//	        String queryStr = "select emp from SinhVien emp";
//	        emp = session.get(SinhVien.class, empId);
//
//	    } catch(Exception ex) {
//	        ex.printStackTrace();
//	        // handle exception here
//	    } finally {
//	        try {if(session != null) session.close();} catch(Exception ex) {}
//	    }
//	    return emp;
//	}
//
//	public void insertEmployee(SinhVien sv) {
//		 
//	    Session session = null;
//	    Transaction transaction = null;
//	    try {
//	        session = SinhVienUtil.getSession();
//	        transaction = session.beginTransaction();
//	        session.save(sv);
//	        transaction.commit();
//	    } catch(Exception ex) {
//	        ex.printStackTrace();
//	        // handle exception here
//	        if(transaction != null) transaction.rollback();
//	    } finally {
//	        try {if(session != null) session.close();} catch(Exception ex) {}
//	    }
//	}
//	public void deleteEmployee(SinhVien sv) {
//		 
//	    Session session = null;
//	    Transaction transaction = null;
//	    try {
//	        session = SinhVienUtil.getSession();
//	        transaction = session.beginTransaction();
//	        session.delete(sv);
//	        transaction.commit();
//	    } catch(Exception ex) {
//	        ex.printStackTrace();
//	        // handle exception here
//	        if(transaction != null) transaction.rollback();
//	    } finally {
//	        try {if(session != null) session.close();} catch(Exception ex) {}
//	    }
//	}
//
//	public void EditEmployee(SinhVien sv) {
//		 
//	    Session session = null;
//	    Transaction transaction = null;
//	    try {
//	        session = SinhVienUtil.getSession();
//	        transaction = session.beginTransaction();
//	        session.update(sv);
//	        transaction.commit();
//	    } catch(Exception ex) {
//	        ex.printStackTrace();
//	        // handle exception here
//	        if(transaction != null) transaction.rollback();
//	    } finally {
//	        try {if(session != null) session.close();} catch(Exception ex) {}
//	    }
//	}
//
	
}
