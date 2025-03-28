package com.desenvolvimento.repositories;

import com.desenvolvimento.domains.OrdemDeMatricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrdemDeMatriculaRepository extends JpaRepository<OrdemDeMatricula, UUID> {
}
