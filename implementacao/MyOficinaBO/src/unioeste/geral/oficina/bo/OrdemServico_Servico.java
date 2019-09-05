package unioeste.geral.oficina.bo;

import java.io.Serializable;

public class OrdemServico_Servico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idOrdemServico;

	private float precoServico;

	private float horasServico;

	private Servico servico;

	public float getPrecoServico() {
		return precoServico;
	}

	public void setPrecoServico(float precoServico) {
		this.precoServico = precoServico;
	}

	public float getHorasServico() {
		return horasServico;
	}

	public void setHorasServico(float horasServico) {
		this.horasServico = horasServico;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public int getIdOrdemServico() {
		return idOrdemServico;
	}

	public void setIdOrdemServico(int idOrdemServico) {
		this.idOrdemServico = idOrdemServico;
	}

}
