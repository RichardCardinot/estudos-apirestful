package br.org.serratec.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.org.serratec.exception.EnumValidationException;

public enum Categoria {
	HATCH,SEDAN,PICAPE,SUV,MINIVAN,CONVERSIVEL;
	
	// A anotação @JsonCreator diz que o Json será validado 
	@JsonCreator   // Lançando a throws EnumValidationException para quem chamar o método validar com o try catch
	public static Categoria verifica(String valor) throws EnumValidationException{
		
		         // Como não é uma classe e não vou instanciar, o método é satatic
		 for (Categoria categoria : Categoria.values()) {
			if (valor.equals(categoria.name())) {
				return categoria;
			}
		}
		// O "throw new" lança um exception. A "EnumValidationException" é uma classe de erro nossa, personalizada
		throw new EnumValidationException("Preencha a categoria corretamente");
	}
}
