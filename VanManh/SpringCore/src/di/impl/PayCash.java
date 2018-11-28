package di.impl;

import di.PayService;

public class PayCash implements PayService{

	@Override
	public String methodPay() {
		return"Thanh toán bằng tiền mặt";
	}

}
