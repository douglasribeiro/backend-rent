package com.douglas.developer.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@EqualsAndHashCode
public class ImovelProrpietarioId implements Serializable {
    private static final long serialVersionUID = 4671531966792866602L;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;

}
