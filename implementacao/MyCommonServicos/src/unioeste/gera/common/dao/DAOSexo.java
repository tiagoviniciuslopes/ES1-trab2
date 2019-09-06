package unioeste.gera.common.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.common.bo.Sexo;

public class DAOSexo {

	public Sexo obterSexoPorId(Sexo sexo, SQLConnector connector) throws Exception{
		
		String query = "SELECT * FROM Sexo WHERE idSexo = " + sexo.getIdSexo() + ";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		sexo.setDescricao(result.getString("descricaoSexo"));
		sexo.setSigla(result.getString("siglaSexo"));
		sexo.setIdSexo(result.getInt("idSexo"));
		
		return sexo;
	}
	
	public ArrayList<Sexo> obterTodosSexos(SQLConnector connector) throws Exception{
		ArrayList<Sexo> sexo = new ArrayList<Sexo>();
		
		String query = "SELECT * FROM Sexo;";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			Sexo s = new Sexo();
			
			s.setDescricao(result.getString("descricaoSexo"));
			s.setSigla(result.getString("siglaSexo"));
			s.setIdSexo(result.getInt("idSexo"));
			
			sexo.add(s);
		}
		
		return sexo;
	}
	
}
