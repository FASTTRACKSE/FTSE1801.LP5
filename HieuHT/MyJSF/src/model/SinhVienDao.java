package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import myJSF.SinhVien;

@ManagedBean(name = "sinhVienDao")
public class SinhVienDao {
	private Connection conn;

	public ArrayList<SinhVien> getAllSinhVien1(int page, int soDong) {
		String sql = "SELECT * FROM quanlysv LIMIT ?,?";
		conn = DatabaseUtil.getConnect();
		ArrayList<SinhVien> listQg = new ArrayList<>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, page);
			statement.setInt(2, soDong);
			ResultSet result = statement.executeQuery();
			// SinhVien sinhVien;
			while (result.next()) {
				SinhVien sinhVien = new SinhVien();
				sinhVien.setId(result.getString("id"));
				sinhVien.setTen(result.getString("Ten"));
				sinhVien.setTuoi(result.getString("Tuoi"));
				sinhVien.setDiachi(result.getString("Diachi"));
				sinhVien.setLop(result.getString("Lop"));
				sinhVien.setImg(result.getString("img"));

				listQg.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return listQg;
	}

	public ArrayList<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM quanlysv ";
		conn = DatabaseUtil.getConnect();
		ArrayList<SinhVien> listQg = new ArrayList<SinhVien>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			// statement.setInt(1, page);
			// statement.setInt(2, soDong);
			ResultSet result = statement.executeQuery();
			// SinhVien sinhVien;
			while (result.next()) {
				SinhVien sinhVien = new SinhVien();
				sinhVien.setId(result.getString("id"));
				sinhVien.setTen(result.getString("Ten"));
				sinhVien.setTuoi(result.getString("Tuoi"));
				sinhVien.setDiachi(result.getString("Diachi"));
				sinhVien.setLop(result.getString("Lop"));
				sinhVien.setImg(result.getString("img"));

				listQg.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return listQg;
	}

	public int getCount(int soDong) {
		String sql = "SELECT COUNT(*) FROM `quanlysv`";
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
		} finally {
			DatabaseUtil.disConnect(conn);
		}
		if (count % soDong == 0) {
			return count / soDong;
		} else {
			return count / soDong + 1;
		}

	}

	public ArrayList<SinhVien> getSinhVien() {
		return null;
	}
	/* Xóa sinh viên */

	public boolean DeleteSinhVien(String id) {
		boolean statusExecute = false;

		String sql = "DELETE FROM `quanlysv` WHERE id = ?";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);

			if (statement.executeUpdate() > 0) {
				System.out.println("Xóa thành công.");
				statusExecute = true;
			} else {
				System.out.println("Mã thành viên không tồn tại");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}

	/* Sửa thông tin sinh viên */
	public boolean UpdateSinhVien(SinhVien sinhvien, String id) {
		boolean statusExecute = false;
		String sql = "UPDATE `quanlysv` SET `Ten`=?,`Tuoi`=?,`Diachi`=?,`Lop`=?, `img`=? WHERE `id` =?";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, sinhvien.getTen());
			statement.setString(2, sinhvien.getTuoi());
			statement.setString(3, sinhvien.getDiachi());
			statement.setString(4, sinhvien.getLop());
			statement.setString(5, id);
			int result = statement.executeUpdate();
			if (result>0) {
				statusExecute=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.disConnect(conn);
		}
		return statusExecute;
	}
	/* Thêm thành viên */

	public boolean addSinhVien(String ten, String tuoi, String diachi, String lop, String img) {
		boolean statusExecute = false;
		String sql = "INSERT INTO `quanlysv`(`Ten`, `Tuoi`, `Diachi`, `Lop`, `img`) VALUES (?,?,?,?,?)";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, ten);
			statement.setString(2, tuoi);
			statement.setString(3, diachi);
			statement.setString(4, lop);
			statement.setString(5, img);
			if (statement.executeUpdate() > 0) {
				statusExecute = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}

	public SinhVien getAllSvById(String id) {
		String sql = "SELECT * FROM `quanlysv` WHERE `id` =?";
		conn = DatabaseUtil.getConnect();

		SinhVien sinhvien = null;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				sinhvien = new SinhVien();
				sinhvien.setId(result.getString("id"));
				sinhvien.setTen(result.getString("ten"));
				sinhvien.setTuoi(result.getString("tuoi"));
				sinhvien.setDiachi(result.getString("diachi"));
				sinhvien.setLop(result.getString("lop"));
				sinhvien.setImg(result.getString("img"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.disConnect(conn);
		}

		return sinhvien;
	}
	

	public int getId() {
		String sql = "SELECT * FROM `quanlysv` ORDER BY `quanlysv`.`id` DESC LIMIT 1" ;
		conn = DatabaseUtil.getConnect();
		int i =0;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				i = result.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.disConnect(conn);
		}

		return i;
	}

	public List<SinhVien> getAllSinhVien11(int first, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
