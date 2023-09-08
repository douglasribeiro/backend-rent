package com.douglas.developer.core.enuns;

public enum EstadoCivil implements EnumGeneric<EstadoCivil>{

    SOLTEIRO(1, "Solteiro"),
    CASADO(2, "Casado"),
    SEPARADO(3, "Separado"),
    DIVORCIADO(4, "Divorciado"),
    VIUVO(5, "Viuvo"),
    AMAZIADO(6, "Amaziado"),
    OUTROS(7, "Outos");

    private int cod;
    private String descricao;

    private EstadoCivil(int cod, String descricao) {
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
