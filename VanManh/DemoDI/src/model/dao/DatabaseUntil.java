package model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.cj.jdbc.Driver;
public class DatabaseUntil {
	private static final String URL = "jdbc:mysql://localhost/sinh_vien";
	private static final String USER = "root";
	private static final String PASS = "manh100997";

	/**
	 * 
	 * Kết nối Database
	 * @return
	 */
	public static Connection getConnect() {
		Connection conn = null;
		try {
			Properties pro = new Properties();
			pro.setProperty("user", USER);
			pro.setProperty("password", PASS);
			pro.setProperty("characterEncoding", "UTF-8");

			Driver driver = new Driver();
			conn = driver.connect(URL, pro);
			System.out.println("Ket noi thanh cong!");
		} catch (SQLException ex) {
			System.out.println("Ket noi that bai!");
		}
		return conn;
	}

	/**
	 * Đóng kết nối Databases
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				System.out.println("dong ket loi");
			}
		} catch (Exception e) {
			System.out.println("loi dong ket loi");
		}
	}
}
