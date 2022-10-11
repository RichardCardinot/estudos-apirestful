package br.org.serratec.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Manutencao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_manutencao")
	private Long idManutencao;

	@Column(name = "data_entrada")
	private LocalDate dataEntrada; // LocalData é o mais novo, então é recomendado usá-lo para se referir a datas

	@Column(name = "data_saida")
	private LocalDate dataSaida; // LocalData é o mais novo, então é recomendado usá-lo para se referir a datas

	private String obs;

	@JsonBackReference // Anotação que determina que esse é o mandado da relação. No outro lado tem o @JsonManagedReference.
	@ManyToOne
	@JoinColumn(name = "id_veiculo") // Incluindo a chave primária da classe Veículo, que é o tributo da classe Veículo.
	private Veiculo veiculo;
	
	@ManyToMany
	@JoinTable(name = "manutencao_servico", // Cria a tabela de relacionamento do banco para a relação de muitos para muitos(many para many)
	joinColumns = @JoinColumn(name = "id_manutencao"), // Junta a coluna "id_manutencao" dessa tabela("Manutencao") com
	inverseJoinColumns = @JoinColumn(name = "id_servico")) // A coluna "id_servico" da tabela da List<> que consta abaixo ("Servico")
	private List<Servico> servicos;

	public Long getIdManutencao() {
		return idManutencao;
	}

	public void setIdManutencao(Long idManutencao) {
		this.idManutencao = idManutencao;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	

}
