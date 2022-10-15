package br.org.serratec.dto;

import br.org.serratec.model.Usuario;

// Server para efetuar uma resposta(Response) com atributos personalizados.
public class UsuarioDTO {
	private Long id;
	private String nome;
	private String email;

	// É necessário criar um construtor vazio
	public UsuarioDTO() {
	}

	// Criar um construtor com todos os fields, alterar o parâmetro para receber a
	// classe a ser personalizada e
	// incluir os "get" para alimentar os "this."
	public UsuarioDTO(Usuario usuario) {
		super();
		this.id = usuario.getIdUsuario();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
	}

	// Criar os gets e sets dos atributos (fields == campos)
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
