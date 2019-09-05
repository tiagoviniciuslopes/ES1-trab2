package unioeste.geral.oficina.dao;

import java.sql.ResultSet;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.common.bo.CNPJ;
import unioeste.geral.common.bo.CPF;
import unioeste.geral.common.bo.DocIdentidade;
import unioeste.geral.common.bo.EnderecoEspecifico;
import unioeste.geral.common.bo.Sexo;
import unioeste.geral.endereco.bo.Endereco;
import unioeste.geral.oficina.bo.Cliente;
import unioeste.geral.oficina.bo.ClienteEmpresa;
import unioeste.geral.oficina.bo.ClientePessoa;

public class DAOCliente {

	public Cliente obterClientePorCpf(Cliente cliente, SQLConnector connector) throws Exception{
		ClientePessoa cp = cliente.getClientePessoa();
		
		String query = "SELECT * FROM Cliente WHERE cpf = '" + cp.getCpf() + "';";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		cp.setCaminhoFoto(result.getString("caminhoFoto"));
		CPF cpf = new CPF();
		cpf.setNumeroDoc(result.getString("cpf"));
		cp.setCpf(cpf);
		cp.setDescricaoFoto(result.getString("descricaoFoto"));
		DocIdentidade docIdentidade = new DocIdentidade();
		docIdentidade.setNumeroDoc(result.getString("numeroDoc"));
		docIdentidade.setDataExpedicao(result.getString("dataExpedicao"));
		cp.setDocIdentidade(docIdentidade);
		EnderecoEspecifico enderecoEspecifico = new EnderecoEspecifico();
		enderecoEspecifico.setNumero(result.getInt("numero"));
		enderecoEspecifico.setComplemento(result.getString("complemento"));
		Endereco endereco = new Endereco();
		endereco.setIdEndereco(result.getInt("idEndereco"));
		enderecoEspecifico.setEndereco(endereco);
		cp.setEnderecoEspecifico(enderecoEspecifico);
		cp.setIdPessoa(result.getInt("idCliente"));
		cp.setNomeAbreviado(result.getString("nomeAbreviadoCliente"));
		//cp.setNomeCompleto(result.getString("nomeCompletoCliente"));
		cp.setNomeMeio(result.getString("nomeMeioCliente"));
		cp.setPrimeiroNome(result.getString("primeiroNomeCliente"));
		cp.setUltimoNome(result.getString("ultimoNomeCliente"));
		Sexo sexo = new Sexo();
		sexo.setIdSexo(result.getInt("idSexo"));
		cp.setSexo(sexo);
		
		cliente.setClientePessoa(cp);
		
		return cliente;
	}
	
	public Cliente obterClientePorCnpj(Cliente cliente, SQLConnector connector) throws Exception{
		ClienteEmpresa ce = cliente.getClienteEmpresa();
		
		String query = "SELECT * FROM Cliente WHERE cnpj= '" + ce.getCnpj() + "';";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		ce.setCaminhoFoto(result.getString("caminhoFoto"));
		CNPJ cnpj = new CNPJ();
		cnpj.setNumeroDoc(result.getString("cnpj"));
		ce.setCnpj(cnpj);
		ce.setDescricaoFoto(result.getString("descricaoFoto"));
		/*DocIdentidade docIdentidade = new DocIdentidade();
		docIdentidade.setNumeroDoc(result.getString("numeroDoc"));
		docIdentidade.setDataExpedicao(result.getString("dataExpedicao"));
		ce.setDocIdentidade(docIdentidade);*/
		EnderecoEspecifico enderecoEspecifico = new EnderecoEspecifico();
		enderecoEspecifico.setNumero(result.getInt("numero"));
		enderecoEspecifico.setComplemento(result.getString("complemento"));
		Endereco endereco = new Endereco();
		endereco.setIdEndereco(result.getInt("idEndereco"));
		enderecoEspecifico.setEndereco(endereco);
		ce.setEnderecoEspecifico(enderecoEspecifico);
		ce.setIdPessoa(result.getInt("idCliente"));
		ce.setNomeAbreviado(result.getString("nomeAbreviadoCliente"));
		ce.setNomeCompleto(result.getString("primeiroNomeCliente"));
		/*cp.setNomeMeio(result.getString("nomeMeioCliente"));
		cp.setPrimeiroNome(result.getString("primeiroNomeCliente"));
		cp.setUltimoNome(result.getString("ultimoNomeCliente"));
		Sexo sexo = new Sexo();
		sexo.setIdSexo(result.getInt("idSexo"));
		cp.setSexo(sexo);*/
		
		cliente.setClienteEmpresa(ce);
		
		return cliente;
	}
	
	public Cliente obterClientePorId(Cliente cliente, SQLConnector connector) throws Exception{
		
		cliente = obterClientePorCpf(cliente, connector);
		ClientePessoa cp = cliente.getClientePessoa();
		cliente = obterClientePorCnpj(cliente, connector);
		cliente.setClientePessoa(cp);
		
		return cliente;
	}
	
	public void inserirClientePessoa(Cliente c, SQLConnector connector) throws Exception{
		
		ClientePessoa cp = c.getClientePessoa();
		
		String query = "INSERT INTO Cliente (caminhoFoto,cpf,descricaoFoto,numeroDoc,dataExpedicao"
				+ "numero,complemento,idEndereco,nomeAbreviadoCliente,nomeMeioCliente"
				+ "primeiroNomeCliente,ultimoNomeCliente,idSexo) VALUES ('"+cp.getCaminhoFoto()+"',"
				+ "'"+cp.getCpf().getNumeroDoc()+"','"+cp.getDescricaoFoto()+"','"+cp.getDocIdentidade().getNumeroDoc()+"','"
				+ cp.getDocIdentidade().getSQLData() + "'," + cp.getEnderecoEspecifico().getNumero() + ",'"+ cp.getEnderecoEspecifico().getComplemento() +"',"
				+ cp.getEnderecoEspecifico().getEndereco().getIdEndereco() +",'"+ cp.getNomeAbreviado() +"',"
				+ "'"+ cp.getNomeMeio() +"', '"+cp.getPrimeiroNome()+"','"+cp.getUltimoNome()+"',"+cp.getSexo().getIdSexo()+");";
		
		connector.executeUpdate(query);
		
	}
	
	public void inserirClienteEmpresa(Cliente c, SQLConnector connector) throws Exception{
		
		ClienteEmpresa ce = c.getClienteEmpresa();
		
		String query = "INSERT INTO Cliente (caminhoFoto,cnpj,descricaoFoto,"
				+ "numero,complemento,idEndereco,"
				+ "primeiroNomeCliente) VALUES ('"+ce.getCaminhoFoto()+"',"
				+ "'"+ce.getCnpj().getNumeroDoc()+"','"+ce.getDescricaoFoto()+"',"
				+ ce.getEnderecoEspecifico().getNumero() + ",'"+ ce.getEnderecoEspecifico().getComplemento() +"',"
				+ ce.getEnderecoEspecifico().getEndereco().getIdEndereco() +", '"+ce.getNomeCompleto()+"');";
		
		connector.executeUpdate(query);
		
	}
	
}
