package com.desenvolvimento.services;

import com.desenvolvimento.domains.Aluno;
import com.desenvolvimento.domains.dtos.AlunoDTO;
import com.desenvolvimento.domains.dtos.CursoDTO;
import com.desenvolvimento.repositories.AlunoRepository;
import com.desenvolvimento.repositories.CursoRepository;
import com.desenvolvimento.services.exceptions.DataIntegrityViolationException;
import com.desenvolvimento.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {


    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoDTO> findAll(){
        return alunoRepository.findAll().stream().map(obj ->
                new AlunoDTO(obj)).collect(Collectors.toList());

    }
    public Aluno findById(int id){
        Optional<Aluno> obj = alunoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Aluno não encontrado! Id: " + id));
    }

    public Aluno findByCpfAluno(String cpfAluno){
        Optional <Aluno> obj = alunoRepository.findByCpfAluno(cpfAluno);
        return obj.orElseThrow(() -> new ObjectNotFoundException(" Aluno não encontrado! CPF: " + cpfAluno));
    }

    public Aluno create(AlunoDTO dto){
        dto.setIdAluno(null);
        validaAluno(dto);
        Aluno obj = new Aluno(dto);
        return alunoRepository.save(obj);
    }

    private void validaAluno(AlunoDTO dto){
        Optional<Aluno> obj = alunoRepository.findByCpfAluno(dto.getCpfAluno());{
            if(obj.isPresent() && obj.get().getCpfAluno() != dto.getCpfAluno()){
                throw new DataIntegrityViolationException("CPF de aluno já cadastrado!");
            }
        }
    }
    public Aluno update(Integer id, AlunoDTO objDto){
        objDto.setIdAluno(id);
        Aluno oldObj = findById(id);
        oldObj = new Aluno(objDto);
        return alunoRepository.save(oldObj);
    }

    public void delete(Integer id){
        Aluno obj = findById(id);
        if (obj.getCursos().size()>0){
            throw new DataIntegrityViolationException("Aluno não pode ser deletado pois possui cursos cadastrados!");
        }
        alunoRepository.deleteById(id);
    }
}
