package unioeste.geral.common.bo;

import java.io.Serializable;

public class Sexo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idSexo;

	private String sigla;

	private String descricao;

	public int getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(int idSexo) {
		this.idSexo = idSexo;
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
