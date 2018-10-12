package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.common.DatabaseUntil;
import model.entity.Diem;
import model.entity.SinhVien;

public class SinhVienDao {
	Connection conn;
	SinhVien sinhVien;
	Diem diem;
	public ArrayList<SinhVien> ShowAllSinhVien(int page, int total) {
		ArrayList<SinhVien> myList = new ArrayList<>();
		PreparedStatement statement = null;
		SinhVien sinhVien;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM sinh_vien JOIN diem ON diem.maSV = sinh_vien.maSV ORDER BY sinh_vien.maSV ASC LIMIT ?,?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, page);
			statement.setInt(2, total);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				sinhVien = new SinhVien();
				diem = new Diem();
				sinhVien.setMaSV(resultset.getString("sinh_vien.maSV"));
				sinhVien.setTenSV(resultset.getString("sinh_vien.tenSV"));
				diem.setMonHoc(resultset.getString("diem.monHoc"));
				diem.setDiem(resultset.getString("diem.diem"));
				sinhVien.setDiem(diem);
				myList.add(sinhVien);
			}
		} catch (Exception e) {
		}finally {
			try {
				statement.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		DatabaseUntil.closeConnection(conn);
		return myList;
	}
	
	public boolean ThemSinhVien(String maSV, String tenSV) {
		boolean kiemTra =false;
		conn = DatabaseUntil.getConnect();
		String sql = "INSERT INTO sinh_vien VALUES(?,?)";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maSV);
			statement.setString(2, tenSV);
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (Exception e) {
		}finally {
			try {
				statement.close();
			} catch (Exception e2) {
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;

	}
	
	public boolean ThemDiem(String maSV, String monHoc, String diem) {
		boolean kiemTra = false;
		conn = DatabaseUntil.getConnect();
		String sql = "INSERT INTO diem VALUES(?,?,?)";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maSV);
			statement.setString(2, monHoc);
			statement.setString(3, diem);
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (Exception e) {
		}finally {
			try {
				statement.close();
			} catch (Exception e2) {
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
		
	}
	
	public boolean SuaThongTin(String monHoc, String diem, String maSV) {
		boolean kiemTra = false;
		conn = DatabaseUntil.getConnect();
		String sql = "UPDATE diem SET monHoc = ?, diem = ? WHERE maSV = ?";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, monHoc);
			statement.setString(2, diem);
			statement.setString(3, maSV);
			statement.executeUpdate();
		} catch (Exception e) {
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;

	}
	
	public boolean XoaThongTin(String maSV) {
		boolean kiemTra = false;
		conn = DatabaseUntil.getConnect();
		String sql = "DELETE FROM diem WHERE maSV = ?";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maSV);
			if (statement.executeUpdate()>0) {
				kiemTra = true;
			}
		} catch (Exception e) {
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		
		return kiemTra;
		
	}
	
	public SinhVien ShowSinhVienTheoMaVS(String maKH) {
		SinhVien sinhVien = null;
		diem = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM sinh_vien JOIN diem ON diem.maSV = sinh_vien.maSV WHERE sinh_vien.maSV = ?";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maKH);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				sinhVien = new SinhVien();
				diem = new Diem();
				sinhVien.setMaSV(resultSet.getString("sinh_vien.maSV"));
				sinhVien.setTenSV(resultSet.getString("sinh_vien.tenSV"));
				diem.setMonHoc(resultSet.getString("diem.monHoc"));
				diem.setDiem(resultSet.getString("diem.diem"));
				sinhVien.setDiem(diem);
			}
		} catch (Exception e) {
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		
		return sinhVien;
		// TODO Auto-generated method stub

	}
	
	public int TotalSV(int row) {
		int total = 0;
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement =null;
		String sql = "SELECT COUNT(*) FROM sinh_vien";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				total = resultSet.getInt("COUNT(*)");
			}
		} catch (Exception e) {
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		if (total % row == 0) {
			return  total/row;
		} else {
			return total/row+1;
		}
		
	}
	
}
