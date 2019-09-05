package unioeste.geral.oficina.col;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.OrdemServico_Produto;
import unioeste.geral.oficina.dao.DAOOrdemServico_Produto;

public class ColOrdemServico_Produto {
	public OrdemServico_Produto obterOrdemServicoProdutoId(OrdemServico_Produto ordemservico_produto, SQLConnector connector) throws Exception{
		DAOOrdemServico_Produto dao = new DAOOrdemServico_Produto();
		
		return dao.obterOrdemServicoProdutoPorId(ordemservico_produto, connector);
	}
}


