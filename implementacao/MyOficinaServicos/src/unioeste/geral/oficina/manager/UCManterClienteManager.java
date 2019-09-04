package unioeste.geral.oficina.manager;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.oficina.col.ColPlaca;
import unioeste.geral.oficina.bo.Placa;
import java.util.ArrayList;

public class UCManterClienteManager {
	public Placa obterPlaca(Placa placa) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColPlaca colPlaca = new ColPlaca();
		
		placa = colPlaca.obterPlaca(placa, connector);
		placa.setPlaca(colPlaca.obterPlaca(placa.getPlaca(), connector));
		
		connector.close();
		return placa;
		
	}
}
