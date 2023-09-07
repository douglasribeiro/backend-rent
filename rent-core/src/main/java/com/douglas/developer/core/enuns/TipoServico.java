package com.douglas.developer.core.enuns;

public enum TipoServico {

    ALUGUEL(0, "ALUGUEL"),
    VENDA(1, "VENDA"),
    OUTROS(2, "OUTROS");

    private Integer codigo;
    private String descricao;

    private TipoServico(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoServico toEnum(Integer cod) {
        if(cod == null)
            return null;
        for (TipoServico x: TipoServico.values()) {
            if(cod.equals(x.getCodigo()))
                return x;
        }
        throw new IllegalArgumentException("tipo de serviço invalido.");
    }

    public static TipoServico toEnum(String desc) {
        if(desc == null)
            return null;
        for (TipoServico x: TipoServico.values()) {
            if(desc.equals(x.getDescricao()))
                return x;
        }
        throw new IllegalArgumentException("tipo de serviço invalido.");
    }

}