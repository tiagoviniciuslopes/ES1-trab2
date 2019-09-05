package unioeste.geral.oficina.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.OrdemServico_Servico;
import unioeste.geral.oficina.dao.DAOOrdemServico_Servico;

public class ColOrdemServico_Servico {

	public ArrayList<OrdemServico_Servico> obterOrdemServicoServicoId(OrdemServico_Servico ordemservico_servico, SQLConnector connector) throws Exception{
		DAOOrdemServico_Servico dao = new DAOOrdemServico_Servico();
		
		return dao.obterOrdemServicoServicoPorId(ordemservico_servico, connector);
	}
	
	public void inserirOrdemServicoServico(OrdemServico_Servico ordemservico_servico, SQLConnector connector) throws Exception{
		DAOOrdemServico_Servico dao = new DAOOrdemServico_Servico();
		
		dao.inserirOrdemServicoServico(ordemservico_servico, connector);
	}
}
