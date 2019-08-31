package unioeste.geral.common.bo;

import java.io.Serializable;

public class DDD implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idDDD;

	private int numero;

	public int getIdDDD() {
		return idDDD;
	}

	public void setIdDDD(int idDDD) {
		this.idDDD = idDDD;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
