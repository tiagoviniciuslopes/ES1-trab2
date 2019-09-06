package unioeste.geral.oficina.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.common.bo.Pessoa;
import unioeste.geral.oficina.bo.Cliente;
import unioeste.geral.oficina.bo.Veiculo;
import unioeste.geral.oficina.dao.DAOVeiculo;

public class ColVeiculo {
	
	
	public ArrayList<Veiculo> obterVeiculoPorCliente(Pessoa pessoa, SQLConnector connector) throws Exception{
		DAOVeiculo dao = new DAOVeiculo();
		return dao.obterVeiculoPorCliente(pessoa, connector);
	}
	
	public Veiculo obterVeiculoPorId(Veiculo veiculo, SQLConnector connector) throws Exception{
		DAOVeiculo dao = new DAOVeiculo();
		
		return dao.obterVeiculoPorId(veiculo,connector);		
	}
	
	public ArrayList<Veiculo> obterTodosVeiculos(SQLConnector connector) throws Exception{
		DAOVeiculo dao = new DAOVeiculo();
		return dao.obterTodosVeiculos(connector);
	}
	
	public Veiculo obterVeiculoPorPlaca(Veiculo veiculo, SQLConnector connector) throws Exception{
		DAOVeiculo dao = new DAOVeiculo();
		
		return dao.obterVeiculoPorPlaca(veiculo,connector);		
	}
	
	public Veiculo inserirVeiculo (Cliente c ,Veiculo veiculo, SQLConnector connector) throws Exception{
		DAOVeiculo dao = new DAOVeiculo();
		
		return dao.inserirVeiculo(c, veiculo,connector);
	}
}
