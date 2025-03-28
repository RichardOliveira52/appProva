package com.desenvolvimento.domains;

import com.desenvolvimento.domains.enums.OrdemDePrioridade;
import com.desenvolvimento.domains.enums.StatusDeMatricula;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ordemdematricula")
public class OrdemDeMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeInicio =LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFinal;

    private String tituloDaOrdem;
    private String descricao;
    private OrdemDePrioridade ordemDePrioridade;
    private StatusDeMatricula statusDeMatricula;

    @ManyToOne
    @JoinColumn(name = "idtecnico")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    public OrdemDeMatricula() {
    }

    public OrdemDeMatricula(UUID id, String tituloDaOrdem, String descricao, OrdemDePrioridade ordemDePrioridade, StatusDeMatricula statusDeMatricula, Tecnico tecnico, Usuario usuario) {
        this.id = id;
        this.tituloDaOrdem = tituloDaOrdem;
        this.descricao = descricao;
        this.ordemDePrioridade = ordemDePrioridade;
        this.statusDeMatricula = statusDeMatricula;
        this.tecnico = tecnico;
        this.usuario = usuario;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(LocalDate dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getTituloDaOrdem() {
        return tituloDaOrdem;
    }

    public void setTituloDaOrdem(String tituloDaOrdem) {
        this.tituloDaOrdem = tituloDaOrdem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public OrdemDePrioridade getOrdemDePrioridade() {
        return ordemDePrioridade;
    }

    public void setOrdemDePrioridade(OrdemDePrioridade ordemDePrioridade) {
        this.ordemDePrioridade = ordemDePrioridade;
    }

    public StatusDeMatricula getStatusDeMatricula() {
        return statusDeMatricula;
    }

    public void setStatusDeMatricula(StatusDeMatricula statusDeMatricula) {
        this.statusDeMatricula = statusDeMatricula;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemDeMatricula that = (OrdemDeMatricula) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
