package unioeste.geral.endereco.col;

import unioeste.geral.endereco.dao.DAOBairro;

public class ColBairro {

	public Bairro obterBairroPorId(Bairro bairro, SQLConnector connector) {
		DAOBairro dao = new DAOBairro();
		
		return dao.obterBairroPorId(bairro, connector);
	}
	
	public ArrayList<Bairro> obterTodosBairros(SQLConnector connector){
		DAOBairro dao = new DAOBairro();
		
		return dao.obterTodosBairros(connector);
	}
	
}
