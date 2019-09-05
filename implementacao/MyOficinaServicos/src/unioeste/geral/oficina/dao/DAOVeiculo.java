package unioeste.geral.oficina.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.common.bo.Pessoa;
import unioeste.geral.oficina.bo.Veiculo;

public class DAOVeiculo {
	
	
	public Pessoa obterVeiculoPorCliente(Pessoa pessoa, SQLConnector connector) throws Exception{
		String query="SELECT *FROM Pessoa WHERE idCliente = " +pessoa.getIdPessoa()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
	
		pessoa.setIdPessoa(result.getInt("idPessoa"));
		
		return pessoa;
	}
	
	public Veiculo obterVeiculoPorId(Veiculo veiculo, SQLConnector connector) throws Exception{
		String query="SELECT *FROM Veiculo WHERE idVeiculo = " +veiculo.getIdVeiculo()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		veiculo.setIdVeiculo(result.getInt("idVeiculo"));
			veiculo.setMarca(result.getString("Marca"));
				veiculo.setNomeVeiculo(result.getString("nomeVeiculo"));
					veiculo.setModelo(result.getString("modelo"));
						veiculo.setKmVeiculo(result.getInt("kmVeiculo"));
		
		return veiculo;	
	}
		
	public ArrayList<Veiculo> obterTodosVeiculos(SQLConnector connector) throws Exception{
		ArrayList<Veiculo> veiculo = new ArrayList<Veiculo>();
		
		String query="Select * FROM Veiculo";
		ResultSet result = connector.executeQuery(query);

		while(result.next()) {
			Veiculo v = new Veiculo();
			v.setIdVeiculo(result.getInt("idVeiculo")); 
				v.setMarca(result.getString("Marca"));
					v.setNomeVeiculo(result.getString("nomeVeiculo"));
						v.setModelo(result.getString("modelo"));
							v.setKmVeiculo(result.getInt("kmVeiculo")); 
			
			veiculo.add(v);	
		}
		return veiculo;
	}
	}

