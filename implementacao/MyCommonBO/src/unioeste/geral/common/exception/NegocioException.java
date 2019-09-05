package unioeste.geral.common.exception;

public class NegocioException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegocioException(String m) {
		System.out.println(m);
	}
	
	public NegocioException() {
		System.out.println("Algum dado informado é invalido");
	}
}
