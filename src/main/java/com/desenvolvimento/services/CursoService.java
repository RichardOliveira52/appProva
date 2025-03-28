package com.desenvolvimento.services;

import com.desenvolvimento.domains.Aluno;
import com.desenvolvimento.domains.Curso;
import com.desenvolvimento.domains.Instrutor;
import com.desenvolvimento.domains.dtos.CursoDTO;
import com.desenvolvimento.repositories.AlunoRepository;
import com.desenvolvimento.repositories.CursoRepository;
import com.desenvolvimento.repositories.InstrutorRepository;
import com.desenvolvimento.services.exceptions.DataIntegrityViolationException;
import com.desenvolvimento.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    InstrutorRepository instrutorRepository;

    public List<CursoDTO> findAll(){
        return cursoRepository.findAll().stream().map(obj ->
                new CursoDTO(obj)).collect(Collectors.toList());
    }
    public Curso findById(Long id){
        Optional<Curso> obj = cursoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Curso não encontrado! Id: " + id));
    }
    public Curso findByNomeCurso(String nomeCurso){
        Optional <Curso> obj = cursoRepository.findByNomeCurso(nomeCurso);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Curso não encontrado! Nome do Curso: " + nomeCurso));
    }
    public Curso create(CursoDTO dto){
        dto.setIdCurso(null);
        validaCurso(dto);
        Curso obj = new Curso(dto);
        return cursoRepository.save(obj);
    }

    public void validaCurso(CursoDTO dto){
        Optional<Aluno> aluno = alunoRepository.findById(dto.getAluno());
        if(!aluno.isPresent()){
            throw new DataIntegrityViolationException("Aluno - " + dto.getAluno() + " não está cadastrado!");
        }
        Optional<Instrutor> instrutor = instrutorRepository.findById(dto.getInstrutor());
        if(!instrutor.isPresent()){
            throw new DataIntegrityViolationException("Instrutor - " + dto.getInstrutor() + " não está cadastrado!");
        }
    }

    public Curso update(Long id, CursoDTO objDto){
        objDto.setIdCurso(id);
        Curso oldObj = findById(id);
        validaCurso(objDto);
        oldObj = new Curso(objDto);
        return cursoRepository.save(oldObj);
    }
    public void delete(Long id){
        Curso obj = findById(id);
        cursoRepository.deleteById(id);
    }

}
