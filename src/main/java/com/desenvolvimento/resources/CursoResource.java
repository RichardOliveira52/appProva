package com.desenvolvimento.resources;

import com.desenvolvimento.domains.Aluno;
import com.desenvolvimento.domains.Curso;
import com.desenvolvimento.domains.dtos.AlunoDTO;
import com.desenvolvimento.domains.dtos.CursoDTO;
import com.desenvolvimento.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/curso")
public class CursoResource {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> findAll(){
        return ResponseEntity.ok().body(cursoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CursoDTO> findById(@PathVariable Long id){
        Curso obj = this.cursoService.findById(id);
        return ResponseEntity.ok().body(new CursoDTO(obj));
}
    @GetMapping(value = "/nomecurso/{nomeCurso}")
    public ResponseEntity<CursoDTO> findById(@PathVariable String nomeCurso){
        Curso obj = this.cursoService.findByNomeCurso(nomeCurso);
        return ResponseEntity.ok().body(new CursoDTO(obj));
    }
    @PostMapping
    public ResponseEntity<CursoDTO> create(@Valid @RequestBody CursoDTO dto){
        Curso curso = cursoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(curso.getIdCurso()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<CursoDTO> update(@PathVariable Long id, @Valid @RequestBody CursoDTO objDto){
        Curso Obj = cursoService.update(id, objDto);
        return ResponseEntity.ok().body(new CursoDTO(Obj));
    }
    @DeleteMapping (value = "/{id}")
    public ResponseEntity<CursoDTO> delete(@PathVariable Long id){
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
