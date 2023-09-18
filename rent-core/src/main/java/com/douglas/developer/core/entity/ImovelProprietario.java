package com.douglas.developer.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ImovelProprietario {

    @EmbeddedId
    private ImovelProrpietarioId id;

    public ImovelProrpietarioId getId() {
        return id;
    }

    public void setId(ImovelProrpietarioId id) {
        this.id = id;
    }
}
