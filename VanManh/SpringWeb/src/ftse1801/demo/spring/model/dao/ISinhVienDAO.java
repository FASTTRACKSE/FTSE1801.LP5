package ftse1801.demo.spring.model.dao;

import java.util.List;

import ftse1801.demo.spring.bean.MonHoc;
import ftse1801.demo.spring.bean.SinhVien;

public interface ISinhVienDAO {

	public List<SinhVien> getSinhVienRecord(int start, int recordPage);

	public List<SinhVien> showAllSinhVien();

	public SinhVien showSinhVienInMaSV(int maSV);

	public boolean addSV(String name, String age, String img);

	public boolean addDiem(int maSV, MonHoc monHoc);

	public boolean upDateSV(int maSV, String name, String age, String img);

	public boolean upDateDiem(int maSV, MonHoc monHoc);

	public boolean deleteDiem(int maSV);

	public boolean deleteSV(int maSV);

	public boolean kiemTraDelete(int maSV);

	public int getMaSV();
}
