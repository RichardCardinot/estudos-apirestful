package br.org.serratec.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.org.serratec.enums.Categoria;
import br.org.serratec.enums.Combustivel;

@Embeddable // Diz que essa classe está sendo embutida por outra, neste caso, em Veiculo(@Embedded no atributo caracteristica)
public class Caracteristica {
	private String renavam;
	private String chassi;
	private Integer ano;

	@Enumerated(EnumType.STRING) // Pedindo para gravar no banco a descrição do enum Combustivel
	private Categoria categoria;
	
	@Enumerated(EnumType.ORDINAL) // Pedindo para gravar no banco o código do enum Combustivel
	private Combustivel combustivel;

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

}
