package unioeste.geral.endereco.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.endereco.bo.Logradouro;
import unioeste.geral.endereco.bo.TipoLogradouro;

public class DAOLogradouro {

	public Logradouro obterLogradouroPorId(Logradouro logradouro, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM Logradouro WHERE idLogradouro = "+logradouro.getIdLogradouro()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		logradouro.setNome(result.getString("nomeLogradouro"));
		logradouro.setIdLogradouro(result.getInt("idLogradouro"));
		TipoLogradouro tl = new TipoLogradouro();
		tl.setIdTipoLogradouro(result.getInt("idTipoLogradouro"));
		logradouro.setTipoLogradouro(tl);
		
		return logradouro;
	}
	
	public ArrayList<Logradouro> obterTodosLogradouros(SQLConnector connector) throws Exception{
		ArrayList<Logradouro> logradouro = new ArrayList<Logradouro>();
		
		String query = "SELECT * FROM Logradouro;";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			Logradouro l = new Logradouro();
			
			l.setNome(result.getString("nomeLogradouro"));
			l.setIdLogradouro(result.getInt("idLogradouro"));
			TipoLogradouro tl = new TipoLogradouro();
			tl.setIdTipoLogradouro(result.getInt("idTipoLogradouro"));
			l.setTipoLogradouro(tl);
			
			logradouro.add(l);
		}
		
		return logradouro;
	}
	
}
