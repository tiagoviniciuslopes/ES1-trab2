package unioeste.gera.common.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.common.bo.DDD;

public class DAODDD {

	public DDD obterDDDPorId(DDD ddd, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM DDD WHERE idDDD = "+ddd.getIdDDD()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		ddd.setNumero(result.getInt("numeroDDD"));
		ddd.setIdDDD(result.getInt("idDDD"));
		
		return ddd;
	}
	
	public ArrayList<DDD> obterTodosDDDs(SQLConnector connector) throws Exception{
		String query = "SELECT * FROM DDD;";
		ResultSet result = connector.executeQuery(query);
		
		ArrayList<DDD> ddds = new ArrayList<DDD>();
		
		while(result.next()){
			DDD ddd = new DDD();
			
			ddd.setNumero(result.getInt("numeroDDD"));
			ddd.setIdDDD(result.getInt("idDDD"));
			
			ddds.add(ddd);
		}
		
		return ddds;
	}
	
}
