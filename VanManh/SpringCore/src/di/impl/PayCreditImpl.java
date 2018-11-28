package di.impl;

import di.PayService;
import di.PayServiceInjector;

public class PayCreditImpl implements PayServiceInjector{
	private PayService payService;
	@Override
	public void setPayService(PayService payService) {
		this.payService = payService;
	}

	@Override
	public void hienThi() {
		System.out.println(payService.methodPay());
	}

}
