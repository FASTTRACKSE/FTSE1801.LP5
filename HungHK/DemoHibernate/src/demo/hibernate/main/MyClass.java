//package demo.hibernate.main;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
////import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//import demo.hibernate.model.entity.Diem;
//
//public class MyClass {
//	public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("quanly_sinhvien");
//        EntityManager em = emf.createEntityManager();
////        EntityTransaction transaction = em.getTransaction();
// 
//        Diem diem = em.find(Diem.class, 1);
// 
//        System.out.println(diem.getSinhVien().getName() +" | "+ diem.getHtml() );
// 
//        em.close();
//        emf.close();
//    }
//}
