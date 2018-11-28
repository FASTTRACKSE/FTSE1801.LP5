package ftse1801.demo.spring.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import ftse1801.demo.spring.bean.MonHoc;
import ftse1801.demo.spring.bean.SinhVien;

public class JDBCSinhVienDAO implements ISinhVienDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<SinhVien> getSinhVienRecord(int start, int recordPage) {
		String sql = "SELECT * FROM `danh_sach` LEFT JOIN diem ON danh_sach.MaSV = diem.MaSV LIMIT ?,?";
		return jdbcTemplate.query(sql, new JDBCSinhVienMapper(),start,recordPage);
	}

	@Override
	public List<SinhVien> showAllSinhVien() {
		String sql = "SELECT * FROM `danh_sach`";
		return jdbcTemplate.query(sql, new JDBCSinhVienMapper());
	}

	@Override
	public SinhVien showSinhVienInMaSV(int maSV) {
		String sql = "SELECT * FROM `danh_sach` WHERE MaSV=?";
		return jdbcTemplate.queryForObject(sql, new JDBCSinhVienMapper(),maSV);
	}

	@Override
	public boolean addSV(String name, String age, String img) {
		String sql = "INSERT INTO danh_sach(HoVaTen,Tuoi,img) VALUES(?,?,?)";
		boolean check=false;
		if (jdbcTemplate.update(sql, name,age,img)>0) {
			check=true;
		}
		return check;
	}

	@Override
	public boolean addDiem(int maSV, MonHoc monHoc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upDateSV(int maSV, String name, String age, String img) {
		String sql = "UPDATE danh_sach SET HoVaTen=?, Tuoi=? WHERE MaSV=?";
		boolean check=false;
		if (jdbcTemplate.update(sql,name,age,maSV)>0) {
			check=true;
		}
		return check;
	}

	@Override
	public boolean upDateDiem(int maSV, MonHoc monHoc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDiem(int maSV) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSV(int maSV) {
		String sql = "DELETE FROM danh_sach WHERE MaSV=?";
		boolean check=false;
		if (jdbcTemplate.update(sql,maSV)>0) {
			check=true;
		}
		return check;
	}

	@Override
	public boolean kiemTraDelete(int maSV) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMaSV() {
		String sql = "SELECT * FROM `danh_sach` ORDER BY `danh_sach`.`MaSV` DESC LIMIT 1";
		return (jdbcTemplate.queryForObject(sql, new JDBCSinhVienMapper()).getMaSV()+1);
	}

}
