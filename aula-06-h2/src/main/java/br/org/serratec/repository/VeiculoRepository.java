package br.org.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.model.Veiculo;

@Repository // Essa anotação é opcional
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
