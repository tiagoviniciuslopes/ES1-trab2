package unioeste.geral.common.bo;

import java.io.Serializable;

public class AtividadeComercial implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idAtividadeComercial;

	private String descricao;
	
	public int getIdAtividadeComercial() {
		return idAtividadeComercial;
	}

	public void setIdAtividadeComercial(int idAtividadeComercial) {
		this.idAtividadeComercial = idAtividadeComercial;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	

}
