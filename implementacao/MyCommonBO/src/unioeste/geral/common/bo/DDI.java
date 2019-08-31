package unioeste.geral.common.bo;

import java.io.Serializable;

public class DDI implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idDDI;

	private int numero;

	public int getIdDDI() {
		return idDDI;
	}

	public void setIdDDI(int idDDI) {
		this.idDDI = idDDI;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
