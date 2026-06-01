package service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import model.Venda;
	public class LeitorCSV {
			private String caminhoDoArquivo;
			
			public LeitorCSV(String caminhoDoArquivo) {
				this.caminhoDoArquivo = caminhoDoArquivo; 
			}
			
			public List<Venda> lerArquivos(){
				List<Venda> vendas = new ArrayList<Venda>();
				try(BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))){
					String linha;
					boolean primeiraLinha = true;
						while((linha = br.readLine())!= null) {
							if(primeiraLinha) {
								primeiraLinha = false;
								continue;
							}
							String[]valores = linha.split(",");
							int id = Integer.parseInt(valores[0].trim());
							String produto = valores[1].trim();
							String categoria = valores[2].trim();
							double valor = Double.parseDouble(valores[3].trim());
							int quantidade = Integer.parseInt(valores[4].trim());
							
							vendas.add(new Venda(id, produto,categoria,valor,quantidade));
						}
				}catch (IOException e) {
					System.out.println("O Arquivo não pode ser Lido:"+ e.getMessage());
				}return vendas;
			}
}
