package unioeste.geral.common.bo;
import java.io.Serializable;

public abstract class Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idPessoa;

	private String nomeCompleto;

	private String nomeAbreviado;

	private String caminhoFoto;

	private String descricaoFoto;

	private Email[] email;

	private Fone[] fone;

	private EnderecoEspecifico enderecoEspecifico;

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeAbreviado() {
		return nomeAbreviado;
	}

	public void setNomeAbreviado(String nomeAbreviado) {
		this.nomeAbreviado = nomeAbreviado;
	}

	public String getCaminhoFoto() {
		return caminhoFoto;
	}

	public void setCaminhoFoto(String caminhoFoto) {
		this.caminhoFoto = caminhoFoto;
	}

	public String getDescricaoFoto() {
		return descricaoFoto;
	}

	public void setDescricaoFoto(String descricaoFoto) {
		this.descricaoFoto = descricaoFoto;
	}

	public Email[] getEmail() {
		return email;
	}

	public void setEmail(Email[] email) {
		this.email = email;
	}

	public Fone[] getFone() {
		return fone;
	}

	public void setFone(Fone[] fone) {
		this.fone = fone;
	}

	public EnderecoEspecifico getEnderecoEspecifico() {
		return enderecoEspecifico;
	}

	public void setEnderecoEspecifico(EnderecoEspecifico enderecoEspecifico) {
		this.enderecoEspecifico = enderecoEspecifico;
	}

}
