package unioeste.geral.endereco.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.endereco.bo.UF;
import unioeste.geral.endereco.dao.DAOUF;

public class ColUF {

	public UF obterUFPorId(UF uf, SQLConnector connector) throws Exception{
		DAOUF dao = new DAOUF();
		
		return dao.obterUFPorId(uf, connector);
	}
	
	public ArrayList<UF> obterTodosUFs(SQLConnector connector) throws Exception{
		DAOUF dao = new DAOUF();
		
		return dao.obterTodosUFs(connector);
	}
	
}
