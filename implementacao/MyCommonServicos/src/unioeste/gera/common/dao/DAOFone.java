package unioeste.gera.common.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.common.bo.DDD;
import unioeste.geral.common.bo.DDI;
import unioeste.geral.common.bo.Fone;
import unioeste.geral.common.bo.Pessoa;
import unioeste.geral.common.bo.TipoFone;

public class DAOFone {
	
	public ArrayList<Fone> obterFoneCliente(Pessoa pessoa, SQLConnector connector) throws Exception{
		ArrayList<Fone> fone = new ArrayList<Fone>();
		
		String query = "SELECT * FROM FoneCliente WHERE idCliente = " + pessoa.getIdPessoa() + ";";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			Fone f = new Fone();
			
			f.setNumeroTelefone(result.getString("numeroFone"));
			f.setIdFone(result.getInt("idFoneCliente"));
			
			DDD ddd = new DDD();
			DDI ddi = new DDI();
			TipoFone tf = new TipoFone();
			
			ddd.setIdDDD(result.getInt("idDDD"));
			ddi.setIdDDI(result.getInt("idDDI"));
			tf.setIdTipoFone(result.getInt("idTipoFone"));
			
			f.setDdd(ddd);
			f.setDdi(ddi);
			f.setTipoFone(tf);
			
			fone.add(f);
		}
		
		return fone;
	}
	
	public ArrayList<Fone> obterFoneFuncionario(Pessoa pessoa, SQLConnector connector) throws Exception{
		ArrayList<Fone> fone = new ArrayList<Fone>();
		
		String query = "SELECT * FROM FoneFuncionario WHERE idFuncionario = " + pessoa.getIdPessoa() + ";";
		ResultSet result = connector.executeQuery(query);
		
		while (result.next()) {
			Fone f = new Fone();
			
			f.setNumeroTelefone(result.getString("numeroFone"));
			f.setIdFone(result.getInt("idFoneFuncionario"));
			
			DDD ddd = new DDD();
			DDI ddi = new DDI();
			TipoFone tf = new TipoFone();
			
			ddd.setIdDDD(result.getInt("idDDD"));
			ddi.setIdDDI(result.getInt("idDDI"));
			tf.setIdTipoFone(result.getInt("idTipoFone"));
			
			f.setDdd(ddd);
			f.setDdi(ddi);
			f.setTipoFone(tf);
			
			fone.add(f);
		}
		
		return fone;
	}
	
	public Fone inserirFoneCliente(Fone f, Pessoa pessoa, SQLConnector connector) throws Exception {
		String query = "INSERT INTO FoneCliente (numeroFone, idCliente, idDDD, idDDI, idTipoFone) VALUES ('"+f.getNumeroTelefone()+"',"+pessoa.getIdPessoa()+","+f.getDdd().getIdDDD()+","+f.getDdi().getIdDDI()+","+f.getTipoFone().getIdTipoFone()+")";
		connector.executeUpdate(query);
		
		return f;
	}
	
}
