package fasttrackse.ftse1801.fbms.dao.quantritailieu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ftse1801.fbms.entity.quantritailieu.DanhMucTaiLieu;
import fasttrackse.ftse1801.fbms.entity.quantritailieu.IconTaiLieu;
import fasttrackse.ftse1801.fbms.entity.quantritailieu.TaiLieu;
import fasttrackse.ftse1801.fbms.entity.quantritailieu.TrangThaiTaiLieu;
import fasttrackse.ftse1801.fbms.entity.security.PhongBan;
import fasttrackse.ftse1801.fbms.service.quantritailieu.DanhMucService;
import fasttrackse.ftse1801.fbms.service.quantritailieu.IConService;
import fasttrackse.ftse1801.fbms.service.quantritailieu.TrangThaiService;
import fasttrackse.ftse1801.fbms.service.security.PhongBanService;

@Repository
public class TaiLieuDaoIMPL implements TaiLieuDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
    private TrangThaiService trangThaiService;
	@Autowired
    private IConService iConService;
	@Autowired
    private PhongBanService phongBanService;
	@Autowired
    private DanhMucService danhMucService;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	Session session;

	@SuppressWarnings("unchecked")
	@Override
	public List<TaiLieu> getAllTaiLieuDel0() {
		session = this.sessionFactory.openSession();
		List<TaiLieu> listTL = session.createQuery("from TaiLieu where isDelete = 0").list();
		session.close();
		return listTL;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaiLieu> getAllTaiLieuDel1() {
		session = this.sessionFactory.openSession();
		List<TaiLieu> listTL = session.createQuery("from TaiLieu where isDelete = 1").list();
		return listTL;
	}

	@Override
	public void insertTaiLieu(TaiLieu tl) {
		session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(tl);
		tx.commit();
		session.close();

	}

	@Override
	public void updateTaiLieu(TaiLieu tl) {
		session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(tl);
		tx.commit();
		session.close();

	}

	@Override
	public void deleteTaiLieu(int maTL) {
		session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(TaiLieu.class, maTL));
		tx.commit();
		session.close();

	}

	@Override
	public TaiLieu getTaiLieuByMa(int maTL) {
		session = this.sessionFactory.openSession();
		TaiLieu taiLieu = session.get(TaiLieu.class, maTL);
		session.close();
		return taiLieu;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaiLieu> getAllTaiLieuDel0(int page, int record) {
		session = this.sessionFactory.openSession();
		List<TaiLieu> listTL = session.createQuery("from TaiLieu where isDelete = 0").setFirstResult(page)
				.setMaxResults(record).list();
		session.close();
		return listTL;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaiLieu> getAllTaiLieuDel1(int page, int record) {
		session = this.sessionFactory.openSession();
		List<TaiLieu> listTL = session.createQuery("from TaiLieu where isDelete = 1").setFirstResult(page)
				.setMaxResults(record).list();
		session.close();
		return listTL;
	}

	@Override
	public List<DanhMucTaiLieu> listDanhMuc() {
		List<DanhMucTaiLieu> listDM = danhMucService.getAllDanhMuc();
		return listDM;
	}

	@Override
	public List<PhongBan> listPhongBan() {
		List<PhongBan> listPB = phongBanService.findAll();
		return listPB;
	}

	@Override
	public List<IconTaiLieu> listIcon() {
		List<IconTaiLieu> listIC = iConService.getAllIcon(); 
		return listIC;
	}

	@Override
	public List<TrangThaiTaiLieu> listTrangThai() {
		List<TrangThaiTaiLieu>listTT = trangThaiService.getAllTrangThaiDel0();
		return listTT;
	}
	

}
