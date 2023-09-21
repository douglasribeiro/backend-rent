package com.douglas.developer.core.enuns;

public enum TipoEndereco {
    Residencial(0, "Residencial"),
    Comercial(1, "Comercial"),
    Entrega(2, "Entrega"),
    Correspondencia(3, "Correspondencia"),
    Outros(4, "Outros");

    private final Integer codigo;
    private final String descricao;

    TipoEndereco(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoEndereco toEnum(Integer cod) {
        if(cod == null)
            return null;
        for (TipoEndereco x: TipoEndereco.values()) {
            if(cod.equals(x.getCodigo()))
                return x;
        }
        throw new IllegalArgumentException("tipo de imovel invalido.");
    }

    public static TipoEndereco toEnum(String desc) {
        //System.out.println(desc);
        if(desc == null)
            return null;
        for (TipoEndereco x: TipoEndereco.values()) {
            if(desc.equals(x.getDescricao()))
                return x;
        }
        throw new IllegalArgumentException("tipo de endereço invalido.");
    }

}
