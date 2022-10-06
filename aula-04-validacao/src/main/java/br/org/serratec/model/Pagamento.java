package br.org.serratec.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pagamento {
	@Autowired
	private Consulta consulta;
	@Autowired
	private Exame exame;

//	public Pagamento(Consulta consulta, Exame exame) {
//		this.consulta = consulta;
//		this.exame = exame;
//	}

	public Double calcularProcedimentos(Double valorConsulta, Double valorExame) {
		return consulta.calcularValorConsulta(valorConsulta) + exame.calcularValorExame(valorExame);
	}
}
