package com.desenvolvimento.domains.dtos;

import com.desenvolvimento.domains.Aluno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AlunoDTO {

    private Integer idAluno;

    @NotNull(message = "O campo nome do aluno não pode ser nulo")
    @NotBlank(message = "O campo nome do aluno não pode ser vazio")
    private String nomeAluno;

    @NotNull(message = "O campo cpf do aluno não pode ser nulo")
    @NotBlank(message = "O campo cpf do aluno não pode ser vazio")
    private String cpfAluno;

    @NotNull(message = "O campo email do aluno não pode ser nulo")
    @NotBlank(message = "O campo email do aluno não pode ser vazio")
    private String emailAluno;

    @NotNull(message = "O campo RA do aluno não pode ser nulo")
    private Integer raAluno;

    public AlunoDTO() {
    }

   public AlunoDTO(Aluno aluno){
        this.idAluno = aluno.getIdAluno();
        this.nomeAluno = aluno.getNomeAluno();
        this.cpfAluno = aluno.getCpfAluno();
        this.emailAluno = aluno.getEmailAluno();
        this.raAluno = aluno.getRaAluno();

   }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public @NotNull(message = "O campo nome do aluno não pode ser nulo") @NotBlank(message = "O campo nome do aluno não pode ser vazio") String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(@NotNull(message = "O campo nome do aluno não pode ser nulo") @NotBlank(message = "O campo nome do aluno não pode ser vazio") String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public @NotNull(message = "O campo cpf do aluno não pode ser nulo") @NotBlank(message = "O campo cpf do aluno não pode ser vazio") String getCpfAluno() {
        return cpfAluno;
    }

    public void setCpfAluno(@NotNull(message = "O campo cpf do aluno não pode ser nulo") @NotBlank(message = "O campo cpf do aluno não pode ser vazio") String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }

    public @NotNull(message = "O campo email do aluno não pode ser nulo") @NotBlank(message = "O campo email do aluno não pode ser vazio") String getEmailAluno() {
        return emailAluno;
    }

    public void setEmailAluno(@NotNull(message = "O campo email do aluno não pode ser nulo") @NotBlank(message = "O campo email do aluno não pode ser vazio") String emailAluno) {
        this.emailAluno = emailAluno;
    }

    public @NotNull(message = "O campo RA do aluno não pode ser nulo") Integer getRaAluno() {
        return raAluno;
    }

    public void setRaAluno(@NotNull(message = "O campo RA do aluno não pode ser nulo") Integer raAluno) {
        this.raAluno = raAluno;
    }
}
