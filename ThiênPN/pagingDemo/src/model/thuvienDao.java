package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entity.Quan;
import model.entity.ThanhPho;







/*
 * lấy dữ liệu từ thành phố
 */
public class thuvienDao {
	Connection conn;
	
	public ArrayList<ThanhPho> getCiTy() {
		String sql = "SELECT `tenThanhPho` FROM `tinh_thanhpho`";
		conn = DatabaseUtil.getConnect();
		ArrayList<ThanhPho> list = new ArrayList<ThanhPho>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
			ThanhPho thanhPho = new ThanhPho();
			thanhPho.setTenThanhPho(result.getString("tenThanhPho"));
			list.add(thanhPho);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;

	}
	
	/*
	 * lấy dữ liệu từ Quận.
	 */
	public ArrayList<Quan> getQuan(int trang, int soDong) {
		String sql = "SELECT quan_huyen.maQuanHuyen,quan_huyen.tenQuanHuyen FROM quan_huyen LIMIT ?,?";
		conn = DatabaseUtil.getConnect();
		ArrayList<Quan> list = new ArrayList<Quan>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, trang);
			statement.setInt(2, soDong);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Quan quan = new Quan();
				quan.setMaQuanHhuyen(Integer.parseInt(result.getString("maQuanHuyen")));
				quan.setTenQuanHuyen(result.getString("tenQuanHuyen"));
				list.add(quan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;

	}
	public int getCount(int soDong) {
		String sql = "SELECT COUNT(*) FROM quan_huyen";
		conn = DatabaseUtil.getConnect();
		int count = 0;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				count = result.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		if(count%soDong == 0) {
			return count/soDong;
		}else {
			return count/soDong+1;
		}
		
	}
	
	public boolean addQuan(String tenQuan) {
		boolean statusExecute = false;
		String sql = "INSERT INTO `quan_huyen`(`tenQuanHuyen`, `maThanhPho`) VALUES (?,?)";
		conn = DatabaseUtil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, tenQuan);
			statement.setInt(2, 3);

			if (statement.executeUpdate() > 0) {
				statusExecute = true;
			}

		} catch (SQLException e) {
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}

	
	
}
