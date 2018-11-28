package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.SinhVien;
import demo.DatabaseUntil;

public class SinhVienDao {
	Connection conn;
	SinhVien sinhVien;
	public ArrayList<SinhVien> ShowAllSinhVien() {
		ArrayList<SinhVien> myList = new ArrayList<>();
		PreparedStatement statement = null;
		SinhVien sinhVien;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM sinh_vien";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMaSV(resultset.getString("sinh_vien.maSV"));
				sinhVien.setTenSV(resultset.getString("sinh_vien.tenSV"));
				myList.add(sinhVien);
			}
		} catch (Exception e) {
		}finally {
			try {
				statement.close();
			} catch (Exception e2) {
			}
		}
		DatabaseUntil.closeConnection(conn);
		return myList;
	}
	
	
	
	
}
