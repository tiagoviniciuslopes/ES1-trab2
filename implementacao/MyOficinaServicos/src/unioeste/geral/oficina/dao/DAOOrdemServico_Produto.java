package unioeste.geral.oficina.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.OrdemServico_Produto;
import unioeste.geral.oficina.bo.Produto;

public class DAOOrdemServico_Produto {

	public ArrayList<OrdemServico_Produto> obterOrdemServicoProdutoPorId(OrdemServico_Produto ordemservico_produto, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM OrdemServico_Produto WHERE idOrdemServico = " +ordemservico_produto.getIdOrdemServico()+";";
		ResultSet result = connector.executeQuery(query);
		ArrayList<OrdemServico_Produto> osps = new ArrayList<OrdemServico_Produto>();
		
		while(result.next()) {
			OrdemServico_Produto osp = new OrdemServico_Produto();
			
			osp.setPrecoProduto(result.getFloat("precoProduto"));
			osp.setQuantidadeProduto(result.getInt("quantidadeProduto"));
			Produto p = new Produto();
			p.setIdProduto(result.getInt("idProduto"));
			osp.setIdOrdemServico(result.getInt("idOrdemServico"));
			osp.setProduto(p);
			osp.setTotal(ordemservico_produto.getQuantidadeProduto() * ordemservico_produto.getPrecoProduto());
			
			osps.add(osp);
		}
		
		return osps;
			
	}
	
	public void inserirOrdemServicoProduto(OrdemServico_Produto osp, SQLConnector connector) throws Exception{
		String query = "INSERT INTO OrdemServico_Produto (idOrdemServico, idProduto, precoProduto, quantidadeProduto)"
				+ " VALUES ("+osp.getIdOrdemServico()+","+osp.getProduto().getIdProduto()+","+osp.getPrecoProduto()+","+osp.getQuantidadeProduto()+");";
		connector.executeUpdate(query);
	}

}
