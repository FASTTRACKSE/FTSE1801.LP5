package demoHibernate.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demoHibernate.model.entity.SinhVien;

public class SinhVienUtil {
	static SessionFactory factory = null;
	 
    static {
        try{
            loadSessionFactory();
        }catch(Exception e){
            System.err.println("Ngoại lệ khi khởi tạo hibernate util.. ");
            e.printStackTrace();
        }
    }
 
    public static void loadSessionFactory(){
 
        Configuration configuration = new Configuration();
       factory =configuration.configure("hibernate.xml").addAnnotatedClass(SinhVien.class).buildSessionFactory();
        
    }
 
    public static Session getSession() throws HibernateException {
 
        Session retSession=null;
            try {
                retSession=factory.openSession();
            }catch(Throwable t){
            System.err.println("Ngoại lệ khi nhận phiên.. ");
            t.printStackTrace();
            }
            if(retSession == null) {
                System.err.println("phiên được phát hiện null");
            }
 
            return retSession;
    }

}
