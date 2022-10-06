package br.org.serratec.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

//Ctrl + Shift + O importa as dependências


@Entity //Dizemos que a classe será uma tabela (entidade)
@Table(name = "produto", schema = "public") //Caso queria mudar o nome da tabela(entidade) no banco, basta alimentar essa anotação com os parâmetros.
public class Produto {
	
	@Id // Informamos que o atributo abaixo é a chave primária (id)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto") //Informando que o atributo é uma coluna da tabela e definindo o seu nome.
	private Long id;
	
	@NotBlank(message = "Preencha a descrição do produto") // Anotação para validar se o campo não está vazio("") ou nulo(null).
	@Size(max = 40, min = 5, message = "Tamanho do campo inválido") // Incluindo a validação de tamanho máximo, mínimo e a mensagem caso não atenda.
	@Column(nullable = false, length = 40) // Informando que o atributo é uma coluna da tabela, que não pode ser nulo, que tem tamanho 40 e definindo o seu nome.
	private String descricao;
	
	@DecimalMax(value = "10000", message = "O preço deve ser inferior a R$ {value}.00") // Limita o valor máximo do produto.
	@DecimalMin(value = "10", message = "O preço deve ser superior a R$ {value}.00") // Limita o valor mínimo do produto.
	@Column  // Informando que o atributo é uma coluna da tabela.
	private BigDecimal valor;
	
	@Past(message = "Você inseriu uma data inválida")
	@Column(name = "data_cadastro") //Informando que o atributo é uma coluna da tabela e definindo o seu nome.
	private LocalDate dataCadastro;
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", dataCadastro=" + dataCadastro
				+ "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
}
