package com.desenvolvimento.domains.dtos;

import com.desenvolvimento.domains.OrdemDeMatricula;
import com.desenvolvimento.domains.Tecnico;
import com.desenvolvimento.domains.Usuario;
import com.desenvolvimento.domains.enums.OrdemDePrioridade;
import com.desenvolvimento.domains.enums.StatusDeMatricula;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public class OrdemDeMatriculaDTO {

    private UUID id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeInicio =LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFinal;

    @NotNull(message = "O campo Titulo é requerido")
    private String tituloDaOrdem;

    @NotNull(message = "O campo Descrição é requerido")
    private String descricao;

    @NotNull(message = "O campo Prioridade é requerido")
    private Integer ordemDePrioridade;

    @NotNull(message = "O campo Status é requerido")
    private Integer statusDeMatricula;

    @NotNull(message = "O campo Tecnico é requerido")
    private Long tecnico;

    @NotNull(message = "O campo Usuario é requerido")
    private Long usuario;

    private String nomeTecnico;

    private String nomeUsuario;

    public OrdemDeMatriculaDTO() {
    }

    public OrdemDeMatriculaDTO(OrdemDeMatricula ordemDeMatricula) {
        this.id = ordemDeMatricula.getId();
        this.dataDeInicio = ordemDeMatricula.getDataDeInicio();
        this.dataFinal = ordemDeMatricula.getDataFinal();
        this.tituloDaOrdem = ordemDeMatricula.getTituloDaOrdem();
        this.descricao = ordemDeMatricula.getDescricao();
        this.ordemDePrioridade = ordemDeMatricula.getOrdemDePrioridade().getId();
        this.statusDeMatricula = ordemDeMatricula.getStatusDeMatricula().getId();
        this.tecnico = ordemDeMatricula.getTecnico().getId();
        this.usuario = ordemDeMatricula.getUsuario().getId();
        this.nomeTecnico = ordemDeMatricula.getTecnico().getNome() + " " + ordemDeMatricula.getTecnico().getSobrenome();
        this.nomeUsuario = ordemDeMatricula.getUsuario().getNome() + " " + ordemDeMatricula.getUsuario().getSobrenome();
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

    public Integer getOrdemDePrioridade() {
        return ordemDePrioridade;
    }

    public void setOrdemDePrioridade(Integer ordemDePrioridade) {
        this.ordemDePrioridade = ordemDePrioridade;
    }

    public Integer getStatusDeMatricula() {
        return statusDeMatricula;
    }

    public void setStatusDeMatricula(Integer statusDeMatricula) {
        this.statusDeMatricula = statusDeMatricula;
    }

    public Long getTecnico() {
        return tecnico;
    }

    public void setTecnico(Long tecnico) {
        this.tecnico = tecnico;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
