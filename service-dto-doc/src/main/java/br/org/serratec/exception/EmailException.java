package br.org.serratec.exception;

public class EmailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Gerado o construtor da superclasse Exception somente com o método Exception(String) [Só ele selecionado].
	public EmailException(String message) {
		super(message);
		
	}
	
}
