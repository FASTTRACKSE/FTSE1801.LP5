package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

@Repository
public class QuanTriDanhGiaDAOImpl implements QuanTriDanhGiaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanVien> getListNhanVienPhongBan(PhongBan phongBan) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		if (session.createQuery("FROM HoSoNhanVien WHERE phongBan = :PhongBan AND chucDanh.maChucDanh = 'NV'")
				.setParameter("PhongBan", phongBan).list().size() > 0) {
			return session.createQuery("FROM HoSoNhanVien WHERE phongBan = :PhongBan AND chucDanh.maChucDanh = 'NV'")
					.setParameter("PhongBan", phongBan).list();
		}
		return null;
	}

	@Override
	public DanhGiaBanThan getDanhGiaBanThan(KyDanhGia kyDanhGia, HoSoNhanVien nhanVien) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		if (session.createQuery("FROM DanhGiaBanThan WHERE kyDanhGia = :kyDanhGia AND nhanVien = :nhanVien")
				.setParameter("kyDanhGia", kyDanhGia).setParameter("nhanVien", nhanVien).list().size() > 0) {
			return (DanhGiaBanThan) session
					.createQuery("FROM DanhGiaBanThan WHERE kyDanhGia = :kyDanhGia AND nhanVien = :nhanVien")
					.setParameter("kyDanhGia", kyDanhGia).setParameter("nhanVien", nhanVien).getSingleResult();
		}
		return null;
	}

	@Override
	public void addDanhGiaBanthan(DanhGiaBanThan danhGiaBanThan) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.persist(danhGiaBanThan);
	}

	@Override
	public void updateDanhGiaBanThan(DanhGiaBanThan danhGiaBanThan) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(danhGiaBanThan);
	}

	@Override
	public void addDanhGianNhanVien(DanhGiaNhanVien danhGiaNhanVien) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.persist(danhGiaNhanVien);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhGiaNhanVien> getDanhGiaNhanVien(KyDanhGia kyDanhGia, HoSoNhanVien nhanVien) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		if (session.createQuery("FROM DanhGiaNhanVien WHERE kyDanhGia = :kyDanhGia AND nhanVienDanhGia = :nhanVien")
				.setParameter("kyDanhGia", kyDanhGia).setParameter("nhanVien", nhanVien.getMaNhanVien()).getResultList()
				.size() > 0) {
			return session
					.createQuery("FROM DanhGiaNhanVien WHERE kyDanhGia = :kyDanhGia AND nhanVienDanhGia = :nhanVien")
					.setParameter("kyDanhGia", kyDanhGia).setParameter("nhanVien", nhanVien.getMaNhanVien())
					.getResultList();
		}
		return null;
	}

	@Override
	public void updateDanhGiaNhanVien(DanhGiaNhanVien danhGiaNhanVien) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(danhGiaNhanVien);
	}

	@Override
	public void deleteDanhGiaNhanVien(DanhGiaNhanVien danhGiaNhanVien) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(danhGiaNhanVien);
	}

	@Override
	public TruongPhongDanhGia getTruongPhongDanhGia(KyDanhGia kyDanhGia, HoSoNhanVien nhanVien) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		if (session.createQuery("FROM TruongPhongDanhGia WHERE kyDanhGia = :kyDanhGia AND nhanVien = :nhanVien")
				.setParameter("kyDanhGia", kyDanhGia).setParameter("nhanVien", nhanVien).list().size() > 0) {
			return (TruongPhongDanhGia) session
					.createQuery("FROM TruongPhongDanhGia WHERE kyDanhGia = :kyDanhGia AND nhanVien = :nhanVien")
					.setParameter("kyDanhGia", kyDanhGia).setParameter("nhanVien", nhanVien).getSingleResult();
		}
		return null;
	}

	@Override
	public int getListKyDanhGia() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM KyDanhGia ").getResultList().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KyDanhGia> getListKyDanhGia(int start, int maxItems) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		if (session.createQuery("FROM KyDanhGia ").setFirstResult(start).setMaxResults(maxItems).getResultList()
				.size() > 0) {
			return session.createQuery("FROM KyDanhGia ").setFirstResult(start).setMaxResults(maxItems).getResultList();
		}
		return null;
	}

	@Override
	public KyDanhGia getKyDanhGia(String id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(KyDanhGia.class, id);
	}

	@Override
	public void addKyDanhGia(KyDanhGia kyDanhGia) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.persist(kyDanhGia);
	}

	@Override
	public void updateKyDanhGia(KyDanhGia kyDanhGia) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(kyDanhGia);
	}

	@Override
	public void deleteKyDanhGia(KyDanhGia kyDanhGia) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(kyDanhGia);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhGiaBanThan> getListDanhGiaBanThanToanCongTy(int start, int maxItems, KyDanhGia kyDanhGia) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		if (session.createQuery("FROM DanhGiaBanThan WHERE kyDanhGia = :kyDanhGia").setParameter("kyDanhGia", kyDanhGia)
				.getResultList().size() > 0) {
			return session.createQuery("FROM DanhGiaBanThan WHERE kyDanhGia = :kyDanhGia")
					.setParameter("kyDanhGia", kyDanhGia).getResultList();
		}
		return null;
	}

	@Override
	public int getListTruongPhongDanhGia(KyDanhGia kyDanhGia, PhongBan phongBan) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM TruongPhongDanhGia WHERE kyDanhGia = :kyDanhGia AND phongBan = :phongBan")
				.setParameter("kyDanhGia", kyDanhGia).setParameter("phongBan", phongBan).getResultList().size();
	}

	@Override
	public TruongPhongDanhGia getTruongPhongDanhGia(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(TruongPhongDanhGia.class, id);
	}

	@Override
	public void addDanhGiaNhanVien(TruongPhongDanhGia truongPhongDanhGia) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.persist(truongPhongDanhGia);
	}

	@Override
	public void updateDanhGiaNhanVien(TruongPhongDanhGia truongPhongDanhGia) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(truongPhongDanhGia);
	}

	@Override
	public void deleteDanhGiaNhanVien(TruongPhongDanhGia truongPhongDanhGia) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(truongPhongDanhGia);
	}

	@Override
	public int getListDanhGiaBanThanPhongBan(KyDanhGia kyDanhGia, PhongBan phongBan) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM DanhGiaBanThan WHERE kyDanhGia = :kyDanhGia AND phongBan = :phongBan")
				.setParameter("kyDanhGia", kyDanhGia).setParameter("phongBan", phongBan).getResultList().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanVien> getNhanVienLimit(int nhanVien, PhongBan phongBan) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM HoSoNhanVien WHERE phongBan = :phongBan AND chucDanh.maChucDanh = 'NV'")
				.setParameter("phongBan", phongBan).setFirstResult(nhanVien).setMaxResults(5).getResultList();
	}

	@Override
	public DanhGiaNhanVien getDanhGiaNhanVien(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(DanhGiaNhanVien.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhGiaNhanVien> getNhanVienDanhGia(KyDanhGia kyDanhGia, HoSoNhanVien nhanVien) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		if (session.createQuery("FROM DanhGiaNhanVien WHERE kyDanhGia = :kyDanhGia AND nhanVien = :nhanVien")
				.setParameter("kyDanhGia", kyDanhGia).setParameter("nhanVien", nhanVien).getResultList().size() > 0) {
			return session.createQuery("FROM DanhGiaNhanVien WHERE kyDanhGia = :kyDanhGia AND nhanVien = :nhanVien")
					.setParameter("kyDanhGia", kyDanhGia).setParameter("nhanVien", nhanVien).getResultList();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PhongBan> getListPhongBan() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM PhongBan").getResultList();
	}

	@Override
	public int checkKyDanhGia(KyDanhGia kyDanhGia) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM KyDanhGia WHERE kyDanhGia = :kyDanhGia").setParameter("kyDanhGia", kyDanhGia)
				.getResultList().size();
	}

	@Override
	public int checkActiveKyDanhGia() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM KyDanhGia WHERE isActive = 1").getResultList().size();
	}

	@Override
	public KyDanhGia getKyDanhGiaActive() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		if (session.createQuery("FROM KyDanhGia WHERE isActive = 1").list().size() > 0) {
			return (KyDanhGia) session.createQuery("FROM KyDanhGia WHERE isActive = 1").getSingleResult();
		}
		return null;
	}

	@Override
	public int getListDanhGiaBanThanToanCongTy(KyDanhGia kyDanhGia) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM DanhGiaBanThan WHERE kyDanhGia = :kyDanhGia")
				.setParameter("kyDanhGia", kyDanhGia).getResultList().size();
	}

	@Override
	public void createPhanCongDanhGia(List<DanhGiaNhanVien> danhGiaNhanVien) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		for (DanhGiaNhanVien x : danhGiaNhanVien) {
			session.persist(x);
		}
	}

	@Override
	public int checkPhanCongDanhGiaExist(KyDanhGia kyDanhGia, PhongBan phongBan) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM DanhGiaNhanVien WHERE kyDanhGia = :kyDanhGia AND phongBan = :phongBan")
				.setParameter("kyDanhGia", kyDanhGia).setParameter("phongBan", phongBan).getResultList().size();
	}

	@Override
	public PhongBan getPhongBanBy(String phongban) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		if (session.createQuery("FROM PhongBan WHERE maPhongBan = :maPhongBan").setParameter("maPhongBan", phongban)
				.list().size() > 0) {
			return (PhongBan) session.createQuery("FROM PhongBan WHERE maPhongBan = :maPhongBan")
					.setParameter("maPhongBan", phongban).getSingleResult();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TruongPhongDanhGia> getListTruongPhongDanhGia(int start, int maxItems, KyDanhGia kyDanhGia,
			PhongBan phongBan) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		if (session.createQuery("FROM TruongPhongDanhGia WHERE phongBan = :phongBan AND kyDanhGia = :kyDanhGia")
				.setParameter("phongBan", phongBan).setParameter("kyDanhGia", kyDanhGia).setFirstResult(start)
				.setMaxResults(maxItems).getResultList().size() > 0) {
			return session.createQuery("FROM TruongPhongDanhGia WHERE phongBan = :phongBan AND kyDanhGia = :kyDanhGia")
					.setParameter("phongBan", phongBan).setParameter("kyDanhGia", kyDanhGia).setFirstResult(start)
					.setMaxResults(maxItems).getResultList();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhGiaBanThan> getListDanhGiaBanThanPhongBan(int start, int maxItems, KyDanhGia kyDanhGia,
			PhongBan phongBan) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		if (session.createQuery("FROM DanhGiaBanThan WHERE phongBan = :phongBan AND kyDanhGia = :kyDanhGia")
				.setParameter("phongBan", phongBan).setParameter("kyDanhGia", kyDanhGia).setFirstResult(start)
				.setMaxResults(maxItems).getResultList().size() > 0) {
			return session.createQuery("FROM DanhGiaBanThan WHERE phongBan = :phongBan AND kyDanhGia = :kyDanhGia")
					.setParameter("phongBan", phongBan).setParameter("kyDanhGia", kyDanhGia).setFirstResult(start)
					.setMaxResults(maxItems).getResultList();
		}
		return null;
	}

	@Override
	public DanhGiaBanThan getDanhGiaBanThan(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(DanhGiaBanThan.class, id);
	}

	@Override
	public void createTruongPhongDanhGia(List<TruongPhongDanhGia> truongPhongDanhGia) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		for (TruongPhongDanhGia x : truongPhongDanhGia) {
			session.persist(x);
		}
	}

}
