package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.entity.SinhVien;

public class SinhVienDAO {
	Connection conn;

	public ArrayList<SinhVien> getAllSinhVien(int trang, int soDong) {
		String sql = "SELECT * FROM `sinh_vien` LIMIT ?, ?";
		conn = DatabaseUltil.getConnection();
		ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, trang );
			statement.setInt(2, soDong);
			ResultSet resultSet = statement.executeQuery();

			SinhVien sinhVien = null;
			while (resultSet.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMaSv(resultSet.getString("MASV"));
				sinhVien.setName(resultSet.getString("TEN"));
				sinhVien.setAge(resultSet.getInt("Age"));

				listSinhVien.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUltil.disConnection(conn);
		}
		return listSinhVien;
	}
	
	public int getCount(int soDong) {
		String sql = "SELECT COUNT(*) FROM sinh_vien";
		conn = DatabaseUltil.getConnection();
		int count = 0;
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				count = result.getInt("COUNT(*)");
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DatabaseUltil.disConnection(conn);
		}
		if (count % soDong == 0) {
			return count/soDong;
		} else {
			return count/soDong+1;
		}
	}
	
	public boolean deleteSinhVienByMaSV(String  id) {
		boolean statusExucute = false;
		conn = DatabaseUltil.getConnection();
		
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
	
	public boolean updateSinhVienByMaSV(String name, int age, String  id) {
		boolean statusExucute = false;
		conn = DatabaseUltil.getConnection();
		
		String sql = "UPDATE sinh_vien SET TEN=?, Age=? WHERE MASV=?";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, age);
			preparedStatement.setString(3, id);

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
	
	public boolean addSinhVienByMaSV(String  id, String name, int age) {
		boolean statusExucute = false;
		conn = DatabaseUltil.getConnection();
		
		String sql = "INSERT INTO sinh_vien VALUE (?,?,?)";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, age);

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
		double b = Double.parseDouble(""+count)/Double.parseDouble(""+soDong);
		double a = Math.ceil(b);
		return (int) a;
	}
	
	
	public Map<String, String> englishLanguage() {
		Map<String, String> map = new HashMap<>();
		map.put("chonNn", "Select Language");
		map.put("tiengviet", "Vietnamese");
		map.put("tienganh", "English");
		map.put("masv", "Id");
		map.put("ten", "Name");
		map.put("tuoi", "Age");
		map.put("them", "Add");
		map.put("chucnang", "Function");
		map.put("sua", "Update");
		map.put("xoa", "Delete");
		return map;
	}
	
	public Map<String, String> vietnameseLanguage() {
		Map<String, String> map = new HashMap<>();
		map.put("chonNn", "Chọn ngôn ngữ");
		map.put("tiengviet", "Tiếng Việt");
		map.put("tienganh", "Tiếng Anh");
		map.put("masv", "Mã sinh viên");
		map.put("ten", "Tên");
		map.put("tuoi", "Tuổi");
		map.put("them", "Thêm");
		map.put("chucnang", "Chức năng");
		map.put("sua", "Sửa");
		map.put("xoa", "Xóa");
		return map;
	}
}
