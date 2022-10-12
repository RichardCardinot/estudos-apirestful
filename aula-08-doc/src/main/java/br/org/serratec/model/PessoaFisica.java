package br.org.serratec.model;

import javax.persistence.Entity;

// Forma 1
//@Entity

@Entity
public class PessoaFisica extends Fornecedor {
	private String rg;
	private String orgaoExpeditor;
	private String cpf;

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoExpeditor() {
		return orgaoExpeditor;
	}

	public void setOrgaoExpeditor(String orgaoExpeditor) {
		this.orgaoExpeditor = orgaoExpeditor;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
