package unioeste.geral.endereco.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.endereco.bo.Endereco;
import unioeste.geral.endereco.dao.DAOEndereco;

public class ColEndereco {

	public Endereco obterEnderecoPorId(Endereco endereco, SQLConnector connector) throws Exception{
		DAOEndereco dao = new DAOEndereco();
		
		return dao.obterEnderecoPorId(endereco, connector);
	}
	
	public ArrayList<Endereco> obterEnderecoPorCep(Endereco endereco, SQLConnector connector) throws Exception{
		DAOEndereco dao = new DAOEndereco();
		
		return dao.obterEnderecoPorCep(endereco,connector);
	}
	
	public Endereco inserirEndereco(Endereco e, SQLConnector connector) throws Exception {
		DAOEndereco dao = new DAOEndereco();
		
		return dao.inserirEndereco(e, connector);
	}
	
}
