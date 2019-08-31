package unioeste.geral.endereco.bo;

import java.io.Serializable;

public class Cidade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idCidade;

	private String nome;

	private UF uf;
	
	public int getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	

}
