package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.NhiemVu;
@Repository
@Transactional
public class NhiemVuDaoImpl implements NhiemVuDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(NhiemVu nhiemVu) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(nhiemVu);

	}

	@Override
	public NhiemVu getByID(String maDuAn) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(NhiemVu.class, maDuAn);
	}

	@Override
	public List<NhiemVu> getByDuAn(String maDuAn) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from NhiemVu where isDelete =1 and duAn.maDuAn='" + maDuAn + "'", NhiemVu.class)
				.list();
	}

	@Override
	public List<NhiemVu> getByMaNhanVien(int maNhanVien) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from NhiemVu where isDelete =1 and hoSoNhanVien.maNhanVien='" + maNhanVien + "'",
				NhiemVu.class).list();
	}

	@Override
	public void update(NhiemVu nhiemVu) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(nhiemVu);

	}

	@Override
	public void delete(int maNhiemVu) {
		Session session = sessionFactory.getCurrentSession();
		NhiemVu nhiemVu = session.get(NhiemVu.class, maNhiemVu);
		nhiemVu.setIsDelete(0);
		session.update(nhiemVu);
	}

	@Override
	public List<NhiemVu> getByDuAn(String maDuAn, String search, int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();

		return session
				.createQuery("from NhiemVu where isDelete =1 and duAn.maDuAn='" + maDuAn + "' " + search, NhiemVu.class)
				.setFirstResult(start).setMaxResults(maxRows).list();
	}

	@Override
	public int countNhiemvu(String maDuAn, String search) {
		Session session = sessionFactory.getCurrentSession();
		List<NhiemVu> nv = session
				.createQuery("from NhiemVu where isDelete = 1 and duAn.maDuAn='" + maDuAn + "' " + search, NhiemVu.class)
				.list();
		return nv.size();
	}

	@Override
	public NhiemVu getByid(int maNhiemVu) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(NhiemVu.class, maNhiemVu);
	}

	@Override
	public int checkVaiTro(int maNhanVien, String maVaiTro, String maDuAn) {
		Session session = sessionFactory.getCurrentSession();
		List<NhiemVu> nv = session
				.createQuery("from NhiemVu where duAn.maDuAn = '" + maDuAn + "' and vaiTroThanhVien.maVaiTro = '"
						+ maVaiTro + "' and hoSoNhanVien.maNhanVien= '" + maNhanVien + "' ", NhiemVu.class)
				.list();

		return nv.size();
	}
}
