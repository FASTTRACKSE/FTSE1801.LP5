package model.entity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class en {
	public static void main(String[] args) {
		Properties pro = new Properties();
		OutputStream out = null;
		try {
			out = new FileOutputStream("en.properties");
			pro.setProperty("TieuDe", "My Login form");
			pro.setProperty("TenDangNhap", "Username");
			pro.setProperty("Tuoi", "Old");
			pro.setProperty("DiaChi", "Adress");
			pro.setProperty("Sdt", "NumberPhone");
			pro.setProperty("Them", "Add");
			pro.setProperty("Sua", "Edit");
			pro.setProperty("Xoa", "Delete");
			pro.setProperty("TieuDe1", "List Student");
			pro.setProperty("ChucNang", "Fution");
			pro.setProperty("id", "Id");
			pro.setProperty("title", "Student Manager");
			pro.setProperty("MatKhau", "PassWord");
			pro.setProperty("DangNhap", "Login");
			pro.setProperty("DangXuat", "Logout");
			pro.setProperty("Huy", "Cancel");
			pro.setProperty("DangNhapSai", "You enter an account or password");
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
