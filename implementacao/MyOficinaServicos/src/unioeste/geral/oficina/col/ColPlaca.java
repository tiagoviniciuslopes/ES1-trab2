package unioeste.geral.oficina.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Placa;
import unioeste.geral.oficina.dao.DAOPlaca;

public class ColPlaca {
	public Placa obterPlaca(Placa placa, SQLConnector connector) throws Exception{
		DAOPlaca dao = new DAOPlaca();
		
		return dao.obterPlaca(placa,connector);
	}
	
	public ArrayList<Placa> obterTodasPlacas(SQLConnector connector) throws Exception{
		DAOPlaca dao= new DAOPlaca();
		return dao.obterTodasPlacas(connector);
	}
}
