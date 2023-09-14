package com.douglas.developer.core.dto;

import com.douglas.developer.core.entity.Cliente;
import com.douglas.developer.core.entity.Endereco;
import com.douglas.developer.core.entity.Imovel;
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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProprietarioDto {

    private Long id;
    private String nome;
    private String cpf;
    private String ident;
    private Date dtNasc;
    private String email;
    private EstadoCivil estCivil;
    private String naturalidade;
    private String nacionalidade;
    private String conjuge;
    private String cpfConjuge;
    private Date dtnConjuge;
    private Cliente cliente;
    private List<Endereco> enderecos = new ArrayList<>();
    private List<Imovel> imoveis = new ArrayList<>();

}
