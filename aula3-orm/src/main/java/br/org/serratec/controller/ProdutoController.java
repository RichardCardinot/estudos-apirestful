package br.org.serratec.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.model.Produto;
import br.org.serratec.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired // Passa o controle para o Spring
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> listar() {
		return produtoRepository.findAll(); // Retorna todos os produtos do banco de dados. Usando o produtoRepository estamos
		                                    // utilizando o repositório e ele criando o "select * from produto" no postgre.
	} 
	
	@GetMapping("{id}")
	public ResponseEntity<Produto> buscar(@PathVariable Long id) {
		// Retornamos o ResposenEntity<Produto> para poder voltar o status HTTP (200, 501...)
		Optional<Produto> produto = produtoRepository.findById(id); // Usamos o Optional<Produto> pois o retorno do dById(id) pode ser nulo.
		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
					 // Usamos o ResponseEntity.ok para retornar o status 200.
					 // Para retornar o conteúdo de um option, devemos usar o .get.
		}
			return ResponseEntity.notFound().build(); 
					// Usamos o ResponseEntity.notFound para retornar o status 200, mas como ele não ter o retorno padrão no formato
					// ResponseEntity, temos que usar o .build() para converter.
		                                    
	} 
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	                       // A anotação @Valid deve ser usada imediatamente antes do que se deve validar, nesse caso o @RequestBody (Não esquecer que há uma anotaçaõ correlacionada no atributo da classe model)
	public Produto inserir(@Valid @RequestBody Produto produto) {
		return produtoRepository.save(produto); //Passamos como parâmetro a entidade produto (Entidade é a classe representada no banco de dados)
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		produtoRepository.deleteById(id);
		return ResponseEntity.noContent().build(); // Quando não existe, retornar "noContent"			
	}
	
	@PutMapping("{id}")                                             // A anotação @Valid deve ser usada imediatamente antes do que se deve validar, nesse caso o @RequestBody (Não esquecer que há uma anotaçaõ correlacionada no atributo da classe model)
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		produto.setId(id);
		produto = produtoRepository.save(produto);
		return ResponseEntity.ok(produto);

	}

}
