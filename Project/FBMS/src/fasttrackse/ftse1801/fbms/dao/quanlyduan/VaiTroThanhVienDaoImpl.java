package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.VaiTroThanhVien;

@Repository
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
	public List<VaiTroThanhVien> listVaiTro(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<VaiTroThanhVien> listVaiTro = (List<VaiTroThanhVien>) session.createQuery("FROM VaiTroThanhVien where isDelete = 1").setFirstResult(start).setMaxResults(maxRows).list();

		return listVaiTro;
	}

	@Override
	public int countVaiTro() {
		Session session = sessionFactory.getCurrentSession();
		List<VaiTroThanhVien> listVaiTro = session.createQuery("from VaiTroThanhVien where isDelete = 1", VaiTroThanhVien.class)
				.list();
		return listVaiTro.size();
	}

	@Override
	public int checkTenVaiTro(String tenVaiTro) {
		Session session = sessionFactory.getCurrentSession();
		List<VaiTroThanhVien> listVaiTro = session.createQuery("from VaiTroThanhVien where tenVaiTro = '" + tenVaiTro + "' and isDelete = 1",VaiTroThanhVien.class).list();

		return listVaiTro.size();
	}

	@Override
	public VaiTroThanhVien findById(String maVaiTro) {
		Session session = sessionFactory.getCurrentSession();
		VaiTroThanhVien vaiTroThanhVien = session.get(VaiTroThanhVien.class, maVaiTro);
		return vaiTroThanhVien;
	}

	@Override
	public void add(VaiTroThanhVien vaiTroThanhVien) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("Tên vai trò là:" + vaiTroThanhVien.getTenVaiTro());
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
