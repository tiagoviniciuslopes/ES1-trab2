package unioeste.gera.common.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.gera.common.dao.DAOOrgaoExpeditor;
import unioeste.geral.common.bo.OrgaoExpeditor;

public class ColOrgaoExpeditor {

	public OrgaoExpeditor obterOrgaoExpeditorPorId(OrgaoExpeditor orgaoExpeditor, SQLConnector connector) throws Exception{
		DAOOrgaoExpeditor dao = new DAOOrgaoExpeditor();
		
		return dao.obterOrgaoExpeditorPorId(orgaoExpeditor, connector);
	}
	
	public ArrayList<OrgaoExpeditor> obterTodosOrgaosExpeditores(SQLConnector connector) throws Exception{
		DAOOrgaoExpeditor dao = new DAOOrgaoExpeditor();
		
		return dao.obterTodosOrgaosExpeditores(connector);
	}
	
}
