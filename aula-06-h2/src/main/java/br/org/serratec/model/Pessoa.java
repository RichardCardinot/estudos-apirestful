package br.org.serratec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Diz que essa tabela é uma entidade do banco de dados
public class Pessoa {

	@Id // Diz que essa propriedade é a chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Diz o tipo (Estratégia) da geração da chave primária
	private Long id;

	//@Column(name = "nomeDaColua") Só precisamos dessa anotação se quisermos alterar o nome da coluna no banco
	private String nome;
	private String email;

	public Pessoa(Long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
