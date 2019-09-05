package unioeste.geral.oficina.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Etapa;

public class DAOEtapa {

	public Etapa obterEtapaId(Etapa etapa, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM Etapa WHERE idEtapa = " +etapa.getIdEtapa()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		etapa.setIdEtapa(result.getInt("idEtapa"));
		etapa.setDescricao(result.getString("descricaoEtapa"));
		return etapa;
			
	}

	public ArrayList<Etapa> obterTodasEtapas(SQLConnector connector) throws Exception {
		ArrayList<Etapa> etapa = new ArrayList<Etapa>();
		String query = "SELECT * FROM Etapa";
		ResultSet result = connector.executeQuery(query);
		while(result.next()){
			Etapa e = new Etapa();
			e.setIdEtapa(result.getInt("idEtapa"));
			e.setDescricao(result.getString("descricaoEtapa"));
			
			etapa.add(e);
		}
		return etapa;
	}

}
