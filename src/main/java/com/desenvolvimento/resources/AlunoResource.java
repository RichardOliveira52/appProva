package com.desenvolvimento.resources;

import com.desenvolvimento.domains.Aluno;
import com.desenvolvimento.domains.dtos.AlunoDTO;
import com.desenvolvimento.services.AlunoService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> findAll(){
       return ResponseEntity.ok().body(alunoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> findById(@PathVariable int id){
        Aluno obj = this.alunoService.findById(id);
        return ResponseEntity.ok().body(new AlunoDTO(obj));
    }
    @GetMapping(value = "/cpfAluno/{cpfAluno}")
    public ResponseEntity<AlunoDTO> findById(@PathVariable String cpfAluno){
        Aluno obj = this.alunoService.findByCpfAluno(cpfAluno);
        return ResponseEntity.ok().body(new AlunoDTO(obj));
    }
    @PostMapping
    public ResponseEntity<AlunoDTO> create(@Valid @RequestBody AlunoDTO dto){
        Aluno aluno = alunoService.create(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getIdAluno()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> update(@PathVariable Integer id, @Valid @RequestBody AlunoDTO objDto){
        Aluno Obj = alunoService.update(id, objDto);
        return ResponseEntity.ok().body(new AlunoDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> delete(@PathVariable Integer id){
        alunoService.delete(id);
        return ResponseEntity.noContent().build();

    }


}
