package unioeste.gera.common.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.gera.common.dao.DAOAtividadeComercial;
import unioeste.geral.common.bo.AtividadeComercial;
import unioeste.geral.common.bo.Pessoa;

public class ColAtividadeComercial {

	public AtividadeComercial obterAtividadeComercialPorId(AtividadeComercial atividadeComercial, SQLConnector connector) throws Exception{
		DAOAtividadeComercial dao = new DAOAtividadeComercial();
		
		return dao.obterAtividadeComercialPorId(atividadeComercial, connector);
	}
	
	public ArrayList<AtividadeComercial> obterTodasAtividadesComerciais(SQLConnector connector) throws Exception{
		DAOAtividadeComercial dao = new DAOAtividadeComercial();
		
		return dao.obterTodasAtividadesComerciais(connector);
	}
	
	public ArrayList<AtividadeComercial> obterAtividadeComercialPorEmpresa(Pessoa pessoa, SQLConnector connector) throws Exception{
		DAOAtividadeComercial dao = new DAOAtividadeComercial();
		
		ArrayList<AtividadeComercial> ac = dao.obterAtividadeComercialPorEmpresa(pessoa, connector);
		
		for(AtividadeComercial atividade : ac ) {
			atividade = dao.obterAtividadeComercialPorId(atividade, connector);
		}
		
		return ac;
	}
	
	public AtividadeComercial inserirAtividadeComercial(AtividadeComercial ac ,Pessoa pessoa, SQLConnector connector) throws Exception {
		DAOAtividadeComercial dao = new DAOAtividadeComercial();
		
		return dao.inserirAtividadeComercial(ac, pessoa, connector);
	}
	
}
