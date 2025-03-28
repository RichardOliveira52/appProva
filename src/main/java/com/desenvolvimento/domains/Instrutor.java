package com.desenvolvimento.domains;

import com.desenvolvimento.domains.dtos.InstrutorDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "instrutor")
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_instrutor")
    private Integer idInstrutor;

    @NotNull @NotBlank
    private String nomeInstrutor;

    @NotNull @NotBlank
    @Column(unique = true)
    private String cpfInstrutor;

    @NotNull @NotBlank
    private String emailInstrutor;

    @NotNull @NotBlank
    private String experienciaInstrutor;

    @JsonIgnore
    @OneToMany(mappedBy = "instrutor")
    private List<Curso> cursos = new ArrayList<>();

    public Instrutor() {
    }

    public Instrutor(Integer idInstrutor, String nomeInstrutor, String cpfInstrutor, String emailInstrutor, String experienciaInstrutor) {
        this.idInstrutor = idInstrutor;
        this.nomeInstrutor = nomeInstrutor;
        this.cpfInstrutor = cpfInstrutor;
        this.emailInstrutor = emailInstrutor;
        this.experienciaInstrutor = experienciaInstrutor;
        this.cursos = cursos;
    }

    public Instrutor(InstrutorDTO dto){
        this.idInstrutor = dto.getIdInstrutor();
        this.nomeInstrutor = dto.getNomeInstrutor();
        this.cpfInstrutor = dto.getCpfInstrutor();
        this.emailInstrutor = dto.getEmailInstrutor();
        this.experienciaInstrutor = dto.getExperienciaInstrutor();
    }

    public Integer getIdInstrutor() {
        return idInstrutor;
    }

    public void setIdInstrutor(Integer idInstrutor) {
        this.idInstrutor = idInstrutor;
    }

    public @NotNull @NotBlank String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(@NotNull @NotBlank String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }

    public @NotNull @NotBlank String getCpfInstrutor() {
        return cpfInstrutor;
    }

    public void setCpfInstrutor(@NotNull @NotBlank String cpfInstrutor) {
        this.cpfInstrutor = cpfInstrutor;
    }

    public @NotNull @NotBlank String getEmailInstrutor() {
        return emailInstrutor;
    }

    public void setEmailInstrutor(@NotNull @NotBlank String emailInstrutor) {
        this.emailInstrutor = emailInstrutor;
    }

    public @NotNull @NotBlank String getExperienciaInstrutor() {
        return experienciaInstrutor;
    }

    public void setExperienciaInstrutor(@NotNull @NotBlank String experienciaInstrutor) {
        this.experienciaInstrutor = experienciaInstrutor;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrutor instrutor = (Instrutor) o;
        return idInstrutor == instrutor.idInstrutor && Objects.equals(nomeInstrutor, instrutor.nomeInstrutor) && Objects.equals(cpfInstrutor, instrutor.cpfInstrutor) && Objects.equals(emailInstrutor, instrutor.emailInstrutor) && Objects.equals(experienciaInstrutor, instrutor.experienciaInstrutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInstrutor, nomeInstrutor, cpfInstrutor, emailInstrutor, experienciaInstrutor);
    }
}

/*
 * ANOTAÇÕES:
 * Esta classe representa uma das entidades da aplicação*/
