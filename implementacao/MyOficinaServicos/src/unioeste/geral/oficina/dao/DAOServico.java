package unioeste.geral.oficina.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Servico;

public class DAOServico {
		public Servico obterServicoPorId(Servico servico,SQLConnector connector) throws Exception{
			String query = "SELECT *FROM Servico WHERE idServico = " +servico.getIdServico()+";";
			ResultSet result = connector.executeQuery(query);
			result.next();
			
			servico.setIdServico(result.getInt("idServico"));
				servico.setPrecoBase(result.getFloat("precoBase"));
					servico.setNome(result.getString("Nome"));
						servico.setHorasBase(result.getFloat("HorasBase"));
			
		return servico;
		}
		
		public ArrayList<Servico> obterTodosServicosId(SQLConnector connector) throws Exception{
			ArrayList<Servico> servico = new ArrayList<Servico>();
			String query = "Select *FROM Servico";
			ResultSet result = connector.executeQuery(query);
			
			while(result.next()){
				Servico s = new Servico();
				s.setIdServico(result.getInt("idServico"));
					s.setPrecoBase(result.getFloat("PrecoBase"));
						s.setNome(result.getString("Nome"));
							s.setHorasBase(result.getFloat("HorasBase"));
				
				servico.add(s);
			}	
			return servico;
		}
}
