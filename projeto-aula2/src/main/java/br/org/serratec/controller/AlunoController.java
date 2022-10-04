package br.org.serratec.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.model.Aluno;

@RestController
@RequestMapping("/alunos") // Caminho que será utilizado por todas as funções contidas na classe
public class AlunoController {
	private static List<Aluno> alunos = new ArrayList<>();

	static {
		alunos.add(new Aluno("123", "Maria", "m@gmail.com"));
		alunos.add(new Aluno("321", "Ana", "a@gmail.com"));
		alunos.add(new Aluno("124", "José", "j@gmail.com"));
		alunos.add(new Aluno("126", "Carlos", "c@gmail.com"));
	}

	@GetMapping
	// Caminho do GET: http://localhost:8080/alunos É o que foi definido no
	// @RequestMapping desta classe (AlunoController)
	public List<Aluno> listar() {
		return alunos;
	}

	@GetMapping("{matricula}")
	// A anotação @PathVariable diz que o parâmetro virá através da variável
	// determinada no @GetMapping, que no caso é a "{matricula}"
	// Caminho do GET: http://localhost:8080/alunos/321

	public Aluno buscar(@PathVariable String matricula) {
//
//		for (int i = 0; i < alunos.size(); i++) {
//			if (alunos.get(i).getMatricula().equals(matricula)) {
//				return alunos.get(i);
//			}
//		}
//		return null;

		// Fazendo tudo que foi feito na função anterior que está comendata, mas agora
		// com programação funcional
		// Nome dessa função é lambda. !!ESTUDAR!!
		return alunos.stream().filter(aluno -> aluno.getMatricula().equals(matricula)).findFirst().orElse(null);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) // A assinatura @ResponseStatus define qual status HTTP deve ser retornando,
										// nesta caso, o 201-Created.
	public Aluno inserir(@RequestBody Aluno aluno) {
		alunos.add(aluno);
		return aluno;
	}

	@DeleteMapping("{matricula}")
	public void apagar(@PathVariable String matricula) {

		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getMatricula().equals(matricula)) {
				alunos.remove(i);
			}
		}

	}
	
	@PutMapping("{matricula}")
	public Aluno atualizar(@RequestBody Aluno aluno, @PathVariable String matricula) {

		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getMatricula().equals(matricula)) {
				alunos.set(i, aluno); //O set edita o elemento na posição especificada do vetor
				return alunos.get(i);
			}
		}
		return null;

	}

}
