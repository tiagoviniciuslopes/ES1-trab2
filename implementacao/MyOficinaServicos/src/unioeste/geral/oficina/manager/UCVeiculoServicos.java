package unioeste.geral.oficina.manager;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.common.bo.Pessoa;
import unioeste.geral.oficina.bo.Cliente;
import unioeste.geral.oficina.bo.Veiculo;
import unioeste.geral.oficina.col.ColVeiculo;

public class UCVeiculoServicos {

	public ArrayList<Veiculo> obterVeiculoPorCliente(Pessoa pessoa) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColVeiculo colVeiculo = new ColVeiculo();
		
		ArrayList<Veiculo> v = colVeiculo.obterVeiculoPorCliente(pessoa, connector);
		connector.close();
		return v;
	}
	
	public Veiculo obterVeiculoPorId(Veiculo veiculo) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColVeiculo colVeiculo = new ColVeiculo();
		
		Veiculo v = colVeiculo.obterVeiculoPorId(veiculo, connector);
		connector.close();
		return v;	
	}
	
	public ArrayList<Veiculo> obterTodosVeiculos() throws Exception{
		SQLConnector connector = new SQLConnector();
		ColVeiculo colVeiculo = new ColVeiculo();
		
		
		ArrayList<Veiculo> v = colVeiculo.obterTodosVeiculos(connector);
		connector.close();
		return v;
	}
	
	public Veiculo obterVeiculoPorPlaca(Veiculo veiculo) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColVeiculo colVeiculo = new ColVeiculo();
		
		Veiculo v = colVeiculo.obterVeiculoPorPlaca(veiculo, connector);
		connector.close();
		return v;
	}
	
	public Veiculo inserirVeiculo(Cliente c, Veiculo veiculo) throws Exception {
		SQLConnector connector = new SQLConnector();
		ColVeiculo colVeiculo = new ColVeiculo();
		
		Veiculo v = colVeiculo.inserirVeiculo(c, veiculo, connector);
		connector.close();
		return v;
		
	}
	
}
