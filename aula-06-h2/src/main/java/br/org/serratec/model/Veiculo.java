package br.org.serratec.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_veiculo")
	private Long id;

	@NotBlank(message = "Preencha a placa")
	@Size(max = 8)
	@Column(nullable = false, length = 8)
	private String placa;

	@NotBlank(message = "Preencha a marca")
	@Size(max = 30)
	@Column(nullable = false, length = 30)
	private String marca;

	@NotBlank(message = "Preencha o modelo")
	@Size(max = 40)
	@Column(nullable = false, length = 40)
	private String modelo;

	@Embedded // Todos os atributos da classe Caracteristica são imbutidos na tabela
				// Veiculo(Essa)
	private Caracteristica caracteristica;

	@OneToOne // Diz que a relação é de um para um, ou seja, um carro tem um proprietário.
	@JoinColumn(name = "idProprietario") // Incluindo a chave primária da classe Proprietario, para que assim seja
											// criado no banco de dados.
	private Proprietario proprietario; // Incluindo a instância do proprietário do carro.

	@JsonManagedReference // Anotação usada para determinar que esse é o mandante da relação (Senão usar entra em looping. No outro lado tem a anotação @JasonBackReference.
	@OneToMany(mappedBy = "veiculo") // "veiculo" é o atributo relacionado existente na classe Manutenção, que é o @ManyToOne.
	private List<Manutencao> manutencoes; // Lista criada para guardar as muitas manutenções que o veículo pode ter.

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public List<Manutencao> getManutencoes() {
		return manutencoes;
	}

	public void setManutencoes(List<Manutencao> manutencoes) {
		this.manutencoes = manutencoes;
	}

}
