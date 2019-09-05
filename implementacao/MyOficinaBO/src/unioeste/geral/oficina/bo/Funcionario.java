package unioeste.geral.oficina.bo;

import unioeste.geral.common.bo.PessoaFisica;

public class Funcionario extends PessoaFisica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private OrdemServico[] ordemServico;

	public OrdemServico[] getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico[] ordemServico) {
		this.ordemServico = ordemServico;
	}

}
