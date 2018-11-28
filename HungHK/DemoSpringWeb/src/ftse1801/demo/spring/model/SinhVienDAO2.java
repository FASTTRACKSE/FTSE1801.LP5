package ftse1801.demo.spring.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ftse1801.demo.spring.model.entity.SinhVien;

public class SinhVienDAO2 {
	Connection conn;

	public ArrayList<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM `sinhvien2`";
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
		
		String sql = "DELETE FROM sinhvien2 WHERE MASV = ?";

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
	
	public boolean updateSinhVienByMaSV(String name, int age, String  maSv) {
		boolean statusExucute = false;
		conn = DatabaseUltil.getConnection();
		
		String sql = "UPDATE sinhvien2 SET TEN=?, Age=? WHERE MASV=?";

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
	
	public boolean addSinhVienByMaSV(String  maSv, String name, int age) {
		boolean statusExucute = false;
		conn = DatabaseUltil.getConnection();
		
		String sql = "INSERT INTO sinhvien2 VALUE (?,?,?)";

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
	
	public SinhVien getSinhVienByMasv(String maSv) {
		SinhVien sinhVien = null;
		String sql = "SELECT * FROM sinhvien2 WHERE MASV=?";
		conn = DatabaseUltil.getConnection();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, maSv);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMaSv(resultSet.getString("sinhvien2.MASV"));
				sinhVien.setName(resultSet.getString("sinhvien2.TEN"));
				sinhVien.setAge(resultSet.getInt("sinhvien2.Age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUltil.disConnection(conn);
		return sinhVien;
	}
	
	public ArrayList<SinhVien> getAllSinhVien1(int trang, int soDong) {
		String sql = "SELECT * FROM `sinhvien2` LIMIT ?, ?";
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
		String sql = "SELECT COUNT(*) FROM sinhvien2";
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
	
}
