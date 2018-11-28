package ftse1801.demo.spring.model.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ftse1801.demo.spring.model.entity.SinhVien;
@Repository
public class HibernateSinhVienDao implements SinhVienDAOIML{

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addSinhVien(String maSV, String tenSV, String pass, String tuoi, String image) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addDiemSV(String maSV, String monHoc, int diem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSV(String maSV, String ten, String pass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDiemSV(SinhVien sinhVien) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSV(String maSinhVien) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean UpdateDiemSV(String maSV, String MH, int diem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<SinhVien> getAllSinhVien(int trang, int soDong) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<SinhVien> getAllSinhVien1() {

		Session session =this.sessionFactory.openSession();
		String queryStr = "from SinhVien";
		Query query = session.createQuery(queryStr);
		
		ArrayList<SinhVien> list = (ArrayList<SinhVien>) query.list();
		
		return list;
	}

	@Override
	public ArrayList<SinhVien> getSinhVienTheoTen(SinhVien sinhVien) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SinhVien SinhVienByMa(String maSV) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount(int soDong) {
		// TODO Auto-generated method stub
		return 0;
	}

}
