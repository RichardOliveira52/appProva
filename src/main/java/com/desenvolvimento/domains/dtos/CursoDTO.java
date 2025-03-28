package com.desenvolvimento.domains.dtos;

import com.desenvolvimento.domains.Aluno;
import com.desenvolvimento.domains.Curso;
import com.desenvolvimento.domains.Instrutor;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CursoDTO {

    private Long idCurso;

    @NotNull(message = "O campo nome do curso não pode ser nulo")
    @NotBlank(message = "O campo nome do curso não pode ser vazio")
    private String nomeCurso;

    @NotNull(message = "O campo nome do curso não pode ser nulo")
    @NotBlank(message = "O campo nome do curso não pode ser vazio")
    private String urlCurso;

    @NotNull(message = "O campo de descrição do curso não pode ser nulo")
    @NotBlank(message = "O campo de descrição do curso não pode ser vazio")
    private String descricaoCurso;

    @NotNull(message = "O campo de carga horaria do curso não pode ser nulo")
    @NotBlank(message = "O campo de carga horaria do curso não pode ser vazio")
    private String cargaHorariaCurso;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicioCurso = LocalDate.now();

    @NotNull(message = "O campo de categoria do curso não pode ser nulo")
    @NotBlank(message = "O campo de categoria do curso não pode ser vazio")
    private String categoriaCurso;

    @NotNull(message = "O campo Aluno não pode ser nulo")
    private int aluno;
    private String nomeAluno;

    @NotNull(message = "O campo Instrutor não pode ser nulo")
    private int instrutor;
    private String nomeInstrutor;

    private int dificuldadeCurso;

    private int statusCurso;

    public CursoDTO() {
    }

    public CursoDTO(Curso curso) {
        this.idCurso = curso.getIdCurso();
        this.nomeCurso = curso.getNomeCurso();
        this.urlCurso = curso.getUrlCurso();
        this.descricaoCurso = curso.getDescricaoCurso();
        this.cargaHorariaCurso = curso.getCargaHorariaCurso();
        this.dataInicioCurso = curso.getDataInicioCurso();
        this.categoriaCurso = curso.getCategoriaCurso();
        this.aluno = curso.getAluno().getIdAluno();
        this.nomeAluno = curso.getAluno().getNomeAluno();
        this.instrutor = curso.getInstrutor().getIdInstrutor();
        this.nomeInstrutor = curso.getInstrutor().getNomeInstrutor();
        this.dificuldadeCurso = curso.getDificuldadeCurso().getIdDificuldade();
        this.statusCurso = curso.getStatusCurso().getIdStatus();

    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public @NotNull(message = "O campo nome do curso não pode ser nulo") @NotBlank(message = "O campo nome do curso não pode ser vazio") String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(@NotNull(message = "O campo nome do curso não pode ser nulo") @NotBlank(message = "O campo nome do curso não pode ser vazio") String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public @NotNull(message = "O campo nome do curso não pode ser nulo") @NotBlank(message = "O campo nome do curso não pode ser vazio") String getUrlCurso() {
        return urlCurso;
    }

    public void setUrlCurso(@NotNull(message = "O campo nome do curso não pode ser nulo") @NotBlank(message = "O campo nome do curso não pode ser vazio") String urlCurso) {
        this.urlCurso = urlCurso;
    }

    public @NotNull(message = "O campo de descrição do curso não pode ser nulo") @NotBlank(message = "O campo de descrição do curso não pode ser vazio") String getDescricaoCurso() {
        return descricaoCurso;
    }

    public void setDescricaoCurso(@NotNull(message = "O campo de descrição do curso não pode ser nulo") @NotBlank(message = "O campo de descrição do curso não pode ser vazio") String descricaoCurso) {
        this.descricaoCurso = descricaoCurso;
    }

    public @NotNull(message = "O campo de carga horaria do curso não pode ser nulo") @NotBlank(message = "O campo de carga horaria do curso não pode ser vazio") String getCargaHorariaCurso() {
        return cargaHorariaCurso;
    }

    public void setCargaHorariaCurso(@NotNull(message = "O campo de carga horaria do curso não pode ser nulo") @NotBlank(message = "O campo de carga horaria do curso não pode ser vazio") String cargaHorariaCurso) {
        this.cargaHorariaCurso = cargaHorariaCurso;
    }

    public LocalDate getDataInicioCurso() {
        return dataInicioCurso;
    }

    public void setDataInicioCurso(LocalDate dataInicioCurso) {
        this.dataInicioCurso = dataInicioCurso;
    }

    public @NotNull(message = "O campo de categoria do curso não pode ser nulo") @NotBlank(message = "O campo de categoria do curso não pode ser vazio") String getCategoriaCurso() {
        return categoriaCurso;
    }

    public void setCategoriaCurso(@NotNull(message = "O campo de categoria do curso não pode ser nulo") @NotBlank(message = "O campo de categoria do curso não pode ser vazio") String categoriaCurso) {
        this.categoriaCurso = categoriaCurso;
    }

    @NotNull(message = "O campo Aluno não pode ser nulo")
    public int getAluno() {
        return aluno;
    }

    public void setAluno(@NotNull(message = "O campo Aluno não pode ser nulo") int aluno) {
        this.aluno = aluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    @NotNull(message = "O campo Instrutor não pode ser nulo")
    public int getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(@NotNull(message = "O campo Instrutor não pode ser nulo") int instrutor) {
        this.instrutor = instrutor;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }

    public int getDificuldadeCurso() {
        return dificuldadeCurso;
    }

    public void setDificuldadeCurso(int dificuldadeCurso) {
        this.dificuldadeCurso = dificuldadeCurso;
    }

    public int getStatusCurso() {
        return statusCurso;
    }

    public void setStatusCurso(int statusCurso) {
        this.statusCurso = statusCurso;
    }
}
