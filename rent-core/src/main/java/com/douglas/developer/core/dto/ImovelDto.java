package com.douglas.developer.core.dto;

import com.douglas.developer.core.entity.Cidade;
import com.douglas.developer.core.entity.Cliente;
import com.douglas.developer.core.enuns.TipoEdificacao;
import com.douglas.developer.core.enuns.TipoImovel;
import com.douglas.developer.core.enuns.TipoServico;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImovelDto {

    private Long id;
    private Long proprietario_id;
    private Long imovel_id;
    private String proprietarioMaster;
    private String logradouro;
    private String complementoImovel;
    private byte condominio;
    private TipoImovel tipoImovel; //TipoImovel;
    private TipoEdificacao tipoEdificacao; //TipoEdificacao
    private TipoServico tipoServico; //TipoServico
    private String numero;
    private String bairro;
    private String cep;
    private Cidade cidade;
    private String referencia;
    private Integer situacao;
    private String quartos;
    private String suites;
    private String banheiros;
    private String areaTotal;
    private String areaContruida;
    private String vagas;
    private String comodos;
    private String contato;
    private String registro;
    private String iptu;
    private Boolean pertence;
    private Boolean ativo;
    private Cliente cliente;

}

