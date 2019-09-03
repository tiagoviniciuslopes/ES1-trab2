package unioeste.geral.endereco.col;

import unioeste.geral.endereco.dao.DAOBairro;
import unioeste.geral.endereco.dao.DAOCidade;

public class ColCidade {

	public Cidade obterCidadePorId(Cidade cidade, SQLConnector connector) {
		DAOCidade dao = new DAOCidade();
		
		return dao.obterCidadePorId(cidade, connector);
	}
	
	public ArrayList<Cidade> obterTodasCidades(SQLConnector connector){
		DAOCidade dao = new DAOCidade();
		
		return dao.obterTodasCidades(connector);
	}
	
}
