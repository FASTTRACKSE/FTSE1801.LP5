package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Connection;

import model.entity.KhachHang;
import model.connection.DatabaseUntil;

public class KhachHangDAO {
	Connection conn;
	
	/**
	 * Lấy ra all thông tin khách hàng
	 * 
	 * @param soTK
	 * @return
	 */ 	
	public ArrayList<KhachHang> showAllKhachHang(int pageid, int total) {
		ArrayList<KhachHang> myList = new ArrayList<>();
		PreparedStatement statement = null;
		KhachHang khachHang;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT*FROM khach_hang JOIN phuong ON khach_hang.maPhuong = phuong.maPhuong JOIN quan ON phuong.maQuan = quan.maQuan JOIN the_atm ON khach_hang.soTheATM = the_atm.soTheATM ORDER BY maKhachHang ASC LIMIT ?,?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, pageid);
			statement.setInt(2, total);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				khachHang = new KhachHang();
				khachHang.setMaKH(resultSet.getString("khach_hang.maKhachHang"));
				khachHang.setTenKH(resultSet.getString("khach_hang.tenKhachHang"));
				khachHang.setDiaChi(resultSet.getString("khach_hang.diaChi"));
				khachHang.setPhuong(resultSet.getString("phuong.tenPhuong"));
				khachHang.setQuan(resultSet.getString("quan.tenQuan"));
				khachHang.setSoDT(resultSet.getString("khach_hang.soDienThoai"));
				khachHang.setEmail(resultSet.getString("khach_hang.email"));
				khachHang.setSoCMND(resultSet.getString("khach_hang.soCMND"));
				khachHang.setSoTheATM(resultSet.getString("khach_hang.soTheATM"));
				khachHang.setSoTK(resultSet.getString("the_atm.soTK"));
				khachHang.setSoTienTrongTK(resultSet.getString("khach_hang.soTienTrongTK"));

				myList.add(khachHang);
			}

		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}

		DatabaseUntil.closeConnection(conn);
		return myList;
	}
	/**
	 * Xóa khách hàng theo maKH
	 * 
	 * @param maKH
	 * @return
	 */
	public boolean deleteKhachHangTheoMaKH(String maKH) {
		boolean kiemTra = false;
		String sql = "DELETE FROM khach_hang WHERE maKhachHang = ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maKH);
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}
	
	/**
	 * Thêm khách hàng
	 * 
	 * @param khachHang,
	 *            maPhuong
	 * @return
	 */
	public boolean addKhachHang(KhachHang khachHang, int maPhuong) {
		boolean kiemTra = false;
		String sql = "INSERT INTO khach_hang(tenKhachHang,diaChi,maPhuong,soDienThoai,email,soCMND,soTheATM,sotienTrongTK) VALUES (?,?,?,?,?,?,?,?)";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, khachHang.getTenKH());
			statement.setString(2, khachHang.getDiaChi());
			statement.setInt(3, maPhuong);
			statement.setString(4, khachHang.getSoDT());
			statement.setString(5,khachHang.getEmail());
			statement.setString(6, khachHang.getSoCMND());
			statement.setString(7, khachHang.getSoTheATM());
			statement.setString(8, khachHang.getSoTienTrongTK());
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("Đóng lỗi");
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}

	/**
	 * Update thông tin khách hàng theo mã khách hàng
	 * 
	 * @param khachHang,
	 *            maPhuong
	 * @return
	 */
	public boolean updateKhachHang(String maKh,KhachHang khachHang, int maPhuong) {
		boolean kiemTra = false;
		String sql = "UPDATE khach_hang SET tenKhachHang = ?, diaChi = ?, maPhuong = ?, soDienThoai = ?, email = ?, soCMND =? WHERE maKhachHang = ?";
		conn = DatabaseUntil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, khachHang.getTenKH());
			statement.setString(2, khachHang.getDiaChi());
			statement.setInt(3, maPhuong);
			statement.setString(4, khachHang.getSoDT());
			statement.setString(5, khachHang.getEmail());
			statement.setString(6, khachHang.getSoCMND());
			statement.setString(7, maKh);
			if (statement.executeUpdate() > 0) {
				kiemTra = true;
			}
		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		DatabaseUntil.closeConnection(conn);
		return kiemTra;
	}
	
	/**
	 * Lấy ra thông tin khách hàng theo số tài khoản
	 * 
	 * @param maKH
	 * @return
	 */
	public KhachHang showKhachHangTheoMaKH(String MaKH) {
		PreparedStatement statement = null;
		KhachHang khachHang = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT*FROM khach_hang JOIN phuong ON khach_hang.maPhuong = phuong.maPhuong JOIN quan ON phuong.maQuan = quan.maQuan JOIN the_atm ON khach_hang.soTheATM = the_atm.soTheATM WHERE khach_hang.maKhachHang= ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, MaKH);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				khachHang = new KhachHang();
				khachHang.setMaKH(resultSet.getString("khach_hang.maKhachHang"));
				khachHang.setTenKH(resultSet.getString("khach_hang.tenKhachHang"));
				khachHang.setSoCMND(resultSet.getString("khach_hang.soCMND"));
				khachHang.setDiaChi(resultSet.getString("khach_hang.diaChi"));
				khachHang.setPhuong(resultSet.getString("phuong.tenPhuong"));
				khachHang.setQuan(resultSet.getString("quan.tenQuan"));
				khachHang.setSoDT(resultSet.getString("khach_hang.soDienThoai"));
				khachHang.setEmail(resultSet.getString("khach_hang.email"));
				khachHang.setSoTheATM(resultSet.getString("khach_hang.soTheATM"));
				khachHang.setSoTK(resultSet.getString("the_atm.soTK"));
				khachHang.setSoTienTrongTK(resultSet.getString("khach_hang.soTienTrongTK"));
			}
		} catch (SQLException e) {
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}

		DatabaseUntil.closeConnection(conn);
		return khachHang;
	}
}
