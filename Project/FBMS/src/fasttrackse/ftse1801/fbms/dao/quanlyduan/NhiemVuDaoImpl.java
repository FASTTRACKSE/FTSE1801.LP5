package fasttrackse.ftse1801.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ftse1801.fbms.entity.quanlyduan.NhiemVu;

public class NhiemVuDaoImpl implements NhiemVuDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(NhiemVu nhiemVu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NhiemVu getByID(String maDuAn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhiemVu getByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NhiemVu> getByDuAn(String maDuAn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NhiemVu> getByDuAn(String maDuAn, String search, int start, int maxRows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(NhiemVu nhiemVu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NhiemVu> getByMaNhanVien(String idNv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countNhiemvu(String maDuAn, String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkVaiTro(String maNv, int idRole, String maDuAn) {
		// TODO Auto-generated method stub
		return 0;
	}

}
