package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;
import ftse1801.demo.spring.model.entity.SinhVien;

public class SinhVienDAO {
	@SuppressWarnings("unchecked")
	public List<SinhVien> getSinhVienList() {
		Session session = null;
		List<SinhVien> list = null;
		try {
			session = HibernateUtil.getSession();
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
			session = HibernateUtil.getSession();
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
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.save(sv);
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

	public void deleteEmployee(SinhVien sv) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
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
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			sv.setMASV("45678");
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
		SinhVienDAO empDao = new SinhVienDAO();

		SinhVien emp = new SinhVien();
		emp.setMASV("012312");
		emp.setNAME("a12");
		emp.setAGE(12);
		emp.setImage(null);

		System.out.println("---------------------------");

		List<SinhVien> empList = empDao.getSinhVienList();
		System.out.println("emp size: " + empList.size());
		empList.stream().forEach(System.out::println);

		System.out.println("---------------------------");

		SinhVien empObj = empDao.getEmployeeById(emp.getMASV());
		System.out.println(empObj);

		System.out.println("---------------------------");
		empDao.deleteEmployee(empObj);

		System.out.println("---------------------------");

		empList = empDao.getSinhVienList();
		System.out.println("emp size: " + empList.size());
		empList.stream().forEach(System.out::println);

		System.out.println("---------------------------");
	}
}
