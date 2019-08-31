package unioeste.geral.oficina.bo;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrdemServico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idOrdemServico;

	private float precoTotal;

	private int horasTotal;

	private Date data;

	private String observacoes;

	private Etapa etapa;

	private OrdemServico_Servico[] ordemServico_Servico;

	private OrdemServico_Produto[] ordemServico_Produto;
	
	private Funcionario funcionario;
	
	private Veiculo veiculo;

	public int getIdOrdemServico() {
		return idOrdemServico;
	}

	public void setIdOrdemServico(int idOrdemServico) {
		this.idOrdemServico = idOrdemServico;
	}

	public float getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(float precoTotal) {
		this.precoTotal = precoTotal;
	}

	public int getHorasTotal() {
		return horasTotal;
	}

	public void setHorasTotal(int horasTotal) {
		this.horasTotal = horasTotal;
	}

	public String getSQLData() {
		if (data == null)
			return "null";
		SimpleDateFormat stringify = new SimpleDateFormat("yyyy-MM-dd");
		return "'" + stringify.format(data) + "'";
	}
	public String getStringData() {
		SimpleDateFormat stringify = new SimpleDateFormat("dd/MM/yyyy");
		return stringify.format(data);
	}
	public boolean setData(String data) {
		String format = "dd/MM/yyyy";
		if (data.indexOf("-") != -1) {
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat parser = new SimpleDateFormat(format);
		try {
			this.data = parser.parse(data);
			return true;
		} catch (Exception exception) {
			return false;
		}
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	public OrdemServico_Servico[] getOrdemServico_Servico() {
		return ordemServico_Servico;
	}

	public void setOrdemServico_Servico(OrdemServico_Servico[] ordemServico_Servico) {
		this.ordemServico_Servico = ordemServico_Servico;
	}

	public OrdemServico_Produto[] getOrdemServico_Produto() {
		return ordemServico_Produto;
	}

	public void setOrdemServico_Produto(OrdemServico_Produto[] ordemServico_Produto) {
		this.ordemServico_Produto = ordemServico_Produto;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
