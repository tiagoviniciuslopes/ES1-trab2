package unioeste.geral.oficina.manager;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Servico;
import unioeste.geral.oficina.col.ColServico;

public class UCServicoServicos {

	public Servico obterServicoPorId(Servico servico) throws Exception{
		ColServico colServico = new ColServico();
		SQLConnector connector = new SQLConnector();
		
		Servico s = colServico.obterServicoPorId(servico, connector);
		connector.close();
		return s;
	}
	
	public ArrayList<Servico> obterTodosServicos() throws Exception{
		ColServico colServico = new ColServico();
		SQLConnector connector = new SQLConnector();
		
		ArrayList<Servico> s = colServico.obterTodosServicos( connector);
		connector.close();
		return s;
	}
	
}
