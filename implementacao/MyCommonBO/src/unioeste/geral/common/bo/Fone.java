package unioeste.geral.common.bo;

import java.io.Serializable;

public class Fone implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idFone;

	private String numeroTelefone;

	private DDD ddd;

	private DDI ddi;

	private TipoFone tipoFone;

	public int getIdFone() {
		return idFone;
	}

	public void setIdFone(int idFone) {
		this.idFone = idFone;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public DDD getDdd() {
		return ddd;
	}

	public void setDdd(DDD ddd) {
		this.ddd = ddd;
	}

	public DDI getDdi() {
		return ddi;
	}

	public void setDdi(DDI ddi) {
		this.ddi = ddi;
	}

	public TipoFone getTipoFone() {
		return tipoFone;
	}

	public void setTipoFone(TipoFone tipoFone) {
		this.tipoFone = tipoFone;
	}

}
