package unioeste.geral.oficina.bo;

import java.io.Serializable;

public class Servico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idServico;

	private float precoBase;

	private String nome;

	private float horasBase;

	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}

	public float getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(float precoBase) {
		this.precoBase = precoBase;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getHorasBase() {
		return horasBase;
	}

	public void setHorasBase(float horasBase) {
		this.horasBase = horasBase;
	}

}
