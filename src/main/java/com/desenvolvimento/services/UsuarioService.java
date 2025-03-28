package com.desenvolvimento.services;

import com.desenvolvimento.domains.Usuario;
import com.desenvolvimento.domains.dtos.UsuarioDTO;
import com.desenvolvimento.repositories.UsuarioRepository;
import com.desenvolvimento.services.exceptions.DataIntegrityViolationException;
import com.desenvolvimento.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    public List<UsuarioDTO> findAll(){
        return usuarioRepo.findAll().stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
    }

    public Usuario findbyId(Long id){
        Optional<Usuario> obj = usuarioRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id));
    }

    public Usuario findbyCpf(String cpf){
        Optional<Usuario> obj = usuarioRepo.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! CPF:" + cpf));

    }

    public Usuario findbyEmail(String email){
        Optional<Usuario> obj = usuarioRepo.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Email:" + email));
    }

    public Usuario create (UsuarioDTO objDto){
        objDto.setId(null);
        ValidaPorCPFeEmail(objDto);
        Usuario newObj = new Usuario(objDto);
        return usuarioRepo.save(newObj);
    }

    public Usuario update(Long id, UsuarioDTO objDto){
        objDto.setId(id);
        Usuario oldObj = findbyId(id);
        ValidaPorCPFeEmail(objDto);
        oldObj = new Usuario(objDto);
        return usuarioRepo.save(oldObj);
    }

    public void delete(Long id){
        Usuario obj = findbyId(id);
        if(obj.getOrdemDeMatriculas().size()>0){
            throw new DataIntegrityViolationException("Usuário não pode ser deletado, pois possui ordens de serviço!");
        } usuarioRepo.deleteById(id);
    }

    private void ValidaPorCPFeEmail(UsuarioDTO objDto){
        Optional<Usuario> obj = usuarioRepo.findByCpf(objDto.getCpf());
        if(obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }
        obj = usuarioRepo.findByEmail(objDto.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema");
        }
    }
}
