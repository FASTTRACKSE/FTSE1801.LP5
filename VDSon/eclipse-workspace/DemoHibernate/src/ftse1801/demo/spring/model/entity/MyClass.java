package ftse1801.demo.spring.model.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyClass {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(SinhVien.class)
				.buildSessionFactory();
		Session session;
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			List<SinhVien> list = session.createQuery("from SinhVien").list();
			for (SinhVien user : list) {
				System.out.println(user);
			}
			// SinhVien sinhVien = new SinhVien("67432", "luân chó", 1, "null");
			// session.save(sinhVien);

//			String id = "23";
//			SinhVien sinhVien;
//			sinhVien = session.get(SinhVien.class, id);
//			sinhVien.setNAME("luân c");
////			session.delete(sinhVien);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
