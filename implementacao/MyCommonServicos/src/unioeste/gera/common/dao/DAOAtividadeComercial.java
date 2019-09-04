package unioeste.gera.common.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.common.bo.AtividadeComercial;

public class DAOAtividadeComercial {
	
	public AtividadeComercial obterAtividadeComercialPorId(AtividadeComercial atividadeComercial, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM AtividadeComercial WHERE idAtividadeComercial = "+atividadeComercial.getIdAtividadeComercial()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		atividadeComercial.setDescricao(result.getString("descricaoAtividadeComercial"));
		atividadeComercial.setIdAtividadeComercial(result.getInt("idAtividadeComercial"));
		
		return atividadeComercial;
	}
	
	public ArrayList<AtividadeComercial> obterTodasAtividadesComerciais(SQLConnector connector) throws Exception{
		ArrayList<AtividadeComercial> atividadeComercial = new ArrayList<AtividadeComercial>();
		
		String query = "SELECT * FROM AtividadeComercial;";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			AtividadeComercial ac = new AtividadeComercial();
			
			ac.setDescricao(result.getString("descricaoAtividadeComercial"));
			ac.setIdAtividadeComercial(result.getInt("idAtividadeComercial"));
			
			atividadeComercial.add(ac);
		}
		
		return atividadeComercial;
	}
}
