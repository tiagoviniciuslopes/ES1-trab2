package unioeste.geral.common.bo;

import java.io.Serializable;

import unioeste.geral.endereco.bo.Endereco;

public class EnderecoEspecifico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int numero;

	private String complemento;

	private Endereco endereco;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
