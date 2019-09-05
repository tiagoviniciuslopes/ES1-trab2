package unioeste.geral.common.bo;

import unioeste.geral.common.exception.*;

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
	
	public void validaObjeto() throws NegocioException{
		
		if(super.getNomeCompleto().length() < 2) {
			throw new NegocioException("Nome invalido");
		}
		
		if(cnpj == null) {
			throw new NegocioException("CNPJ invalido");
		}
	}

}
