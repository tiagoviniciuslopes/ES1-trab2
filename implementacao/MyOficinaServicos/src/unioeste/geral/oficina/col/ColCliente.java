package unioeste.geral.oficina.col;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.bo.Cliente;
import unioeste.geral.oficina.dao.DAOCliente;

public class ColCliente {

	public Cliente obterClientePorCpf(Cliente c, SQLConnector connector) throws Exception{
		DAOCliente dao = new DAOCliente();
		
		c = dao.obterClientePorCpf(c,connector);	
		c.setClienteEmpresa(null);
		
		return c;
	}
	
	public Cliente obterClientePorCnpj(Cliente c, SQLConnector connector) throws Exception{
		DAOCliente dao = new DAOCliente();
		
		c =  dao.obterClientePorCnpj(c,connector);
		c.setClientePessoa(null);
		
		return c;		
	}
	
	public Cliente obterClienteEmpresaPorId(Cliente c, SQLConnector connector) throws Exception{
		DAOCliente dao = new DAOCliente();
		
		return dao.obterClienteEmpresaPorId(c,connector);		
	}
	
	public Cliente obterClientePessoaPorId(Cliente c, SQLConnector connector) throws Exception{
		DAOCliente dao = new DAOCliente();
		
		return dao.obterClientePessoaPorId(c,connector);		
	}
	
	public void inserirClientePessoa(Cliente c, SQLConnector connector) throws Exception{
		DAOCliente dao = new DAOCliente();
		
		dao.inserirClientePessoa(c, connector);
	}
	
	public void inserirClienteEmpresa(Cliente c, SQLConnector connector) throws Exception{
		DAOCliente dao = new DAOCliente();
		
		dao.inserirClienteEmpresa(c, connector);
	}
	
}
