package ftse1801.demo.spring.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ftse1801.demo.spring.model.IQLSinhVienDAO;
import ftse1801.demo.spring.model.entity.SinhVien;

public class SinhVienDaoNew implements IQLSinhVienDAO {

	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public ArrayList<SinhVien> displayAllSinhVien(int size, int page) {

		return (ArrayList<SinhVien>) template.query(
				"SELECT * FROM sinh_vien ORDER BY sinh_vien.MASV ASC LIMIT " + size + "," + page,
				new RowMapper<SinhVien>() {
					public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
						SinhVien e = new SinhVien();
						e.setImage(rs.getString("image"));
						e.setMASV(rs.getString("MASV"));
						e.setNAME(rs.getString("TEN"));
						e.setAGE(rs.getInt("Age"));
						return e;
					}
				});
	}

	@Override
	public boolean deleteSinhVienByMaSV(String id) {
		boolean statusExucute = false;
		String sql = "DELETE FROM sinh_vien WHERE MASV = ?";
		int count = template.update(sql, id);
		if (count > 0) {
			statusExucute = true;
		}
		return statusExucute;
	}

	@Override
	public boolean addSinhVien(String image ,String id, String name, int age) {
		boolean statusExucute = false;
		String sql = "INSERT INTO sinh_vien VALUES(?,?,?,?,?)";
		int count = template.update(sql, image, id, name, "", age);
		if (count > 0) {
			statusExucute = true;
		}
		return statusExucute;
	}

	@Override
	public boolean updateSinhVienByMaSV(String name, int age, String id) {
		boolean statusExucute = false;
		String sql = "UPDATE `sinh_vien` SET `TEN`=?,`PASS`=?,`Age`=? WHERE  `MASV`= ?";
		int count = template.update(sql, name, "", age, id);
		if (count > 0) {
			statusExucute = true;
		}
		return statusExucute;
	}

	@Override
	public int soTrang(int soDong) {
		return 0;
	}

	@Override
	public SinhVien displaySinhVientheoMa(String id) {
		String sql = "SELECT `MASV`, `TEN`, `Age` FROM `sinh_vien` WHERE `MASV` =?";
		return (SinhVien) template.queryForObject(sql, new Object[] { id }, new RowMapper<SinhVien>() {

			@Override
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien e = new SinhVien();
				e.setMASV(rs.getString("MASV"));
				e.setNAME(rs.getString("TEN"));
				e.setAGE(rs.getInt("Age"));
				return e;
			}
		});
	}

	@Override
	public boolean login(String name, String pass) {
		return false;
	}

	@Override
	public SinhVien displaySV(String name) {
		return null;
	}

	@Override
	public ArrayList<SinhVien> displayAllSinhVien() {
		return (ArrayList<SinhVien>) template.query("SELECT * FROM sinh_vien", new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien e = new SinhVien();
				e.setMASV(rs.getString("MASV"));
				e.setNAME(rs.getString("TEN"));
				e.setAGE(rs.getInt("Age"));
				return e;
			}
		});
	}

}
