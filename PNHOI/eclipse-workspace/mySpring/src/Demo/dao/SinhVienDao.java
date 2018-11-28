package Demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.springframework.jdbc.core.JdbcTemplate;

import update.Students;  

public class SinhVienDao {
	Connection conn;
	private JdbcTemplate jdbc;
	
	
	
	public ArrayList<String> getAllSinhVien(){
		String sql = "SELECT sinhvien.name FROM sinhvien";
		conn = DatabaseUtil.getConnect();
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			PreparedStatement  statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				list.add(result.getString("name"));
			}
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			DatabaseUtil.disConnect(conn);
		}
		
		return list;
	}
	
//	public int addSinhVien(Students students){
//		String sql = "INSERT INTO `sinhvien`(`id`, `name`, `age`, `address`) VALUES (?,?,?,?)";
//		return jdbc.update(sql);
//	}
	
}
