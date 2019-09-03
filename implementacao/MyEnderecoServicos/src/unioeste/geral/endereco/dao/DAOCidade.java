package unioeste.geral.endereco.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOCidade {
	
	public ColCidade obterCidadePorId(ColCidade cidade, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM Cidade WHERE idCidade = "+cidade.getIdCidade()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		cidade.setNome(result.getString("nomeCidade"));
		cidade.setIdCidade(result.getInt("idCidade"));
		UF uf = new UF();
		uf.setIdUF(result.getInt("idUF"));
		cidade.setUF(uf);
		
		return cidade;
	}
	
	public ArrayList<ColCidade> obterTodasCidades(SQLConnector connector) throws Exception{
		ArrayList<ColCidade> cidade = new ArrayList<ColCidade>();
		
		String query = "SELECT * FROM Cidade;";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			ColCidade c = new ColCidade();
			
			c.setNome(result.getString("nomeCidade"));
			c.setIdCidade(result.getInt("idCidade"));
			UF uf = new UF();
			uf.setIdUF(result.getInt("idUF"));
			c.setUF(uf);
			
			cidade.add(c);
		}
		
		return cidade;
	}
}
