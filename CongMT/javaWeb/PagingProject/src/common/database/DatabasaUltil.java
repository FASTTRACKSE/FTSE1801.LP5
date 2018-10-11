package common.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;
/**
 * DatabasaUltil Class
 * @author CÃ´ngMT
 *
 */
public class DatabasaUltil {
	private static final String URL = "jdbc:mysql://localhost/qltruonghoc";
	private static final String USER = "root";
	private static final String PASS = "";
	/**
	 * Káº¿t ná»‘i vá»›i Database
	 * @return
	 */
	public static Connection getConnect() {
		Connection conn = null;

		try {
			Properties pro = new Properties();
			pro.setProperty("user", USER);
			pro.setProperty("password", PASS);
			pro.put("characterEncoding", "UTF-8");

			Driver driver = new Driver();
			conn = driver.connect(URL, pro);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	/**
	 *  Ä�Ã³ng káº¿t ná»‘i vá»›i database
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {

		try {
			if (conn != null) {
				conn.close();
				
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
