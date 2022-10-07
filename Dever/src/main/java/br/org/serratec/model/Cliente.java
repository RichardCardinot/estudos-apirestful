package br.org.serratec.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;
	
	@NotBlank(message = "O nome do cliente deve ser informado")
	@Size(max = 60, min = 2, message = "O nome deve ter entre 2 a 60 caracteres")
	@Column(length = 60)
	private String nome;
	
	@NotBlank(message = "O CPF deve ser informado")
	@Size(max = 11, min = 11, message = "O CPF deve ter 11 dígitos")
	@Column(length = 11)
	private String cpf;
	
	@NotBlank(message = "O email deve ser informado")
	@Email(message = "O e-mail deve conter @ e ponto" )
	@Size(max = 50, min = 10, message = "O email deve ter entre 10 a 50 caracteres")
	@Column(length = 50)
	private String email;
	

	@Past(message = "A nascimento deve ser igual ou menor que a data de hoje")
	@NotNull(message = "A data de nascimento não pode ser nula")
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", dataNascimento="
				+ dataNascimento + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
