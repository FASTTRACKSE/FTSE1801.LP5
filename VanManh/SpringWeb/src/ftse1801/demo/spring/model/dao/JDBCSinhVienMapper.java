package ftse1801.demo.spring.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ftse1801.demo.spring.bean.SinhVien;

public class JDBCSinhVienMapper implements RowMapper<SinhVien>{

	@Override
	public SinhVien mapRow(ResultSet rs, int arg1) throws SQLException {
		SinhVien sinhVien = new SinhVien();
		sinhVien.setMaSV(rs.getInt("MaSV"));
		sinhVien.setName(rs.getString("HoVaTen"));
		sinhVien.setAge(rs.getString("Tuoi"));
		sinhVien.setImg(rs.getString("img"));
		return sinhVien;
	}

}
