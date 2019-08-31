package unioeste.geral.endereco.bo;

import java.io.Serializable;

public class Pais implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idPais;

	private String sigla;

	private String nome;

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
