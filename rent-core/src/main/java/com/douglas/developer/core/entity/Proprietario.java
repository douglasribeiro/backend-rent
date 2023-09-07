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
public class Proprietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75)
    private String nome;

    @Column(length = 75)
    private String email;

    @JsonIgnore
    @ManyToMany(mappedBy = "proprietarios", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Imovel> imoveis = new ArrayList<>();

}
