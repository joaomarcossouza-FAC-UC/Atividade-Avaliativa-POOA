package factory;

import service.VendaProcessos;

public class ProcessosVendaFactory extends ProcessosFactory{

	@Override
	public VendaProcessos criarProcessamento() {
		return new VendaProcessos();
	}
	
	
}
