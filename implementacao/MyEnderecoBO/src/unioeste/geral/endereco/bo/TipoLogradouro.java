package unioeste.geral.endereco.bo;

import java.io.Serializable;

public class TipoLogradouro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idTipoLogradouro;

	private String siglaTipo;

	private String descricaoTipo;

	public int getIdTipoLogradouro() {
		return idTipoLogradouro;
	}

	public void setIdTipoLogradouro(int idTipoLogradouro) {
		this.idTipoLogradouro = idTipoLogradouro;
	}

	public String getSiglaTipo() {
		return siglaTipo;
	}

	public void setSiglaTipo(String siglaTipo) {
		this.siglaTipo = siglaTipo;
	}

	public String getDescricaoTipo() {
		return descricaoTipo;
	}

	public void setDescricaoTipo(String descricaoTipo) {
		this.descricaoTipo = descricaoTipo;
	}

}
