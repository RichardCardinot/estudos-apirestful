package br.org.serratec.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity // Informa que essa classe será uma tabela no banco
@Table(name = "usuario_perfil")
public class UsuarioPerfil {

	@EmbeddedId // Anotação usada especificamente para embutir uma classe de chave primária
				// composta.
	private UsuarioPerfilPK id = new UsuarioPerfilPK();

	@Column(name = "data_criacao")
	private LocalDate dataCriacao;

	// Crtl + espaço para criar o construtor vazio
	public UsuarioPerfil() {
	}

	// Construtor com atributos (fields), posteriormente alterado.
	public UsuarioPerfil(Usuario usuario, Perfil perfil, LocalDate dataCriacao) {
		id.setUsuario(usuario);
		id.setPerfil(perfil);
		this.dataCriacao = dataCriacao;
	}

	// ============== Gets e Sets criados manualmente, início ==============
	
	public Usuario getUsuario() {
		return id.getUsuario();
	}
	
	public void setUsuario(Usuario usuario) {
		id.setUsuario(usuario);
	}
	
	public Perfil getPerfil() {
		return id.getPerfil();
	}
	
	public void setPerfil(Perfil perfil) {
		id.setPerfil(perfil);
	}
	
	// ============== Gets e Sets criados manualmente, fim ==============
	
	
	// Gets e sets gerados automaticamente
	public UsuarioPerfilPK getId() {
		return id;
	}

	public void setId(UsuarioPerfilPK id) {
		this.id = id;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
