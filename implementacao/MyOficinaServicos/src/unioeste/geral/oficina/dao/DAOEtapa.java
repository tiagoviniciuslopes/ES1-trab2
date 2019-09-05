package unioeste.geral.oficina.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Etapa;

public class DAOEtapa {

	public Etapa obterEtapaId(Etapa etapa, SQLConnector connector) throws Exception{
		String query = "SELECT *FROM Etapa WHERE idOrdemServico = " +etapa.getIdEtapa()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
			etapa.setIdEtapa(result.getInt("Etapa"));
			etapa.setDescricao(result.getString("Descricao"));
		return etapa;
			
	}

	public ArrayList<Etapa> obterTodasEtapasId(SQLConnector connector) throws Exception {
		ArrayList<Etapa> etapa = new ArrayList<Etapa>();
			String query = "SELECT *FROM Etapa";
				ResultSet result = connector.executeQuery(query);
				while(result.next()){
					Etapa e = new Etapa();
						e.setIdEtapa(result.getInt("Etapa"));
						e.setDescricao(result.getString("Descricao"));
						
						etapa.add(e);
				}
		return etapa;
	}

}
