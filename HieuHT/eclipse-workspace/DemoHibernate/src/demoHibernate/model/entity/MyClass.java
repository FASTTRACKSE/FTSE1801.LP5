package demoHibernate.model.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demoHibernate.model.dao.SinhVienDao;

public class MyClass {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// SessionFactory sessionFactory = new
		// Configuration().configure("hibernate.xml").addAnnotatedClass(SinhVien.class)
		// .buildSessionFactory();
		// Session session;
		// try {
		// session = sessionFactory.getCurrentSession();
		// session.beginTransaction();
		// List<SinhVien> list = session.createQuery("from SinhVien").list();
		// for (SinhVien sv : list) {
		// System.out.println(sv);
		// }
		// int id = 60;
		// System.out.println("Sinh viên vừa sữa có id: " + id);
		// SinhVien sinhvien = session.get(SinhVien.class, id);
		// System.out.println("sữa: " + sinhvien);
		// sinhvien.setTen("Duy Luân");
		// session.getTransaction().commit();
		// } finally {
		// sessionFactory.close();
		// }
		SinhVienDao svDao = new SinhVienDao();
		List<SinhVien> list = svDao.getSinhVienList();
		for (SinhVien sinhvien : list) {
			System.out.println(sinhvien);
		}

		/* Sữa sinh viên */
		// SinhVien sv = svDao.getEmployeeById(56);
		// sv.setTen("Hồ Tấn Hiệu");
		// svDao.EditEmployee(sv);
		// System.out.println("----------------");
		// list = svDao.getSinhVienList();
		// for(SinhVien sinhvien: list){
		// System.out.println(sinhvien);
		// }

		/* Xóa sinh viên */
		// SinhVien sv = svDao.getEmployeeById(55);
		// svDao.deleteEmployee(sv);
		// System.out.println("----------------");
		// list = svDao.getSinhVienList();
		// for(SinhVien sinhVien: list) {
		// System.out.println(sinhVien);
		// }

		/* Thêm sinh viên */
		// SinhVien sv = new SinhVien();
		// sv.setTen("Tấn Hiệu");
		// sv.setTuoi("22");
		// sv.setDiachi("Quảng Nam");
		// sv.setLop("1801007");
		// sv.setImg("");
		// System.out.println("-------------");
		// svDao.insertEmployee(sv);
	}
}
