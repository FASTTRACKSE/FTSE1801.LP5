package ftse1801.demo.spring.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ftse1801.demo.spring.model.entity.SinhVien;

public class QLSinhVienDAO implements IQLSinhVienDAO {
	Connection conn;

	@Override
	public ArrayList<SinhVien> displayAllSinhVien(int size, int page) {
		String sql = "SELECT * FROM sinh_vien ORDER BY sinh_vien.MASV ASC LIMIT ?,?";
		conn = DatabaseUltil.getConnection();
		ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, size);
			statement.setInt(2, page);
			ResultSet resultSet = statement.executeQuery();

			SinhVien sinhVien;
			while (resultSet.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMASV(resultSet.getString("MASV"));
				sinhVien.setNAME(resultSet.getString("TEN"));
				sinhVien.setAGE(resultSet.getInt("Age"));

				listSinhVien.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUltil.disConnection(conn);
		}
		return listSinhVien;
	}

	@Override
	public boolean deleteSinhVienByMaSV(String id) {
		boolean statusExucute = false;
		conn = DatabaseUltil.getConnection();
		String sql1 = "DELETE FROM `diem` WHERE MASV = ?";
		try {
			PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
			preparedStatement1.setString(1, id);

			if (preparedStatement1.executeUpdate() > 0) {
				statusExucute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "DELETE FROM sinh_vien WHERE MASV = ?";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, id);

			if (preparedStatement.executeUpdate() > 0) {
				statusExucute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUltil.disConnection(conn);
		}

		return statusExucute;
	}

	@Override
	public boolean addSinhVien(String id, String name, int age) {
		boolean statusExecute = false;
		String sql = "INSERT INTO sinh_vien VALUES(?,?,?,?,?)";
		conn = DatabaseUltil.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "");
			preparedStatement.setString(2, id);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, "");
			preparedStatement.setInt(5, age);

			if (preparedStatement.executeUpdate() > 0) {
				statusExecute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUltil.disConnection(conn);
		}
		return statusExecute;
	}

	@Override
	public boolean updateSinhVienByMaSV(String name, int age, String id) {
		boolean statusExucute = false;
		String sql = "UPDATE `sinh_vien` SET `TEN`=?,`PASS`=?,`Age`=? WHERE  `MASV`= ?";
		conn = DatabaseUltil.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, "");
			preparedStatement.setInt(3, age);
			preparedStatement.setString(4, id);

			if (preparedStatement.executeUpdate() > 0) {
				statusExucute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUltil.disConnection(conn);
		}
		return statusExucute;
	}

	@Override
	public int soTrang(int soDong) {
		String sql = "SELECT COUNT(*) FROM sinh_vien";
		conn = DatabaseUltil.getConnection();
		int count = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				count = resultSet.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUltil.disConnection(conn);
		}
		double b = Double.parseDouble("" + count) / Double.parseDouble("" + soDong);
		double a = Math.ceil(b);
		return (int) a;
	}

	@Override
	public SinhVien displaySinhVientheoMa(String id) {
		String sql = "SELECT `MASV`, `TEN`, `Age` FROM `sinh_vien` WHERE `MASV` =?";
		conn = DatabaseUltil.getConnection();
		SinhVien sinhVien = null;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMASV(resultSet.getString("MASV"));
				sinhVien.setNAME(resultSet.getString("TEN"));
				sinhVien.setAGE(resultSet.getInt("Age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUltil.disConnection(conn);
		}
		return sinhVien;
	}

	// public Map<String,String> englishlanguage(){
	// Map<String,String> map = new HashMap<String,String>();
	// map.put("masv", "Id");
	// map.put("ten", "Name");
	// map.put("tuoi", "Age");
	// map.put("chucnang", "Function");
	// map.put("them", "Add");
	// map.put("sua", "Update");
	// map.put("xoa", "Delete");
	// map.put("ngonngu", "Selection Laguage");
	// map.put("vietnam", "VietNamese");
	// map.put("english", "English");
	// map.put("themthongtin", "Add information");
	// return map;
	// }
	//
	// public Map<String,String> vietnamlaguage(){
	// Map<String,String> map = new HashMap<String,String>();
	// map.put("masv", "Mã sinh viên");
	// map.put("ten", "Tên sinh viên");
	// map.put("tuoi", "Tuổi sinh viên");
	// map.put("chucnang", "Chức năng");
	// map.put("them", "Thêm");
	// map.put("sua", "Sửa");
	// map.put("xoa", "Xóa");
	// map.put("ngonngu", "Chọn ngôn ngữ");
	// map.put("vietnam", "Việt Nam");
	// map.put("english", "Tiếng Anh");
	// map.put("themthongtin", "Thêm thông tin sinh viên");
	// return map;
	// }

	@Override
	public boolean login(String name, String pass) {
		boolean statusExucute = false;
		String sql = "SELECT * FROM `sinh_vien` WHERE TEN = ? AND PASS = ?";
		conn = DatabaseUltil.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, pass);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				statusExucute = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUltil.disConnection(conn);
		}
		return statusExucute;
	}

	@Override
	public SinhVien displaySV(String name) {
		SinhVien sinhVien = new SinhVien();
		String sql = "SELECT * FROM `sinh_vien` WHERE `TEN`=?";
		conn = DatabaseUltil.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				sinhVien.setMASV(resultSet.getString("MASV"));
				sinhVien.setNAME(resultSet.getString("TEN"));
				sinhVien.setAGE(resultSet.getInt("Age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUltil.disConnection(conn);
		}
		return sinhVien;
	}

	@Override
	public ArrayList<SinhVien> displayAllSinhVien() {
		String sql = "SELECT MASV, TEN, Age FROM sinh_vien";
		conn = DatabaseUltil.getConnection();
		ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			SinhVien sinhVien;
			while (resultSet.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMASV(resultSet.getString("MASV"));
				sinhVien.setNAME(resultSet.getString("TEN"));
				sinhVien.setAGE(resultSet.getInt("Age"));

				listSinhVien.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUltil.disConnection(conn);
		}
		return listSinhVien;
	}

}
