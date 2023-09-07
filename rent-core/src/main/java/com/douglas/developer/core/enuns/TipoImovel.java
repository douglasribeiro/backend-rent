package com.douglas.developer.core.enuns;

public enum TipoImovel {

    RESIDENCIAL(0, "RESIDENCIAL"),
    COMERCIAL(1, "COMERCIAL"),
    INDUSTRIAL(2, "INDUSTRIAL"),
    RURAL(3, "RURAL"),
    OUTROS(4, "OUTROS");

    private Integer codigo;
    private String descricao;

    private TipoImovel(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoImovel toEnum(Integer cod) {
        if(cod == null)
            return null;
        for (TipoImovel x: TipoImovel.values()) {
            if(cod.equals(x.getCodigo()))
                return x;
        }
        throw new IllegalArgumentException("tipo de imovel invalido.");
    }

    public static TipoImovel toEnum(String desc) {
        //System.out.println(desc);
        if(desc == null)
            return null;
        for (TipoImovel x: TipoImovel.values()) {
            if(desc.equals(x.getDescricao()))
                return x;
        }
        throw new IllegalArgumentException("tipo de imovel invalido.");
    }

}