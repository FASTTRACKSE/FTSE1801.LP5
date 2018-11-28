package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.SinhVien;

public class SinhVienDAO {
	@SuppressWarnings("unchecked")
	public List<SinhVien> getSinhVienList() {
		Session session = null;
		List<SinhVien> list = null;
		try {
			session = SinhVienUtil.getSession();
			String queryStr = "from SinhVien";
			Query query = session.createQuery(queryStr);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e) {

			}
		}
		return list;
	}

	@SuppressWarnings("unused")
	public SinhVien getEmployeeById(String empId) {

		Session session = null;
		SinhVien emp = null;
		try {
			session = SinhVienUtil.getSession();
			String queryStr = "select emp from SinhVien emp";
			emp = session.get(SinhVien.class, empId);

		} catch (Exception ex) {
			ex.printStackTrace();
			// handle exception here
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}
		return emp;
	}

	public void insertEmployee(SinhVien sv) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = SinhVienUtil.getSession();
			transaction = session.beginTransaction();
			session.save(sv);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}
	}

	public void deleteEmployee(SinhVien sv) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = SinhVienUtil.getSession();
			transaction = session.beginTransaction();
			session.delete(sv);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			// handle exception here
			if (transaction != null)
				transaction.rollback();
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}
	}

	public void EditEmployee(SinhVien sv) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = SinhVienUtil.getSession();
			transaction = session.beginTransaction();
			sv.setTensinhVien("45678");
			session.update(sv);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			// handle exception here
			if (transaction != null)
				transaction.rollback();
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}
	}

	public static void main(String[] args) {
		SinhVienDAO dao = new SinhVienDAO();
		List<SinhVien> list = dao.getSinhVienList();
		for (SinhVien sinhVien : list) {
			System.out.println(sinhVien);
		}
		dao.EditEmployee(dao.getEmployeeById("123123"));
		list = dao.getSinhVienList();
		for (SinhVien sinhVien : list) {
			System.out.println(sinhVien);
		}

		// SinhVien sinhVien2 = new SinhVien();
		// sinhVien2.setMaSinhVien("aa");
		// sinhVien2.setTensinhVien("bb");
		// sinhVien2.setPassword("123345");
		// sinhVien2.setTuoi("12");
		// sinhVien2.setImg("sex");
		// System.out.println("---------------------------");
		// dao.insertEmployee(sinhVien2);
		// list = dao.getSinhVienList();
		// for (SinhVien sinhVien : list) {
		// System.out.println(sinhVien);
		// }

		// System.out.println("---------------------------");
		// dao.deleteEmployee(sinhVien2);
		// list = dao.getSinhVienList();
		// for (SinhVien sinhVien : list) {
		// System.out.println(sinhVien);
		// }

		// System.out.println("sv size: "+list.size());
		// list.stream().forEach(System.out::println);
	}
	// public static void main(String[] args) {
	// SessionFactory factory = new
	// Configuration().configure("j2n-hibernate.cfg.xml").addAnnotatedClass(SinhVien.class).buildSessionFactory();
	// Session session;
	// try {
	// session = factory.getCurrentSession();
	// session.beginTransaction();
	// @SuppressWarnings("unchecked")
	// List<SinhVien> list = session.createQuery("from SinhVien").list();
	// for(SinhVien sv: list) {
	// System.out.println(sv);
	// }
	// session.getTransaction().commit();
	// } finally {
	// factory.close();
	// }
	// }
}
