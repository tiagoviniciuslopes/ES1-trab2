package unioeste.geral.oficina.dao;

import java.sql.ResultSet;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.common.bo.CPF;
import unioeste.geral.common.bo.DocIdentidade;
import unioeste.geral.common.bo.EnderecoEspecifico;
import unioeste.geral.common.bo.OrgaoExpeditor;
import unioeste.geral.common.bo.Sexo;
import unioeste.geral.endereco.bo.Endereco;
import unioeste.geral.oficina.bo.Funcionario;

public class DAOFuncionario {

	public Funcionario obterFuncionarioPorCpf(Funcionario f, SQLConnector connector) throws Exception{
		
		String query = "SELECT * FROM Funcionario WHERE cpf = '" + f.getCpf() + "';";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		f.setCaminhoFoto(result.getString("caminhoFoto"));
		CPF cpf = new CPF();
		cpf.setNumeroDoc(result.getString("cpf"));
		f.setCpf(cpf);
		f.setDescricaoFoto(result.getString("descricaoFoto"));
		DocIdentidade docIdentidade = new DocIdentidade();
		docIdentidade.setNumeroDoc(result.getString("numeroDoc"));
		OrgaoExpeditor orgaoExpeditor = new OrgaoExpeditor();
		orgaoExpeditor.setIdOrgaoExpeditor(result.getInt("idOrgaoExpeditor"));
		docIdentidade.setOrgaoExpeditor(orgaoExpeditor);
		f.setDocIdentidade(docIdentidade);
		EnderecoEspecifico enderecoEspecifico = new EnderecoEspecifico();
		enderecoEspecifico.setNumero(result.getInt("numero"));
		enderecoEspecifico.setComplemento(result.getString("complemento"));
		Endereco endereco = new Endereco();
		endereco.setIdEndereco(result.getInt("idEndereco"));
		enderecoEspecifico.setEndereco(endereco);
		f.setEnderecoEspecifico(enderecoEspecifico);
		f.setIdPessoa(result.getInt("idFuncionario"));
		f.setNomeAbreviado(result.getString("nomeAbreviadoPessoa"));
		//cp.setNomeCompleto(result.getString("nomeCompletoFuncionario"));
		f.setNomeMeio(result.getString("nomeMeioFuncionario"));
		f.setPrimeiroNome(result.getString("primeiroNomeFuncionario"));
		f.setUltimoNome(result.getString("ultimoNomeFuncionario"));
		Sexo sexo = new Sexo();
		sexo.setIdSexo(result.getInt("idSexo"));
		f.setSexo(sexo);
		
		return f;
	}
	
	public Funcionario obterFuncionarioPorId(Funcionario f, SQLConnector connector) throws Exception{
		
		String query = "SELECT * FROM Funcionario WHERE idFuncionario = '" + f.getIdPessoa() + "';";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		f.setCaminhoFoto(result.getString("caminhoFoto"));
		CPF cpf = new CPF();
		cpf.setNumeroDoc(result.getString("cpf"));
		f.setCpf(cpf);
		f.setDescricaoFoto(result.getString("descricaoFoto"));
		DocIdentidade docIdentidade = new DocIdentidade();
		docIdentidade.setNumeroDoc(result.getString("numeroDoc"));
		docIdentidade.setDataExpedicao(result.getString("dataExpedicao"));
		OrgaoExpeditor orgaoExpeditor = new OrgaoExpeditor();
		orgaoExpeditor.setIdOrgaoExpeditor(result.getInt("idOrgaoExpeditor"));
		docIdentidade.setOrgaoExpeditor(orgaoExpeditor);
		f.setDocIdentidade(docIdentidade);
		EnderecoEspecifico enderecoEspecifico = new EnderecoEspecifico();
		enderecoEspecifico.setNumero(result.getInt("numero"));
		enderecoEspecifico.setComplemento(result.getString("complemento"));
		Endereco endereco = new Endereco();
		endereco.setIdEndereco(result.getInt("idEndereco"));
		enderecoEspecifico.setEndereco(endereco);
		f.setEnderecoEspecifico(enderecoEspecifico);
		f.setIdPessoa(result.getInt("idFuncionario"));
		f.setNomeAbreviado(result.getString("nomeAbreviadoPessoa"));
		//cp.setNomeCompleto(result.getString("nomeCompletoFuncionario"));
		f.setNomeMeio(result.getString("nomeMeioFuncionario"));
		f.setPrimeiroNome(result.getString("primeiroNomeFuncionario"));
		f.setUltimoNome(result.getString("ultimoNomeFuncionario"));
		Sexo sexo = new Sexo();
		sexo.setIdSexo(result.getInt("idSexo"));
		f.setSexo(sexo);
		
		return f;
	}
	
	public void inserirFuncionario(Funcionario f, SQLConnector connector) throws Exception{
		
		String query = "INSERT INTO Funcionario (caminhoFoto,cpf,descricaoFoto,numeroDoc,dataExpedicao,idOrgaoExpeditor"
				+ "numero,complemento,idEndereco,nomeAbreviadoPessoa,nomeMeioFuncionario"
				+ "primeiroNomeFuncionario,ultimoNomeFuncionario,idSexo) VALUES ('"+f.getCaminhoFoto()+"',"
				+ "'"+f.getCpf().getNumeroDoc()+"','"+f.getDescricaoFoto()+"','"+f.getDocIdentidade().getNumeroDoc()+"','"
				+ f.getDocIdentidade().getSQLData() +"'," + f.getDocIdentidade().getOrgaoExpeditor().getIdOrgaoExpeditor() + "," +f.getEnderecoEspecifico().getNumero() + ",'"+ f.getEnderecoEspecifico().getComplemento() +"',"
				+ f.getEnderecoEspecifico().getEndereco().getIdEndereco() +",'"+ f.getNomeAbreviado() +"',"
				+ "'"+ f.getNomeMeio() +"', '"+f.getPrimeiroNome()+"','"+f.getUltimoNome()+"',"+f.getSexo().getIdSexo()+");";
		
		connector.executeUpdate(query);
		
	}
	
}
