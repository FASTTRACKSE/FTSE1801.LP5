package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import myJSF.SinhVien;

@ManagedBean(name = "sinhVienDAO")
public class SinhVienDAO {
	private Connection conn;

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
	
	public SinhVien getSinhVienByMaSv(String maSv) {
		String sql = "SELECT * FROM `sinh_vien` WHERE `MASV`=?";
		conn = DatabaseUltil.getConnection();
		
		SinhVien sinhVien = new SinhVien();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, maSv);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMaSv(resultSet.getString("MASV"));
				sinhVien.setName(resultSet.getString("TEN"));
				sinhVien.setAge(resultSet.getInt("Age"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUltil.disConnection(conn);
		}
		return sinhVien;
	}
	
	public boolean addSinhVien(String  maSv, String name, int age) {
		boolean statusExucute = false;
		conn = DatabaseUltil.getConnection();
		
		String sql = "INSERT INTO sinh_vien VALUE (?,?,?)";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, maSv);
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
	
	public boolean updateSinhVienByMaSV(String name, int age, String maSv) {
		boolean statusExucute = false;
		conn = DatabaseUltil.getConnection();
		
		String sql = "UPDATE sinh_vien SET TEN=?, Age=? WHERE MASV=?";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, age);
			preparedStatement.setString(3, maSv);

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
	
	public boolean deleteSinhVienByMaSV(String  maSv) {
		boolean statusExucute = false;
		conn = DatabaseUltil.getConnection();
		
		String sql = "DELETE FROM sinh_vien WHERE MASV = ?";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, maSv);

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
	
	public ArrayList<SinhVien> getAllSinhVien1(int trang, int soDong) {
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
	
}
