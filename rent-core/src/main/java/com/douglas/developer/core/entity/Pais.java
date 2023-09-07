package com.douglas.developer.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String bacen;

    @Column(length = 50)
    private String nome;

    @Column(length = 50)
    private String nomePt;

    @Column(length = 3)
    private String sigla;
}
