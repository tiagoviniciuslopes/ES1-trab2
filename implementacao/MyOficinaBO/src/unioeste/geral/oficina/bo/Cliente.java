package unioeste.geral.oficina.bo;

import java.io.Serializable;

public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Veiculo[] veiculo;

	private OrdemServico[] ordemServico;

	private ClienteEmpresa clienteEmpresa;

	private ClientePessoa clientePessoa;
	
	public Veiculo[] getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo[] veiculo) {
		this.veiculo = veiculo;
	}

	public OrdemServico[] getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico[] ordemServico) {
		this.ordemServico = ordemServico;
	}

	public ClienteEmpresa getClienteEmpresa() {
		return clienteEmpresa;
	}

	public void setClienteEmpresa(ClienteEmpresa clienteEmpresa) {
		this.clienteEmpresa = clienteEmpresa;
	}

	public ClientePessoa getClientePessoa() {
		return clientePessoa;
	}

	public void setClientePessoa(ClientePessoa clientePessoa) {
		this.clientePessoa = clientePessoa;
	}
	
	public boolean isPessoa() {
		if(clienteEmpresa == null && clientePessoa != null) return true;
		return false;
	}
	
	public boolean isEmpresa() {
		if(clienteEmpresa == null && clientePessoa != null) return false;
		return true;
	}


}
