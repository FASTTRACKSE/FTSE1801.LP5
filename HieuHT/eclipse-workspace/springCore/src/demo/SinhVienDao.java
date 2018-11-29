package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import id.impl.SinhVien;

public class SinhVienDao {
	 Connection conn;
	public ArrayList<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM `quanlysv`";
		conn = DatabaseUtil.getConnect();
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
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
				list.add(sinhvien);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseUtil.disConnect(conn);
		}
			
		return list;
	}
}
