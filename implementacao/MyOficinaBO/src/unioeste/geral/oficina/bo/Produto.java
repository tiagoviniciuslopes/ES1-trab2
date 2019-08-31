package unioeste.geral.oficina.bo;

import java.io.Serializable;

public class Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idProduto;

	private String nome;

	private float precoBase;

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(float precoBase) {
		this.precoBase = precoBase;
	}

}
