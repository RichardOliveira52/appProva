package com.desenvolvimento.domains.enums;

public enum OrdemDePrioridade {

    BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");
    private Integer id;
    private String ordemDePrioridade;

    OrdemDePrioridade(Integer id, String ordemDePrioridade) {
        this.id = id;
        this.ordemDePrioridade = ordemDePrioridade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdemDePrioridade() {
        return ordemDePrioridade;
    }

    public void setOrdemDePrioridade(String ordemDePrioridade) {
        this.ordemDePrioridade = ordemDePrioridade;
    }
    public static OrdemDePrioridade toEnum(Integer id) {
        if (id == null) return null;
        for (OrdemDePrioridade x : OrdemDePrioridade.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Ordem de Prioridade inválida");
    }
}
