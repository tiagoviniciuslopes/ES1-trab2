package unioeste.geral.endereco.col;

import java.util.ArrayList;

import unioeste.geral.endereco.dao.DAOUF;

public class ColUF {

	public UF obterUFPorId(UF uf, SQLConnector connector) {
		DAOUF dao = new DAOUF();
		
		return dao.obterUFPorId(uf, connector);
	}
	
	public ArrayList<UF> obterTodosUFs(SQLConnector connector){
		DAOUF dao = new DAOUF();
		
		return dao.obterTodosUFs(connector);
	}
	
}
