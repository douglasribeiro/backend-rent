package com.douglas.developer.core.entity;

import com.douglas.developer.core.enuns.EstadoCivil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Proprietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75)
    private String nome;

    @Column(length = 20)
    private String cpf;

    @Column(length = 20)
    private String ident;

    private Date dtNasc;

    @Column(length = 75)
    private String email;

    @Enumerated(EnumType.ORDINAL)
    private EstadoCivil estCivil;

    @Column(length = 30)
    private String naturalidade;

    @Column(length = 30)
    private String nacionalidade;

    @JsonIgnore
    private Boolean ativo;

    @Column(length = 75)
    private String conjuge;

    @Column(length = 20)
    private String cpfConjuge;

    private Date dtnConjuge;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PROPRIETARIO_ENDERECO",
            joinColumns = @JoinColumn(name = "proprietario_id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    private List<Endereco> enderecos = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "proprietarios")
    private List<Imovel> imoveis = new ArrayList<>();

//    @JsonIgnore
//    @OneToMany(mappedBy = "id.proprietario")
//    private Set<ImovelProprietario> imovelProprietarioList = new HashSet<>();

}
