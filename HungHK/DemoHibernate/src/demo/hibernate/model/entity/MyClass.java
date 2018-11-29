package demo.hibernate.model.entity;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import demo.hibernate.model.SinhVienDao;

public class MyClass {
	static SessionFactory factory;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
//		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(SinhVien.class)
//				.buildSessionFactory();
//		Session session;
//		try {
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			List<SinhVien> list = session.createQuery("from SinhVien").list();
//			for (SinhVien user : list) {
//				System.out.println(user);
//			}
////			 SinhVien sinhVien = new SinhVien();
////			 sinhVien.setMaSv("67");
////			 sinhVien.setName("luân chó");
////			 sinhVien.setAge(11);
////			 session.save(sinhVien);
//
////			String id = "67432";
////			SinhVien sinhVien;
////			sinhVien = session.get(SinhVien.class, id);
//////			sinhVien.setName("luân chó đẻ");
////			session.delete(sinhVien);
//			session.getTransaction().commit();
//		} finally {
//			factory.close();
//		}
		
		SinhVienDao sinhVienDao = new SinhVienDao();
		SinhVien sinhVien = new SinhVien();
		List<SinhVien> listSv = sinhVienDao.getSinhVienList();
		System.out.println(listSv.size());
		listSv.stream().forEach(System.out::println);
		
		
		sinhVien.setMaSv("29");
		sinhVien.setName("aa");
		sinhVien.setAge(22);
		sinhVienDao.addSinhVien(sinhVien);
		
		
//		SinhVien sv = sinhVienDao.getSinhVienById("28");
//		sinhVienDao.deleteSinhVien(sv);
//		
//		SinhVien sv2 = sinhVienDao.getSinhVienById("29");
//		sv2.setName("bb");
//		sv2.setAge(24);
//		sinhVienDao.updateSinhVien(sv2);
//		
//		List<SinhVien> listSv2 = sinhVienDao.getSinhVienList();
//		System.out.println(listSv2.size());
//		listSv2.stream().forEach(System.out::println);
		
		
	}

}
