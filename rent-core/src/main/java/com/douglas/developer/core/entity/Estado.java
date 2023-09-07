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
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String ddd;

    @Column(length = 50)
    private String nome;

    @ManyToOne
    @JoinColumn(name="pais_id")
    private Pais pais;

    @Column(length = 2)
    private String sigla;
}
