package unioeste.geral.endereco.bo;

import java.io.Serializable;

import unioeste.geral.endereco.exception.EnderecoException;

public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idEndereco;

	private String cep;

	private Bairro bairro;

	private Logradouro logradouro;

	private Cidade cidade;

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public void validaObjeto() throws Exception{
		if(cep.length() != 8) {
			throw new EnderecoException("CEP invalido");
		}
		if(bairro == null) {
			throw new EnderecoException("Bairro invalido");
		}
		if(cidade == null) {
			throw new EnderecoException("Cidade invalida");
		}
		if(logradouro == null) {
			throw new EnderecoException("Logradouro invalido");
		}
		
		
	}

}
