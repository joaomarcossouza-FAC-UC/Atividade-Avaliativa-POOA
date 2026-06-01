package model;
	public class Venda {
		private String orderId;
		private String produto;
		private String categoria;
		private double valor;
		private int quantidade;
		private String cidade;
		private String data;
		
		public Venda(String orderId,String produto,String categoria,double valor,int quantidade,String data,String cidade) {
			this.categoria = categoria;
			this.orderId = orderId;
			this.produto = produto;
			this.quantidade = quantidade;
			this.valor = valor;
			this.cidade = cidade;
			this.data = data;
		}

		public String getProduto() {
			return produto;
		}

		public void setProduto(String produto) {
			this.produto = produto;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public double getValor() {
			return valor;
		}

		public void setValor(double valor) {
			this.valor = valor;
		}

		public int getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		
		public String getOrderId() {
			return orderId;
		}

		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Venda [OrderId=" + orderId + ", produto=" + produto + ", categoria=" + categoria + ", valor="
					+ valor + ", quantidade=" + quantidade + ", cidade=" + cidade + ", data=" + data + "]";
		}

	
}
