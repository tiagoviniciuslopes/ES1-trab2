package unioeste.geral.endereco.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.endereco.bo.Logradouro;
import unioeste.geral.endereco.dao.DAOLogradouro;

public class ColLogradouro {
	public Logradouro obterLogradouroPorId(Logradouro logradouro, SQLConnector connector) throws Exception{
		DAOLogradouro dao = new DAOLogradouro();
		
		return dao.obterLogradouroPorId(logradouro, connector);
	}
	
	public ArrayList<Logradouro> obterTodosLogradouros(SQLConnector connector) throws Exception{
		DAOLogradouro dao = new DAOLogradouro();
		
		return dao.obterTodosLogradouros(connector);
	}
}
