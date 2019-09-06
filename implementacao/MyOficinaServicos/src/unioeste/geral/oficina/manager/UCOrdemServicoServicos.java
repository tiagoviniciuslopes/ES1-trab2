package unioeste.geral.oficina.manager;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Etapa;
import unioeste.geral.oficina.bo.Funcionario;
import unioeste.geral.oficina.bo.OrdemServico;
import unioeste.geral.oficina.bo.OrdemServico_Produto;
import unioeste.geral.oficina.bo.OrdemServico_Servico;
import unioeste.geral.oficina.col.ColEtapa;
import unioeste.geral.oficina.col.ColOrdemServico;
import unioeste.geral.oficina.col.ColOrdemServico_Produto;
import unioeste.geral.oficina.col.ColOrdemServico_Servico;
import unioeste.geral.oficina.col.ColProduto;
import unioeste.geral.oficina.col.ColServico;

public class UCOrdemServicoServicos {

	public OrdemServico obterOrdemServicoPorId(OrdemServico os) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColOrdemServico colOrdemServico = new ColOrdemServico();
		ColEtapa colEtapa = new ColEtapa();
		ColOrdemServico_Servico colOSS = new ColOrdemServico_Servico();
		ColOrdemServico_Produto colOSP = new ColOrdemServico_Produto();
		UCFuncionarioServicos ucf = new UCFuncionarioServicos();
		UCVeiculoServicos ucv = new UCVeiculoServicos();
		ColServico colServico = new ColServico();
		ColProduto colProduto = new ColProduto();
		
		
		os = colOrdemServico.obterOrdemServicoId(os, connector);
		os.setEtapa(colEtapa.obterEtapaId(os.getEtapa(), connector));
		os.setPrecoTotal(0);
		
		OrdemServico_Servico oss_aux = new OrdemServico_Servico();
		oss_aux.setIdOrdemServico(os.getIdOrdemServico());
		ArrayList<OrdemServico_Servico> osss = colOSS.obterOrdemServicoServicoId(oss_aux, connector);
		os.setOrdemServico_Servico(osss.toArray(new OrdemServico_Servico[osss.size()]));
		for(OrdemServico_Servico oss : os.getOrdemServico_Servico()) {
			oss.setServico(colServico.obterServicoPorId(oss.getServico(), connector));
			os.setPrecoTotal(os.getPrecoTotal() + oss.getPrecoServico());
		}
		os.setOrdemServico_Servico(osss.toArray(new OrdemServico_Servico[osss.size()]));
		
		OrdemServico_Produto osp_aux = new OrdemServico_Produto();
		osp_aux.setIdOrdemServico(os.getIdOrdemServico());
		ArrayList<OrdemServico_Produto> osps = colOSP.obterOrdemServicoProdutoId(osp_aux, connector);
		os.setOrdemServico_Produto(osps.toArray(new OrdemServico_Produto[osps.size()]));
		for(OrdemServico_Produto osp : os.getOrdemServico_Produto()) {
			osp.setProduto(colProduto.obterProdutoPorId(osp.getProduto(), connector));
			osp.setTotal(osp.getPrecoProduto() * osp.getQuantidadeProduto());
			os.setPrecoTotal(os.getPrecoTotal() + osp.getTotal());
		}
		os.setOrdemServico_Produto(osps.toArray(new OrdemServico_Produto[osps.size()]));
		
		os.setFuncionario(ucf.obterFuncionarioPorId(os.getFuncionario()));
		os.setVeiculo(ucv.obterVeiculoPorId(os.getVeiculo()));
		
		connector.close();
		return os;
	}
	
	public OrdemServico inserirOrdemServico(OrdemServico os) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColOrdemServico colOS = new ColOrdemServico();
		ColOrdemServico_Servico colOSS = new ColOrdemServico_Servico();
		ColOrdemServico_Produto colOSP = new ColOrdemServico_Produto();
		
		Etapa e = new Etapa();
		e.setIdEtapa(1);
		Funcionario f = new Funcionario();
		f.setIdPessoa(1);
		
		os.setEtapa(e);
		os.setFuncionario(f);
		
		os = colOS.inserirOrdemServico(os, connector);
		
		for(OrdemServico_Servico oss : os.getOrdemServico_Servico()) {
			oss.setIdOrdemServico(os.getIdOrdemServico());
			colOSS.inserirOrdemServicoServico(oss, connector);
		}
		
		for(OrdemServico_Produto osp : os.getOrdemServico_Produto()) {
			osp.setIdOrdemServico(os.getIdOrdemServico());
			colOSP.inserirOrdemServicoProduto(osp, connector);
		}
		
		connector.close();
		return os;
	}
	
	public OrdemServico atualizarEtapa(OrdemServico os) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColOrdemServico colOS = new ColOrdemServico();
		os = obterOrdemServicoPorId(os);
		
		Etapa e = os.getEtapa();
		e.setIdEtapa(e.getIdEtapa()+1);
		os.setEtapa(e);
		
		colOS.atualizarEtapa(os, connector);
		connector.close();
		return os;
	}
	
}
