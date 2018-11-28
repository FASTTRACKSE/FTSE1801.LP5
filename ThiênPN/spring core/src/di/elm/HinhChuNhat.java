
package di.elm;


public class HinhChuNhat{
   private double dai;
   private double rong;

	public HinhChuNhat(double dai, double rong) {
	this.dai = dai;
	this.rong = rong;
}




	public double chuVi() {
		return (dai+rong)*2;
	}

	
	public double dienTich() {
		return dai*rong;
	}
  
public void xuat() {
	System.out.println(chuVi());
	System.out.println(dienTich());
}
  
}
