package unioeste.geral.oficina.manager;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Produto;
import unioeste.geral.oficina.col.ColProduto;

public class UCProdutoServicos {

	public Produto obterProdutoPorId(Produto produto) throws Exception{
		ColProduto colProduto = new ColProduto();
		SQLConnector connector = new SQLConnector();
		
		Produto p = colProduto.obterProdutoPorId(produto, connector);
		connector.close();
		return p;
	}
	
	public ArrayList<Produto> Produto() throws Exception{
		ColProduto colProduto = new ColProduto();
		SQLConnector connector = new SQLConnector();
		
		ArrayList<Produto> p = colProduto.obterTodosProdutos( connector);
		connector.close();
		return p;
	}
	
}
