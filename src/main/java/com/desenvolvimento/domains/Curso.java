package com.desenvolvimento.domains;

import com.desenvolvimento.domains.dtos.CursoDTO;
import com.desenvolvimento.domains.enums.Dificuldade;
import com.desenvolvimento.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_curso")
    private Long idCurso;

    @NotNull @NotBlank
    private String nomeCurso;

   @NotNull @NotBlank
    private String urlCurso;

    @NotNull @NotBlank
    private String descricaoCurso;

    @NotNull @NotBlank
    private String cargaHorariaCurso;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicioCurso = LocalDate.now();

    @NotNull @NotBlank
    private String categoriaCurso;

    @ManyToOne
    @JoinColumn(name = "idaluno")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name="idinstrutor")
    private Instrutor instrutor;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "dificuldadedocurso")
    private Dificuldade dificuldadeCurso;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "statusdocurso")
    private Status statusCurso;

    public Curso() {
    }

    public Curso(Long idCurso, String nomeCurso, String urlCurso, String descricaoCurso, String cargaHorariaCurso, LocalDate dataInicioCurso, String categoriaCurso, Aluno aluno, Instrutor instrutor, Dificuldade dificuldadeCurso, Status statusCurso) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.urlCurso = urlCurso;
        this.descricaoCurso = descricaoCurso;
        this.cargaHorariaCurso = cargaHorariaCurso;
        this.dataInicioCurso = dataInicioCurso;
        this.categoriaCurso = categoriaCurso;
        this.aluno = aluno;
        this.instrutor = instrutor;
        this.dificuldadeCurso = dificuldadeCurso;
        this.statusCurso = statusCurso;
    }

    public Curso(CursoDTO dto){
        this.idCurso = dto.getIdCurso();
        this.nomeCurso = dto.getNomeCurso();
        this.urlCurso = dto.getUrlCurso();
        this.descricaoCurso = dto.getDescricaoCurso();
        this.cargaHorariaCurso = dto.getCargaHorariaCurso();
        this.dataInicioCurso = dto.getDataInicioCurso();
        this.categoriaCurso = dto.getCategoriaCurso();
        this.aluno = new Aluno();
        this.aluno.setIdAluno(dto.getAluno());
        this.instrutor = new Instrutor();
        this.instrutor.setIdInstrutor(dto.getInstrutor());
        this.dificuldadeCurso = Dificuldade.toEnum(dto.getDificuldadeCurso());
        this.statusCurso = Status.toEnum(dto.getStatusCurso());
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public @NotNull @NotBlank String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(@NotNull @NotBlank String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public @NotNull @NotBlank String getUrlCurso() {
        return urlCurso;
    }

    public void setUrlCurso(@NotNull @NotBlank String urlCurso) {
        this.urlCurso = urlCurso;
    }

    public @NotNull @NotBlank String getDescricaoCurso() {
        return descricaoCurso;
    }

    public void setDescricaoCurso(@NotNull @NotBlank String descricaoCurso) {
        this.descricaoCurso = descricaoCurso;
    }

    public @NotNull @NotBlank String getCargaHorariaCurso() {
        return cargaHorariaCurso;
    }

    public void setCargaHorariaCurso(@NotNull @NotBlank String cargaHorariaCurso) {
        this.cargaHorariaCurso = cargaHorariaCurso;
    }

    public LocalDate getDataInicioCurso() {
        return dataInicioCurso;
    }

    public void setDataInicioCurso(LocalDate dataInicioCurso) {
        this.dataInicioCurso = dataInicioCurso;
    }

    public @NotNull @NotBlank String getCategoriaCurso() {
        return categoriaCurso;
    }

    public void setCategoriaCurso(@NotNull @NotBlank String categoriaCurso) {
        this.categoriaCurso = categoriaCurso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public Dificuldade getDificuldadeCurso() {
        return dificuldadeCurso;
    }

    public void setDificuldadeCurso(Dificuldade dificuldadeCurso) {
        this.dificuldadeCurso = dificuldadeCurso;
    }

    public Status getStatusCurso() {
        return statusCurso;
    }

    public void setStatusCurso(Status statusCurso) {
        this.statusCurso = statusCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return idCurso == curso.idCurso && Objects.equals(nomeCurso, curso.nomeCurso) && Objects.equals(urlCurso, curso.urlCurso) && Objects.equals(descricaoCurso, curso.descricaoCurso) && Objects.equals(cargaHorariaCurso, curso.cargaHorariaCurso) && Objects.equals(dataInicioCurso, curso.dataInicioCurso) && Objects.equals(categoriaCurso, curso.categoriaCurso) && Objects.equals(aluno, curso.aluno) && Objects.equals(instrutor, curso.instrutor) && dificuldadeCurso == curso.dificuldadeCurso && statusCurso == curso.statusCurso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso, nomeCurso, urlCurso, descricaoCurso, cargaHorariaCurso, dataInicioCurso, categoriaCurso, aluno, instrutor, dificuldadeCurso, statusCurso);
    }
}

/*
* ANOTAÇÕES:
* Esta classe representa uma das entidades da aplicação,
* a relação declarada como @ManyToOne é feita, pois
* Um aluno pode fazer vários cursos e um instrutor
* pode instruir vários cursos se assim ele desejar*/
