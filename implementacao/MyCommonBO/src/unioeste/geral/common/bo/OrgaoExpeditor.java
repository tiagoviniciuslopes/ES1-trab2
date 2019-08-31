package unioeste.geral.common.bo;
import java.io.Serializable;

import unioeste.geral.endereco.bo.UF;

public class OrgaoExpeditor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idOrgaoExpeditor;

	private String nomeOrgao;

	private UF uf;

	public int getIdOrgaoExpeditor() {
		return idOrgaoExpeditor;
	}

	public void setIdOrgaoExpeditor(int idOrgaoExpeditor) {
		this.idOrgaoExpeditor = idOrgaoExpeditor;
	}

	public String getNomeOrgao() {
		return nomeOrgao;
	}

	public void setNomeOrgao(String nomeOrgao) {
		this.nomeOrgao = nomeOrgao;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

}
