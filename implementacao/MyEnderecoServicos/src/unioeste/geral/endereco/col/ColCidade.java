package unioeste.geral.endereco.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.endereco.bo.Cidade;
import unioeste.geral.endereco.dao.DAOCidade;

public class ColCidade {

	public Cidade obterCidadePorId(Cidade cidade, SQLConnector connector) throws Exception{
		DAOCidade dao = new DAOCidade();
		
		return dao.obterCidadePorId(cidade, connector);
	}
	
	public ArrayList<Cidade> obterTodasCidades(SQLConnector connector) throws Exception{
		DAOCidade dao = new DAOCidade();
		
		return dao.obterTodasCidades(connector);
	}
	
}
