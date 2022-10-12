package br.org.serratec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Documento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name = "id")
	private Pessoa pessoa;

	private String cpf;
	private String ci;

	@Column(name = "orgao_expeditor")
	private String orgaoExpeditor;

	@Column(name = "titulo_eleitor")
	private String tituloEleitor;

	@Column(name = "certificadoReservista")
	private String certificadoReservista;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getOrgaoExpeditor() {
		return orgaoExpeditor;
	}

	public void setOrgaoExpeditor(String orgaoExpeditor) {
		this.orgaoExpeditor = orgaoExpeditor;
	}

	public String getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public String getCertificadoReservista() {
		return certificadoReservista;
	}

	public void setCertificadoReservista(String certificadoReservista) {
		this.certificadoReservista = certificadoReservista;
	}

}
