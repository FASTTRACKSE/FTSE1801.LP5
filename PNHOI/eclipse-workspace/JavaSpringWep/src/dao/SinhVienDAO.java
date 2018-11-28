package dao;

import java.util.List;

import com.mysql.cj.Query;
import com.mysql.cj.Session;

public class SinhVienDAO {
@SuppressWarnings("unchecked")
public List<SinhVien> getSinhVienList(){
	  Session session = null;
	  List<SinhVien> list=null;
	  	try {
	  		session = SinhVien;
	            String queryStr = "from SinhVien";
	            Query query = session.createQuery(queryStr);
	            list = query.list();
	  		
	  	}catch(Exception e){
	  		e.printStackTrace();
	  	}finally {
			try {
				if(session!=null){
					session.close();
				}
			}catch (Exception e) {
              
			}
		}
	  	return list;
  }
@SuppressWarnings("unused")
public SinhVien getEmployeeById(String empId){
	 
    Session session = null;
    SinhVien emp = null;
    try {
        session = SinhVienUtil.getSession();
        String queryStr = "select emp from SinhVien emp";
        emp = session.get(SinhVien.class, empId);

    } catch(Exception ex) {
        ex.printStackTrace();
        // handle exception here
    } finally {
        try {if(session != null) session.close();} catch(Exception ex) {}
    }
    return emp;
}

public void insertEmployee(SinhVien sv) {
	 
    Session session = null;
    Transaction transaction = null;
    try {
        session = SinhVienUtil.getSession();
        transaction = session.beginTransaction();
        session.save(sv);
        transaction.commit();
    } catch(Exception ex) {
        ex.printStackTrace();
        // handle exception here
        if(transaction != null) transaction.rollback();
    } finally {
        try {if(session != null) session.close();} catch(Exception ex) {}
    }
}
public void deleteEmployee(SinhVien sv) {
	 
    Session session = null;
    Transaction transaction = null;
    try {
        session = SinhVienUtil.getSession();
        transaction = session.beginTransaction();
        session.delete(sv);
        transaction.commit();
    } catch(Exception ex) {
        ex.printStackTrace();
        // handle exception here
        if(transaction != null) transaction.rollback();
    } finally {
        try {if(session != null) session.close();} catch(Exception ex) {}
    }
}

public void EditEmployee(SinhVien sv) {
	 
    Session session = null;
    Transaction transaction = null;
    try {
        session = SinhVienUtil.getSession();
        transaction = session.beginTransaction();
        sv.setTensinhVien("45678");
        session.update(sv);
        transaction.commit();
    } catch(Exception ex) {
        ex.printStackTrace();
        // handle exception here
        if(transaction != null) transaction.rollback();
    } finally {
        try {if(session != null) session.close();} catch(Exception ex) {}
    }
}