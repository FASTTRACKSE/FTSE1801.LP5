package di;

import modal.di.Consumer;
import modal.di.PayService;

public class MyDIApplication implements Consumer{
	private PayService payService;
	
	public MyDIApplication(PayService payService) {
		this.payService = payService;
	}
	@Override
	public void processPay(String soTien) {
		this.payService.methodPay(soTien);
	}

}
