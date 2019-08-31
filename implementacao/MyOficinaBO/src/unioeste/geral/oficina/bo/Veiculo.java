package unioeste.geral.oficina.bo;

import java.io.Serializable;

public class Veiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idVeiculo;

	private String nomeVeiculo;

	private String modelo;

	private String marca;

	private int kmVeiculo;

	private Placa placa;

	private OrdemServico[] ordemServico;

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getNomeVeiculo() {
		return nomeVeiculo;
	}

	public void setNomeVeiculo(String nomeVeiculo) {
		this.nomeVeiculo = nomeVeiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getKmVeiculo() {
		return kmVeiculo;
	}

	public void setKmVeiculo(int kmVeiculo) {
		this.kmVeiculo = kmVeiculo;
	}

	public Placa getPlaca() {
		return placa;
	}

	public void setPlaca(Placa placa) {
		this.placa = placa;
	}

	public OrdemServico[] getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico[] ordemServico) {
		this.ordemServico = ordemServico;
	}

}
