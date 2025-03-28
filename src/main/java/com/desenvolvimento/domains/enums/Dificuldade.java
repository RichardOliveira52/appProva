package com.desenvolvimento.domains.enums;

public enum Dificuldade {

    Iniciante(1, "Iniciante"), Intermediario(2,"Intermediario"), Avancado(3, "Avancado");

    private Integer idDificuldade;
    private String situacaoDificuldade;

    Dificuldade(Integer idDificuldade, String situacaoDificuldade) {
        this.idDificuldade = idDificuldade;
        this.situacaoDificuldade = situacaoDificuldade;
    }

    public int getIdDificuldade() {
        return idDificuldade;
    }

    public void setIdDificuldade(Integer idDificuldade) {
        this.idDificuldade = idDificuldade;
    }

    public String getSituacaoDificuldade() {
        return situacaoDificuldade;
    }

    public void setSituacaoDificuldade(String situacaoDificuldade) {
        this.situacaoDificuldade = situacaoDificuldade;
    }

    /*Criação de metodo static para que
    * não necessite instanciar (criar um objeto
    * da classe) enum para utilizá-lo */

    public static Dificuldade toEnum(Integer id){
        if(id==null) return null; //verifica se o id é nulo
        for(Dificuldade d : Dificuldade.values()){ //
            if(id.equals(d.getIdDificuldade())){
                return d;
            }
        }
        throw new IllegalArgumentException("Dificuldade inválida");
    }
}

/*Anotações:
* Dificuldade.values() -> é um metodo java que retorna um array de todos os valores possíveis do enum
* Dificuldade d -> é uma variável do tipo Dificuldade que armazenará um valor
* Explicação: depois de passar um numero como parâmetro o metodo vai verificar se o id passado não é nulo,
 * se não for, ocorrerá uma iteração onde a variavel d do tipo Dificuldade irá percorrer um array de valores presentes
 * no enum Dificuldade, e a cada iteração d vai se comparar com o numero passado como parâmetro para ver se ele corresponde
 * e se os ids forem iguais retornará o valor de d, se não abrirá uma excecão.
 */
