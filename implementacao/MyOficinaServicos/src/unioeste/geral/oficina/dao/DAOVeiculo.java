package unioeste.geral.oficina.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Veiculo;;

public class DAOVeiculo {
	
	
	public Veiculo obterVeiculoPorId(Veiculo veiculo, SQLConnector connector) throws Exception{
		String query="SELECT *FROM Veiculo WHERE idVeiculo = " +veiculo.getIdVeiculo()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		veiculo.setIdVeiculo(result.getInt("idVeiculo")); //verifica esse GetInt que eu fiz, se pode ser usado dessa maneira
		veiculo.setMarca(result.getString("Marca"));
		veiculo.setNomeVeiculo(result.getString("nomeVeiculo"));
		veiculo.setModelo(result.getString("modelo"));
		veiculo.setKmVeiculo(result.getInt("kmVeiculo")); //verifica esse GetInt que eu fiz, se pode ser usado dessa maneira
		
		
		return veiculo;	
	}
		
	public ArrayList<Veiculo> obterTodosVeiculos(SQLConnector connector) throws Exception{
		ArrayList<Veiculo> veiculo = new ArrayList<Veiculo>();
		
		String query="Select * FROM Veiculo";
		ResultSet result = connector.executeQuery(query);

		while(result.next()) {
			Veiculo v = new Veiculo();
			v.setIdVeiculo(result.getInt("idVeiculo")); //verifica esse GetInt que eu fiz, se pode ser usado dessa maneira
			v.setMarca(result.getString("Marca"));
			v.setNomeVeiculo(result.getString("nomeVeiculo"));
			v.setModelo(result.getString("modelo"));
			v.setKmVeiculo(result.getInt("kmVeiculo")); //verifica esse GetInt que eu fiz, se pode ser usado dessa maneira
			
			veiculo.add(v);	
		}
		return veiculo;
	}
	}
