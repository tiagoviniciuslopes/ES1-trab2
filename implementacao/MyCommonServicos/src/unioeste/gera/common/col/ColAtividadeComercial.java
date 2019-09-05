package unioeste.gera.common.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.gera.common.dao.DAOAtividadeComercial;
import unioeste.geral.common.bo.AtividadeComercial;

public class ColAtividadeComercial {

	public AtividadeComercial obterAtividadeComercialPorId(AtividadeComercial atividadeComercial, SQLConnector connector) throws Exception{
		DAOAtividadeComercial dao = new DAOAtividadeComercial();
		
		return dao.obterAtividadeComercialPorId(atividadeComercial, connector);
	}
	
	public ArrayList<AtividadeComercial> obterTodasAtividadesComerciais(SQLConnector connector) throws Exception{
		DAOAtividadeComercial dao = new DAOAtividadeComercial();
		
		return dao.obterTodasAtividadesComerciais(connector);
	}
	
}
