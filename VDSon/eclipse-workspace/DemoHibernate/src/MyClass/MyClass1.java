package MyClass;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ftse1801.demo.spring.model.entity.SinhVien;

public class MyClass1 {
	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("JPAExamples");
		SinhVien sinhVien = new SinhVien();
		
		EntityManager manager = managerFactory.createEntityManager();
		manager.getTransaction().begin();
		List<SinhVien> sinhViens = manager.createQuery("from SinhVien").getResultList();
		for (SinhVien sinhVien2 : sinhViens) {
			System.out.println(sinhVien2);
		}
		manager.getTransaction().commit();
	}
}
