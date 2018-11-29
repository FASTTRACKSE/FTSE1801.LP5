package ftse1801.demo.spring.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ftse1801.demo.spring.model.entity.SinhVien;

public class ISinhVienDAO implements SinhVienDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<SinhVien> getAllSinhVien(int trang, int soDong) {
		String sql = "SELECT * FROM `sinhvien2` LIMIT " + trang + "," + soDong;
		List<SinhVien> listSv = jdbcTemplate.query(sql, new RowMapper<SinhVien>() {

			@Override
			public SinhVien mapRow(ResultSet resultSet, int row) throws SQLException {
				SinhVien sinhVien = new SinhVien();
				
				sinhVien.setMaSv(resultSet.getString("MASV"));
				sinhVien.setName(resultSet.getString("TEN"));
				sinhVien.setAge(resultSet.getInt("Age"));
				
				return sinhVien;
			}
		});
		return listSv;
	}
	
	@Override
	public List<SinhVien> getAllSinhVien1() {
		String sql = "SELECT * FROM `sinhvien2`";
		List<SinhVien> listSv = jdbcTemplate.query(sql, new RowMapper<SinhVien>() {

			@Override
			public SinhVien mapRow(ResultSet resultSet, int row) throws SQLException {
				SinhVien sinhVien = new SinhVien();
				
				sinhVien.setMaSv(resultSet.getString("MASV"));
				sinhVien.setName(resultSet.getString("TEN"));
				sinhVien.setAge(resultSet.getInt("Age"));
				
				return sinhVien;
			}
		});
		return listSv;
	}
	
	@Override
	public int getCount(int soDong) {
		soDong = getAllSinhVien1().size();
		return soDong;
	}

	@Override
	public void addSinhVien(SinhVien sinhVien) {
		String sql = "INSERT INTO sinhvien2 VALUE (?,?,?)";
		jdbcTemplate.update(sql, sinhVien.getMaSv(), sinhVien.getName(), sinhVien.getAge());
		
	}

	@Override
	public void updateSinhVienByMasv(SinhVien sinhVien) {
		String sql = "UPDATE sinhvien2 SET TEN=?, Age=? WHERE MASV=?";
		jdbcTemplate.update(sql, sinhVien.getName(), sinhVien.getAge(), sinhVien.getMaSv());
	}

	@Override
	public void deleteSinhVienByMasv(String maSv) {
		String sql = "DELETE FROM sinhvien2 WHERE MASV = ?";
		jdbcTemplate.update(sql, maSv);
	}

	@Override
	public SinhVien getSinhVienByMasv(String maSv) {
		String sql = "SELECT * FROM sinhvien2 WHERE MASV=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{maSv}, new BeanPropertyRowMapper<SinhVien>(SinhVien.class));
	}

	


}
