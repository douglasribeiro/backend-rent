package com.douglas.developer.core.enuns;

public enum Situacao implements EnumGeneric<Situacao>{

    ALUGAR(1, "Para alugar"),
    VENDER(2, "Para vender"),
    ALUGAR_VENDER(3, "Alugar e Vender"),
    ALUGADO(4, "Alugado"),
    VENDIDO(5, "Vendido"),
    SEM_FUNCAO(6, "Sem função");

    private int cod;
    private String descricao;

    private Situacao(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    @Override
    public int getCod() {
        return cod;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}
