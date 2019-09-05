package unioeste.geral.oficina.col;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.OrdemServico;
import unioeste.geral.oficina.dao.DAOOrdemServico_Produto;

public class ColOrdemServico_Produto {
		public OrdemServico obterOrdemServicoProdutoId(OrdemServico ordemservico_produto, SQLConnector connector) throws Exception{
			DAOOrdemServico_Produto dao = new DAOOrdemServico_Produto();
			
			return dao.obterOrdemServicoProdutoId(ordemservico_produto, connector);
		}
		
		
}


