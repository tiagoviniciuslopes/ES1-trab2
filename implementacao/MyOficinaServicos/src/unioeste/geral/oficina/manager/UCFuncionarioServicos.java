package unioeste.geral.oficina.manager;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.gera.common.col.ColEmail;
import unioeste.gera.common.col.ColFone;
import unioeste.gera.common.col.ColOrgaoExpeditor;
import unioeste.gera.common.col.ColSexo;
import unioeste.geral.common.bo.DocIdentidade;
import unioeste.geral.common.bo.Email;
import unioeste.geral.common.bo.EnderecoEspecifico;
import unioeste.geral.common.bo.Fone;
import unioeste.geral.common.bo.OrgaoExpeditor;
import unioeste.geral.common.bo.Sexo;
import unioeste.geral.endereco.bo.Endereco;
import unioeste.geral.endereco.col.ColUF;
import unioeste.geral.endereco.manager.UCEnderecoGeralServicos;
import unioeste.geral.oficina.bo.Funcionario;
import unioeste.geral.oficina.col.ColFuncionario;

public class UCFuncionarioServicos {

	public Funcionario obterFuncionarioPorId(Funcionario f) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColFuncionario colFuncionario = new ColFuncionario();
		ColOrgaoExpeditor colOrgaoExpeditor = new ColOrgaoExpeditor();
		UCEnderecoGeralServicos ucEndereco = new UCEnderecoGeralServicos();
		ColUF colUF = new ColUF();
		ColSexo colSexo = new ColSexo();
		ColEmail colEmail = new ColEmail();
		ColFone colFone = new ColFone();
		
		f = colFuncionario.obterFuncionarioPorId(f, connector);
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
		f.setFone(fones.toArray(new Fone[fones.size()]));
		
		connector.close();
		f.validaObjeto();
		return f;
		
	}
	
	public Funcionario obterFuncionarioPorCpf(Funcionario f) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColFuncionario colFuncionario = new ColFuncionario();
		ColOrgaoExpeditor colOrgaoExpeditor = new ColOrgaoExpeditor();
		UCEnderecoGeralServicos ucEndereco = new UCEnderecoGeralServicos();
		ColUF colUF = new ColUF();
		ColSexo colSexo = new ColSexo();
		ColEmail colEmail = new ColEmail();
		ColFone colFone = new ColFone();
		
		f = colFuncionario.obterFuncionarioPorCpf(f, connector);
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
		f.setFone(fones.toArray(new Fone[fones.size()]));
		
		connector.close();
		f.validaObjeto();
		return f;
		
	}
	
}
