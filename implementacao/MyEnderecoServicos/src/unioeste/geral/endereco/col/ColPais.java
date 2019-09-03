package unioeste.geral.endereco.col;

import java.util.ArrayList;

import unioeste.geral.endereco.dao.DAOPais;

public class ColPais {

	public Pais obterPaisPorId(Pais pais, SQLConnector connector) {
		DAOPais dao = new DAOPais();
		
		return dao.obterPaisPorId(pais, connector);
	}
	
	public ArrayList<Pais> obterTodosPaises(SQLConnector connector){
		DAOPais dao = new DAOPais();
		
		return dao.obterTodosPaises(connector);
	}
	
}
