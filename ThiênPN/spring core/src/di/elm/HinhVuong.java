package di.elm;


public class HinhVuong extends HinhChuNhat{
   public HinhVuong(double canh) {
	   super(canh,canh);
   }
   
//public HinhChuNhat getChuNhat() {
//	return chuNhat;
//}
//
//public void setChuNhat(HinhChuNhat chuNhat) {
//	this.chuNhat = chuNhat;
//}
   public void hv() {
	System.out.println("hình vuông");
	super.xuat();
}

}
