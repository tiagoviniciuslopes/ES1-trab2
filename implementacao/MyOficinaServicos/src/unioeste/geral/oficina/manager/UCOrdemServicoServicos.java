package unioeste.geral.oficina.manager;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.OrdemServico;
import unioeste.geral.oficina.bo.OrdemServico_Produto;
import unioeste.geral.oficina.bo.OrdemServico_Servico;
import unioeste.geral.oficina.col.ColEtapa;
import unioeste.geral.oficina.col.ColFuncionario;
import unioeste.geral.oficina.col.ColOrdemServico;
import unioeste.geral.oficina.col.ColOrdemServico_Produto;
import unioeste.geral.oficina.col.ColOrdemServico_Servico;
import unioeste.geral.oficina.col.ColProduto;
import unioeste.geral.oficina.col.ColServico;
import unioeste.geral.oficina.col.ColVeiculo;

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
		
		
		os = colOrdemServico.ObterOrdemServicoId(os, connector);
		os.setEtapa(colEtapa.obterEtapaId(os.getEtapa(), connector));
		
		OrdemServico_Servico oss_aux = new OrdemServico_Servico();
		ArrayList<OrdemServico_Servico> osss = colOSS.obterOrdemServicoServicoId(oss_aux, connector);
		os.setOrdemServico_Servico(osss.toArray(new OrdemServico_Servico[osss.size()]));
		for(OrdemServico_Servico oss : os.getOrdemServico_Servico()) {
			oss.setServico(colServico.obterServicoPorId(oss.getServico(), connector));
		}
		
		OrdemServico_Produto osp_aux = new OrdemServico_Produto();
		ArrayList<OrdemServico_Produto> osps = colOSP.obterOrdemServicoProdutoId(osp_aux, connector);
		os.setOrdemServico_Produto(osps.toArray(new OrdemServico_Produto[osps.size()]));
		for(OrdemServico_Produto osp : os.getOrdemServico_Produto()) {
			osp.setProduto(colProduto.obterProdutoPorId(osp.getProduto(), connector));
		}
		
		os.setFuncionario(ucf.obterFuncionarioPorId(os.getFuncionario()));
		os.setVeiculo(ucv.obterVeiculoPorId(os.getVeiculo()));
		
		/*private Etapa etapa;
	
		private OrdemServico_Servico[] ordemServico_Servico;
	
		private OrdemServico_Produto[] ordemServico_Produto;
		
		private Funcionario funcionario;
		
		private Veiculo veiculo;*/
		
		connector.close();
		return os;
	}
	
}
