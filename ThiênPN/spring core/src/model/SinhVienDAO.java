package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import di.elm.Diem;
import di.elm.SinhVien;



/**
 * This class using for ...
 * 
 * @author ThienPN 1801014
 *
 */

public class SinhVienDAO {
	Connection conn;

	public ArrayList<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM sinh_vien LEFT JOIN diem ON sinh_vien.maSV = diem.maSV";
		conn = DatabaseUtil.getConnect();
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			SinhVien sv;
			Diem diem;
			while (result.next()) {
				sv = new SinhVien();
				sv.setMaSinhVien(result.getString("maSV"));
				sv.setTensinhVien(result.getString("ten"));
				sv.setPassword(result.getString("pass"));
				sv.setTuoi(result.getString("tuoi"));
				diem = new Diem();
				diem.setDiem(result.getInt("diem"));
				diem.setMonHoc(result.getString("monhoc"));
				sv.setDiem(diem);

				list.add(sv);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;

	}
	
}
