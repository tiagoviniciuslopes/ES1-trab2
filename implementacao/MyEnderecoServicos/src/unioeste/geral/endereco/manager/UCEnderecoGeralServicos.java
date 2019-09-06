package unioeste.geral.endereco.manager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONObject;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.endereco.bo.Bairro;
import unioeste.geral.endereco.bo.Cidade;
import unioeste.geral.endereco.bo.Endereco;
import unioeste.geral.endereco.bo.Logradouro;
import unioeste.geral.endereco.bo.UF;
import unioeste.geral.endereco.col.ColBairro;
import unioeste.geral.endereco.col.ColCidade;
import unioeste.geral.endereco.col.ColEndereco;
import unioeste.geral.endereco.col.ColLogradouro;
import unioeste.geral.endereco.col.ColPais;
import unioeste.geral.endereco.col.ColTipoLogradouro;
import unioeste.geral.endereco.col.ColUF;

public class UCEnderecoGeralServicos {
	
	public Endereco obterEnderecoPorId(Endereco endereco) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColEndereco colEndereco = new ColEndereco();
		ColBairro colBairro = new ColBairro();
		
		endereco = colEndereco.obterEnderecoPorId(endereco, connector);
		endereco.setBairro(colBairro.obterBairroPorId(endereco.getBairro(), connector));
		endereco.setLogradouro(obterLogradouroPorId(endereco.getLogradouro(), connector));
		endereco.setCidade(obterCidadePorId(endereco.getCidade(),connector));		
		
		connector.close();
		endereco.validaObjeto();
		return endereco;
	}
	
	public ArrayList<Endereco> obterEnderecoPorCep(Endereco endereco) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColEndereco colEndereco = new ColEndereco();
		ColBairro colBairro = new ColBairro();
		
		ArrayList<Endereco> enderecos = colEndereco.obterEnderecoPorCep(endereco, connector);
		
		for(Endereco e : enderecos) {
			e.setBairro(colBairro.obterBairroPorId(e.getBairro(), connector));
			e.setLogradouro(obterLogradouroPorId(e.getLogradouro(), connector));
			e.setCidade(obterCidadePorId(e.getCidade(),connector));
			e.validaObjeto();
		}
		
		connector.close();
		return enderecos;
	}
	
	public Endereco obterEnderecoExterno(String cep) throws Exception{
		
		JSONObject obj = new JSONObject(getHttpGET("http://viacep.com.br/ws/" + cep + "/json/"));
		
		Endereco e = new Endereco();
		e.setCep(obj.getString("cep"));
		Bairro b = new Bairro();
		b.setNome(obj.getString("bairro"));
		Logradouro l = new Logradouro();
		l.setNome(obj.getString("logradouro"));
		Cidade c = new Cidade();
		c.setNome(obj.getString("localidade"));
		UF uf = new UF();
		uf.setNome(obj.getString("uf"));
		c.setUf(uf);
		e.setBairro(b);
		e.setCidade(c);
		e.setLogradouro(l);
		
		
		return e;
	}
	
	public final String getHttpGET(String urlToRead) throws Exception{
        StringBuilder result = new StringBuilder();

      
            URL url = new URL(urlToRead);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            
    
        
        return result.toString();
    }

	
	public Cidade obterCidadePorId(Cidade cidade,  SQLConnector connector) throws Exception{
		ColCidade colCidade = new ColCidade();
		ColUF colUF = new ColUF();
		ColPais colPais = new ColPais();
		
		cidade = colCidade.obterCidadePorId(cidade, connector);
		cidade.setUf(colUF.obterUFPorId(cidade.getUf(), connector));
		UF uf = cidade.getUf();
		uf.setPais(colPais.obterPaisPorId(uf.getPais(), connector));
		
		return cidade;
	}
	
	public Logradouro obterLogradouroPorId(Logradouro logradouro,  SQLConnector connector) throws Exception{
		ColLogradouro colLogradouro = new ColLogradouro();
		ColTipoLogradouro colTipoLogradouro = new ColTipoLogradouro();
		
		logradouro = colLogradouro.obterLogradouroPorId(logradouro, connector);
		logradouro.setTipoLogradouro(colTipoLogradouro.obterTipoLogradouroPorId(logradouro.getTipoLogradouro(), connector));
		
		return logradouro;
	}
	
	public Cidade obterCidadePorId(Cidade cidade) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColCidade colCidade = new ColCidade();
		ColUF colUF = new ColUF();
		ColPais colPais = new ColPais();
		
		cidade = colCidade.obterCidadePorId(cidade, connector);
		cidade.setUf(colUF.obterUFPorId(cidade.getUf(), connector));
		UF uf = cidade.getUf();
		uf.setPais(colPais.obterPaisPorId(uf.getPais(), connector));
		
		connector.close();
		return cidade;
	}
	
	public Endereco inserirEndereco(Endereco e) throws Exception {
		SQLConnector connector = new SQLConnector();
		ColEndereco colEndereco = new ColEndereco();
		
		e = colEndereco.inserirEndereco(e, connector);
				
		connector.close();
		return e;
	}
}
