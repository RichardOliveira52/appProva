package com.desenvolvimento.domains;

import com.desenvolvimento.domains.dtos.TecnicoDTO;
import com.desenvolvimento.domains.dtos.UsuarioDTO;
import com.desenvolvimento.domains.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
//@Table(name = "usuarios")
public class Usuario extends Pessoa{

    @JsonIgnore
    @OneToMany(mappedBy = "usuario") //usuario é o nome do atributo em OrdemDeMatricula
    private List<OrdemDeMatricula> ordemDeMatriculas = new ArrayList<>();

    public Usuario(Long id, String nome, String sobrenome, String cpf, String email, String senha) {
        super(id, nome, sobrenome, cpf, email, senha);

        addTipoPessoa(TipoPessoa.USUARIO);

    }

    public Usuario(UsuarioDTO obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.sobrenome = obj.getSobrenome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.criadoEm = obj.getCriadoEm();
        this.tipoPessoa = obj.getTipoPessoa().stream().map(x -> x.getId()).collect(Collectors.toSet());
        addTipoPessoa(TipoPessoa.USUARIO);
        addTipoPessoa(TipoPessoa.TECNICO);
    }


    public Usuario() {
        super();
        addTipoPessoa(TipoPessoa.USUARIO);
    }

    public List<OrdemDeMatricula> getOrdemDeMatriculas() {
        return ordemDeMatriculas;
    }

    public void setOrdemDeMatriculas(List<OrdemDeMatricula> ordemDeMatriculas) {
        this.ordemDeMatriculas = ordemDeMatriculas;
    }
}
