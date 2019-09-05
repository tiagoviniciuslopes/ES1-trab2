package unioeste.gera.common.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.gera.common.dao.DAOFone;
import unioeste.geral.common.bo.Fone;
import unioeste.geral.common.bo.Pessoa;

public class ColFone {
	
	public ArrayList<Fone> obterFoneCliente(Pessoa pessoa, SQLConnector connector) throws Exception{
		DAOFone dao = new DAOFone();
		
		return dao.obterFoneCliente(pessoa, connector);
	}
	
	public ArrayList<Fone> obterFoneFuncionario(Pessoa pessoa, SQLConnector connector) throws Exception{
		DAOFone dao = new DAOFone();
		
		return dao.obterFoneFuncionario(pessoa, connector);
	}
	
	public Fone inserirFoneCliente(Fone f,Pessoa pessoa, SQLConnector connector) throws Exception {
		DAOFone dao = new DAOFone();
		
		return dao.inserirFoneCliente(f, pessoa, connector);
	}
}
