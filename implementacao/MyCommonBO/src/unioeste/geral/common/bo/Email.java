package unioeste.geral.common.bo;

import java.io.Serializable;

public class Email implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idEmail;

	private String descricao;

	public int getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(int idEmail) {
		this.idEmail = idEmail;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
