package di.impl;

import di.PayService;

public class PayCredit implements PayService{

	@Override
	public String methodPay() {
		return"Thanh toán bằng thẻ";
	}

}
