package com.desenvolvimento.domains.dtos;

import com.desenvolvimento.domains.Instrutor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class InstrutorDTO {

    private Integer idInstrutor;

    @NotNull(message = "O campo nome do instrutor não pode ser nulo")
    @NotBlank (message = "O campo nome do instrutor não pode ser vazio")
    private String nomeInstrutor;

    @NotNull(message = "O campo cpf do instrutor não pode ser nulo")
    @NotBlank(message = "O campo cpf o instrutor não pode ser vazio")
    private String cpfInstrutor;

    @NotNull(message = "O campo email do instrutor não pode ser nulo" )
    @NotBlank(message = "O campo email do instrutor não pode ser vazio")
    private String emailInstrutor;

    @NotNull(message = "O campo de experiência do instrutor não pode ser nulo")
    @NotBlank (message = "O campo de experiência do instrutor não pode ser vazio" )
    private String experienciaInstrutor;

    public InstrutorDTO() {
    }

    public InstrutorDTO(Instrutor instrutor){
        this.idInstrutor = instrutor.getIdInstrutor();
        this.nomeInstrutor = instrutor.getNomeInstrutor();
        this.cpfInstrutor = instrutor.getCpfInstrutor();
        this.emailInstrutor = instrutor.getEmailInstrutor();
        this.experienciaInstrutor = instrutor.getExperienciaInstrutor();

    }

    public Integer getIdInstrutor() {
        return idInstrutor;
    }

    public void setIdInstrutor(Integer idInstrutor) {
        this.idInstrutor = idInstrutor;
    }

    public @NotNull(message = "O campo nome do instrutor não pode ser nulo") @NotBlank(message = "O campo nome do instrutor não pode ser vazio") String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(@NotNull(message = "O campo nome do instrutor não pode ser nulo") @NotBlank(message = "O campo nome do instrutor não pode ser vazio") String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }

    public @NotNull(message = "O campo cpf do instrutor não pode ser nulo") @NotBlank(message = "O campo cpf o instrutor não pode ser vazio") String getCpfInstrutor() {
        return cpfInstrutor;
    }

    public void setCpfInstrutor(@NotNull(message = "O campo cpf do instrutor não pode ser nulo") @NotBlank(message = "O campo cpf o instrutor não pode ser vazio") String cpfInstrutor) {
        this.cpfInstrutor = cpfInstrutor;
    }

    public @NotNull(message = "O campo email do instrutor não pode ser nulo") @NotBlank(message = "O campo email do instrutor não pode ser vazio") String getEmailInstrutor() {
        return emailInstrutor;
    }

    public void setEmailInstrutor(@NotNull(message = "O campo email do instrutor não pode ser nulo") @NotBlank(message = "O campo email do instrutor não pode ser vazio") String emailInstrutor) {
        this.emailInstrutor = emailInstrutor;
    }

    public @NotNull(message = "O campo de experiência do instrutor não pode ser nulo") @NotBlank(message = "O campo de experiência do instrutor não pode ser vazio") String getExperienciaInstrutor() {
        return experienciaInstrutor;
    }

    public void setExperienciaInstrutor(@NotNull(message = "O campo de experiência do instrutor não pode ser nulo") @NotBlank(message = "O campo de experiência do instrutor não pode ser vazio") String experienciaInstrutor) {
        this.experienciaInstrutor = experienciaInstrutor;
    }
}
