package unioeste.geral.oficina.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Etapa;
import unioeste.geral.oficina.bo.Funcionario;
import unioeste.geral.oficina.bo.OrdemServico;
import unioeste.geral.oficina.bo.Veiculo;

public class DAOOrdemServico {
		public OrdemServico ObterOrdemServicoId(OrdemServico ordemservico, SQLConnector connector) throws Exception{
			String query ="SELECT * FROM OrdemServico WHERE idOrdemServico = " +ordemservico.getIdOrdemServico()+";";
			ResultSet result = connector.executeQuery(query);
			result.next();
			
			ordemservico.setIdOrdemServico(result.getInt("IdOrdemServico"));
			ordemservico.setData(result.getString("data"));
			ordemservico.setObservacoes(result.getString("observacoes"));
			Etapa e = new Etapa();
			Veiculo v = new Veiculo();
			Funcionario f = new Funcionario();
			e.setIdEtapa(result.getInt("idEtapa"));
			v.setIdVeiculo(result.getInt("idVeiculo"));
			f.setIdPessoa(result.getInt("idFuncionario"));
			ordemservico.setVeiculo(v);
			ordemservico.setEtapa(e);
			ordemservico.setFuncionario(f);
			
			return ordemservico;
		}
		
		public ArrayList<OrdemServico> obterTodosOrdemServico(SQLConnector connector) throws Exception{
			ArrayList<OrdemServico> ordemservico = new ArrayList<OrdemServico>();
			String query = "SELECT * FROM OrdemServico";
			ResultSet result = connector.executeQuery(query);
			
			while(result.next()) {
				OrdemServico os = new OrdemServico();
				os.setIdOrdemServico(result.getInt("IdOrdemServico"));
				os.setData(result.getString("data"));
				os.setObservacoes(result.getString("observacoes"));
				Etapa e = new Etapa();
				Veiculo v = new Veiculo();
				Funcionario f = new Funcionario();
				e.setIdEtapa(result.getInt("idEtapa"));
				v.setIdVeiculo(result.getInt("idVeiculo"));
				f.setIdPessoa(result.getInt("idFuncionario"));
				os.setVeiculo(v);
				os.setEtapa(e);
				os.setFuncionario(f);
				
				ordemservico.add(os);
			}
			return ordemservico;	
		}
		
		public void atualizarEtapa(OrdemServico os, SQLConnector connector) throws Exception{
			String query = "UPDATE OrdemServico SET idEtapa = " +os.getEtapa().getIdEtapa() + " WHERE idOrdemServico = " + os.getIdOrdemServico() +";" ;
			connector.executeUpdate(query);
		}
		
		public OrdemServico inserirOrdemServico(OrdemServico os, SQLConnector connector) throws Exception{
			
			String query = "INSERT INTO OrdemServico (data,observacoes,idEtapa,idVeiculo,idFuncionario)"
					+ " VALUES ("+os.getSQLData()+",'"+os.getObservacoes()+"',"+os.getEtapa().getIdEtapa()+","+os.getVeiculo().getIdVeiculo()+","+os.getFuncionario().getIdPessoa()+");";
			
			os.setIdOrdemServico(connector.executeUpdateLastInserId(query));
		
			return os;
		}
		
}
