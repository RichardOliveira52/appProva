package com.desenvolvimento.resources;

import com.desenvolvimento.domains.Aluno;
import com.desenvolvimento.domains.Instrutor;
import com.desenvolvimento.domains.dtos.AlunoDTO;
import com.desenvolvimento.domains.dtos.InstrutorDTO;
import com.desenvolvimento.services.InstrutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/instrutor")
public class InstrutorResource {

    @Autowired
    private InstrutorService instrutorService;

    @GetMapping
    public ResponseEntity<List<InstrutorDTO>> findAll(){
        return ResponseEntity.ok().body(instrutorService.findAll());

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<InstrutorDTO> findById(@PathVariable int id){
        Instrutor obj = this.instrutorService.findById(id);
        return ResponseEntity.ok().body(new InstrutorDTO(obj));
}
    @GetMapping(value = "/cpfInstrutor/{cpfInstrutor}")
    public ResponseEntity<InstrutorDTO> findById(@PathVariable String cpfInstrutor){
        Instrutor obj = this.instrutorService.findByCpfInstrutor(cpfInstrutor);
        return ResponseEntity.ok().body(new InstrutorDTO(obj));
    }
    @PostMapping
    public ResponseEntity<InstrutorDTO> create(@Valid @RequestBody InstrutorDTO dto) {
        Instrutor instrutor = instrutorService.create(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(instrutor.getIdInstrutor()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<InstrutorDTO> update(@PathVariable Integer id, @Valid @RequestBody InstrutorDTO objDto){
        Instrutor Obj = instrutorService.update(id, objDto);
        return ResponseEntity.ok().body(new InstrutorDTO(Obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<InstrutorDTO> delete(@PathVariable Integer id){
        instrutorService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
