package com.desenvolvimento.repositories;

import com.desenvolvimento.domains.Aluno;
import com.desenvolvimento.domains.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    Optional<Curso> findByNomeCurso(String nomeCurso);
}
