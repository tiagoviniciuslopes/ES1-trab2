package unioeste.geral.endereco.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.endereco.bo.TipoLogradouro;

public class DAOTipoLogradouro {

	public TipoLogradouro obterTipoLogradouroPorId(TipoLogradouro tl, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM TipoLogradouro WHERE idTipoLogradouro = "+tl.getIdTipoLogradouro()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		tl.setDescricaoTipo(result.getString("nomeTipo"));
		tl.setSiglaTipo(result.getString("siglaTipo"));
		tl.setIdTipoLogradouro(result.getInt("idTipoLogradouro"));
		
		return tl;
	}
	
	public ArrayList<TipoLogradouro> obterTodosTiposLogradouro(SQLConnector connector) throws Exception{
		ArrayList<TipoLogradouro> tls = new ArrayList<TipoLogradouro>();
		
		String query = "SELECT * FROM TipoLogradouro;";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			TipoLogradouro tl = new TipoLogradouro();
			
			tl.setDescricaoTipo(result.getString("nomeTipo"));
			tl.setSiglaTipo(result.getString("siglaTipo"));
			tl.setIdTipoLogradouro(result.getInt("idTipoLogradouro"));
			
			tls.add(tl);
		}
		
		return tls;
	}
	
}
