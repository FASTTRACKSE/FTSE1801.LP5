package di.ilm;

import di.PhuongTien;

public class Car implements PhuongTien {

	@Override
	public void move() {
		System.out.println("Move by car");
	}
	
}
