package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.entity.ThanhPho;

public class ThanhPhoDAO {
	Connection conn;
	public ArrayList<ThanhPho> getAll(int trang,int soDong){
		String sql = "SELECT * FROM tinhthanhpho LIMIT ?,?";
		conn = DatabaseUntil.getConnect();
		ArrayList<ThanhPho> listCity = new ArrayList<ThanhPho>();
		
		try {
			PreparedStatement  statement = conn.prepareStatement(sql);
			statement.setInt(1, trang);
			statement.setInt(2, soDong);
			ResultSet result = statement.executeQuery();
			
			ThanhPho tp = null;
			while(result.next()) {
				tp = new ThanhPho();
				tp.setId(result.getString("matp"));
				tp.setName(result.getString("name"));
				tp.setType(result.getString("type"));
				
				listCity.add(tp);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			DatabaseUntil.disConnect(conn);
		}
		
		return listCity;
	}
	
	public int getCount(int soDong){
		String sql = "SELECT COUNT(*) FROM tinhthanhpho";
		conn = DatabaseUntil.getConnect();
		int count = 0;
		
		try {
			PreparedStatement  statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				count = result.getInt("COUNT(*)");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			DatabaseUntil.disConnect(conn);
		}
		if(count%soDong == 0) {
			return count/soDong;
		}else {
			return count/soDong+1;
		}
		
	}
}
