package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.database.DatabaseUtil;
import model.entity.SinhVien;

public class SinhVienDao {
	Connection conn;

	/* Hiển thị danh sách */
	public ArrayList<SinhVien> getSinhVien() {
		String sql = "SELECT * FROM quanlysv";
		conn = DatabaseUtil.getConnect();
		ArrayList<SinhVien> listSv = new ArrayList<SinhVien>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			SinhVien sinhvien;

			while (result.next()) {
				sinhvien = new SinhVien();
				sinhvien.setId(result.getString("id"));
				sinhvien.setTen(result.getString("ten"));
				sinhvien.setTuoi(result.getString("tuoi"));
				sinhvien.setDiachi(result.getString("diachi"));
				sinhvien.setLop(result.getString("lop"));
				listSv.add(sinhvien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return listSv;

	}
	/*Xóa sinh viên*/
	
	public boolean DeleteSinhVien(String id) {
		boolean statusExecute = false;

		String sql = "DELETE FROM `quanlysv` WHERE id = ?";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);

			if (statement.executeUpdate() > 0) {
				System.out.println("Xóa thành công.");
				statusExecute = true;
			} else {
				System.out.println("Mã thành viên không tồn tại");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}
	
	/* Sửa thông tin sinh viên*/
	public boolean UpdateSinhVien(SinhVien sinhvien,String id) {
		boolean statusExecute = false;
		String sql = "UPDATE `quanlysv` SET `Ten`=?,`Tuoi`=?,`Diachi`=?,`Lop`=? WHERE `id` =?";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, sinhvien.getTen());
			statement.setString(2, sinhvien.getTuoi());
			statement.setString(3, sinhvien.getDiachi());
			statement.setString(4, sinhvien.getLop());
			statement.setString(5, id);
			if (statement.executeUpdate() > 0) {
				System.out.println("Thay đổi thông tin thành công");
				statusExecute = true;
			} else {
				System.out.println("Mã thành viên không tồn tại");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}
	
	public boolean addSinhVien(SinhVien sinhvien) {
		boolean statusExecute = false;
		String sql = "INSERT INTO `quanlysv`(`id`, `Ten`, `Tuoi`, `Diachi`, `Lop`) VALUES (?,?,?,?,?)";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhvien.getId());
			statement.setString(2, sinhvien.getTen());
			statement.setString(3, sinhvien.getTuoi());
			statement.setString(4, sinhvien.getDiachi());
			statement.setString(5, sinhvien.getLop());
			
			if (statement.executeUpdate() > 0) {
				System.out.println("Thay đổi thông tin thành công");
				statusExecute = true;
			} else {
				System.out.println("Mã thành viên không tồn tại");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}

}
