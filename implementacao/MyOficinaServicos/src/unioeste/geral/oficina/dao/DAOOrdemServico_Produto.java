package unioeste.geral.oficina.dao;

import java.sql.ResultSet;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.OrdemServico;

public class DAOOrdemServico_Produto {

	public OrdemServico obterOrdemServicoProdutoId(OrdemServico ordemservico_produto, SQLConnector connector) throws Exception{
		String query = "SELECT *FROM OrdemServico WHERE idOrdemServico = " +ordemservico_produto.getIdOrdemServico()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		return ordemservico_produto;
			
	}

}
