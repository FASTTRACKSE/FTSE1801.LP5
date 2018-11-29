package dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SinhVienUtil {
	static EntityManagerFactory factory = null;
	 
    public static void loadEntityManagerFactory(){
       factory =Persistence.createEntityManagerFactory("persistence");
    }
 
    public static EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
    
    public static void close(){
		factory.close();
    }
}
