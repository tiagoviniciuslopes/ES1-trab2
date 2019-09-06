package unioeste.gera.common.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.common.bo.AtividadeComercial;
import unioeste.geral.common.bo.Pessoa;

public class DAOAtividadeComercial {
	
	public AtividadeComercial obterAtividadeComercialPorId(AtividadeComercial atividadeComercial, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM AtividadeComercial WHERE idAtividadeComercial = "+atividadeComercial.getIdAtividadeComercial()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		atividadeComercial.setDescricao(result.getString("descricaoAtividadeComercial"));
		atividadeComercial.setIdAtividadeComercial(result.getInt("idAtividadeComercial"));
		
		return atividadeComercial;
	}
	
	public ArrayList<AtividadeComercial> obterTodasAtividadesComerciais(SQLConnector connector) throws Exception{
		ArrayList<AtividadeComercial> atividadeComercial = new ArrayList<AtividadeComercial>();
		
		String query = "SELECT * FROM AtividadeComercial;";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			AtividadeComercial ac = new AtividadeComercial();
			
			ac.setDescricao(result.getString("descricaoAtividadeComercial"));
			ac.setIdAtividadeComercial(result.getInt("idAtividadeComercial"));
			
			atividadeComercial.add(ac);
		}
		
		return atividadeComercial;
	}
	
	public ArrayList<AtividadeComercial> obterAtividadeComercialPorEmpresa(Pessoa pessoa, SQLConnector connector) throws Exception{
		ArrayList<AtividadeComercial> atividadeComercial = new ArrayList<AtividadeComercial>();
		
		String query = "SELECT * FROM AtividadeComercial_Cliente WHERE idCliente = " + pessoa.getIdPessoa() + ";";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			AtividadeComercial ac = new AtividadeComercial();
			
			ac.setIdAtividadeComercial(result.getInt("idAtividadeComercial"));
			
			atividadeComercial.add(ac);
		}
		
		return atividadeComercial;
	}
	
	public AtividadeComercial inserirAtividadeComercial(AtividadeComercial ac,Pessoa pessoa, SQLConnector connector) throws Exception {
		String query = "INSERT INTO AtividadeComercial_Cliente (idAtividadeComercial, idCliente) VALUES ("+ac.getIdAtividadeComercial()+","+pessoa.getIdPessoa()+");";
		connector.executeUpdate(query);
		
		return ac;
	}
}
