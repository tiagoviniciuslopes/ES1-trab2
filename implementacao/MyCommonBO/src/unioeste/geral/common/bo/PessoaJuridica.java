package unioeste.geral.common.bo;
public abstract class PessoaJuridica extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String regimeTributario;

	private CNPJ cnpj;

	private AtividadeComercial[] atividadeComercial;

	public String getRegimeTributario() {
		return regimeTributario;
	}

	public void setRegimeTributario(String regimeTributario) {
		this.regimeTributario = regimeTributario;
	}

	public CNPJ getCnpj() {
		return cnpj;
	}

	public void setCnpj(CNPJ cnpj) {
		this.cnpj = cnpj;
	}

	public AtividadeComercial[] getAtividadeComercial() {
		return atividadeComercial;
	}

	public void setAtividadeComercial(AtividadeComercial[] atividadeComercial) {
		this.atividadeComercial = atividadeComercial;
	}

}
