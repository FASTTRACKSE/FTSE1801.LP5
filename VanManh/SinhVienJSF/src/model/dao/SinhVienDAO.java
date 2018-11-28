package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import model.entity.MonHoc;
import model.entity.SinhVien;

@ManagedBean
public class SinhVienDAO {
	Connection conn;

	public ArrayList<SinhVien> getSinhVienRecord(int start, int recordPage) {
		ArrayList<SinhVien> myList = new ArrayList<>();
		PreparedStatement statement = null;
		SinhVien sinhVien;
		MonHoc monHoc;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM `danh_sach` LEFT JOIN diem ON danh_sach.MaSV = diem.MaSV LIMIT ?,?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, start);
			statement.setInt(2, recordPage);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				sinhVien = new SinhVien();
				monHoc = new MonHoc();
				monHoc.setDiem(resultSet.getString("Diem"));
				monHoc.setTenMonHoc(resultSet.getString("MonHoc"));
				sinhVien.setMaSV(resultSet.getInt("MaSv"));
				sinhVien.setName(resultSet.getString("HoVaTen"));
				sinhVien.setAge(resultSet.getString("Tuoi"));
				sinhVien.setImg(resultSet.getString("img"));
				sinhVien.setMonHoc(monHoc);
				myList.add(sinhVien);
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
	
	public ArrayList<SinhVien> showAllSinhVien() {
		ArrayList<SinhVien> myList = new ArrayList<>();
		PreparedStatement statement = null;
		SinhVien sinhVien;
		MonHoc monHoc;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM `danh_sach` LEFT JOIN diem ON danh_sach.MaSV = diem.MaSV";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				sinhVien = new SinhVien();
				monHoc = new MonHoc();
				monHoc.setDiem(resultSet.getString("Diem"));
				monHoc.setTenMonHoc(resultSet.getString("MonHoc"));
				sinhVien.setMaSV(resultSet.getInt("MaSv"));
				sinhVien.setName(resultSet.getString("HoVaTen"));
				sinhVien.setAge(resultSet.getString("Tuoi"));
				sinhVien.setMonHoc(monHoc);
				myList.add(sinhVien);
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
	
	public boolean addSV(String name, String age, String img) {
		PreparedStatement statement = null;
		boolean check = false;
		conn = DatabaseUntil.getConnect();
		String sql = "INSERT INTO danh_sach(HoVaTen,Tuoi,img) VALUES(?,?,?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, age);
			statement.setString(3, img);
			int count = statement.executeUpdate();
			if (count>0) {
				check = true;
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
		return check;
	}
	
	public boolean addDiem(int maSV,MonHoc monHoc) {
		PreparedStatement statement = null;
		boolean check = false;
		conn = DatabaseUntil.getConnect();
		String sql = "INSERT INTO diem VALUES(?,?,?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maSV);
			statement.setString(2, monHoc.getTenMonHoc());
			statement.setString(3, monHoc.getDiem());
			int count = statement.executeUpdate();
			if (count>0) {
				check = true;
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
		return check;
	}
	
	public boolean upDateSV(int maSV, String name, String age) {
		PreparedStatement statement = null;
		boolean check = false;
		conn = DatabaseUntil.getConnect();
		String sql = "UPDATE danh_sach SET HoVaTen=?, Tuoi=? WHERE MaSV=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2,age);
			statement.setInt(3, maSV);
			int count = statement.executeUpdate();
			if (count>0) {
				check = true;
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
		return check;
	}
	
	public boolean upDateDiem(int maSV, MonHoc monHoc) {
		PreparedStatement statement = null;
		boolean check = false;
		conn = DatabaseUntil.getConnect();
		String sql = "UPDATE diem SET Diem=? WHERE MonHoc=? AND MaSV=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, monHoc.getDiem());
			statement.setString(2,monHoc.getTenMonHoc());
			statement.setInt(3, maSV);
			int count = statement.executeUpdate();
			if (count>0) {
				check = true;
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
		return check;
	}
	
	public boolean deleteDiem(int maSV) {
		PreparedStatement statement = null;
		boolean check = false;
		conn = DatabaseUntil.getConnect();
		String sql = "DELETE FROM diem WHERE MaSV=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maSV);
			int count = statement.executeUpdate();
			if (count>0) {
				check = true;
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
		return check;
	}
	
	public boolean deleteSV(int maSV) {
		PreparedStatement statement = null;
		boolean check = false;
		conn = DatabaseUntil.getConnect();
		String sql = "DELETE FROM danh_sach WHERE MaSV=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maSV);
			int count = statement.executeUpdate();
			if (count>0) {
				check = true;
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
		return check;
	}
	
	public boolean kiemTraDelete(int maSV) {
		boolean check =false;
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM `diem` WHERE MaSV=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maSV);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				check=true;
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
		return check;
	}
	
	public int getMaSV() {
		int maSV=0;
		PreparedStatement statement = null;
		conn = DatabaseUntil.getConnect();
		String sql = "SELECT * FROM `danh_sach` ORDER BY `danh_sach`.`MaSV` DESC LIMIT 1";
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				maSV=resultSet.getInt("MaSV")+1;
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
		return maSV;
	}
}
