package com.desenvolvimento.repositories;

import com.desenvolvimento.domains.Curso;
import com.desenvolvimento.domains.Instrutor;
import com.desenvolvimento.domains.Usuario;
import com.desenvolvimento.domains.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    Optional<Veiculo> findById(Long findbyId);
    Optional<Veiculo> findByCpfProprietario(String cpfProprietario);
}
