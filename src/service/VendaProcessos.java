package service;
import java.util.List;
import model.Venda;
import singleton.RelatorioSingleton;
	public class VendaProcessos {
		public void processar(List<Venda> vendas) {
			RelatorioSingleton relatorio = RelatorioSingleton.getInstance();
			for(Venda venda: vendas) {
				relatorio.adicionarDados(venda.getProduto(), venda.getValor(), venda.getQuantidade());
			}
		}
}
