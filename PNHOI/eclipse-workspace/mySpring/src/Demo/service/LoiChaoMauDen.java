package Demo.service;

import Demo.di.ClientLoiChao;
import Demo.di.SendLoiChao;

public class LoiChaoMauDen implements ClientLoiChao{
	private SendLoiChao sendLoiChao;
	@Override
	public void setSendLoiChao(SendLoiChao sendLoiChao) {
		this.sendLoiChao  = sendLoiChao;
	}

	@Override
	public void xuatLoiChao() {
		System.out.println(sendLoiChao.loiChao());
	}

}
