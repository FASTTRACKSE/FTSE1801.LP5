package MyClass;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import Hibernate.HibernateUtil;
import ftse1801.demo.spring.model.entity.SinhVien;

public class MyClass2 {
	@SuppressWarnings({ "unchecked"})
	public static void main(String[] args) {
		Session session = null;
		session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(SinhVien.class);
		
		List<SinhVien> list = criteria.list();
		for (SinhVien sinhVien : list) {
			System.out.println(sinhVien);
		}
		session.close();
	}
}
