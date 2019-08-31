package unioeste.geral.oficina.bo;

import java.io.Serializable;

public class OrdemServico_Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private float precoProduto;

	private int quantidadeProduto;

	private float total;

	private Produto produto;

	public float getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(float precoProduto) {
		this.precoProduto = precoProduto;
	}

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
