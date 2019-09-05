package unioeste.geral.endereco.exception;

public class EnderecoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnderecoException() {
		System.out.println("Erro no endereco");
	}
	
	public EnderecoException(String m) {
		System.out.println(m);
	}
}
