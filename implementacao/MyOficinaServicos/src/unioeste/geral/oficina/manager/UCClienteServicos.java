package unioeste.geral.oficina.manager;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.gera.common.col.ColAtividadeComercial;
import unioeste.gera.common.col.ColDDD;
import unioeste.gera.common.col.ColDDI;
import unioeste.gera.common.col.ColEmail;
import unioeste.gera.common.col.ColFone;
import unioeste.gera.common.col.ColOrgaoExpeditor;
import unioeste.gera.common.col.ColSexo;
import unioeste.gera.common.col.ColTipoFone;
import unioeste.geral.common.bo.AtividadeComercial;
import unioeste.geral.common.bo.DocIdentidade;
import unioeste.geral.common.bo.Email;
import unioeste.geral.common.bo.EnderecoEspecifico;
import unioeste.geral.common.bo.Fone;
import unioeste.geral.common.bo.OrgaoExpeditor;
import unioeste.geral.common.bo.Sexo;
import unioeste.geral.endereco.bo.Endereco;
import unioeste.geral.endereco.col.ColUF;
import unioeste.geral.endereco.manager.UCEnderecoGeralServicos;
import unioeste.geral.oficina.bo.Cliente;
import unioeste.geral.oficina.bo.ClienteEmpresa;
import unioeste.geral.oficina.bo.ClientePessoa;
import unioeste.geral.oficina.col.ColCliente;

public class UCClienteServicos {

	public Cliente obterClientePessoaPorId(Cliente c) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColCliente colCliente = new ColCliente();
		ColOrgaoExpeditor colOrgaoExpeditor = new ColOrgaoExpeditor();
		UCEnderecoGeralServicos ucEndereco = new UCEnderecoGeralServicos();
		ColUF colUF = new ColUF();
		ColSexo colSexo = new ColSexo();
		ColEmail colEmail = new ColEmail();
		ColFone colFone = new ColFone();
		
		c = colCliente.obterClientePessoaPorId(c, connector);
		ClientePessoa f = c.getClientePessoa();
		OrgaoExpeditor oe = colOrgaoExpeditor.obterOrgaoExpeditorPorId(f.getDocIdentidade().getOrgaoExpeditor(), connector);
		Endereco e = ucEndereco.obterEnderecoPorId(f.getEnderecoEspecifico().getEndereco());
		Sexo s = colSexo.obterSexoPorId(f.getSexo(), connector);
		
		DocIdentidade di = f.getDocIdentidade();
		oe.setUf(colUF.obterUFPorId(oe.getUf(), connector));
		di.setOrgaoExpeditor(oe);
		EnderecoEspecifico ee = f.getEnderecoEspecifico();
		ee.setEndereco(e);
		
		f.setDocIdentidade(di);
		f.setEnderecoEspecifico(ee);
		f.setSexo(s);
		
		
		ArrayList<Email> emails = colEmail.obterEmailFuncionario(f, connector);
		f.setEmail(emails.toArray(new Email[emails.size()]));
		
		ArrayList<Fone> fones = colFone.obterFoneFuncionario(f, connector);
		ColDDD colDDD = new ColDDD();
		ColDDI colDDI = new ColDDI();
		ColTipoFone colTipoFone = new ColTipoFone();
		for(Fone fone : fones) {
			fone.setDdd(colDDD.obterDDDPorId(fone.getDdd(), connector));
			fone.setDdi(colDDI.obterDDIPorId(fone.getDdi(), connector));
			fone.setTipoFone(colTipoFone.obterTipoFonePorId(fone.getTipoFone(), connector));
		}
		
		f.setFone(fones.toArray(new Fone[fones.size()]));
		
		c.setClientePessoa(f);
		
		connector.close();
		return c;
		
	}
	
	public Cliente obterClientePessoaPorCpf(Cliente c) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColCliente colCliente = new ColCliente();
		ColOrgaoExpeditor colOrgaoExpeditor = new ColOrgaoExpeditor();
		UCEnderecoGeralServicos ucEndereco = new UCEnderecoGeralServicos();
		ColUF colUF = new ColUF();
		ColSexo colSexo = new ColSexo();
		ColEmail colEmail = new ColEmail();
		ColFone colFone = new ColFone();
		
		c = colCliente.obterClientePorCpf(c, connector);
		ClientePessoa f = c.getClientePessoa();
		OrgaoExpeditor oe = colOrgaoExpeditor.obterOrgaoExpeditorPorId(f.getDocIdentidade().getOrgaoExpeditor(), connector);
		Endereco e = ucEndereco.obterEnderecoPorId(f.getEnderecoEspecifico().getEndereco());
		Sexo s = colSexo.obterSexoPorId(f.getSexo(), connector);
		
		DocIdentidade di = f.getDocIdentidade();
		oe.setUf(colUF.obterUFPorId(oe.getUf(), connector));
		di.setOrgaoExpeditor(oe);
		EnderecoEspecifico ee = f.getEnderecoEspecifico();
		ee.setEndereco(e);
		
		f.setDocIdentidade(di);
		f.setEnderecoEspecifico(ee);
		f.setSexo(s);
		
		
		ArrayList<Email> emails = colEmail.obterEmailFuncionario(f, connector);
		f.setEmail(emails.toArray(new Email[emails.size()]));
		
		ArrayList<Fone> fones = colFone.obterFoneFuncionario(f, connector);
		ColDDD colDDD = new ColDDD();
		ColDDI colDDI = new ColDDI();
		ColTipoFone colTipoFone = new ColTipoFone();
		for(Fone fone : fones) {
			fone.setDdd(colDDD.obterDDDPorId(fone.getDdd(), connector));
			fone.setDdi(colDDI.obterDDIPorId(fone.getDdi(), connector));
			fone.setTipoFone(colTipoFone.obterTipoFonePorId(fone.getTipoFone(), connector));
		}
		
		f.setFone(fones.toArray(new Fone[fones.size()]));
		
		c.setClientePessoa(f);
		
		connector.close();
		return c;
		
	}
	
	public Cliente obterClienteEmpresaPorId(Cliente c) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColCliente colCliente = new ColCliente();
		//ColOrgaoExpeditor colOrgaoExpeditor = new ColOrgaoExpeditor();
		UCEnderecoGeralServicos ucEndereco = new UCEnderecoGeralServicos();
		//ColUF colUF = new ColUF();
		//ColSexo colSexo = new ColSexo();
		ColAtividadeComercial colAtividadeComercial = new ColAtividadeComercial();
		ColEmail colEmail = new ColEmail();
		ColFone colFone = new ColFone();
		
		c = colCliente.obterClienteEmpresaPorId(c, connector);
		ClienteEmpresa f = c.getClienteEmpresa();
		//OrgaoExpeditor oe = colOrgaoExpeditor.obterOrgaoExpeditorPorId(f.getDocIdentidade().getOrgaoExpeditor(), connector);
		Endereco e = ucEndereco.obterEnderecoPorId(f.getEnderecoEspecifico().getEndereco());
		//Sexo s = colSexo.obterSexoPorId(f.getSexo(), connector);
		
		//DocIdentidade di = f.getDocIdentidade();
		//oe.setUf(colUF.obterUFPorId(oe.getUf(), connector));
		//di.setOrgaoExpeditor(oe);
		EnderecoEspecifico ee = f.getEnderecoEspecifico();
		ee.setEndereco(e);
		
		//f.setDocIdentidade(di);
		f.setEnderecoEspecifico(ee);
		//f.setSexo(s);
		
		
		ArrayList<Email> emails = colEmail.obterEmailFuncionario(f, connector);
		f.setEmail(emails.toArray(new Email[emails.size()]));
		
		ArrayList<Fone> fones = colFone.obterFoneFuncionario(f, connector);
		ColDDD colDDD = new ColDDD();
		ColDDI colDDI = new ColDDI();
		ColTipoFone colTipoFone = new ColTipoFone();
		for(Fone fone : fones) {
			fone.setDdd(colDDD.obterDDDPorId(fone.getDdd(), connector));
			fone.setDdi(colDDI.obterDDIPorId(fone.getDdi(), connector));
			fone.setTipoFone(colTipoFone.obterTipoFonePorId(fone.getTipoFone(), connector));
		}
		
		f.setFone(fones.toArray(new Fone[fones.size()]));
		
		ArrayList<AtividadeComercial> atividades = colAtividadeComercial.obterAtividadeComercialPorEmpresa(f, connector);
		f.setAtividadeComercial(atividades.toArray(new AtividadeComercial[atividades.size()]));
		
		c.setClienteEmpresa(f);
		
		connector.close();
		return c;
		
	}
	
	public Cliente obterClienteEmpresaPorCnpj(Cliente c) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColCliente colCliente = new ColCliente();
		//ColOrgaoExpeditor colOrgaoExpeditor = new ColOrgaoExpeditor();
		UCEnderecoGeralServicos ucEndereco = new UCEnderecoGeralServicos();
		//ColUF colUF = new ColUF();
		//ColSexo colSexo = new ColSexo();
		ColAtividadeComercial colAtividadeComercial = new ColAtividadeComercial();
		ColEmail colEmail = new ColEmail();
		ColFone colFone = new ColFone();
		
		c = colCliente.obterClientePorCnpj(c, connector);
		ClienteEmpresa f = c.getClienteEmpresa();
		//OrgaoExpeditor oe = colOrgaoExpeditor.obterOrgaoExpeditorPorId(f.getDocIdentidade().getOrgaoExpeditor(), connector);
		Endereco e = ucEndereco.obterEnderecoPorId(f.getEnderecoEspecifico().getEndereco());
		//Sexo s = colSexo.obterSexoPorId(f.getSexo(), connector);
		
		//DocIdentidade di = f.getDocIdentidade();
		//oe.setUf(colUF.obterUFPorId(oe.getUf(), connector));
		//di.setOrgaoExpeditor(oe);
		EnderecoEspecifico ee = f.getEnderecoEspecifico();
		ee.setEndereco(e);
		
		//f.setDocIdentidade(di);
		f.setEnderecoEspecifico(ee);
		//f.setSexo(s);
		
		
		ArrayList<Email> emails = colEmail.obterEmailFuncionario(f, connector);
		f.setEmail(emails.toArray(new Email[emails.size()]));
		
		ArrayList<Fone> fones = colFone.obterFoneFuncionario(f, connector);
		ColDDD colDDD = new ColDDD();
		ColDDI colDDI = new ColDDI();
		ColTipoFone colTipoFone = new ColTipoFone();
		for(Fone fone : fones) {
			fone.setDdd(colDDD.obterDDDPorId(fone.getDdd(), connector));
			fone.setDdi(colDDI.obterDDIPorId(fone.getDdi(), connector));
			fone.setTipoFone(colTipoFone.obterTipoFonePorId(fone.getTipoFone(), connector));
		}
		
		f.setFone(fones.toArray(new Fone[fones.size()]));
		
		ArrayList<AtividadeComercial> atividades = colAtividadeComercial.obterAtividadeComercialPorEmpresa(f, connector);
		f.setAtividadeComercial(atividades.toArray(new AtividadeComercial[atividades.size()]));
		
		c.setClienteEmpresa(f);
		
		connector.close();
		return c;
		
	}
	
	
}
