package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.connection.DatabaseUntil;

public class PageDAO {
	Connection conn;
	public int countDAO(int soDong) {
		conn = DatabaseUntil.getConnect();
		int count = 0;
		String sql = "SELECT COUNT(*) FROM khach_hang";
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				count = resultset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
			if (count%soDong == 0) {
				return count/soDong;
			}else {
				return count/soDong+1;
			}
	}
}
