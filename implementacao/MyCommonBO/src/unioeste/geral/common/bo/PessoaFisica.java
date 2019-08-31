package unioeste.geral.common.bo;
public abstract class PessoaFisica extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String primeiroNome;

	private String nomeMeio;

	private String ultimoNome;

	private CPF cpf;

	private Sexo sexo;

	private DocIdentidade docIdentidade;

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getNomeMeio() {
		return nomeMeio;
	}

	public void setNomeMeio(String nomeMeio) {
		this.nomeMeio = nomeMeio;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public CPF getCpf() {
		return cpf;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public DocIdentidade getDocIdentidade() {
		return docIdentidade;
	}

	public void setDocIdentidade(DocIdentidade docIdentidade) {
		this.docIdentidade = docIdentidade;
	}

}
