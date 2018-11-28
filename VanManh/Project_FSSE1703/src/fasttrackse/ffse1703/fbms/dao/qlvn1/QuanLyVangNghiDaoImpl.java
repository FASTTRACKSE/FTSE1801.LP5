
package fasttrackse.ffse1703.fbms.dao.qlvn1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.qlvn1.DonNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn1.LyDo;
import fasttrackse.ffse1703.fbms.entity.qlvn1.TinhTrangNghi;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;

@Repository
public class QuanLyVangNghiDaoImpl implements QuanLyVangNghiDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addDon(DonNghi dn) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println(dn);
		session.save(dn);
	}


	@Override
	public UserAccount getThongTinUser(String username) {
		Session session = this.sessionFactory.openSession();
		UserAccount user = session.createQuery("from UserAccount where username='" + username + "'", UserAccount.class)
				.getSingleResult();
		session.close();
		return user;
	}

	@Override
	public TinhTrangNghi getTinhTrang(int id_nv) {
		TinhTrangNghi tinhTrang = null;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			tinhTrang = session.createQuery("from TinhTrangNghi where id_nv=" + id_nv + "", TinhTrangNghi.class).getSingleResult();
		}catch (Exception e) {
			tinhTrang= null;
		}
		
		session.close();
		return tinhTrang;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LyDo> listLyDo() {
		Session session = this.sessionFactory.openSession();
		List<LyDo> list = session.createQuery("from LyDo").list();
		session.close();
		return list;
	}

	@Override
	public List<DonNghi> listDonNghiNhap(int id_nv) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where id_nv ='"+id_nv+"' and tinh_trang = "+0+" ").list();
		session.close();
		return listDn;
	}

	@Override
	public void insertTinhTrang(int id_nv, TinhTrangNghi tt) {
		TinhTrangNghi tinhTrang = new TinhTrangNghi();
		Session session = null;
		tinhTrang = getTinhTrang(id_nv);
		session = this.sessionFactory.getCurrentSession();
		if(tinhTrang==null) {
			session.persist(tt);
		}else {
			session.update(tt);
		}
	}
	
	public void updateTinhTrang(TinhTrangNghi tt) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(tt);
	}


	@Override
	public List<DonNghi> listDonNghiChoDuyet(int id_nv) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where id_nv ='"+id_nv+"' and ( tinh_trang = "+1+" or tinh_trang = "+2+")").list();
		session.close();
		return listDn;
	}

	@Override
	public DonNghi getDonNghiNv(int id_don) {
		Session session = this.sessionFactory.openSession();
		DonNghi donNghi = new DonNghi();
		donNghi = session.createQuery("from DonNghi where id_don=" + id_don + "", DonNghi.class).getSingleResult();
		return donNghi;
	}

	@Override
	public void updateDon(DonNghi dn) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(dn);
	}

	@Override
	public void deleteDon(int id_don) {
		Session session = this.sessionFactory.getCurrentSession();
		DonNghi donNghi = (DonNghi) session.load(DonNghi.class, new Integer(id_don));
		if(null != donNghi){
			session.delete(donNghi);
		}
		
	}

	@Override
	public List<DonNghi> listDonNghiPheDuyet1(String tenPhongBan) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where tinh_trang = "+1+" and phong_ban ='"+tenPhongBan+"' ").list();
		session.close();
		return listDn;
	}

	@Override
	public List<DonNghi> listDonNghiPheDuyet2() {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where tinh_trang = "+2+" ").list();
		session.close();
		return listDn;
	}

	@Override
	public List<DonNghi> listDonNghiBiTuChoi(int id_nv, int start, int end) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where id_nv ='"+id_nv+"' and  tinh_trang = "+4+" ").setFirstResult(start).setMaxResults(end).list();
		session.close();
		return listDn;
	}

	@Override
	public List<DonNghi> listDanhSachPheDuyet(int id_nv,int start,int end) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where id_nv ='"+id_nv+"' and  tinh_trang = "+3+" ").setFirstResult(start).setMaxResults(end).list();
		session.close();
		return listDn;
	}


	@Override
	public Long countListDaDuyet(int id_nv) {
		Session session = this.sessionFactory.getCurrentSession();
		Long count = session.createQuery("select count(*) from  DonNghi where id_nv ='"+id_nv+"' and  tinh_trang = "+3+" " ,Long.class).getSingleResult();
		return count;
	}


	@Override
	public Long countListTuChoi(int id_nv) {
		Session session = this.sessionFactory.getCurrentSession();
		Long count = session.createQuery("select count(*) from  DonNghi where id_nv ='"+id_nv+"' and  tinh_trang = "+4+" " ,Long.class).getSingleResult();
		return count;	}

	@Override
	public List<DonNghi> listdanhsachpheduyetcty() {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where tinh_trang = "+3+" ").list();
		session.close();
		return listDn;
	}

	
	

	
	
	
}
