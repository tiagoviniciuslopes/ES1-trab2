package unioeste.geral.endereco.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.endereco.bo.Bairro;
import unioeste.geral.endereco.dao.DAOBairro;

public class ColBairro {

	public Bairro obterBairroPorId(Bairro bairro, SQLConnector connector) throws Exception{
		DAOBairro dao = new DAOBairro();
		
		return dao.obterBairroPorId(bairro, connector);
	}
	
	public ArrayList<Bairro> obterTodosBairros(SQLConnector connector) throws Exception{
		DAOBairro dao = new DAOBairro();
		
		return dao.obterTodosBairros(connector);
	}
	
}
