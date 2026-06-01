package app;

import java.util.List;

import model.Venda;
import service.LeitorCSV;
import service.RelatorioService;
import singleton.RelatorioSingleton;

public class Main {
	

	public static void main(String[] args) {
		
		//caminho do arquivo
		String caminho = "src/dados/vendas.CSV";
		
		
		
		// leitura do arquivo
        System.out.println("Lendo arquivo...");
        LeitorCSV leitor = new LeitorCSV(caminho);
        List<Venda> vendas = leitor.lerArquivos();
        System.out.println("Total de vendas carregadas: " + vendas.size());
        

        // Processar as vendas com as threads
        System.out.println("\nIniciando processamento paralelo...");
        RelatorioService service = new RelatorioService();
        try {
            service.processarAsThreads(vendas);
        } catch (InterruptedException e) {
            System.out.println(" processamento apresenta falhas: " + e.getMessage());
        }

        // 3. Exibe o relatório final via Singleton
        RelatorioSingleton.getInstance().exibirRelatorio();
	}

}
