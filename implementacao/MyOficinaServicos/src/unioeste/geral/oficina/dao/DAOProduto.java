package unioeste.geral.oficina.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Produto;

public class DAOProduto {

	public Produto obterProdutoPorId(Produto produto, SQLConnector connector) throws Exception {
			String query="SELECT * FROM Produto WHERE idProduto = " +produto.getIdProduto()+";";
			ResultSet result = connector.executeQuery(query);
			result.next();
			produto.setIdProduto(result.getInt("idProduto"));
			produto.setNome(result.getString("nomeProduto"));
			produto.setPrecoBase(result.getFloat("precoBaseProduto"));
			return produto;
	}

	public ArrayList<Produto> obterTodosProdutos(SQLConnector connector) throws Exception{
		ArrayList<Produto> produto = new ArrayList<Produto>();
		
		String query="SELECT * FROM Produto";
		ResultSet result = connector.executeQuery(query);
		while(result.next()) {
			Produto p = new Produto();
			p.setIdProduto(result.getInt("IdProduto"));
			p.setNome(result.getString("nomeProduto"));
			p.setPrecoBase(result.getFloat("precoBaseProduto"));
			
			produto.add(p);
		}
		return produto;
	}
	
}
