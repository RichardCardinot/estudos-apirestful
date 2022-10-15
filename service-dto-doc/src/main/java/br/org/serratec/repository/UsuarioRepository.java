package br.org.serratec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	// digita findby + Ctrl + espaço, então selecionamos o atributo email. Com isso será mostado o método abaixo:
	// findbyList<Usuario> findByEmail(String email);
	// e como não queremos uma lista, somente um Usuario, alteramos o "findbyList<Usuario>" por "Usuario".
	// e agora o UsuarioRepository sabe encontrar por email.
	Usuario findByEmail(String email);
	
	// Feito igual o de cima.
	Optional<Usuario> findByNome(String nome);
}
