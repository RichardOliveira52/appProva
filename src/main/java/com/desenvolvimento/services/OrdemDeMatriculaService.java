package com.desenvolvimento.services;

import com.desenvolvimento.domains.OrdemDeMatricula;
import com.desenvolvimento.domains.Tecnico;
import com.desenvolvimento.domains.Usuario;
import com.desenvolvimento.domains.dtos.OrdemDeMatriculaDTO;
import com.desenvolvimento.domains.enums.OrdemDePrioridade;
import com.desenvolvimento.domains.enums.StatusDeMatricula;
import com.desenvolvimento.repositories.OrdemDeMatriculaRepository;
import com.desenvolvimento.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrdemDeMatriculaService {

    @Autowired
    private OrdemDeMatriculaRepository ordemDeMatriculaRepo;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private UsuarioService usuarioService;

    public OrdemDeMatricula findbyId(UUID id){
        Optional<OrdemDeMatricula> obj = ordemDeMatriculaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado! id:" + id));
    }

    public List<OrdemDeMatriculaDTO> findAll(){
        return ordemDeMatriculaRepo.findAll().stream().map(obj -> new OrdemDeMatriculaDTO(obj)).collect(Collectors.toList());
    }

    private OrdemDeMatricula newOrdemDeMatricula(OrdemDeMatriculaDTO obj){
        Tecnico tecnico = tecnicoService.findbyId(obj.getTecnico());
        Usuario usuario = usuarioService.findbyId(obj.getUsuario());

        OrdemDeMatricula os = new OrdemDeMatricula();
        if(obj.getId() != null){
            os.setId(obj.getId());
        }
        if(obj.getStatusDeMatricula().equals(2)){
            os.setDataFinal(LocalDate.now());
        }

        os.setTecnico(tecnico);
        os.setUsuario(usuario);
        os.setOrdemDePrioridade(OrdemDePrioridade.toEnum(obj.getOrdemDePrioridade()));
        os.setStatusDeMatricula(StatusDeMatricula.toEnum(obj.getStatusDeMatricula()));
        os.setTituloDaOrdem(obj.getTituloDaOrdem());
        os.setDescricao(obj.getDescricao());
        return os;
    }

    public OrdemDeMatricula create(OrdemDeMatriculaDTO objDto){
        return ordemDeMatriculaRepo.save(newOrdemDeMatricula(objDto));
    }

    public OrdemDeMatricula update(UUID id, OrdemDeMatriculaDTO objDto){
        objDto.setId(id);
        OrdemDeMatricula oldObj = findbyId(id);
        oldObj = newOrdemDeMatricula(objDto);
        return ordemDeMatriculaRepo.save(oldObj);
    }
}
