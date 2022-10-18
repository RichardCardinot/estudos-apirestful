package br.org.serratec.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice // Anotação que pede para que todas as exceptions(Erros) sejam acompanhadas.
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmailException.class) // A anotação @ExceptionHandler pede para apurar as excepetions que não estão 
	// contidas na herança de ResponseEntityExceptionHandler [Usar o Crtl + click esquerdo do mouse em ResponseEntityExceptionHandler 
	// para visualizar a lista de exceptions herdadas [@ExceptionHandler]
	
	public ResponseEntity<Object> handleEmailException(EmailException ex) {
		EmailException emailException = new EmailException(ex.getMessage());
		
		return ResponseEntity.unprocessableEntity().body(emailException);
	}
	
	@ExceptionHandler(HttpClientErrorException.class) // A anotação @ExceptionHandler pede para apurar as excepetions que não estão 
	// contidas na herança de ResponseEntityExceptionHandler [Usar o Crtl + click esquerdo do mouse em ResponseEntityExceptionHandler 
	// para visualizar a lista de exceptions herdadas [@ExceptionHandler]
	
	public ResponseEntity<Object> handleHttpClientErrorException(HttpClientErrorException ex) {	
		return ResponseEntity.unprocessableEntity().body("Cep inválido!");
	}
}
