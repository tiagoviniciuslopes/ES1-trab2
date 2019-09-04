package unioeste.gera.common.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.common.bo.OrgaoExpeditor;
import unioeste.geral.endereco.bo.UF;

public class DAOOrgaoExpeditor {
	
	public OrgaoExpeditor obterOrgaoExpeditorPorId(OrgaoExpeditor oe, SQLConnector connector) throws Exception{
		
		String query = "SELECT * FROM OrgaoExpeditor WHERE idOrgaoExpeditor = " + oe.getIdOrgaoExpeditor() + ";";
		ResultSet result = connector.executeQuery(query);	
		result.next();
	
		oe.setNomeOrgao(result.getString("nomeOrgaoExpeditor"));
		oe.setIdOrgaoExpeditor(result.getInt("idOrgaoExpeditor"));
		
		UF uf = new UF();		
		uf.setIdUF(result.getInt("idUF"));
		
		oe.setUf(uf);
		
		return oe;
	}
	
	public ArrayList<OrgaoExpeditor> obterTodosOrgaosExpeditores(SQLConnector connector) throws Exception{
		ArrayList<OrgaoExpeditor> orgaoExpeditor = new ArrayList<OrgaoExpeditor>();
		
		String query = "SELECT * FROM OrgaoExpeditor;";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			OrgaoExpeditor oe_aux = new OrgaoExpeditor();
			
			oe_aux.setNomeOrgao(result.getString("nomeOrgaoExpeditor"));
			oe_aux.setIdOrgaoExpeditor(result.getInt("idOrgaoExpeditor"));
			
			UF uf = new UF();		
			uf.setIdUF(result.getInt("idUF"));
			
			oe_aux.setUf(uf);
			
			orgaoExpeditor.add(oe_aux);
		}
		
		return orgaoExpeditor;
	}
	
}
