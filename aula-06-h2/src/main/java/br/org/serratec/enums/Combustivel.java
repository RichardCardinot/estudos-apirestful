package br.org.serratec.enums;

import br.org.serratec.exception.EnumValidationException;

public enum Combustivel {
	ALCOOL(1, "ÁLCOOL"), GASOLINA(2, "GASOLINA"), DIESEL(3, "DIESEL"), FLEX(4, "FLEX");

	private Integer codigo;
	private String tipo;

	private Combustivel(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}
	
	public static Combustivel verifica(Integer valor) throws EnumValidationException{
		
		        // Como não é uma classe e não vou instanciar, o método é satatic
		for (Combustivel combustivel : Combustivel.values()) {
			if (valor.equals(combustivel.getCodigo())) {
				return combustivel;
			}
		}
		// O "throw new" lança um exception. A "EnumValidationException" é uma classe de erro nossa, personalizada
		throw new EnumValidationException("Preencha o combustível corretamente");
	}
	
	

	public Integer getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}

}
