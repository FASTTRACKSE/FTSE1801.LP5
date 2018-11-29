package model.entity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class vi {
	 public static void main(String[] args) {
			
			Properties prop = new Properties();
			OutputStream output = null;

			try {

				output = new FileOutputStream("vi.properties");

				// set the properties value
				prop.setProperty("id", "Mã");
				prop.setProperty("name", "Tên");
				prop.setProperty("age", "Tuổi");
				prop.setProperty("address", "Địa chỉ");
				prop.setProperty("add", "Thêm");
				prop.setProperty("del", "Xóa");
				prop.setProperty("ins", "Sửa");
				prop.setProperty("fun", "Chức năng");
				// save properties to project root folder
				prop.store(output, null);

			} catch (IOException io) {
				io.printStackTrace();
			} finally {
				if (output != null) {
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		  }
}
