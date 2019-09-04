package unioeste.gera.common.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.gera.common.dao.DAODDI;
import unioeste.geral.common.bo.DDI;

public class ColDDI {

	public DDI obterDDIPorId(DDI ddi, SQLConnector connector) throws Exception{
		DAODDI dao = new DAODDI();
		
		return dao.obterDDIPorId(ddi, connector);
	}
	
	public ArrayList<DDI> obterTodosDDIs(SQLConnector connector) throws Exception{
		DAODDI dao = new DAODDI();
		
		return dao.obterTodosDDIs(connector);
	}
	
}
