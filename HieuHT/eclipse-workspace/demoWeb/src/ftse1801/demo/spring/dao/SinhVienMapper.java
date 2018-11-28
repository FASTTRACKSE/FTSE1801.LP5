package ftse1801.demo.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ftse1801.demo.spring.entity.SinhVien;

public class SinhVienMapper implements RowMapper<SinhVien> {

	@Override
	public SinhVien mapRow(ResultSet rs, int rowNum) throws SQLException {
		SinhVien sinhvien = new SinhVien();
		sinhvien.setId(rs.getInt("id"));
		sinhvien.setTen(rs.getString("ten"));
		sinhvien.setTuoi(rs.getString("tuoi"));
		sinhvien.setDiachi(rs.getString("diachi"));
		sinhvien.setLop(rs.getString("lop"));
		sinhvien.setImg(rs.getString("img"));
		return sinhvien;
	}

}
