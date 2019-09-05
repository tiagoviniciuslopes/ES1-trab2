package unioeste.geral.oficina.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Etapa;
import unioeste.geral.oficina.dao.DAOEtapa;

public class ColEtapa {
	public Etapa obterEtapaId(Etapa etapa, SQLConnector connector) throws Exception{
		DAOEtapa dao = new DAOEtapa();
		return dao.obterEtapaId(etapa,connector);
	}
	
	public ArrayList<Etapa> obterTodasEtapas(SQLConnector connector) throws Exception{
		DAOEtapa dao = new DAOEtapa();
		return dao.obterTodasEtapas(connector);
	}
}
