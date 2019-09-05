package unioeste.geral.oficina.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.OrdemServico;
import unioeste.geral.oficina.dao.DAOOrdemServico;

public class ColOrdemServico {
	public OrdemServico obterOrdemServicoId(OrdemServico ordemservico, SQLConnector connector) throws Exception{

		DAOOrdemServico dao = new DAOOrdemServico();
		return dao.ObterOrdemServicoId(ordemservico, connector);
	
	}
	
	public ArrayList<OrdemServico> obterTodosOrdemServico(SQLConnector connector) throws Exception{

		DAOOrdemServico dao = new DAOOrdemServico();
		return dao.obterTodosOrdemServico(connector);
	
	}
	
	public void atualizarEtapa(OrdemServico os, SQLConnector connector) throws Exception{
		DAOOrdemServico dao = new DAOOrdemServico();
		dao.atualizarEtapa(os, connector);
	}
	
	public OrdemServico inserirOrdemServico(OrdemServico os, SQLConnector connector) throws Exception{
		DAOOrdemServico dao = new DAOOrdemServico();
		return dao.inserirOrdemServico(os, connector);
	}
}
