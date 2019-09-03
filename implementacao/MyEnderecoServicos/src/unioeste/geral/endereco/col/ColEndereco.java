package unioeste.geral.endereco.col;

import unioeste.geral.endereco.dao.DAOEndereco;

public class ColEndereco {

	public Endereco obterEnderecoPorId(Endereco endereco, SQLConnector connector) {
		DAOEndereco dao = new DAOEndereco();
		
		return dao.obterEnderecoPorId(endereco, connector);
	}
	
	public ArrayList<Endereco> obterEnderecoPorCep(Endereco endereco, SQLConnector connector){
		DAOEndereco dao = new DAOEndereco();
		
		return dao.obterEnderecoPorCep(endereco,connector);
	}
	
}
