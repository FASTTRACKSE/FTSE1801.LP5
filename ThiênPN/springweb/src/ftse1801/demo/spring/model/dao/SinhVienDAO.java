package ftse1801.demo.spring.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ftse1801.demo.spring.model.entity.Diem;
import ftse1801.demo.spring.model.entity.SinhVien;




/**
 * This class using for ...
 * 
 * @author ThienPN 1801014
 *
 */

public class SinhVienDAO implements SinhVienDAOIML{
	
	Connection conn;

	/**
	 * thêm sinh viên
	 * 
	 * @param sinhVien
	 * @return
	 */
	@Override
	public boolean addSinhVien(String maSV, String tenSV, String pass,String tuoi) {
		boolean statusExecute = false;
		String sql = "INSERT INTO sinh_vien VALUES(?,?,?,?,?)";
		conn = DatabaseUtil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maSV);
			statement.setString(2, tenSV);
			statement.setString(3, pass);
			statement.setString(4, tuoi);
			statement.setString(5, "");
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

	/**
	 * thêm điểm sinh viên
	 * 
	 * @param sinhVien
	 * @return
	 */
	@Override
	public boolean addDiemSV(String maSV,String monHoc,int diem) {
		boolean statusExecute = false;
		String sql = "INSERT INTO diem VALUES(?,?,?)";
		conn = DatabaseUtil.getConnect();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, maSV);
			statement.setString(2, monHoc);
			statement.setInt(3, diem);

			if (statement.executeUpdate() > 0) {
				statusExecute = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
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

	/**
	 * UpDate Sinh viên theo mã sinh viên
	 * 
	 * @param sinhVien
	 * @return
	 */
	@Override
	public boolean updateSV(String maSV, String ten,String pass) {
		boolean statusExecute = false;
		String sql = "UPDATE `sinh_vien` SET `ten`=?,`pass`=? WHERE maSV=?";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(3, maSV);
			statement.setString(1, ten);
			statement.setString(2, pass);

			if (statement.executeUpdate() > 0) {
				statusExecute = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}

	/**
	 * Delete Điểm sinh viên theo mã và môn học
	 * 
	 * @param sinhVien
	 * @return
	 */
	@Override
	public boolean deleteDiemSV(SinhVien sinhVien) {
		boolean statusExecute = false;
		String sql = "DELETE FROM diem WHERE maSV = ? AND monhoc = ?";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getMaSinhVien());
			statement.setString(2, sinhVien.getDiem().getMonHoc());

			if (statement.executeUpdate() > 0) {
				statusExecute = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}

	/**
	 * Delete Sinh viên theo mã sinh viên
	 * 
	 * @param sinhVien
	 * @return
	 */
	@Override
	public boolean deleteSV(String  maSinhVien) {
		boolean statusExecute = false;

		String sql1 = "DELETE FROM diem WHERE maSV = ?";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement1 = conn.prepareStatement(sql1);
			statement1.setString(1, maSinhVien);

			if (statement1.executeUpdate() > 0) {
				statusExecute = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		/**
		 * Xóa điểm sinh viên theo mã
		 */
		String sql = "DELETE  FROM sinh_vien WHERE maSV = ?";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, maSinhVien);

			if (statement.executeUpdate() > 0) {
				statusExecute = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}

	/**
	 * Update điểm sinh viên theo mã và môn học
	 * 
	 * @param sinhVien
	 * @return
	 */
	@Override
	public boolean UpdateDiemSV(String maSV,String MH,int diem) {
		boolean statusExecute = false;
		String sql = "UPDATE `diem` SET `monhoc`= ?, `diem`= ? WHERE maSV = ?";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(3, maSV);
			statement.setString(1, MH);
			statement.setInt(2, diem);

			if (statement.executeUpdate() > 0) {
				statusExecute = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return statusExecute;
	}

	/**
	 * Hiển thị danh sách sinh viên
	 * 
	 * @return
	 */
	@Override
	public ArrayList<SinhVien> getAllSinhVien(int trang, int soDong) {
		String sql = "SELECT * FROM sinh_vien LEFT JOIN diem ON sinh_vien.maSV = diem.maSV LIMIT ?,?";
		conn = DatabaseUtil.getConnect();
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, trang);
			statement.setInt(2, soDong);
			ResultSet result = statement.executeQuery();
			SinhVien sv;
			Diem diem;
			while (result.next()) {
				sv = new SinhVien();
				sv.setMaSinhVien(result.getString("maSV"));
				sv.setTensinhVien(result.getString("ten"));
				sv.setPassword(result.getString("pass"));
				sv.setTuoi(result.getString("tuoi"));
				diem = new Diem();
				diem.setDiem(result.getInt("diem"));
				diem.setMonHoc(result.getString("monhoc"));
				sv.setDiem(diem);

				list.add(sv);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return list;

	}
	/**
	 * hiển thị danh sách sinh viên theo tên
	 * @param ten
	 * @return
	 */
	@Override
	public ArrayList<SinhVien> getSinhVienTheoTen(SinhVien sinhVien) {
		String sql = "SELECT * FROM sinh_vien LEFT JOIN diem ON sinh_vien.maSV = diem.maSV WHERE ten = ?";
		conn = DatabaseUtil.getConnect();
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();


		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, sinhVien.getTensinhVien());
			ResultSet result = statement.executeQuery();

			SinhVien sv;
			Diem diem;

			while (result.next()) {
				sv = new SinhVien();
				sv.setMaSinhVien(result.getString("masv"));
				sv.setTensinhVien(result.getString("ten"));
				sv.setPassword(result.getString("pass"));
				sv.setTuoi(result.getString("tuoi"));

				diem = new Diem();
				diem.setDiem(result.getInt("diem"));
				diem.setMonHoc(result.getString("monhoc"));
				sv.setDiem(diem);

				list.add(sv);

			}

		} catch (Exception e) {
			e.getStackTrace();
		}
			DatabaseUtil.disConnect(conn);
		

		return list;
	}
	@Override
	public SinhVien SinhVienByMa(String maSV) {
		SinhVien sv = null;
		Diem diem = null;
		String sql = "SELECT * FROM sinh_vien LEFT JOIN diem ON sinh_vien.maSV = diem.maSV WHERE sinh_vien.maSV = ?";
		conn = DatabaseUtil.getConnect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, maSV);
			ResultSet result = statement.executeQuery();

			

			while (result.next()) {
				sv = new SinhVien();
				sv.setMaSinhVien(result.getString("sinh_vien.maSV"));
				sv.setTensinhVien(result.getString("sinh_vien.ten"));
				sv.setPassword(result.getString("sinh_vien.pass"));
				sv.setTuoi(result.getString("sinh_vien.tuoi"));

				diem = new Diem();
				diem.setDiem(result.getInt("diem.diem"));
				diem.setMonHoc(result.getString("diem.monhoc"));
				sv.setDiem(diem);

			

			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		DatabaseUtil.disConnect(conn);
		return sv;
	}
	@Override
	public int getCount(int soDong) {
		String sql = "SELECT COUNT(*) FROM sinh_vien LEFT JOIN diem ON sinh_vien.maSV = diem.maSV\r\n" + 
				"";
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
}
