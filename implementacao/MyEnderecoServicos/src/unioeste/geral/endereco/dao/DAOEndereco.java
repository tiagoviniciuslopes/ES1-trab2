package unioeste.geral.endereco.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOEndereco {

	public Endereco obterEnderecoPorId(Endereco endereco, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM Endereco WHERE idEndereco = "+endereco.getIdEndereco()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		endereco.setCep(result.getString("cep"));
		endereco.setIdEndereco(result.getInt("idEndereco"));
		
		ColCidade cidade = new ColCidade();
		Bairro bairro = new Bairro();
		Logradouro logradouro = new Logradouro();
		
		cidade.setIdCidade(result.getInt("idCidade"));
		bairro.setIdBairro(result.getInt("idBairro"));
		logradouro.setIdLogradouro(result.getInt("idLogradouro"));
		
		endereco.setCidade(cidade);
		endereco.setBairro(bairro);
		endereco.setLogradouro(logradouro);
		
		return endereco;
	}
	
	public ArrayList<Endereco> obterEnderecoPorCep(Endereco endereco, SQLConnector connector) throws Exception{
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		
		String query = "SELECT * FROM Endereco WHERE cep = "+endereco.getCep()+";";
		ResultSet result = connector.executeQuery(query);
		
		while(result.next()) {
			Endereco e = new Endereco();
					
			e.setCep(result.getString("cep"));
			e.setIdEndereco(result.getInt("idEndereco"));
			
			ColCidade cidade = new ColCidade();
			Bairro bairro = new Bairro();
			Logradouro logradouro = new Logradouro();
			
			cidade.setIdCidade(result.getInt("idCidade"));
			bairro.setIdBairro(result.getInt("idBairro"));
			logradouro.setIdLogradouro(result.getInt("idLogradouro"));
			
			e.setCidade(cidade);
			e.setBairro(bairro);
			e.setLogradouro(logradouro);
			
			enderecos.add(e);
		}
		
		return enderecos;
	}
	
}
