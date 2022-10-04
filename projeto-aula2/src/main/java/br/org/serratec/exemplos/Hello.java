package br.org.serratec.exemplos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Hello {
	
	//A anotação @GetMapping especifica que a função abaixo é do verbo GET no caminho passaod em @RequestMapping("/api/v1") 
	// mais o parâmetro passado em @GetMapping("/ola")
	//Caminho do GET: http://localhost:8080/api/v1/ola
	@GetMapping("/ola")
	public String teste() {
		return "Hello World !";
	}
	
	// A barra do endereço passado como parâmetro é opcional, ou seja, pode não ser utilizada (/resposta ou resposta)
	//Caminho do GET: http://localhost:8080/api/v1/resposta
	@GetMapping("/resposta")
	public String resposta() {
		return "Teste";
	}
	
	@GetMapping("/converter")
	//A anotação @RequestParam indica que a requisição espera um parâmetor
	//Caminho do GET: http://localhost:8080/api/v1/converter?nome=Richard
	//Observe que o "?nome=" é necessário, pois é por ele que passamos o valor "Richard"
	//Caminho do GET(Exemplo 2): http://localhost:8080/api/v1/converter?nome="Richard"&nome="Amanda"
	//Observe que com o uso do &, foi possível passar dois parâmetros no get
	
	public String converter(@RequestParam String nome) {
		return nome.toUpperCase();
	}
	
	@GetMapping("/somar")
	//A anotação @RequestParam indica que a requisição espera um parâmetro, a anotação
	//eve ser reinformada a cada parâmetro especificado na função
	//Caminho do GET: http://localhost:8080/api/v1/somar?numero1=10&numero2=20
	//Observe que foram passados os valores 10 e 20 como parâmetros (somar?numero1=10&numero2=20)
	
	public Integer somar(@RequestParam Integer numero1, @RequestParam Integer numero2) {
		return numero1 + numero2;
	}

}
