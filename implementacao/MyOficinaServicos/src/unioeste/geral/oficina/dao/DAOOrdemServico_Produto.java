package unioeste.geral.oficina.dao;

import java.sql.ResultSet;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.OrdemServico_Produto;
import unioeste.geral.oficina.bo.Produto;

public class DAOOrdemServico_Produto {

	public OrdemServico_Produto obterOrdemServicoProdutoPorId(OrdemServico_Produto ordemservico_produto, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM OrdemServico_Produto WHERE idOrdemServico = " +ordemservico_produto.getIdOrdemServico()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		ordemservico_produto.setPrecoProduto(result.getFloat("precoProduto"));
		ordemservico_produto.setQuantidadeProduto(result.getInt("quantidadeProduto"));
		Produto p = new Produto();
		p.setIdProduto(result.getInt("idProduto"));
		ordemservico_produto.setIdOrdemServico(result.getInt("idOrdemServico"));
		ordemservico_produto.setProduto(p);
		ordemservico_produto.setTotal(ordemservico_produto.getQuantidadeProduto() * ordemservico_produto.getPrecoProduto());
		
		
		return ordemservico_produto;
			
	}

}
