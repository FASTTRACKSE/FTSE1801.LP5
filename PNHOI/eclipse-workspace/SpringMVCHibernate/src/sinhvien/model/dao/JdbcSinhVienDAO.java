package sinhvien.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sinhvien.model.entity.SinhVien;

public class JdbcSinhVienDAO implements ISinhVienDAO{
	JdbcTemplate template;  
	@Override
	public ArrayList<SinhVien> getAllSinhVien() {
		
		return null;
	}

	@Override
	public boolean deleteSinhVien(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addNewSinhVien(SinhVien sinhvien) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSinhVien(SinhVien sinhvien, String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SinhVien getSinhVien(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SinhVien> getAll(int trang, int soDong) {
		String sql = "SELECT * FROM sinhvien LIMIT " + trang + "," + soDong;
		return (ArrayList<SinhVien>)template.query(sql, new RowMapper<SinhVien>() {

			@Override
			public SinhVien mapRow(ResultSet resultSet, int row) throws SQLException {
				SinhVien sinhVien = new SinhVien();
				sinhVien.setId(resultSet.getString("id"));
				sinhVien.setName(resultSet.getString("name"));
				sinhVien.setAge(resultSet.getString("age"));
				sinhVien.setAddress(resultSet.getString("address"));
				return sinhVien;
			}
			
		});
	}

	@Override
	public int getCount(int soDong) {
		// TODO Auto-generated method stub
		return 0;
	}

}
