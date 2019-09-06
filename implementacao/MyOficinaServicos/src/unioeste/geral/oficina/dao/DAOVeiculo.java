package unioeste.geral.oficina.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.common.bo.Pessoa;
import unioeste.geral.oficina.bo.Cliente;
import unioeste.geral.oficina.bo.Placa;
import unioeste.geral.oficina.bo.Veiculo;


public class DAOVeiculo {
	
	
	public  ArrayList<Veiculo> obterVeiculoPorCliente(Pessoa pessoa, SQLConnector connector) throws Exception{
		ArrayList<Veiculo> veiculo = new ArrayList<Veiculo>();
		
		String query="SELECT * FROM Veiculo WHERE idCliente = " + pessoa.getIdPessoa()+ ";" ;
		ResultSet result = connector.executeQuery(query);

		while(result.next()) {
			Veiculo v = new Veiculo();
			v.setIdVeiculo(result.getInt("idVeiculo")); //verifica esse GetInt que eu fiz, se pode ser usado dessa maneira
			v.setMarca(result.getString("marcaVeiculo"));
			v.setNomeVeiculo(result.getString("nomeVeiculo"));
			v.setModelo(result.getString("modeloVeiculo"));
			v.setKmVeiculo(result.getInt("kmVeiculo")); //verifica esse GetInt que eu fiz, se pode ser usado dessa maneira
			Placa p = new Placa();
			p.setPlaca(result.getString("placaVeiculo"));
			v.setPlaca(p);
			
			veiculo.add(v);	
		}
		return veiculo;
	}
	
	public Veiculo obterVeiculoPorId(Veiculo veiculo, SQLConnector connector) throws Exception{
		String query="SELECT *FROM Veiculo WHERE idVeiculo = " +veiculo.getIdVeiculo()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		veiculo.setIdVeiculo(result.getInt("idVeiculo")); //verifica esse GetInt que eu fiz, se pode ser usado dessa maneira
		veiculo.setMarca(result.getString("marcaVeiculo"));
		veiculo.setNomeVeiculo(result.getString("nomeVeiculo"));
		veiculo.setModelo(result.getString("modeloVeiculo"));
		veiculo.setKmVeiculo(result.getInt("kmVeiculo")); //verifica esse GetInt que eu fiz, se pode ser usado dessa maneira
		Placa p = new Placa();
		p.setPlaca(result.getString("placaVeiculo"));
		veiculo.setPlaca(p);
		
		return veiculo;	
	}
		
	public ArrayList<Veiculo> obterTodosVeiculos(SQLConnector connector) throws Exception{
		ArrayList<Veiculo> veiculo = new ArrayList<Veiculo>();
		
		String query="SELECT * FROM Veiculo";
		ResultSet result = connector.executeQuery(query);

		while(result.next()) {
			Veiculo v = new Veiculo();
			v.setIdVeiculo(result.getInt("idVeiculo")); //verifica esse GetInt que eu fiz, se pode ser usado dessa maneira
			v.setMarca(result.getString("marcaVeiculo"));
			v.setNomeVeiculo(result.getString("nomeVeiculo"));
			v.setModelo(result.getString("modeloVeiculo"));
			v.setKmVeiculo(result.getInt("kmVeiculo")); //verifica esse GetInt que eu fiz, se pode ser usado dessa maneira
			Placa p = new Placa();
			p.setPlaca(result.getString("placaVeiculo"));
			v.setPlaca(p);
			
			veiculo.add(v);	
		}
		return veiculo;
	}
	
	public Veiculo obterVeiculoPorPlaca(Veiculo veiculo, SQLConnector connector) throws Exception{
		String query="SELECT *FROM Veiculo WHERE placaVeiculo = '" +veiculo.getPlaca().getPlaca()+"';";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		veiculo.setIdVeiculo(result.getInt("idVeiculo")); //verifica esse GetInt que eu fiz, se pode ser usado dessa maneira
		veiculo.setMarca(result.getString("marcaVeiculo"));
		veiculo.setNomeVeiculo(result.getString("nomeVeiculo"));
		veiculo.setModelo(result.getString("modeloVeiculo"));
		veiculo.setKmVeiculo(result.getInt("kmVeiculo")); //verifica esse GetInt que eu fiz, se pode ser usado dessa maneira
		Placa p = new Placa();
		p.setPlaca(result.getString("placaVeiculo"));
		veiculo.setPlaca(p);
		
		return veiculo;	
	}
	
	public Veiculo inserirVeiculo(Cliente c, Veiculo veiculo, SQLConnector connector) throws Exception{
		int id;
		
		if(c.getClienteEmpresa() != null && c.getClienteEmpresa().getIdPessoa() != 0) id = c.getClienteEmpresa().getIdPessoa();
		else id = c.getClientePessoa().getIdPessoa();
		
		String query = "INSERT INTO Veiculo (marcaVeiculo,nomeVeiculo,modeloVeiculo,kmVeiculo,placaVeiculo,idCliente)"
				+ " VALUES ('"+veiculo.getMarca()+"','"+veiculo.getNomeVeiculo()+"','"+veiculo.getModelo()+"',"+veiculo.getKmVeiculo()+",'"+veiculo.getPlaca().getPlaca()+"',"+id+");";
		
		connector.executeUpdate(query);
		
		veiculo = obterVeiculoPorPlaca(veiculo,connector);
		
		return veiculo;
	}
	
	
	
}

