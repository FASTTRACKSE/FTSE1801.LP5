package fasttrackse.ftse1801.fbms.dao.quanlynhansu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanVien;

public class HoSoNhanVienImpl implements HoSoNhanVienDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanVien> getAll() {
		Session session = this.sessionFactory.openSession();
		List<HoSoNhanVien> list = session.createQuery("from HoSoNhanVien").list();
		session.close();
		return list;
	}

	@Override
	public List<HoSoNhanVien> getByPaging(int fistResult, int maxResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HoSoNhanVien getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HoSoNhanVien> getByPhongBan(String maPhongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNew(HoSoNhanVien nhanVien) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(HoSoNhanVien nhanVien) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
