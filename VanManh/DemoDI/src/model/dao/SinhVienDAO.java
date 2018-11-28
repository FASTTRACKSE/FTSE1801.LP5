package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import di.ITFDao;
import model.entity.SinhVien;

public class SinhVienDAO implements ITFDao {
	Connection conn;

	@SuppressWarnings("unchecked")
	@Override
	public List<SinhVien> select() {
		List<SinhVien> myList = new ArrayList<SinhVien>();
		PreparedStatement statement = null;
		SinhVien sinhVien;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT*FROM danh_sach";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				sinhVien = new SinhVien();
				sinhVien.setName(resultSet.getString("HoVaTen"));
				sinhVien.setAge(resultSet.getString("Tuoi"));
				myList.add(sinhVien);
			}

		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}

		DatabaseUntil.closeConnection(conn);
		return myList;
	}

	@Override
	public boolean update() {
		return false;
	}

}
