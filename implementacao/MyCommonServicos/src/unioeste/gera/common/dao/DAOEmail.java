package unioeste.gera.common.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.common.bo.Email;
import unioeste.geral.common.bo.Pessoa;

public class DAOEmail {

	public ArrayList<Email> obterEmailCliente(Pessoa pessoa, SQLConnector connector) throws Exception{
		ArrayList<Email> email = new ArrayList<Email>();
		
		String query = "SELECT * FROM EmailCliente WHERE idCliente = " + pessoa.getIdPessoa() + ";";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			Email e = new Email();
			
			e.setDescricao(result.getString("descricaoEmail"));
			e.setIdEmail(result.getInt("idEmailCliente"));
			
			email.add(e);
		}
		
		return email;
	}
	
	public ArrayList<Email> obterEmailFuncionario(Pessoa pessoa, SQLConnector connector) throws Exception{
		ArrayList<Email> email = new ArrayList<Email>();
		
		String query = "SELECT * FROM EmailFuncionario WHERE idFuncionario = " + pessoa.getIdPessoa() + ";";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			Email e = new Email();
			
			e.setDescricao(result.getString("descricaoEmail"));
			e.setIdEmail(result.getInt("idEmailFuncionario"));
			
			email.add(e);
		}
		
		return email;
	}
	
	public Email inserirEmailCliente(Email e, Pessoa pessoa, SQLConnector connector) throws Exception {
		String query = "INSERT INTO EmailCliente (descricaoEmail,idCliente) VALUES ('"+e.getDescricao()+"',"+pessoa.getIdPessoa()+");";
		connector.executeUpdate(query);
		
		return e;
	}
	
}
