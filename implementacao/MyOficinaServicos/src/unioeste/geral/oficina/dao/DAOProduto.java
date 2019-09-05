package unioeste.geral.oficina.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Produto;

public class DAOProduto {

	public Produto obterProdutoPorId(Produto produto, SQLConnector connector) throws Exception {
			String query="SELECT *FROM Produto WHERE idProduto = " +produto.getIdProduto()+";";
			ResultSet result = connector.executeQuery(query);
			result.next();
					produto.setIdProduto(result.getInt("idProdruto"));
						produto.setNome(result.getString("Nome"));
								produto.setPrecoBase(result.getFloat("PrecoBase"));
				return produto;
	}

	public ArrayList<Produto> obterTodosProdutosId(SQLConnector connector) throws Exception{
		ArrayList<Produto> produto = new ArrayList<Produto>();
		
		String query="Select *FROM Produto";
			ResultSet result = connector.executeQuery(query);
				while(result.next()) {
					Produto p = new Produto();
						p.setIdProduto(result.getInt("IdProduto"));
							p.setNome(result.getString("Nome"));
								p.setPrecoBase(result.getFloat("PrecoBase"));
					
					produto.add(p);
				}
			return produto;
	}
	
}
