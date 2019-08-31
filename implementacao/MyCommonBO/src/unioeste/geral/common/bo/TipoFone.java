package unioeste.geral.common.bo;

import java.io.Serializable;

public class TipoFone implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idTipoFone;

	private String sigla;

	private String descricao;

	public int getIdTipoFone() {
		return idTipoFone;
	}

	public void setIdTipoFone(int idTipoFone) {
		this.idTipoFone = idTipoFone;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
