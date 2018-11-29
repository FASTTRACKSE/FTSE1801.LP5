package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entity.SinhVien;

public class SinhVienDAO {
	Connection conn;

	public ArrayList<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM `sinh_vien`";
		conn = DatabaseUltil.getConnection();
		ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
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
	
}
