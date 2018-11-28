package ftse1801.demo.spring.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUltil {
	private static final String URL = "jdbc:mysql://localhost/diem_sinhvien";
	private static final String USER = "root";
	private static final String PASS = "";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties properties = new Properties();
			properties.setProperty("user", USER);
			properties.setProperty("pass", PASS);
			properties.setProperty("characterEncoding", "UTF-8");

			Driver driver = new Driver();
			conn = driver.connect(URL, properties);
			System.out.println("Kết nối MYSQL thành công");
		} catch (SQLException e) {
			System.out.println("Kết nối MYSQL thất bại");
		}
		return conn;
	}
	
	public static void disConnection(Connection conn) {
		try {
			conn.close();
			System.out.println("Đóng kết nối MYSQL thành công");
		} catch(SQLException e) {
			System.out.println("Đóng kết nối MYSQL thất bại");
		}
	}
}
