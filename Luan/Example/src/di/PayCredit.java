package di;

import modal.di.PayService;

public class PayCredit implements PayService{

	@Override
	public void methodPay(String soTien) {
		System.out.println("Thanh toán bằng thẻ với số tiền là : " + soTien);
	}

}
