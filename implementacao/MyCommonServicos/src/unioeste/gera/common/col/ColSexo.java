package unioeste.gera.common.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.gera.common.dao.DAOSexo;
import unioeste.geral.common.bo.Sexo;

public class ColSexo {

	public Sexo obterSexoPorId(Sexo sexo, SQLConnector connector) throws Exception{
		DAOSexo dao = new DAOSexo();
		
		return dao.obterSexoPorId(sexo, connector);
	}
	
	public ArrayList<Sexo> obterTodosSexos(SQLConnector connector) throws Exception{
		DAOSexo dao = new DAOSexo();
		
		return dao.obterTodosSexos(connector);
	}
	
}
