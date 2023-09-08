package com.douglas.developer.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15)
    private String cep;

    @Column(length = 80)
    private String logradouro;

    @Column(length = 5)
    private String numero;

    @Column(length = 80)
    private String pontoRef;

    @Column(length = 80)
    private String Bairro;

    @ManyToOne
    @JoinColumn(name="cidade")
    private Cidade cidade;

    @JsonIgnore
    @ManyToMany(mappedBy = "enderecos", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Proprietario> proprietarios = new ArrayList<>();
}
