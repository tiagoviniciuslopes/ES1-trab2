package unioeste.geral.oficina.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.dao.DAOVeiculo;
import unioeste.geral.common.bo.Pessoa;
import unioeste.geral.oficina.bo.Veiculo;

public class ColVeiculo {
	
	
	public Pessoa obterVeiculoPorCliente(Pessoa pessoa, SQLConnector connector) throws Exception{
		DAOVeiculo dao = new DAOVeiculo();
		return dao.obterVeiculoPorCliente(pessoa, connector);
	}
	
	public Veiculo obterVeiculoPorID(Veiculo veiculo, SQLConnector connector) throws Exception{
		DAOVeiculo dao = new DAOVeiculo();
		
		return dao.obterVeiculoPorId(veiculo,connector);		
	}
	
	public ArrayList<Veiculo> obterTodosVeiculos(SQLConnector connector) throws Exception{
		DAOVeiculo dao = new DAOVeiculo();
		return dao.obterTodosVeiculos(connector);
	}
}
