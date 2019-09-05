package unioeste.geral.oficina.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Produto;
import unioeste.geral.oficina.dao.DAOProduto;

public class ColProduto {
		public Produto obterProdutoPorId(Produto produto,SQLConnector connector) throws Exception{
			DAOProduto dao = new DAOProduto();
			
			return dao.obterProdutoPorId(produto,connector);
		}
		
		public ArrayList<Produto> obterTodosProdutos(SQLConnector connector) throws Exception{
			DAOProduto dao = new DAOProduto();
			return dao.obterTodosProdutos(connector);
		}
}
