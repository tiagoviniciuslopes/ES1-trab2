package unioeste.geral.endereco.manager;

import java.util.ArrayList;

import unioeste.geral.endereco.col.ColBairro;
import unioeste.geral.endereco.col.ColCidade;
import unioeste.geral.endereco.col.ColEndereco;
import unioeste.geral.endereco.col.ColLogradouro;
import unioeste.geral.endereco.col.ColPais;
import unioeste.geral.endereco.col.ColTipoLogradouro;
import unioeste.geral.endereco.col.ColUF;
import unioeste.geral.endereco.col.SQLConnector;
import unioeste.geral.endereco.dao.Endereco;

public class UCEnderecoGeralServicos {
	
	public Endereco obterEnderecoPorId(Endereco endereco) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColEndereco colEndereco = new ColEndereco();
		ColBairro colBairro = new ColBairro();
		
		endereco = colEndereco.obterEnderecoPorId(endereco, connector);
		endereco.setBairro(colBairro.obterBairroPorId(endereco.getBairro(), connector));
		endereco.setLogradouro(oberLogradouroPorId(endereco.getLogradouro(), connector));
		endereco.setCidade(obterCidadePorId(endereco.getCidade(),connector));		
		
		connector.close();
		return endereco;
	}
	
	public ArrayList<Endereco> obterEnderecoPorCep(Endereco endereco) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColEndereco colEndereco = new ColEndereco();
		ColBairro colBairro = new ColBairro();
		
		ArrayList<Endereco> enderecos = colEndereco.obterEnderecoPorCep(endereco, connector);
		
		for(Enderecos e : enderecos) {
			e.setBairro(colBairro.obterBairroPorId(e.getBairro(), connector));
			e.setLogradouro(oberLogradouroPorId(e.getLogradouro(), connector));
			e.setCidade(obterCidadePorId(e.getCidade(),connector));		
		}
		
		return enderecos;
		connector.close();
	}
	
	public Endereco obterEnderecoExterno(String site) {
		
		//pesquisa em um site
		
		return new Endereco();
	}
	
	public Cidade obterCidadePorId(Cidade cidade,  SQLConnector connector) {
		ColCidade colCidade = new ColCidade();
		ColUF colUF = new ColUF();
		ColPais colPais = new ColPais();
		
		cidade = colCidade.obterCidadePorId(cidade, connector);
		cidade.setUF(colUF.obterUFPorId(cidade.getUF(), connector));
		UF uf = cidade.getUF();
		uf.setPais(colPais.obterPaisPorId(uf.getPais(), connector));
		
		return cidade;
	}
	
	public Logradouro obterLogradouroPorId(Logradouro logradouro,  SQLConnector connector) {
		ColLogradouro colLogradouro = new ColLogradouro();
		ColTipoLogradouro colTipoLogradouro = new ColTipoLogradouro();
		
		logradouro = colLogradouro.obterLogradouroPorId(logradouro, connector);
		logradouro.setTipoLogradouro(colTipoLogradouro.obterTipoLogradouroPorId(logradouro.getTipoLogradouro(), connector));
		
		return logradouro;
	}
	
	public Cidade obterCidadePorId(Cidade cidade) {
		SQLConnector connector = new SQLConnector();
		ColCidade colCidade = new ColCidade();
		ColUF colUF = new ColUF();
		ColPais colPais = new ColPais();
		
		cidade = colCidade.obterCidadePorId(cidade, connector);
		cidade.setUf(colUF.obterUFPorId(cidade.getUF(), connector));
		UF uf = cidade.getUF();
		uf.setPais(colPais.obterPaisPorId(uf.getPais(), connector));
		
		connector.close();
		return cidade;
	}
	
}
