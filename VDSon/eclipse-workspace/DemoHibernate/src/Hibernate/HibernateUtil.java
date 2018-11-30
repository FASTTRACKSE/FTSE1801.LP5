package Hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ftse1801.demo.spring.model.entity.SinhVien;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	 
    static {
        try{
            loadSessionFactory();
        }catch(Exception e){
            System.err.println("Exception while initializing hibernate util.. ");
            e.printStackTrace();
        }
    }
 
    public static void loadSessionFactory(){
 
    	   Configuration configuration = new Configuration();
    	   sessionFactory =configuration.configure("hibernate.cfg.xml").addAnnotatedClass(SinhVien.class).buildSessionFactory();
    }
 
    public static Session getSession() throws HibernateException {
 
        Session retSession=null;
            try {
                retSession=sessionFactory.openSession();
            }catch(Throwable t){
            System.err.println("Exception while getting session.. ");
            t.printStackTrace();
            }
            if(retSession == null) {
                System.err.println("session is discovered null");
            }
 
            return retSession;
    }
}