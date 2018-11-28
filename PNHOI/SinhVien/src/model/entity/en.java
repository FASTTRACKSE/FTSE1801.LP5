package model.entity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class en {
	 public static void main(String[] args) {
			
			Properties prop = new Properties();
			OutputStream output = null;

			try {

				output = new FileOutputStream("en.properties");

				// set the properties value
				prop.setProperty("id", "Id");
				prop.setProperty("name", "Name");
				prop.setProperty("age", "Age");
				prop.setProperty("address", "Address");
				prop.setProperty("add", "Add");
				prop.setProperty("del", "Delete");
				prop.setProperty("ins", "Insert");
				prop.setProperty("fun", "Function");
				
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
