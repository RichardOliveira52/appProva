package com.desenvolvimento.repositories;

import com.desenvolvimento.domains.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

   Optional<Aluno> findByCpfAluno(String cpfAluno);
}
