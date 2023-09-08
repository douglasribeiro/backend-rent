package com.douglas.developer.core.entity;

import com.douglas.developer.core.enuns.EstadoCivil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "PROPRIETARIO_ENDERECO",
            joinColumns = @JoinColumn(name = "proprietario_id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    private List<Endereco> enderecos = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "proprietarios", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Imovel> imoveis = new ArrayList<>();

}
