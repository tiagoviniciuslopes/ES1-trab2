package unioeste.geral.endereco.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.endereco.bo.Pais;
import unioeste.geral.endereco.dao.DAOPais;

public class ColPais {

	public Pais obterPaisPorId(Pais pais, SQLConnector connector) throws Exception{
		DAOPais dao = new DAOPais();
		
		return dao.obterPaisPorId(pais, connector);
	}
	
	public ArrayList<Pais> obterTodosPaises(SQLConnector connector) throws Exception{
		DAOPais dao = new DAOPais();
		
		return dao.obterTodosPaises(connector);
	}
	
}
