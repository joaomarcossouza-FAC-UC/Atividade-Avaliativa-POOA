package singleton;

public class RelatorioSingleton {
	private static RelatorioSingleton instancia;
	
	private double valorTotalVendido = 0;
	private int quantidadeTotalItens = 0;
	private String produtoMaisVendido = "";
	private int maiorQuantidade = 0;
	
	private RelatorioSingleton() {}
	
	public static RelatorioSingleton getInstance() {
		if(instancia==null) {
			instancia = new RelatorioSingleton();
		}return instancia;
	}
	
	//fazer uma sincronização para as threads serem acumuladas com synchronized
		public synchronized void adicionarDados(String produto, double valor, int quantidade) {
			valorTotalVendido += valor * quantidade;
			quantidadeTotalItens += quantidade;
			if(quantidade >  maiorQuantidade) {
				maiorQuantidade = quantidade;
				produtoMaisVendido = produto;
			}
		}

		
		public void exibirRelatorio() {
			System.out.println("\n===== RELATÓRIO FINAL =====");
			System.out.println("Valor total vendido: R$ "+String.format("%.2f", valorTotalVendido));
			System.out.println("Quantidade total de itens: "+ quantidadeTotalItens);
			System.out.println("Produto mais vendido: "+ produtoMaisVendido);
		}
		
		
	
	
}
