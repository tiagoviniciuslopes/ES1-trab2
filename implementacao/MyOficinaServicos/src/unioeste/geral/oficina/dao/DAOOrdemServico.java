package unioeste.geral.oficina.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.OrdemServico;

public class DAOOrdemServico {
		public OrdemServico ObterOrdemServicoId(OrdemServico ordemservico, SQLConnector connector) throws Exception{
			String query ="SELECT *FROM OrdemServico WHERE idOrdemServico = " +ordemservico.getIdOrdemServico()+";";
			ResultSet result = connector.executeQuery(query);
			result.next();
			
			ordemservico.setIdOrdemServico(result.getInt("IdOrdemServico"));
			ordemservico.setPrecoTotal(result.getFloat("PrecoTotal"));
			ordemservico.setHorasTotal(result.getInt("HorasTotal"));
			ordemservico.setData(result.getDate("Data"));
			ordemservico.setObservacoes(result.getString("Observacoes"));
			
			
			return ordemservico;
		}
		
		public ArrayList<OrdemServico> obterTodosOrdemServicoId(SQLConnector connector) throws Exception{
			ArrayList<OrdemServico> ordemservico = new ArrayList<OrdemServico>();
			String query = "Select *FROM OrdemServico";
			ResultSet result = connector.executeQuery(query);
			
			while(result.next()) {
				OrdemServico os = new OrdemServico();
					os.setIdOrdemServico(result.getInt("IdServico"));
					os.setPrecoTotal(result.getFloat("PrecoTotal"));
					os.setHorasTotal(result.getInt("HorasTotal"));
					os.setData(result.getDate("data"));
					os.setObservacoes(result.getString("Observacoes"));
					
					ordemservico.add(os);
			}
			return ordemservico;	
		}	
}
