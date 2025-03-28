package com.desenvolvimento.domains.enums;


public enum Status {

    Nao_Iniciado (1, "Nao_Iniciado"), Em_Andamento(2, "Em_Andamento"), Concluido(3, "Concluido");

    private Integer idStatus;
    private String situacaoStatus;

    Status(Integer idStatus, String situacaoStatus) {
        this.idStatus = idStatus;
        this.situacaoStatus = situacaoStatus;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getSituacaoStatus() {
        return situacaoStatus;
    }

    public void setSituacaoStatus(String situacaoStatus) {
        this.situacaoStatus = situacaoStatus;
    }

    public static Status toEnum(Integer id){
        if(id==null) return null;
        for(Status s : Status.values()){
            if(id.equals(s.getIdStatus())){
            return s;
            }
        } throw new IllegalArgumentException("Status inválido");
    }
}
/*Anotações:
* Status.values() -> é um metodo java que retorna um array de todos os valores possíveis do enum
* Status s -> é uma variável do tipo Status que armazenará um valor
* Explicação: depois de passar um numero como parâmetro o metodo vai verificar se o id passado não é nulo,
* se não for, ocorrerá uma iteração onde a variavel s do tipo Status irá percorrer um array de valores presentes
* no enum Status, e a cada iteração s vai se comparar com o numero passado como parâmetro para ver se ele corresponde
* e se os ids forem iguais retornará o valor de s, se não abrirá uma excecão
 */
