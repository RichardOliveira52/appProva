package com.desenvolvimento.repositories;

import com.desenvolvimento.domains.Aluno;
import com.desenvolvimento.domains.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, Integer> {

    Optional<Instrutor> findByCpfInstrutor(String cpfInstrutor);
}
