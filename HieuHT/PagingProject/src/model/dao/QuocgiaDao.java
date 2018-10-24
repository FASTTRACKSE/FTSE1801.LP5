package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.database.DatabaseUtil;
import model.entity.QuocGia;

public class QuocgiaDao {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet result;
	
	public ArrayList<QuocGia> getAllQuocGia(int page, int soDong){
		String sql = "SELECT * FROM `quocgia` LIMIT ?,?";
		conn = DatabaseUtil.getConnect();
		ArrayList<QuocGia> listQg = new ArrayList<QuocGia>();
	
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, page);
			statement.setInt(2, soDong);
			result = statement.executeQuery();
			QuocGia quocGia = null;
			while(result.next()) {
				quocGia = new QuocGia();
				quocGia.setId(result.getInt("id"));
				quocGia.setCode(result.getString("code"));
				quocGia.setName(result.getString("name"));
				listQg.add(quocGia);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return listQg;
	}
	public int getCount(int soDong) {
		String sql = "SELECT COUNT(*) FROM `quocgia`";
		conn = DatabaseUtil.getConnect();
		int count = 0;
		try {
			statement = conn.prepareStatement(sql);
			result = statement.executeQuery();
			while (result.next()) {
				count = result.getInt("COUNT(*)");
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseUtil.disConnect(conn);
		}
		if(count%soDong == 0) {
			return count/soDong;
		}else {
			return count/soDong+1;
		}
		
	}
	public ArrayList<QuocGia> getQuocGia() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
