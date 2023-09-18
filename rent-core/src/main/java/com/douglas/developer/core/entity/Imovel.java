package com.douglas.developer.core.entity;

import com.douglas.developer.core.enuns.TipoEdificacao;
import com.douglas.developer.core.enuns.TipoImovel;
import com.douglas.developer.core.enuns.TipoServico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    //@Transient
    private Long proprietario_id;

    //@Transient
    private Long imovel_id;

    @Column(length = 100)
    private String proprietarioMaster;

    @Column(length = 70, nullable = false)
    private String logradouro;

    @Column(length = 256)
    private String complementoImovel;

    private byte condominio;

    @Enumerated(EnumType.ORDINAL)
    private TipoImovel tipoImovel; //TipoImovel;

    @Enumerated(EnumType.ORDINAL)
    private TipoEdificacao tipoEdificacao; //TipoEdificacao

    @Enumerated(EnumType.ORDINAL)
    private TipoServico tipoServico; //TipoServico

    @Column(length = 10)
    private String numero;

    @Column(length = 70)
    private String bairro;

    @Column(length = 15)
    private String cep;

    @ManyToOne
    @JoinColumn(name="cidade")
    private Cidade cidade;

    @Column(length = 150)
    private String referencia;

    private Integer situacao;

    @Column(length = 2)
    private String quartos;

    @Column(length = 2)
    private String suites;

    @Column(length = 2)
    private String banheiros;

    @Column(length = 10)
    private String areaTotal;

    @Column(length = 10)
    private String areaContruida;

    @Column(length = 3)
    private String vagas;

    @Column(length = 3)
    private String comodos;

    @Column(length = 65)
    private String contato;

    private String registro;

    private String iptu;

    @Column(columnDefinition="bit default 0")
    private Boolean pertence;

    @JsonIgnore
    private Boolean ativo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "id.imovel")
    private Set<ImovelProprietario> imovelProprietarioList = new HashSet<>();
}
