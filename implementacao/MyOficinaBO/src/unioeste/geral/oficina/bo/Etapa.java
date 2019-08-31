package unioeste.geral.oficina.bo;

import java.io.Serializable;

public class Etapa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idEtapa;

	private String descricao;

	public int getIdEtapa() {
		return idEtapa;
	}

	public void setIdEtapa(int idEtapa) {
		this.idEtapa = idEtapa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
