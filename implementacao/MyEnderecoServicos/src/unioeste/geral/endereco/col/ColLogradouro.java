package unioeste.geral.endereco.col;

import java.util.ArrayList;

import unioeste.geral.endereco.dao.DAOLogradouro;

public class ColLogradouro {
	public Logradouro obterLogradouroPorId(Logradouro logradouro, SQLConnector connector) {
		DAOLogradouro dao = new DAOLogradouro();
		
		return dao.obterLogradouroPorId(logradouro, connector);
	}
	
	public ArrayList<Cidade> obterTodasCidades(SQLConnector connector){
		DAOLogradouro dao = new DAOLogradouro();
		
		return dao.obterTodosLogradouros(connector);
	}
}
