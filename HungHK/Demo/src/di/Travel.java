package di;

public class Travel {
	PhuongTien pt;
	
	public Travel(PhuongTien pt) {
		this.pt = pt;
	}
	
	void khoiHanh() {
		pt.move();
	}
}
