package demo.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import demo.entity.Student;

public class StudentDao {
	
	 @SuppressWarnings("unchecked")
	public List<Student> getAllStudent(){
		 
	        Session session = null;
	        List<Student> listSv = null;
	        try {
	            session = HibernateUtil.getSession();
	            String sql = "SELECT  * FROM sinhvien";
	            Query query = session.createQuery(sql);
	            listSv = query.list();
	        } catch(Exception ex) {
	            ex.printStackTrace();
	            // handle exception here
	        } finally {
	            try {if(session != null) session.close();} catch(Exception ex) {}
	        }
	        return listSv;
	    }
	 public Student getStudentById(String id){
		 
	        Session session = null;
	        Student student = null;
	        try {
	            session = HibernateUtil.getSession();
	            String sql = "SELECT  * FROM sinhvien WHERE id=?";
	            student = session.get(Student.class, id);
	 
	        } catch(Exception ex) {
	            ex.printStackTrace();
	            // handle exception here
	        } finally {
	            try {if(session != null) session.close();} catch(Exception ex) {}
	        }
	        return student;
	    }
	 public void addStudent(Student student) {
		 
	        Session session = null;
	        Transaction transaction = null;
	        try {
	            session = HibernateUtil.getSession();
	            transaction = session.beginTransaction();
	            session.save(student);
	            System.out.println("inserted student: "+student.getName());
	            transaction.commit();
	        } catch(Exception ex) {
	            ex.printStackTrace();
	            // handle exception here
	            if(transaction != null) transaction.rollback();
	        } finally {
	            try {if(session != null) session.close();} catch(Exception ex) {}
	        }
	    }
	 
	 public void deleteStudent(Student student) {
		 
	        Session session = null;
	        Transaction transaction = null;
	        try {
	            session = HibernateUtil.getSession();
	            transaction = session.beginTransaction();
	            session.delete(student);
	            transaction.commit();
	            System.out.println("deleted student: "+student.getName());
	        } catch(Exception ex) {
	            ex.printStackTrace();
	            // handle exception here
	            if(transaction != null) transaction.rollback();
	        } finally {
	            try {if(session != null) session.close();} catch(Exception ex) {}
	        }
	    }
	 public void editStudent(Student student) {
		 
	        Session session = null;
	        Transaction transaction = null;
	        try {
	            session = HibernateUtil.getSession();
	            transaction = session.beginTransaction();
	            session.update(student);
	            transaction.commit();
	            System.out.println("edit student: "+student.getName());
	        } catch(Exception ex) {
	            ex.printStackTrace();
	            // handle exception here
	            if(transaction != null) transaction.rollback();
	        } finally {
	            try {if(session != null) session.close();} catch(Exception ex) {}
	        }
	    }
	 
	   
	
	
}
