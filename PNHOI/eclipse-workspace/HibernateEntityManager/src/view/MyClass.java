package view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.SinhVien;

public class MyClass {
	public static void main(String[] args) {
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<SinhVien> list=entityManager.createQuery("from SinhVien").getResultList();
		for(SinhVien sv : list) {
			System.out.println(sv);
		}
		entityManager.getTransaction().commit();
		
		
		System.out.println("-------------------------");
		
//		dao.insertEmployee(new SinhVien(25,"olala","12","USA"));;
////		dao.deleteEmployee(dao.getEmployeeById(26));
//		
//		System.out.println("-------------------------");
//		
//		dao.EditEmployee(new SinhVien(1,"thien","21","QN"));
//		
	}
}