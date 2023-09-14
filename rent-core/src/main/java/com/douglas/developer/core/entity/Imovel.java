package com.douglas.developer.core.entity;

import com.douglas.developer.core.enuns.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "PROPRIETARIO_IMOVEL",
            joinColumns = @JoinColumn(name = "imovel_id"),
            inverseJoinColumns = @JoinColumn(name = "proprietario_id"))
    private List<Proprietario> proprietarios = new ArrayList<>();

    public Situacao getTipo() {
        return EnumGeneric.toEnum(situacao);
    }

    public void setTipo(Situacao situacao) {
        this.situacao = situacao.getCod();
    }
}
