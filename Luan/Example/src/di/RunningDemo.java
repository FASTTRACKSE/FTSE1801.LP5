package di;

import modal.di.PayService;
import modal.di.PayServiceInjector;

public class RunningDemo {
	public static void main(String[] args) {
		PayServiceInjector payServiceInjector = null;
		payServiceInjector = new CashServiceInjector();
		payServiceInjector.getConsumer().processPay("20000");
		payServiceInjector = new CreditServiceInjector();
		payServiceInjector.getConsumer().processPay("20000");
		PayService payService =null;
		payService = new PayCash();
		payService.methodPay("10000");
		payService = new PayCredit();
		payService.methodPay("10000");
		
	}
}
