package unioeste.gera.common.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.common.bo.DDI;

public class DAODDI {

	public DDI obterDDIPorId(DDI ddi, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM DDI WHERE idDDI = "+ddi.getIdDDI()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		ddi.setNumero(result.getInt("numeroDDI"));
		ddi.setIdDDI(result.getInt("idDDI"));
		
		return ddi;
	}
	
	public ArrayList<DDI> obterTodosDDIs(SQLConnector connector) throws Exception{
		String query = "SELECT * FROM DDI;";
		ResultSet result = connector.executeQuery(query);
		
		ArrayList<DDI> ddis = new ArrayList<DDI>();
		
		while(result.next()){
			DDI ddi = new DDI();
			
			ddi.setNumero(result.getInt("numeroDDI"));
			ddi.setIdDDI(result.getInt("idDDI"));
			
			ddis.add(ddi);
		}
		
		return ddis;
	}
	
}
