package com.douglas.developer.core.enuns;

public interface EnumGeneric<T> {

    public int getCod();

    public String getDescricao ();

    public static Situacao toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (Situacao x : Situacao.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
