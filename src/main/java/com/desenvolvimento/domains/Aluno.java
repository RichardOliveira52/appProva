package com.desenvolvimento.domains;


import com.desenvolvimento.domains.dtos.AlunoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="aluno")

public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_aluno")
    private Integer idAluno;

    @NotNull
    @NotBlank
    private String nomeAluno;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String cpfAluno;

    @NotNull
    @NotBlank
    private String emailAluno;

    @NotNull
    private Integer raAluno;

    @JsonIgnore
    @OneToMany(mappedBy = "aluno")
    private List<Curso> cursos = new ArrayList<>();

    public Aluno() {
    }

    public Aluno(Integer idAluno, String nomeAluno, String cpfAluno, String emailAluno, Integer raAluno) {
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.emailAluno = emailAluno;
        this.raAluno = raAluno;
    }
    public Aluno(AlunoDTO dto){
        this.idAluno = dto.getIdAluno();
        this.nomeAluno = dto.getNomeAluno();
        this.cpfAluno = dto.getCpfAluno();
        this.emailAluno = dto.getEmailAluno();
        this.raAluno = dto.getRaAluno();
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public @NotNull @NotBlank String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(@NotNull @NotBlank String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public @NotNull @NotBlank String getCpfAluno() {
        return cpfAluno;
    }

    public void setCpfAluno(@NotNull @NotBlank String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }

    public @NotNull @NotBlank String getEmailAluno() {
        return emailAluno;
    }

    public void setEmailAluno(@NotNull @NotBlank String emailAluno) {
        this.emailAluno = emailAluno;
    }

    public @NotNull Integer getRaAluno() {
        return raAluno;
    }

    public void setRaAluno(@NotNull Integer raAluno) {
        this.raAluno = raAluno;
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
        Aluno aluno = (Aluno) o;
        return Objects.equals(idAluno, aluno.idAluno) && Objects.equals(nomeAluno, aluno.nomeAluno) && Objects.equals(cpfAluno, aluno.cpfAluno) && Objects.equals(emailAluno, aluno.emailAluno) && Objects.equals(raAluno, aluno.raAluno) && Objects.equals(cursos, aluno.cursos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAluno, nomeAluno, cpfAluno, emailAluno, raAluno, cursos);
    }
}

/* ANOTAÇÕES:
 * Esta classe representa uma das entidades da aplicação*/
