package br.org.serratec.dto;

import java.util.HashSet;
import java.util.Set;

import br.org.serratec.model.Usuario;
import br.org.serratec.model.UsuarioPerfil;

// Server para efetuar uma resposta(Response) com atributos personalizados.
public class UsuarioInserirDTO {

	private String nome;
	private String email;
	private String senha;
	
	private Set<UsuarioPerfil> usuariosPerfil = new HashSet<>(); // Set é uma lista que não permite elementos duplicados

	
	// É necessário criar um construtor vazio (Ctrl + espaço)
	public UsuarioInserirDTO() {
	}
	
	// Criar um construtor com todos os fields, alterar o parâmetro para receber a
	// classe a ser personalizada(Usuario) e
	// incluir os "get" para alimentar os "this."
	public UsuarioInserirDTO(Usuario usuario) {
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}

	
	// Criar os gets e sets dos atributos (fields == campos)
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<UsuarioPerfil> getUsuariosPerfil() {
		return usuariosPerfil;
	}

	public void setUsuariosPerfil(Set<UsuarioPerfil> usuariosPerfil) {
		this.usuariosPerfil = usuariosPerfil;
	}
	
}
