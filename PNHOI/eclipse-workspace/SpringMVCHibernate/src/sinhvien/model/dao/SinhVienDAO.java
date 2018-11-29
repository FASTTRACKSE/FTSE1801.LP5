package sinhvien.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import sinhvien.model.entity.SinhVien;

public class SinhVienDAO implements ISinhVienDAO{
	Connection conn;
	@Override
	public ArrayList<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM sinhvien";
		conn = DatabaseUntil.getConnect();
		ArrayList<SinhVien> listSV = new ArrayList<SinhVien>();
		
		try {
			PreparedStatement  statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			SinhVien sinhVien = null;
			while(result.next()) {
				sinhVien = new SinhVien();
				sinhVien.setId(result.getString("id"));
				sinhVien.setName(result.getString("name"));
				sinhVien.setAge(result.getString("age"));
				sinhVien.setAddress(result.getString("address"));
				
				listSV.add(sinhVien);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			DatabaseUntil.disConnect(conn);
		}
		
		return listSV;
	}

	@Override
	public boolean deleteSinhVien(String id) {
		boolean statusExecute = false;
		conn = DatabaseUntil.getConnect();
		
		String sql = "DELETE FROM `sinhvien` WHERE id = ?";
		
		try {
			PreparedStatement  statement = conn.prepareStatement(sql);
			statement.setString(1, id);
		
			while(statement.executeUpdate()>0) {
				statusExecute = true;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			DatabaseUntil.disConnect(conn);
		}
		
		return statusExecute;
	}

	@Override
	public boolean addNewSinhVien(SinhVien sinhvien) {
		boolean statusExecute = false;
		conn = DatabaseUntil.getConnect();
		PreparedStatement  statement;
		String sql = "INSERT INTO `sinhvien`(`id`, `name`, `age`, `address`) VALUES (?,?,?,?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, sinhvien.getId());
			statement.setString(2, sinhvien.getName());
			statement.setString(3, sinhvien.getAge());
			statement.setString(4, sinhvien.getAddress());
			
			int count = statement.executeUpdate();
			
			if (count > 0) {
				statusExecute = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUntil.disConnect(conn);
		}
		
		return statusExecute;
	}

	@Override
	public boolean updateSinhVien(SinhVien sinhvien, String id) {
		boolean statusExecute = false;
		conn = DatabaseUntil.getConnect();
		PreparedStatement  statement;
		String sql = "UPDATE sinhvien SET name=?,age=?,address=? WHERE id=?";
		try {
			statement = conn.prepareStatement(sql);

			statement.setString(1, sinhvien.getName());
			statement.setString(2, sinhvien.getAge());
			statement.setString(3, sinhvien.getAddress());
			statement.setString(4, id);
			
			int count = statement.executeUpdate();
			if (count > 0) {
				statusExecute = true;
			}
		} catch (Exception e) {
			System.out.println("Cập nhập thất bại!!");
		}
		DatabaseUntil.disConnect(conn);
		return statusExecute;
	}

	@Override
	public SinhVien getSinhVien(String id) {
		String sql = "SELECT * FROM sinhvien WHERE id = ?";
		conn = DatabaseUntil.getConnect();
		SinhVien students = null;
		try {
			PreparedStatement  statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				students = new SinhVien();
				students.setId(result.getString("id"));
				students.setName(result.getString("name"));
				students.setAge(result.getString("age"));
				students.setAddress(result.getString("address"));
				
			}
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			DatabaseUntil.disConnect(conn);
		}
		
		return students;
	}

	@Override
	public ArrayList<SinhVien> getAll(int trang, int soDong) {
		String sql = "SELECT * FROM sinhvien LIMIT ?,?";
		conn = DatabaseUntil.getConnect();
		ArrayList<SinhVien> listSv = new ArrayList<SinhVien>();
		
		try {
			PreparedStatement  statement = conn.prepareStatement(sql);
			statement.setInt(1, trang);
			statement.setInt(2, soDong);
			ResultSet result = statement.executeQuery();
			
			SinhVien sv = null;
			while(result.next()) {
				sv = new SinhVien();
				sv.setId(result.getString("id"));
				sv.setName(result.getString("name"));
				sv.setAge(result.getString("age"));
				sv.setAddress(result.getString("address"));
				
				listSv.add(sv);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			DatabaseUntil.disConnect(conn);
		}
		
		return listSv;
	}

	@Override
	public int getCount(int soDong) {
		// TODO Auto-generated method stub
		return 0;
	}

}
