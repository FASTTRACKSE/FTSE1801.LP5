package fasttrackse.ftse1801.fbms.dao.quanlythoigian;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quanlythoigian.LogWork;

@Repository
public class LogWorkDaoIplm implements LogWorkDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addLogWork(LogWork logWork) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editTrangThai(LogWork logWork) {
		// TODO Auto-generated method stub
	}

	@Override
	public void editLogWork(LogWork logWork) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(logWork);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteLogWork(LogWork logWork) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogWork> getAllLorkWork() {
		Session session = sessionFactory.openSession();
		List<LogWork> list = session.createQuery("from LogWork").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogWork> getNhapTheoNhanVien(int maNV) {
		Session session = sessionFactory.openSession();
		List<LogWork> list = session.createQuery("from LogWork where status=0 and ma_nhan_vien=" + maNV).list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogWork> getAllChoPheDuyet() {
		Session session = sessionFactory.openSession();
		List<LogWork> list = session.createQuery("from LogWork where status=1").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogWork> getAllPheDuyetLan1() {
		Session session = sessionFactory.openSession();
		List<LogWork> list = session.createQuery("from LogWork where status=2").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogWork> getAllDapheDuyet() {
		Session session = sessionFactory.openSession();
		List<LogWork> list = session.createQuery("from LogWork where status=3").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogWork> getChoPheDuyetTheoNhanVien(int maNV) {
		Session session = sessionFactory.openSession();
		List<LogWork> list = session.createQuery("from LogWork where status=1 and ma_nhan_vien=" + maNV).list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogWork> getAllPheDuyetLan1TheoNhanVien(int maNV) {
		Session session = sessionFactory.openSession();
		List<LogWork> list = session.createQuery("from LogWork where status=2 and ma_nhan_vien=" + maNV).list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogWork> getAllDapheDuyetTheoNhanVien(int maNV) {
		Session session = sessionFactory.openSession();
		List<LogWork> list = session.createQuery("from LogWork where status=3 and ma_nhan_vien=" + maNV).list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogWork> getAllBiTuChoiTheoNhanVien(int maNV) {
		Session session = sessionFactory.openSession();
		List<LogWork> list = session.createQuery("from LogWork where status=4 and ma_nhan_vien=" + maNV).list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogWork> getAllBiTuChoi() {
		Session session = sessionFactory.openSession();
		List<LogWork> list = session.createQuery("from LogWork where status=4").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogWork> getAllLogWorkTheoThang(int thang, int nam) {
		Session session = sessionFactory.openSession();
		List<LogWork> list = session
				.createQuery("from LogWork where MONTH(date) = " + thang + " AND YEAR(date) = " + nam + "").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogWork> getLogWorkTheoThangTheoNhanVien(int thang, int nam, int maNV) {
		Session session = sessionFactory.openSession();
		List<LogWork> list = session.createQuery(
				"from LogWork where MONTH(date) = " + thang + " AND YEAR(date) = " + nam + "AND ma_nhan_vien=" + maNV)
				.list();
		session.close();
		return list;
	}

	@Override
	public LogWork getLorkWorkTheoNhanVien(int maNV) {
		Session session = sessionFactory.openSession();
		LogWork logWork = session.get(LogWork.class, maNV);
		session.close();
		return logWork;
	}

}
