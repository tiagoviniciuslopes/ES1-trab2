package unioeste.geral.oficina.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.OrdemServico;
import unioeste.geral.oficina.dao.DAOOrdemServico;

public class ColOrdemServico {
	public OrdemServico ObterOrdemServicoId(OrdemServico ordemservico, SQLConnector connector) throws Exception{

	DAOOrdemServico dao = new DAOOrdemServico();
	return dao.ObterOrdemServicoId(ordemservico, connector);
	
	}
	
	public ArrayList<OrdemServico> obterTodosOrdemServicoId(SQLConnector connector) throws Exception{

		DAOOrdemServico dao = new DAOOrdemServico();
		return dao.obterTodosOrdemServicoId(connector);
	
	}
}
