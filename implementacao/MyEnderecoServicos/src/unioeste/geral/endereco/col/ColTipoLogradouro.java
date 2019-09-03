package unioeste.geral.endereco.col;

import java.util.ArrayList;

import unioeste.geral.endereco.dao.DAOTipoLogradouro;

public class ColTipoLogradouro {

	public TipoLogradouro obterTipoLogradouroPorId(TipoLogradouro tl, SQLConnector connector) {
		DAOTipoLogradouro dao = new DAOTipoLogradouro();
		
		return dao.obterTipoLogradouroPorId(tl, connector);
	}
	
	public ArrayList<TipoLogradouro> obterTodosTipoLogradouros(SQLConnector connector){
		DAOTipoLogradouro dao = new DAOTipoLogradouro();
		
		return dao.obterTodosTipoLogradouros(connector);
	}
	
}
