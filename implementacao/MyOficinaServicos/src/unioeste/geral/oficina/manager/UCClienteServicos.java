package unioeste.geral.oficina.manager;

import java.util.ArrayList;

import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;

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
import unioeste.geral.endereco.col.ColEndereco;
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
		
		
		ArrayList<Email> emails = colEmail.obterEmailCliente(f, connector);
		f.setEmail(emails.toArray(new Email[emails.size()]));
		
		ArrayList<Fone> fones = colFone.obterFoneCliente(f, connector);
		ColDDD colDDD = new ColDDD();
		ColDDI colDDI = new ColDDI();
		ColTipoFone colTipoFone = new ColTipoFone();
		for(Fone fone : fones) {
			fone.setDdd(colDDD.obterDDDPorId(fone.getDdd(), connector));
			fone.setDdi(colDDI.obterDDIPorId(fone.getDdi(), connector));
			fone.setTipoFone(colTipoFone.obterTipoFonePorId(fone.getTipoFone(), connector));
		}
		
		f.setFone(fones.toArray(new Fone[fones.size()]));
		
		f.validaObjeto();
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
		
		
		ArrayList<Email> emails = colEmail.obterEmailCliente(f, connector);
		f.setEmail(emails.toArray(new Email[emails.size()]));
		
		ArrayList<Fone> fones = colFone.obterFoneCliente(f, connector);
		ColDDD colDDD = new ColDDD();
		ColDDI colDDI = new ColDDI();
		ColTipoFone colTipoFone = new ColTipoFone();
		for(Fone fone : fones) {
			fone.setDdd(colDDD.obterDDDPorId(fone.getDdd(), connector));
			fone.setDdi(colDDI.obterDDIPorId(fone.getDdi(), connector));
			fone.setTipoFone(colTipoFone.obterTipoFonePorId(fone.getTipoFone(), connector));
		}
		
		f.setFone(fones.toArray(new Fone[fones.size()]));
		
		f.validaObjeto();
		c.setClientePessoa(f);
		
		connector.close();
		return c;
		
	}
	
	public Cliente obterClienteEmpresaPorId(Cliente c) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColCliente colCliente = new ColCliente();
		UCEnderecoGeralServicos ucEndereco = new UCEnderecoGeralServicos();
		ColAtividadeComercial colAtividadeComercial = new ColAtividadeComercial();
		ColEmail colEmail = new ColEmail();
		ColFone colFone = new ColFone();
		
		c = colCliente.obterClienteEmpresaPorId(c, connector);
		ClienteEmpresa f = c.getClienteEmpresa();
		Endereco e = ucEndereco.obterEnderecoPorId(f.getEnderecoEspecifico().getEndereco());
		EnderecoEspecifico ee = f.getEnderecoEspecifico();
		ee.setEndereco(e);
		
		f.setEnderecoEspecifico(ee);

		
		ArrayList<Email> emails = colEmail.obterEmailCliente(f, connector);
		f.setEmail(emails.toArray(new Email[emails.size()]));
		
		ArrayList<Fone> fones = colFone.obterFoneCliente(f, connector);
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
		
		f.validaObjeto();
		c.setClienteEmpresa(f);
		
		connector.close();
		return c;
		
	}
	
	public Cliente obterClienteEmpresaPorCnpj(Cliente c) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColCliente colCliente = new ColCliente();
		UCEnderecoGeralServicos ucEndereco = new UCEnderecoGeralServicos();
		ColAtividadeComercial colAtividadeComercial = new ColAtividadeComercial();
		ColEmail colEmail = new ColEmail();
		ColFone colFone = new ColFone();
		
		c = colCliente.obterClientePorCnpj(c, connector);
		ClienteEmpresa f = c.getClienteEmpresa();
		Endereco e = ucEndereco.obterEnderecoPorId(f.getEnderecoEspecifico().getEndereco());
		EnderecoEspecifico ee = f.getEnderecoEspecifico();
		ee.setEndereco(e);
		
		f.setEnderecoEspecifico(ee);
		
		
		ArrayList<Email> emails = colEmail.obterEmailCliente(f, connector);
		f.setEmail(emails.toArray(new Email[emails.size()]));
		
		ArrayList<Fone> fones = colFone.obterFoneCliente(f, connector);
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
		
		f.validaObjeto();
		c.setClienteEmpresa(f);
		
		connector.close();
		return c;
		
	}
	
	public Cliente inserirClienteEmpresa(Cliente c) throws Exception {
		SQLConnector connector = new SQLConnector();
		ColCliente colCliente = new ColCliente();
		ColEndereco colEndereco = new ColEndereco();
		ColAtividadeComercial colAtividadeComercial = new ColAtividadeComercial();
		ColEmail colEmail = new ColEmail();
		ColFone colFone = new ColFone();
		
		ClienteEmpresa ce = c.getClienteEmpresa();
		ce.setDescricaoFoto(getDescFoto(ce.getCaminhoFoto()));
		EnderecoEspecifico ee = ce.getEnderecoEspecifico();
		ee.setEndereco(colEndereco.inserirEndereco(ee.getEndereco(), connector));
		ce.setEnderecoEspecifico(ee);
		c.setClienteEmpresa(ce);
		
		colCliente.inserirClienteEmpresa(c, connector);
		
		for(AtividadeComercial ac : c.getClienteEmpresa().getAtividadeComercial()) {
			ac = colAtividadeComercial.inserirAtividadeComercial(ac, c.getClienteEmpresa(), connector);
		}
		
		for(Email e : c.getClienteEmpresa().getEmail()) {
			e = colEmail.inserirEmailCliente(e, c.getClienteEmpresa(), connector);
		}
		
		for(Fone f : c.getClienteEmpresa().getFone()) {
			f = colFone.inserirFoneCliente(f, c.getClienteEmpresa(), connector);
		}
		
		
		connector.close();
		return c;
	}
	
	public Cliente inserirClientePessoa(Cliente c) throws Exception {
		SQLConnector connector = new SQLConnector();
		ColCliente colCliente = new ColCliente();
		ColEndereco colEndereco = new ColEndereco();
		ColEmail colEmail = new ColEmail();
		ColFone colFone = new ColFone();
		
		ClientePessoa cp = c.getClientePessoa();
		cp.setDescricaoFoto(getDescFoto(cp.getCaminhoFoto()));
		EnderecoEspecifico ee = cp.getEnderecoEspecifico();
		ee.setEndereco(colEndereco.inserirEndereco(ee.getEndereco(), connector));
		cp.setEnderecoEspecifico(ee);
		c.setClientePessoa(cp);
		
		colCliente.inserirClientePessoa(c, connector);
		
		for(Email e : c.getClientePessoa().getEmail()) {
			e = colEmail.inserirEmailCliente(e, c.getClientePessoa(), connector);
		}
		
		for(Fone f : c.getClientePessoa().getFone()) {
			f = colFone.inserirFoneCliente(f, c.getClientePessoa(), connector);
		}
		
		
		
		connector.close();
		return c;
	}
	
	
	public String getDescFoto(String caminho) throws Exception{
		
		IamOptions options = new IamOptions.Builder ()
		        .apiKey ("MZUFKMo-8P8onuoQhnWqLVxrHaWC18OxnWUoi4a8Ggzp")
		        .build();

		    VisualRecognition service = new VisualRecognition("2018-03-19", options);

		    ClassifyOptions classifyOptions = new ClassifyOptions.Builder ()
		        .url(caminho)
		        .build();
		    ClassifiedImages result = service.classify(classifyOptions).execute().getResult();
		    /*System.out.println(
		        "\n******** Classify with the General model ********\n" + result
		            + "\n******** END Classify with the General model ********\n");*/
		    System.out.println(result.getImages().get(0).getClassifiers().get(0).getClasses().get(0).getClassName());
		
		return result.getImages().get(0).getClassifiers().get(0).getClasses().get(0).getClassName();
	}
	
}
