package di;

import modal.di.PayService;

public class PayCash implements PayService{

	@Override
	public void methodPay(String soTien) {
		System.out.println("Thanh toán bằng tiền mặt với số tiền là : " + soTien);
	}

}
