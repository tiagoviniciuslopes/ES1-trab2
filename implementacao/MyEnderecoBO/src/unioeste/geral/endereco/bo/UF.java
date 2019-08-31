package unioeste.geral.endereco.bo;

import java.io.Serializable;

public class UF implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idUF;

	private String sigla;

	private String nome;

	private Pais pais;

	public int getIdUF() {
		return idUF;
	}

	public void setIdUF(int idUF) {
		this.idUF = idUF;
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
