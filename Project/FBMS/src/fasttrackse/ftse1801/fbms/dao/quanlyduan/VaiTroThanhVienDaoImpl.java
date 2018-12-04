package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.VaiTroThanhVien;

public class VaiTroThanhVienDaoImpl implements VaiTroThanhVienDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<VaiTroThanhVien> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from VaiTroThanhVien where isDelete = 1", VaiTroThanhVien.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VaiTroThanhVien> listRoles(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<VaiTroThanhVien> list = (List<VaiTroThanhVien>) session.createQuery("FROM VaiTroThanhVien where isDelete = 1").setFirstResult(start).setMaxResults(maxRows).list();

		return list;
	}

	@Override
	public int countVaiTroThanhVien() {
		Session session = sessionFactory.getCurrentSession();
		List<VaiTroThanhVien> dm = session.createQuery("from VaiTroThanhVien where isDelete = 1", VaiTroThanhVien.class)
				.list();
		return dm.size();
	}

	@Override
	public int checkNameVaiTroThanhVien(String tenVaiTro) {
		Session session = sessionFactory.getCurrentSession();
		List<VaiTroThanhVien> dm = session.createQuery("from VaiTroThanhVien where tenVaiTro = '" + tenVaiTro + "' and isDelete = 1",VaiTroThanhVien.class).list();

		return dm.size();
	}

	@Override
	public VaiTroThanhVien findById(int maVaiTro) {
		Session session = sessionFactory.getCurrentSession();
		VaiTroThanhVien dm = session.get(VaiTroThanhVien.class, maVaiTro);
		return dm;
	}

	@Override
	public void addNew(VaiTroThanhVien vaiTroThanhVien) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("Name roles là:" + vaiTroThanhVien.getTenVaiTro());
		session.persist(vaiTroThanhVien);

	}

	@Override
	public void update(VaiTroThanhVien vaiTroThanhVien) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(vaiTroThanhVien);
	}

	@Override
	public void delete(VaiTroThanhVien vaiTroThanhVien) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(vaiTroThanhVien);

	}
}
