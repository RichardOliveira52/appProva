package com.desenvolvimento.resources;

import com.desenvolvimento.domains.Tecnico;
import com.desenvolvimento.domains.dtos.TecnicoDTO;
import com.desenvolvimento.services.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tecnico")
public class TecnicoResource {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll(){
        return ResponseEntity.ok().body(tecnicoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Long id){
        Tecnico obj = this.tecnicoService.findbyId(id);
        return ResponseEntity.ok().body(new TecnicoDTO(obj));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<TecnicoDTO> findByCpf(@PathVariable String cpf){
        Tecnico obj = this.tecnicoService.findbyCpf(cpf);
        return ResponseEntity.ok().body(new TecnicoDTO(obj));
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<TecnicoDTO> findByEmail(@PathVariable String email){
        Tecnico obj = this.tecnicoService.findbyEmail(email);
        return ResponseEntity.ok().body(new TecnicoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO objDto){
        Tecnico newObj = tecnicoService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> update(@PathVariable Long id, @Valid @RequestBody TecnicoDTO objDto){
        Tecnico Obj = tecnicoService.update(id, objDto);
        return ResponseEntity.ok().body(new TecnicoDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> delete(@PathVariable Long id){
        tecnicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
