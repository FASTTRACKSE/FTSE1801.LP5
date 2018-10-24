package model.entity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class vi {
	public static void main(String[] args) {
		
		Properties pro = new Properties();
		OutputStream out = null;
		try {
			out = new FileOutputStream("vi.properties");
			pro.setProperty("TieuDe", "Nhập thông tin");
			pro.setProperty("TenDangNhap", "Tên sinh viên");
			pro.setProperty("Tuoi", "Tuổi");
			pro.setProperty("DiaChi", "Địa chỉ");
			pro.setProperty("Sdt", "Số điện thoại");
			pro.setProperty("Them", "Thêm");
			pro.setProperty("Sua", "Sửa");
			pro.setProperty("Xoa", "Xóa");
			pro.setProperty("TieuDe1", "Danh sách sinh viên");
			pro.setProperty("ChucNang", "Chức năng");
			pro.setProperty("id", "Mã sinh viên");
			pro.setProperty("title", "Quản lý sinh viên");
			pro.setProperty("MatKhau", "Mật khẩu");
			pro.setProperty("DangNhap", "Đăng nhập");
			pro.setProperty("DangXuat", "Đăng Xuất");
			pro.setProperty("Huy", "Hủy");
			pro.setProperty("DangNhapSai", "Bạn nhập sai tài khoản hoặc mật khẩu!!");
			pro.store(out, null);
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}
