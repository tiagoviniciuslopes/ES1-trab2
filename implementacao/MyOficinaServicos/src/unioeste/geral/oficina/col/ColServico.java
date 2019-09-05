package unioeste.geral.oficina.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Servico;
import unioeste.geral.oficina.dao.DAOServico;

public class ColServico {
	public Servico obterServicoPorId(Servico servico,SQLConnector connector) throws Exception{
		DAOServico dao = new DAOServico();
		
		return dao.obterServicoPorId(servico, connector);
	}
	
	public ArrayList<Servico> obterTodosServicos(SQLConnector connector) throws Exception{
		DAOServico dao = new DAOServico();
		return dao.obterTodosServicos(connector);
	}
}
