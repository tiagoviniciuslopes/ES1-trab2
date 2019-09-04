package unioeste.geral.oficina.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Placa;

public class DAOPlaca {
	
	public Placa obterPlaca(Placa placa, SQLConnector connector) throws Exception{
		String query = "SELECT *FROM Placa WHERE placa = " +placa.getPlaca()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		placa.setPlaca(result.getString("Placa"));
		
		return placa;
	}
	
	public ArrayList<Placa> obterTodasPlacas(SQLConnector connector) throws Exception{
		ArrayList<Placa> placa = new ArrayList<Placa>(); 
		
		String query="Select * FROM Placa;";
		ResultSet result = connector.executeQuery(query);
			while(result.next()){
				Placa p = new Placa();
				p.setPlaca(result.getString("Placa"));
				
				placa.add(p);
			}
			return placa;
	}
}
