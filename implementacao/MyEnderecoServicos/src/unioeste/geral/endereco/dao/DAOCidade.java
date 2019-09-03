package unioeste.geral.endereco.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.endereco.bo.Cidade;
import unioeste.geral.endereco.bo.UF;

public class DAOCidade {
	
	public Cidade obterCidadePorId(Cidade cidade, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM Cidade WHERE idCidade = "+cidade.getIdCidade()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		cidade.setNome(result.getString("nomeCidade"));
		cidade.setIdCidade(result.getInt("idCidade"));
		UF uf = new UF();
		uf.setIdUF(result.getInt("idUF"));
		cidade.setUf(uf);
		
		return cidade;
	}
	
	public ArrayList<Cidade> obterTodasCidades(SQLConnector connector) throws Exception{
		ArrayList<Cidade> cidade = new ArrayList<Cidade>();
		
		String query = "SELECT * FROM Cidade;";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			Cidade c = new Cidade();
			
			c.setNome(result.getString("nomeCidade"));
			c.setIdCidade(result.getInt("idCidade"));
			UF uf = new UF();
			uf.setIdUF(result.getInt("idUF"));
			c.setUf(uf);
			
			cidade.add(c);
		}
		
		return cidade;
	}
}
