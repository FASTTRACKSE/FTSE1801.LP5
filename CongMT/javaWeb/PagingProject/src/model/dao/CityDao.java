package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.database.DatabasaUltil;

import model.entity.ThanhPho;

public class CityDao {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet result;
	 public ArrayList<ThanhPho> getAllCity(int page, int soDong){
		 String sql = "SELECT * FROM tinhthanhpho LIMIT ?,?";
		 conn = DatabasaUltil.getConnect();
		 ArrayList<ThanhPho> listCity= new  ArrayList<ThanhPho>();
		 try {
			 statement = conn.prepareStatement(sql);
			 statement.setInt(1, page);
			 statement.setInt(2, soDong);
			 result = statement.executeQuery();
			ThanhPho thanhPho = null;
			while (result.next()) {
				thanhPho = new ThanhPho();
				thanhPho.setMatp(result.getString("matp"));
				thanhPho.setName(result.getString("name"));
				thanhPho.setType(result.getString("type"));
				listCity.add(thanhPho);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabasaUltil.closeConnection(conn);
		}
		return listCity;
		 
	 }
	 public int getCount(int soDong) {
		 String sql= " SELECT COUNT(*) FROM tinhthanhpho";
		 conn = DatabasaUltil.getConnect();
		 int count =0;
		 try {
			 statement = conn.prepareStatement(sql);
			 result = statement.executeQuery();
			while (result.next()) {
			count = result.getInt("COUNT(*)");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabasaUltil.closeConnection(conn);
		}
		 if(count%soDong ==0) {
		return count/soDong;
		}else {
			return count/soDong+1;
		}
	 }
}
