package br.org.serratec.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;
	private String nome;
	private String email;
	private String senha;
	
	@OneToMany(mappedBy = "id.usuario", fetch = FetchType.EAGER)
	private Set<UsuarioPerfil> usuarioPerfil = new HashSet<>(); // Set é uma lista que não permite elementos duplicados
	
	@ManyToOne // Muitos usuários podem ter um endereço (O mesmo endereço)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	@Override
	public String toString() {
		return "Id: " + idUsuario + "\nNome: " + nome + "\nEmail:" + email;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<UsuarioPerfil> getUsuarioPerfil() {
		return usuarioPerfil;
	}

	public void setUsuarioPerfil(Set<UsuarioPerfil> usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}
	
	

}
