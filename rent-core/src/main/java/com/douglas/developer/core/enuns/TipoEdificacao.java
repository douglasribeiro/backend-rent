package com.douglas.developer.core.enuns;

public enum TipoEdificacao {

    CASA(0, "CASA"),
    APARTAMENTO(1, "APARTAMENTO"),
    GALPAO(2, "GALPAO"),
    TERRENO(3, "TERRENO"),
    OUTROS(4, "OUTROS"),
    SALAO(5, "SALÂO");

    private Integer codigo;
    private String descricao;

    private TipoEdificacao(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoEdificacao toEnum(Integer cod) {
        if(cod == null)
            return null;
        for (TipoEdificacao x: TipoEdificacao.values()) {
            if(cod.equals(x.getCodigo()))
                return x;
        }
        throw new IllegalArgumentException("tipo de edificação invalido.");
    }

    public static TipoEdificacao toEnum(String desc) {
        if(desc == null)
            return null;
        for (TipoEdificacao x: TipoEdificacao.values()) {
            if(desc.equals(x.getDescricao()))
                return x;
        }
        throw new IllegalArgumentException("tipo de imovel invalido.");
    }
}