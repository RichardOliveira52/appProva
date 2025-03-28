package com.desenvolvimento.services;

import com.desenvolvimento.domains.Aluno;
import com.desenvolvimento.domains.Instrutor;
import com.desenvolvimento.domains.dtos.AlunoDTO;
import com.desenvolvimento.domains.dtos.InstrutorDTO;
import com.desenvolvimento.repositories.InstrutorRepository;
import com.desenvolvimento.services.exceptions.DataIntegrityViolationException;
import com.desenvolvimento.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    public List<InstrutorDTO> findAll(){
        return instrutorRepository.findAll().stream().map(obj ->
                new InstrutorDTO(obj)).collect(Collectors.toList());
    }
    public Instrutor findById(int id){
        Optional<Instrutor> obj = instrutorRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Instrutor não encontrado! Id: " + id));

    }
    public Instrutor findByCpfInstrutor(String cpfInstrutor){
        Optional <Instrutor> obj = instrutorRepository.findByCpfInstrutor(cpfInstrutor);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Instrutor não encontrado! CPF: " + cpfInstrutor));
    }
    public Instrutor create(InstrutorDTO dto) {
        dto.setIdInstrutor(null);
        validaInstrutor(dto);
        Instrutor obj = new Instrutor(dto);
        return instrutorRepository.save(obj);
    }
    private void validaInstrutor(InstrutorDTO dto){
        Optional<Instrutor> obj = instrutorRepository.findByCpfInstrutor(dto.getCpfInstrutor());{
            if(obj.isPresent() && obj.get().getCpfInstrutor() != dto.getCpfInstrutor()){
                throw new DataIntegrityViolationException("CPF de instrutor já cadastrado!");
            }
        }
    }
    public Instrutor update(Integer id, InstrutorDTO objDto){
        objDto.setIdInstrutor(id);
        Instrutor oldObj = findById(id);
        oldObj = new Instrutor(objDto);
        return instrutorRepository.save(oldObj);
    }
    public void delete(Integer id){
        Instrutor obj = findById(id);
        if (obj.getCursos().size()>0){
            throw new DataIntegrityViolationException("Instrutor não pode ser deletado pois possui cursos cadastrados!");
        }
        instrutorRepository.deleteById(id);
    }
}
