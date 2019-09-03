package unioeste.geral.endereco.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.endereco.bo.TipoLogradouro;
import unioeste.geral.endereco.dao.DAOTipoLogradouro;

public class ColTipoLogradouro {

	public TipoLogradouro obterTipoLogradouroPorId(TipoLogradouro tl, SQLConnector connector) throws Exception{
		DAOTipoLogradouro dao = new DAOTipoLogradouro();
		
		return dao.obterTipoLogradouroPorId(tl, connector);
	}
	
	public ArrayList<TipoLogradouro> obterTodosTipoLogradouros(SQLConnector connector) throws Exception{
		DAOTipoLogradouro dao = new DAOTipoLogradouro();
		
		return dao.obterTodosTiposLogradouro(connector);
	}
	
}
