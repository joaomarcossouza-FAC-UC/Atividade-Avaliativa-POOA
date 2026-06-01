package service;
import java.util.ArrayList;
import java.util.List;
import factory.ProcessosVendaFactory;
import model.Venda;
import thread.VendaThread;
	public class RelatorioService {
			//serão 4 threads
			private static final int NUM_THREADS = 4;
			
			//processar as vendas separadamente
			public void processarAsThreads(List<Venda> vendas) throws InterruptedException{
				int tamanhoBlocos = (int) Math.ceil((double)vendas.size()/NUM_THREADS);
				List<Thread> threads = new ArrayList<>();
				
				
				for(int i = 0; i < NUM_THREADS; i++) {
					//inicio e fim do bloco
					int inicio = i*tamanhoBlocos;
					int fim = Math.min(inicio + tamanhoBlocos,vendas.size());
					//evita criar threads vazias
					if(inicio >= vendas.size()) break;
					//pega o bloco da thread
					List<Venda> bloco = vendas.subList(inicio, fim);
					//cria o processo com o Factory
					VendaProcessos processo = new ProcessosVendaFactory().criarProcessamento();
					
					//iniciar a thread
					Thread thread = new Thread(new VendaThread(bloco, processo));
					threads.add(thread);
					thread.start();
				}
				//espera as threads acabar
				for(Thread thread: threads) {
					thread.join();
				}
			}
}
