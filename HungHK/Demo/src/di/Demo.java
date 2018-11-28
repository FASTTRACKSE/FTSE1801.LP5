package di;

import di.ilm.Car;
import di.ilm.Train;

public class Demo {
	public static void main(String[] args) {
		PhuongTien phuongTien = new Car();
		phuongTien.move();
		
		PhuongTien phuongTien2 = new Train();
		phuongTien2.move();
		
		Travel travel = new Travel(phuongTien);
		travel.khoiHanh();
	}
}
