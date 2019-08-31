package unioeste.geral.common.bo;

import java.io.Serializable;

public class CNPJ implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numeroDoc;

	public String getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

}
