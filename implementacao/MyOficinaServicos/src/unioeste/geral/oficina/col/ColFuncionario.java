package unioeste.geral.oficina.col;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Funcionario;
import unioeste.geral.oficina.dao.DAOFuncionario;

public class ColFuncionario {
	public Funcionario obterFuncionarioPorCpf(Funcionario f, SQLConnector connector) throws Exception{
		DAOFuncionario dao = new DAOFuncionario();
		
		return dao.obterFuncionarioPorCpf(f,connector);		
	}
	
	public Funcionario obterFuncionarioPorId(Funcionario f, SQLConnector connector) throws Exception{
		DAOFuncionario dao = new DAOFuncionario();
		
		return dao.obterFuncionarioPorId(f,connector);		
	}
	
	public void inserirFuncionario(Funcionario f, SQLConnector connector) throws Exception{
		DAOFuncionario dao = new DAOFuncionario();
		
		dao.inserirFuncionario(f, connector);
	}
}
