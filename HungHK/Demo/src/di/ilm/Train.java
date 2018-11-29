package di.ilm;

import di.PhuongTien;

public class Train implements PhuongTien {

	@Override
	public void move() {
		System.out.println("Move by train");
	}
	
}
