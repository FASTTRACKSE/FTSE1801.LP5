package demo.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ftse1801.demo.spring.entity.SinhVien;

@Repository
@Transactional
public class JDBCSinhVienDao implements ISinhVienDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public ArrayList<SinhVien> getAllSinhVien() {
		String sql = "SELECT * FROM quanlysv";
		return (ArrayList<SinhVien>) jdbcTemplate.query(sql, new SinhVienMapper());
	}

	@Override
	public ArrayList<SinhVien> getAllSinhVien1(int paging, int soDong) {
		String sql = "SELECT * FROM `quanlysv` LIMIT ?,?";
		return (ArrayList<SinhVien>) jdbcTemplate.query(sql, new SinhVienMapper(), paging, soDong);
	}

	@Override
	public int getCount(int soDong) {
		String sql="SELECT * FROM `quanlysv` ORDER BY `id` DESC LIMIT 1";
		if (jdbcTemplate.queryForObject(sql, new SinhVienMapper())==null) {
			return 1;
		}else {
			return (jdbcTemplate.queryForObject(sql, new SinhVienMapper()).getId()+1);
		}
	}

	@Override
	public ArrayList<SinhVien> getSinhVien() {
		return null;
	}

	@Override
	public boolean DeleteSinhVien(int id) {
		String sql = "DELETE FROM `quanlysv` WHERE id = ?";
		if (jdbcTemplate.update(sql,id) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean UpdateSinhVien(SinhVien sinhvien, int id) {
		String sql = "UPDATE `quanlysv` SET `Ten`=?,`Tuoi`=?,`Diachi`=?,`Lop`=? WHERE `id` =?";
		if (jdbcTemplate.update(sql, sinhvien.getTen(), sinhvien.getTuoi(), sinhvien.getDiachi(), sinhvien.getLop(),id) > 0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean addSinhVien(String ten, String tuoi, String diachi, String lop, String img) {
		String sql = "INSERT INTO `quanlysv`(`Ten`, `Tuoi`, `Diachi`, `Lop`, `img`) VALUES (?,?,?,?,?)";
		if (jdbcTemplate.update(sql, ten, tuoi, diachi, lop, img) > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public SinhVien getAllSvById(int id) {
		String sql = "SELECT * FROM `quanlysv` WHERE `id` =?";
		return (SinhVien) jdbcTemplate.queryForObject(sql, new SinhVienMapper(),id);
	}

	@Override
	public ArrayList<SinhVien> getSinhVien1() {
		return null;
	}
}
