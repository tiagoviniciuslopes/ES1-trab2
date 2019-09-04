package unioeste.gera.common.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.common.bo.TipoFone;

public class DAOTipoFone {
	
	public TipoFone obterTipoFonePorId(TipoFone tipoFone, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM TipoFone WHERE idTipoFone = "+tipoFone.getIdTipoFone()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		tipoFone.setDescricao(result.getString("descricaoTipoFone"));
		tipoFone.setSigla(result.getString("siglaTipoFone"));
		tipoFone.setIdTipoFone(result.getInt("idTipoFone"));
		
		return tipoFone;
	}
	
	public ArrayList<TipoFone> obterTodosTiposFone(SQLConnector connector) throws Exception{
		String query = "SELECT * FROM TipoFone;";
		ResultSet result = connector.executeQuery(query);
		ArrayList<TipoFone> tipoFone = new ArrayList<TipoFone>();
		
		while(result.next()) {
			TipoFone tf = new TipoFone();
		
			tf.setDescricao(result.getString("descricaoTipoFone"));
			tf.setSigla(result.getString("siglaTipoFone"));
			tf.setIdTipoFone(result.getInt("idTipoFone"));
			
			tipoFone.add(tf);
		}
		
		return tipoFone;
	}
}
