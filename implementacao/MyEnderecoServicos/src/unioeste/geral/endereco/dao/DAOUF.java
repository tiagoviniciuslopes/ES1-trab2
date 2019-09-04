package unioeste.geral.endereco.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.endereco.bo.Pais;
import unioeste.geral.endereco.bo.UF;

public class DAOUF {

	public UF obterUFPorId(UF uf, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM UF WHERE idUF = "+uf.getIdUF()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		uf.setNome(result.getString("nomeUF"));
		uf.setIdUF(result.getInt("idUF"));
		uf.setSigla(result.getString("siglaUF"));
		Pais pais = new Pais();
		pais.setIdPais(result.getInt("idPais"));
		uf.setPais(pais);
		
		return uf;
	}
	
	public ArrayList<UF> obterTodosUFs(SQLConnector connector) throws Exception{
		ArrayList<UF> uf = new ArrayList<UF>();
		
		String query = "SELECT * FROM UF;";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			UF uf_aux = new UF();
			
			uf_aux.setNome(result.getString("nomeUF"));
			uf_aux.setIdUF(result.getInt("idUF"));
			uf_aux.setSigla(result.getString("siglaUF"));
			Pais pais = new Pais();
			pais.setIdPais(result.getInt("idPais"));
			uf_aux.setPais(pais);
			
			uf.add(uf_aux);
		}
		
		return uf;
	}
	
}
