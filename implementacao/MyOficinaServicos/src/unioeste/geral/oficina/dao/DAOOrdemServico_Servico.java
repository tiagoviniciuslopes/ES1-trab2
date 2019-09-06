package unioeste.geral.oficina.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.OrdemServico_Servico;
import unioeste.geral.oficina.bo.Servico;

public class DAOOrdemServico_Servico {

	public ArrayList<OrdemServico_Servico> obterOrdemServicoServicoPorId(OrdemServico_Servico ordemservico_servico, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM OrdemServico_Servico WHERE idOrdemServico = " +ordemservico_servico.getIdOrdemServico()+";";
		ResultSet result = connector.executeQuery(query);
		ArrayList<OrdemServico_Servico> osss = new ArrayList<OrdemServico_Servico>();
		
		while(result.next()){
			OrdemServico_Servico oss = new OrdemServico_Servico();
		
			oss.setPrecoServico(result.getFloat("precoServico"));
			oss.setHorasServico(result.getFloat("horasServico"));
			Servico s = new Servico();
			s.setIdServico(result.getInt("idServico"));
			oss.setIdOrdemServico(result.getInt("idOrdemServico"));
			oss.setServico(s);
			osss.add(oss);
		}
		
		return osss;
			
	}
	
	public void inserirOrdemServicoServico(OrdemServico_Servico oss, SQLConnector connector) throws Exception{
		String query = "INSERT INTO OrdemServico_Servico (idOrdemServico, idServico, precoServico, horasServico)"
				+ " VALUES ("+oss.getIdOrdemServico()+","+oss.getServico().getIdServico()+","+oss.getPrecoServico()+","+oss.getHorasServico()+");";
		connector.executeUpdate(query);
	}
	
}
