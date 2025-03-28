package com.desenvolvimento.services;

import com.desenvolvimento.domains.Aluno;
import com.desenvolvimento.domains.Curso;
import com.desenvolvimento.domains.Instrutor;
import com.desenvolvimento.domains.Veiculo;
import com.desenvolvimento.domains.dtos.CursoDTO;
import com.desenvolvimento.domains.dtos.VeiculoDTO;
import com.desenvolvimento.domains.dtos.VeiculoDTO;
import com.desenvolvimento.repositories.VeiculoRepository;
import com.desenvolvimento.repositories.VeiculoRepository;
import com.desenvolvimento.services.exceptions.DataIntegrityViolationException;
import com.desenvolvimento.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<VeiculoDTO> findAll(){
        return veiculoRepository.findAll().stream().map(obj ->
                new VeiculoDTO(obj)).collect(Collectors.toList());

    }
    public Veiculo findById(Long id){
        Optional<Veiculo> obj = veiculoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Veiculo não encontrado! Id: " + id));
    }

    public Veiculo findByCpfProprietario(String cpfProprietario){
        Optional <Veiculo> obj = veiculoRepository.findByCpfProprietario(cpfProprietario);
        return obj.orElseThrow(() -> new ObjectNotFoundException(" Veiculo não encontrado! CPF: " + cpfProprietario));
    }

    public Veiculo create(VeiculoDTO dto){
        dto.setId(null);
        Veiculo obj = new Veiculo(dto);
        return veiculoRepository.save(obj);
    }

    public void validaVeiculo(VeiculoDTO dto){
        Optional<Veiculo> veiculo = veiculoRepository.findById(dto.getId());
        if(!veiculo.isPresent()){
            throw new DataIntegrityViolationException("Veiculo - " + dto.getId() + " não está cadastrado!");
        }
    }
    public Veiculo update(Long id, VeiculoDTO objDto){
        objDto.setId(id);
        Veiculo oldObj = findById(id);
        validaVeiculo(objDto);
        oldObj = new Veiculo(objDto);
        return veiculoRepository.save(oldObj);
    }

    public void delete(Long id){
        Veiculo obj = findById(id);
        veiculoRepository.deleteById(id);
    }
}

