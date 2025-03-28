package com.desenvolvimento.domains.dtos;

import com.desenvolvimento.domains.Veiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

public class VeiculoDTO {

    private Long id;

    @NotNull(message = "O campo descrição não pode ser nulo")
    @NotBlank(message = "O campo descrição não pode ser vazio")
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAquisicao = LocalDate.now();

    @NotNull(message = "O campo valor aquisição não pode ser nulo")
    private double valorAquisicao;

    @NotNull(message = "O campo nome proprietario não pode ser nulo")
    @NotBlank(message = "O campo nome proprietario não pode ser vazio")
    private String nomeProprietario;

    @NotNull(message = "O campo CPF proprietario não pode ser nulo")
    @NotBlank(message = "O campo CPF proprietario não pode ser vazio")

    private String cpfProprietario;

    public VeiculoDTO() {
    }

    public VeiculoDTO(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.descricao = veiculo.getDescricao();
        this.dataAquisicao = veiculo.getDataAquisicao();
        this.valorAquisicao = veiculo.getValorAquisicao();
        this.nomeProprietario = veiculo.getNomeProprietario();
        this.cpfProprietario = veiculo.getCpfProprietario();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public double getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(double valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getCpfProprietario() {
        return cpfProprietario;
    }

    public void setCpfProprietario(String cpfProprietario) {
        this.cpfProprietario = cpfProprietario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeiculoDTO that = (VeiculoDTO) o;
        return Double.compare(that.valorAquisicao, valorAquisicao) == 0 && Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao) && Objects.equals(dataAquisicao, that.dataAquisicao) && Objects.equals(nomeProprietario, that.nomeProprietario) && Objects.equals(cpfProprietario, that.cpfProprietario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, dataAquisicao, valorAquisicao, nomeProprietario, cpfProprietario);
    }
}
