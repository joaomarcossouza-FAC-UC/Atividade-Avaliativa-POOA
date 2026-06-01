package thread;
import service.VendaProcessos;
import java.util.List;
import model.Venda;
	public class VendaThread implements Runnable{
		private List<Venda> vendas;
		private VendaProcessos processos;
		
		public VendaThread(List<Venda> vendas, VendaProcessos processos) {
			this.processos = processos;
			this.vendas = vendas;
		}
	
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+ " processando "+vendas.size()+ " vendas... ");
			processos.processar(vendas);
			System.out.println(Thread.currentThread().getName()+ "finalizado");
			
		}
}
