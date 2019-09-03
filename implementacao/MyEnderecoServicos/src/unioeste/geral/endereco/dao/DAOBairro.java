package unioeste.geral.endereco.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.endereco.bo.Bairro;

public class DAOBairro {

	public Bairro obterBairroPorId(Bairro bairro, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM Bairro WHERE idBairro = "+bairro.getIdBairro()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		bairro.setNome(result.getString("nomeBairro"));
		bairro.setIdBairro(result.getInt("idBairro"));
		
		return bairro;
	}
	
	public ArrayList<Bairro> obterTodosBairros(SQLConnector connector) throws Exception{
		ArrayList<Bairro> bairro = new ArrayList<Bairro>();
		
		String query = "SELECT * FROM Bairro;";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			Bairro b = new Bairro();
			
			b.setNome(result.getString("nomeBairro"));
			b.setIdBairro(result.getInt("idBairro"));
			
			bairro.add(b);
		}
		
		return bairro;
	}
	
}
