package br.org.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.model.Produto;

@Repository //Informando que essa classe é um repositório                                                 
public interface ProdutoRepository extends JpaRepository<Produto, Long>{ // <artefato: Produto, tipo do ID de Produto: Long>
	//Essa interface tem que extender de JpaRepository

}
