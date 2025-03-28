package com.desenvolvimento.domains.enums;

public enum StatusDeMatricula {

    ABERTA(0, "ABERTA"), EM_ANDAMENTO(1, "EM_ANDAMENTO"), FECHADA(2, "FECHADA");
    private Integer id;
    private String statusDeMatricula;

    StatusDeMatricula(Integer id, String statusDeMatricula) {
        this.id = id;
        this.statusDeMatricula = statusDeMatricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusDeMatricula() {
        return statusDeMatricula;
    }

    public void setStatusDeMatricula(String statusDeMatricula) {
        this.statusDeMatricula = statusDeMatricula;
    }

    public static StatusDeMatricula toEnum(Integer id) {
        if (id == null) return null;
        for (StatusDeMatricula x : StatusDeMatricula.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Status de Matrícula inválido");
    }
}
