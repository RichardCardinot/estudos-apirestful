package br.org.serratec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.model.Cliente;
import br.org.serratec.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping()
	public List<Cliente> buscarClientes() {
		return clienteRepository.findAll();
	}

	@GetMapping("{id}")
	public Optional<Cliente> buscarClientePorId(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente;
	}

	@PostMapping()
	public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@PostMapping("/salvarClientes")
	public List<Cliente> cadastrarClientes(@RequestBody List<Cliente> clientes) {
		return clienteRepository.saveAll(clientes);
	}

	@PutMapping("{id}")
	public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		if (clienteRepository.findById(id).isPresent()) {
			cliente.setId(id);
			return clienteRepository.save(cliente);
		} else {
			return null;
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		if (clienteRepository.findById(id).isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
