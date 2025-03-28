package com.desenvolvimento.services;

import com.desenvolvimento.domains.Tecnico;
import com.desenvolvimento.domains.dtos.TecnicoDTO;
import com.desenvolvimento.repositories.TecnicoRepository;
import com.desenvolvimento.services.exceptions.DataIntegrityViolationException;
import com.desenvolvimento.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TecnicoService {
//fiz substituição de palavras do codigo, então se não rodar, o B.O pode estar aqui haha
    @Autowired
    private TecnicoRepository tecnicoRepo;

    public List<TecnicoDTO> findAll(){
        return tecnicoRepo.findAll().stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
    }

    public Tecnico findbyId(Long id){
        Optional<Tecnico> obj = tecnicoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id));
    }

    public Tecnico findbyCpf(String cpf){
        Optional<Tecnico> obj = tecnicoRepo.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! cpf:" + cpf));
    }
    public Tecnico findbyEmail(String email){
        Optional<Tecnico> obj = tecnicoRepo.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! email:" + email));
    }

    public Tecnico create(TecnicoDTO objDto){
        objDto.setId(null);
        ValidaCPFeEmail(objDto);
        Tecnico newObj = new Tecnico(objDto);
        return tecnicoRepo.save(newObj);
    }

    public Tecnico update(Long id, TecnicoDTO objDto){
        objDto.setId(id);
        Tecnico oldObj = findbyId(id);
        ValidaCPFeEmail(objDto);
        oldObj = new Tecnico(objDto);
        return tecnicoRepo.save(oldObj);
    }

    public void delete(Long id){
        Tecnico obj = findbyId(id);
        if(obj.getOrdemDeMatriculas().size()>0){
            throw new DataIntegrityViolationException("Técnico não pode ser deletado pois possui ordens de serviço!");
        }
        tecnicoRepo.deleteById(id);
    }

    private void ValidaCPFeEmail(TecnicoDTO objDto){
        Optional<Tecnico> obj = tecnicoRepo.findByCpf(objDto.getCpf());
        if(obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }
        Optional<Tecnico> obj2 = tecnicoRepo.findByEmail(objDto.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema");
        }
    }
}
