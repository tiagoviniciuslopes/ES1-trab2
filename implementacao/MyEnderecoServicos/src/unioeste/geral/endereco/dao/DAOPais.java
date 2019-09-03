package unioeste.geral.endereco.dao;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOPais {

	public Pais obterPaisPorId(Pais pais, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM Pais WHERE idPais = "+pais.getIdPais()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		pais.setNome(result.getString("nomePais"));
		pais.setIdPais(result.getInt("idPais"));
		
		return pais;
	}
	
	public ArrayList<Pais> obterTodosPaises(SQLConnector connector) throws Exception{
		ArrayList<Pais> pais = new ArrayList<Pais>();
		
		String query = "SELECT * FROM Pais;";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			Pais p = new Pais();
			
			pais.setNome(result.getString("nomePais"));
			pais.setIdPais(result.getInt("idPais"));
			
			pais.add(p);
		}
		
		return pais;
	}
	
}
