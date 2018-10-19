package di;

import modal.di.Consumer;
import modal.di.PayServiceInjector;

public class CreditServiceInjector implements PayServiceInjector{

	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new PayCredit());
	}

}
