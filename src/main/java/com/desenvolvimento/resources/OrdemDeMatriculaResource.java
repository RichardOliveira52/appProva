package com.desenvolvimento.resources;

import com.desenvolvimento.domains.OrdemDeMatricula;
import com.desenvolvimento.domains.dtos.OrdemDeMatriculaDTO;
import com.desenvolvimento.services.OrdemDeMatriculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/matricula")
public class OrdemDeMatriculaResource {

    @Autowired
    private OrdemDeMatriculaService ordemDeMatriculaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrdemDeMatriculaDTO> findById(@PathVariable UUID id){
        OrdemDeMatricula obj = this.ordemDeMatriculaService.findbyId(id);
        return ResponseEntity.ok().body(new OrdemDeMatriculaDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<OrdemDeMatriculaDTO>> findAll(){
        return ResponseEntity.ok().body(ordemDeMatriculaService.findAll());
    }

    @PostMapping
    public ResponseEntity<OrdemDeMatriculaDTO> create(@Valid @RequestBody OrdemDeMatriculaDTO objDto){
        OrdemDeMatricula newObj = ordemDeMatriculaService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OrdemDeMatriculaDTO> update(@PathVariable UUID id, @Valid @RequestBody OrdemDeMatriculaDTO objDto){
        OrdemDeMatricula Obj = ordemDeMatriculaService.update(id, objDto);
        return ResponseEntity.ok().body(new OrdemDeMatriculaDTO(Obj));
    }
}
